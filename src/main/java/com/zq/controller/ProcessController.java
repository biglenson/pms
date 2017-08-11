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

import com.zq.commons.result.Tree;
import com.zq.commons.shiro.captcha.CMCCCaptcha;
import com.zq.commons.utils.CMCCConstant;
import com.zq.commons.utils.StringUtils;
import com.zq.service.system.IResourceService;
import com.zq.service.process.*;
import com.zq.vo.process.*;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;

import java.util.*;



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
    private IdentityService identityService;

    @Autowired
    private BenefitEvalTplSvc benefitEvalTplSvc;
	
    @Autowired
    private BenefitEvalTplItemSvc benefitEvalTplItemSvc;
	
    @Autowired
    private BenefitEvalSvc benefitEvalSvc;

    @Autowired
    private BenefitEvalItemSvc benefitEvalItemSvc;

    /*@RequestMapping(value = "benefitEvalPopup")
    public String benefitEvalPopup(HttpServletRequest request, String pageTitle, String url) {
        request.setAttribute("pageTitle", pageTitle);
        request.setAttribute("url", url);
    }
    */
	//@RequestMapping(value = "getBenefitEvalInfo", method = RequestMethod.GET)  
	@RequestMapping(value = "benefitEvalPopup", method = RequestMethod.GET)  
	public String getBenefitEvalInfo(HttpServletRequest request, HttpServletResponse response, Model model,String captcha,
                                    @RequestParam("pageTitle") String pageTitle,
                                    @RequestParam("url") String url, 
                                    @RequestParam("evalID") Integer evalID) {		 	
        logger.info("测试中！----------------------------evalForm"); 

        List<BenefitEvalItemVO> benefitEvalForm = benefitEvalItemSvc.getBenefitEvalForm(evalID);
        BenefitEvalVO benefitEvalInfo = benefitEvalSvc.getBenefitEvalInfo(evalID);
        List<TaskHisItemVO> taskHis = benefitEvalSvc.getTaskHis(benefitEvalInfo.getProcessID());
        model.addAttribute("benefitEvalInfo",benefitEvalInfo );
        model.addAttribute("benefitEvalForm",benefitEvalForm );
        model.addAttribute("taskHis",taskHis );
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("url", url);

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
                                    @RequestParam("url") String url) {		 	
        logger.info("测试中！----------------------------taskTodo"); 

        List<TaskTodoItemVO> taskTodo = benefitEvalSvc.getTaskTodo();
        model.addAttribute("taskTodo", taskTodo);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("url", url);
        return CMCCConstant.GetTaskTodo;
	 } 

	@RequestMapping(value = "getTaskDone", method = RequestMethod.GET)  
	public String getTaskDone(HttpServletRequest request, HttpServletResponse response, Model model,String captcha,
						            @RequestParam("pageTitle") String pageTitle,
						            @RequestParam("url") String url) {		 			 	
        logger.info("测试中！----------------------------taskDone"); 

        List<TaskTodoItemVO> taskDone = benefitEvalSvc.getTaskDone();
        model.addAttribute("taskDone", taskDone);
        model.addAttribute("pageTitle", pageTitle);
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
