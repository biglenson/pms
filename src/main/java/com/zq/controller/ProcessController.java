package com.zq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.transaction.annotation.*;

import com.zq.commons.result.PageInfo;
import com.zq.commons.result.Tree;
import com.zq.commons.shiro.captcha.CMCCCaptcha;
import com.zq.commons.utils.CMCCConstant;
import com.zq.commons.utils.StringUtils;
import com.zq.service.system.IResourceService;
import com.alibaba.fastjson.JSON;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.FormService;
import org.apache.shiro.SecurityUtils;

import org.springframework.beans.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;
import java.util.*;

import com.zq.service.process.*;
import com.zq.vo.process.*;
import com.zq.entity.process.*;


/** 
* @ClassName: TestController 
* @Description: TODO(登陆) 
* @author shujukuss 
* @date 2017年6月18日 下午7:01:35 
*  
*/
@Controller
@RequestMapping("/datamap/") 
public class ProcessController extends BaseController{	
	private static Logger logger = Logger.getLogger(ProcessController.class);  
	
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private BenefitEvalTplSvc benefitEvalTplSvc;
	
    @Autowired
    private BenefitEvalTplItemSvc benefitEvalTplItemSvc;
	
    @Autowired
    private BenefitEvalSvc benefitEvalSvc;

    @Autowired
    private BenefitEvalItemSvc benefitEvalItemSvc;

    @RequestMapping(value = "submitBenefitEval", method = RequestMethod.POST)  
	public String submitBenefitEval(HttpServletRequest request, HttpServletResponse response, Model model,
                                    @RequestParam("evalInfo") String evalInfo, 
                                    @RequestParam("evalForm") String evalForm
                                    ) {		 	
        evalInfo = StringEscapeUtils.unescapeHtml(evalInfo);
        logger.info("-BenefitEval------------------------origin evalInfo:    "+evalInfo); 
        evalForm = StringEscapeUtils.unescapeHtml(evalForm);
        logger.info("-BenefitEval------------------------origin evalform:    "+evalForm); 
        BenefitEvalVO benefitEvalVO = JSON.parseObject(evalInfo, BenefitEvalVO.class);
        List<BenefitEvalItemVO> benefitEvalForm = JSON.parseArray(evalForm, BenefitEvalItemVO.class);
        
        benefitEvalSvc.submitBenefitEvalInfo(benefitEvalVO, benefitEvalForm);   
        
        model.addAttribute("feedback","评估信息提交成功！" );

        return CMCCConstant.Feedback;
    }

    @RequestMapping(value = "delBenefitEval", method = RequestMethod.GET)  
	public String delBenefitEval(HttpServletRequest request, HttpServletResponse response, Model model,
                                    @RequestParam("taskID") String taskID
                                    ) {		 	
        /*
        String pName = formService.getTaskFormData(taskID).getFormProperties().get(0).getName();
        Map<String, String> selectValues = (Map<String, String>)formService.getTaskFormData(taskID).getFormProperties().get(0).getType().getInformation("values");
        if (selectValues != null) {
                for (Map.Entry<String, String> enumEntry : selectValues.entrySet()){
                    logger.info("enum, key: {}, value: {}-----------"+ enumEntry.getKey()+"=========="+ enumEntry.getValue());
                }
        }
        logger.info("-testFormProperties------------------------pName:    "+pName); 
        */
        Map<String, String> variables = new HashMap<String, String>();
        variables.put("isToSubmit", "0");
        formService.submitTaskFormData(taskID, variables);

        model.addAttribute("feedback","评估信息删除成功！" );

        return CMCCConstant.Feedback;
    }
    @RequestMapping(value = "saveBenefitEval", method = RequestMethod.POST)  
	public String saveBenefitEval(HttpServletRequest request, HttpServletResponse response, Model model,
                                    @RequestParam("evalInfo") String evalInfo, 
                                    @RequestParam("evalForm") String evalForm,
                                    @RequestParam("submitFrom") String submitFrom
                                    ) {		 	
        evalInfo = StringEscapeUtils.unescapeHtml(evalInfo);
        logger.info("-BenefitEval------------------------origin evalInfo:    "+evalInfo); 
        evalForm = StringEscapeUtils.unescapeHtml(evalForm);
        logger.info("-BenefitEval------------------------origin evalform:    "+evalForm); 
        BenefitEvalVO benefitEvalVO = JSON.parseObject(evalInfo, BenefitEvalVO.class);
        logger.info("-BenefitEval------------------------evalTitle:    "+benefitEvalVO.getEvalTitle()); 
        
        List<BenefitEvalItemVO> benefitEvalForm = JSON.parseArray(evalForm, BenefitEvalItemVO.class);
        for (BenefitEvalItemVO benefitEvalItemVO : benefitEvalForm) {  
            logger.info("-parseArray------------------------:   "+benefitEvalItemVO.getEvalValue()); 
        }

        benefitEvalVO = benefitEvalSvc.saveBenefitEvalInfo(benefitEvalVO, benefitEvalForm);   
        logger.info("-BenefitEval------------------------evalTitle back:    "+benefitEvalVO.getEvalTitle()); 


        int isEditable = 0;
        int evalID = benefitEvalVO.getEvalID();
        String taskID = null;
        Map<String, String> rsltOption = null;
        String processID = benefitEvalVO.getProcessID();
        HistoricProcessInstance hisProcInst = historyService.createHistoricProcessInstanceQuery().processInstanceId(processID).singleResult(); 
        Task task = taskService.createTaskQuery().processInstanceId(processID).singleResult();
        String curUser = getStaffName();
        if (task != null) {
            taskID = task.getId();
             rsltOption = benefitEvalSvc.getDealRsltOption(taskID);
            if (hisProcInst.getStartUserId().equals(curUser)){
                 isEditable = 1;
            }
            
        }

        logger.info("-BenefitEval------------------------evalID back:    "+evalID); 
        benefitEvalForm = benefitEvalItemSvc.getBenefitEvalForm(evalID);
        BenefitEvalVO benefitEvalInfo = benefitEvalSvc.getBenefitEvalInfo(evalID);
        logger.info("-BenefitEval------------------------evalTitle :    "+benefitEvalInfo.getEvalTitle()); 
        List<TaskHisItemVO> taskHis = benefitEvalSvc.getTaskHis(benefitEvalInfo.getProcessID());
        model.addAttribute("benefitEvalInfo",benefitEvalInfo );
        model.addAttribute("benefitEvalForm",benefitEvalForm );
        model.addAttribute("taskHis",taskHis );
        model.addAttribute("taskID",taskID );
        model.addAttribute("isEditable",isEditable );
        model.addAttribute("rsltOption", rsltOption );
        model.addAttribute("submitFrom", submitFrom );
        return CMCCConstant.BenefitEvalPopup;
    }


	//@RequestMapping(value = "getBenefitEvalInfo", method = RequestMethod.GET)  
	@RequestMapping(value = "benefitEvalPopup", method = RequestMethod.GET)  
	public String getBenefitEvalInfo(HttpServletRequest request, HttpServletResponse response, Model model,String captcha,
                                    @RequestParam("pageTitle") String pageTitle,
                                    @RequestParam("url") String url, 
                                    @RequestParam("processID") String processID,
                                    @RequestParam("submitFrom") String submitFrom
                                    ) {		 	
        logger.info("测试中！----------------------------submitFrom:  "+submitFrom); 
        
        int isEditable = 0;
        int evalID = benefitEvalSvc.getEvalIDByProcessID(processID);
        String taskID = null;
        Map<String, String> rsltOption = null;
        String curUser = getStaffName();
        HistoricProcessInstance hisProcInst = historyService.createHistoricProcessInstanceQuery().processInstanceId(processID).singleResult(); 
        Task task = taskService.createTaskQuery().processInstanceId(processID).singleResult();
        if (task != null) {
            taskID = task.getId();
             rsltOption = benefitEvalSvc.getDealRsltOption(taskID);
            if (hisProcInst.getStartUserId().equals(curUser)){
                isEditable = 1;
            }
            logger.info("测试中！----------------------------assigneeeee:   "+ task.getAssignee()); 
        }
        logger.info("测试中！----------------------------isEditable:   "+ isEditable); 

        List<BenefitEvalItemVO> benefitEvalForm = benefitEvalItemSvc.getBenefitEvalForm(evalID);
        BenefitEvalVO benefitEvalInfo = benefitEvalSvc.getBenefitEvalInfo(evalID);
        List<TaskHisItemVO> taskHis = benefitEvalSvc.getTaskHis(benefitEvalInfo.getProcessID());
        model.addAttribute("benefitEvalInfo",benefitEvalInfo );
        model.addAttribute("benefitEvalForm",benefitEvalForm );
        model.addAttribute("taskHis",taskHis );
        model.addAttribute("taskID",taskID );
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("url", url);
        model.addAttribute("isEditable", isEditable);
        model.addAttribute("rsltOption", rsltOption );
        model.addAttribute("submitFrom", submitFrom );

        return CMCCConstant.BenefitEvalPopup;
	 } 

    /*
    public String simpleFromBenefit(HttpServletRequest request, String pageTitle, String url) {
        request.setAttribute("pageTitle", pageTitle);
        request.setAttribute("url", url);
        return CMCCConstant.SimpleFromBenefit;
    }
    */
    //@RequestMapping(value = "simpleFromBenefit", method = RequestMethod.GET)  
	@RequestMapping(value = "getTaskTodo", method = RequestMethod.GET)  
	public String getTaskTodo(HttpServletRequest request, HttpServletResponse response, Model model,String captcha,
                                    @RequestParam("pageTitle") String pageTitle,
                                    @RequestParam("page") Integer pageNo,
                                    @RequestParam("url") String url) {		 	
        logger.info("测试中！----------------------------taskTodo"); 
        logger.info("测试中！----------------------------pageNo----" + pageNo); 

        PageModel<TaskTodoItemVO> taskTodoPage = benefitEvalSvc.getTaskTodo(getStaffName(), pageNo-1);
        PageInfo pageInfo = new PageInfo();
        List<TaskTodoItemVO> taskTodo = taskTodoPage.getResultList();
        pageInfo.setPageSize(taskTodoPage.size());
        pageInfo.setTotalRows(taskTodoPage.getTotalItems());
        pageInfo.setPageCount(taskTodoPage.getTotalPages());
        pageInfo.setCurrentPage(pageNo);

        model.addAttribute("taskTodo", taskTodo);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("url", url);
        return CMCCConstant.GetTaskTodo;
	 } 

	@RequestMapping(value = "getTaskDone", method = RequestMethod.GET)  
	public String getTaskDone(HttpServletRequest request, HttpServletResponse response, Model model,String captcha,
						            @RequestParam("pageTitle") String pageTitle,
                                    @RequestParam("page") Integer pageNo,
						            @RequestParam("url") String url) {		 			 	
        logger.info("测试中！----------------------------taskDone"); 

        PageModel<TaskTodoItemVO> taskDonePage = benefitEvalSvc.getTaskDone(getStaffName(), pageNo-1);
        PageInfo pageInfo = new PageInfo();
        List<TaskTodoItemVO> taskDone = taskDonePage.getResultList();
        pageInfo.setPageSize(taskDonePage.size());
        pageInfo.setTotalRows(taskDonePage.getTotalItems());
        pageInfo.setPageCount(taskDonePage.getTotalPages());
        pageInfo.setCurrentPage(pageNo);

        model.addAttribute("taskDone", taskDone);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("url", url);
		return CMCCConstant.GetTaskDone;  
	 } 

	@RequestMapping(value = "chooseTemplate", method = RequestMethod.GET)  
	public String getTemplateList(HttpServletRequest request, HttpServletResponse response, Model model,String captcha, 
                                    @RequestParam("evalPhase") Integer evalPhase,
                                    @RequestParam("evalFor") Integer evalFor
                                 ) {		 	
        logger.info("测试中！----------------------------service begin"+ evalPhase+"-----"+evalFor); 
        Map<String, Object> variables = new HashMap<String, Object>();
        List<BenefitEvalTplVO> benefitEvalTplVOList = benefitEvalTplSvc.getBenefitEvalTplList(evalPhase, evalFor);
        logger.info("测试中！----------------------------service 2"); 
        for (BenefitEvalTplVO benefitEvalTplVO : benefitEvalTplVOList) {
            logger.info("测试中！"+ benefitEvalTplVO.getTplTitle()); 
            

        }
        logger.info("测试中！----------------------------service 3"); 
        model.addAttribute("benefitEvalTplList", benefitEvalTplVOList);

		return CMCCConstant.ChooseTemplate;  
		//return CMCCConstant.TEST;  
	 } 


    /**
    * @Title: simpleFormBasic
    * @Description: TODO(项目、产品[基本信息])
    * @author Administrator
    * @date 2017年7月27日 下午1:37:19
    * @param @param request
    * @param @param pageTitle 标题
    * @param @return 设定文件
    * @return String 返回类型
    * @throws
    */
    @RequestMapping(value = "simpleFormBasic")
    public String simpleFormGeneral(HttpServletRequest request, String pageTitle, String url) {
        request.setAttribute("pageTitle", pageTitle);
        request.setAttribute("url", url);
        return CMCCConstant.SimpleFormBasic;
    }


    /**
    * @Title: benefitEvalPopup
    * @Description: TODO(效益评估弹出框)
    * @author Administrator
    * @date 2017年7月30日 下午4:04:37
    * @param @param request
    * @param @param pageTitle
    * @param @param url
    * @param @return 设定文件
    * @return String 返回类型
    * @throws
    */

    /**
    * @Title: logPopup
    * @Description: TODO(效益评估弹出框--日志)
    * @author Administrator
    * @date 2017年7月30日 下午11:42:24
    * @param @param request
    * @param @param pageTitle
    * @param @param url
    * @param @return 设定文件
    * @return String 返回类型
    * @throws
    */
    @RequestMapping(value = "logPopup")
    public String logPopup(HttpServletRequest request, String pageTitle, String url) {
        request.setAttribute("pageTitle", pageTitle);
        request.setAttribute("url", url);
        return CMCCConstant.LogPopup;
    }

    /**
    * @Title: userSelectCommon
    * @Description: TODO(效益评估弹出框--选择用户)
    * @author Administrator
    * @date 2017年8月1日 下午5:36:29
    * @param @param request
    * @param @param pageTitle
    * @param @param url
    * @param @return 设定文件
    * @return String 返回类型
    * @throws
    */
    @RequestMapping(value = "userSelectCommon")
    public String userSelectCommon(HttpServletRequest request, String pageTitle, String url) {
        request.setAttribute("pageTitle", pageTitle);
        request.setAttribute("url", url);
        return CMCCConstant.UserSelectCommon;
    }

    /**
    * @Title: benefitEvalEditPopup
    * @Description: TODO(选择模版之后的效益评估编辑窗体)
    * @author Administrator
    * @date 2017年8月3日 上午10:07:29
    * @param @param request
    * @param @param pageTitle
    * @param @param url
    * @param @return 设定文件
    * @return String 返回类型
    * @throws
    */
    @RequestMapping(value = "benefitEvalEditPopup")
	public String benefitEvalEditPopup(HttpServletRequest request, HttpServletResponse response, Model model,String captcha, 
                                    @RequestParam("tplID") Integer tplID
                                 ) {		 	
        BenefitEvalTplVO benefitEvalTplVO = benefitEvalTplSvc.getBenefitEvalTplInfo(tplID);
        List<BenefitEvalTplItemVO> formTemplate = benefitEvalTplItemSvc.getFormTemplate(tplID);
        List<TaskHisItemVO> taskHisList = new ArrayList<TaskHisItemVO>();
        TaskHisItemVO taskHisItemVO = new TaskHisItemVO();
        taskHisItemVO.setTaskName("新建");
        taskHisItemVO.setAssignee(getStaffName());
        taskHisList.add(taskHisItemVO);
        LoginInfoVO loginInfo = new LoginInfoVO();
        loginInfo.setLoginID(getUserId());
        loginInfo.setLoginName(getStaffName());
        model.addAttribute("loginInfo", loginInfo);
        model.addAttribute("taskName", "新建");
        model.addAttribute("taskHisList", taskHisList);
        model.addAttribute("templateInfo", benefitEvalTplVO);
        model.addAttribute("formTemplate", formTemplate);
        return CMCCConstant.BenefitEvalEditPopup;
    }

}
