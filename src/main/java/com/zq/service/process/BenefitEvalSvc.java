package com.zq.service.process;

import com.zq.vo.process.*;
import com.zq.entity.process.*;
import com.zq.dao.process.*;
import com.zq.commons.utils.*;

import java.util.*;
import java.net.URLEncoder;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.*;
//import org.apache.commons.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import java.io.*;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.TaskService;
import org.activiti.engine.FormService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.Attachment;
import org.apache.shiro.SecurityUtils;
import org.activiti.engine.task.Task;
import org.activiti.engine.form.FormProperty;

@Component
public class BenefitEvalSvc{
    private static Log logger = LogFactory.getLog(BenefitEvalSvc.class);
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    @Autowired
    BenefitEvalRepository benefitEvalRepo;

    @Autowired
    BenefitEvalItemRepository benefitEvalItemRepo;

    @Autowired
    BenefitEvalTplRepository benefitEvalTplRepo;

    //@Autowired
    //private EvalCodeGenSvc evalCodeGenSvc;

	@Autowired
	EvalCodeGenRepository evalCodeGenRepo;


	public List<UserInfoVO> getUserInfoList(){
        List<UserInfoVO> userInfoListVO = benefitEvalRepo.getUserInfoList();

        return userInfoListVO;
    }
	@Transactional
	public void downloadFile(HttpServletRequest request, HttpServletResponse response, String attachID) throws IOException, UnsupportedEncodingException{
        Attachment attachment = taskService.getAttachment(attachID);
        InputStream fileData = taskService.getAttachmentContent(attachID);

        String contentType = StringUtils.substringBefore(attachment.getType(), ";");
        response.addHeader("Content-Type", contentType + ";charset=UTF-8");
        
        String extName = StringUtils.substringAfter(attachment.getType(), ";");
        //String 
        String fileName = attachment.getName() + "." + extName;

        String agent=request.getHeader("User-Agent").toLowerCase();
        if (agent.indexOf("firefox")>0) {
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        } else {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        }
        
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        IOUtils.copy(new BufferedInputStream(fileData), response.getOutputStream());

    }

	@Transactional
	public String delAttachment(String attachID){
        taskService.deleteAttachment(attachID);
        return "done";
    }

	@Transactional
	public String addAttachment(String processID, MultipartFile fileData) throws IOException, UnsupportedEncodingException{

        String taskID = taskService.createTaskQuery().processInstanceId(processID).singleResult().getId();

        //String fileName = new String(fileData.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8");
        String fileName = fileData.getOriginalFilename();
        String extName =  FilenameUtils.getExtension(fileName);
        /*
        if (fileName.lastIndexOf(".") >= 0) {
                    extName = fileName.substring(fileName.lastIndexOf("."));
        }
        */
        String fileType = fileData.getContentType()  + ";" +  extName;

        taskService.createAttachment(fileType, taskID, processID, FilenameUtils.getBaseName(fileName), fileName, fileData.getInputStream());
		return "done";
	}

    @Transactional
    public BenefitEvalVO submitBenefitEvalInfo(BenefitEvalVO benefitEvalVO, List<BenefitEvalItemVO> benefitEvalForm) {
        Map<String, String> variables = new HashMap<String, String>();
        this.saveBenefitEvalInfo(benefitEvalVO, benefitEvalForm);   


        String processID = benefitEvalVO.getProcessID();
        Task task = taskService.createTaskQuery().processInstanceId(processID).singleResult();
        String taskID = task.getId();

        /*
        variables.put("tAssignee", benefitEvalVO.getAssignee());
        variables.put("dealRslt", benefitEvalVO.getDealRslt());
        variables.put("rsltDesc", benefitEvalVO.getRsltDesc());
        variables.put("dealOpinion", benefitEvalVO.getDealOpinion());
        taskService.setVariablesLocal(taskID, variables);
        variables.clear();
        */

        String dealRsltPropName = null;
        variables.put("vAssignee", benefitEvalVO.getAssignee());
        variables.put("hasDept", benefitEvalVO.getHasDept()+"");
        List<FormProperty> formProperties = formService.getTaskFormData(taskID).getFormProperties();
        for (FormProperty formProperty : formProperties){
            if (formProperty.getType().getName() == "enum") dealRsltPropName = formProperty.getName();
        }
        variables.put(dealRsltPropName, benefitEvalVO.getDealRslt());
        formService.submitTaskFormData(taskID, variables);

        return benefitEvalVO;
    }
    public Map<String, String> getDealRsltOption(String taskID) {
        List<FormProperty> formProperties = formService.getTaskFormData(taskID).getFormProperties();
        Map<String, String> rsltOption = null;
        for (FormProperty formProperty : formProperties){
            if (formProperty.getType().getName() == "enum")
                rsltOption =  (Map<String, String>)formProperty.getType().getInformation("values");
        }
        return rsltOption;
    }

    public List<TaskHisItemVO> getTaskHis(String processID) {
        return benefitEvalRepo.getTaskHis(processID);
    }

    public int getEvalIDByProcessID(String processID) {

        return benefitEvalRepo.getBenefitEvalByProcessID(processID).getEvalID();
    }
    
    @Transactional
    public BenefitEvalVO saveBenefitEvalInfo(BenefitEvalVO benefitEvalVO, List<BenefitEvalItemVO> benefitEvalForm) {
        BenefitEval benefitEval = null;
        BenefitEvalItem benefitEvalItem = null;
        String processID = "";
        Map<String, Object> variables = new HashMap<String, Object>();

        String evalCode = benefitEvalVO.getEvalCode();
        int evalPhase = benefitEvalVO.getEvalPhase();
        int evalID = 0;
        /*
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey("ppp").taskAssignee("lenson").list();
        String taskName = new String("abc");
        for (Task task : tasks) {
                logger.info(task.getName());
                    taskName = new String(task.getName());
        }
        */
        
        if (evalCode == null || evalCode.length() == 0 ) {
            String procCreator= benefitEvalVO.getCreator();
            variables.put("vAssignee", procCreator);
            evalCode = this.getEvalCode("XYPG", evalPhase);
            logger.info("获取EvalCode！----------------------------evalCode: "+ evalCode); 
            logger.info("获取EvalCode！----------------------------hasDept: "+ benefitEvalVO.getHasDept()); 
            identityService.setAuthenticatedUserId(procCreator);
            ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("BenefitEvalProcess", evalCode, variables);
            benefitEval = new BenefitEval();
            processID = processInstance.getProcessInstanceId();
            logger.info("获取-------------------processID: "+ processID); 
            benefitEval.setProcessID(processID);
            benefitEval.setEvalCode(evalCode);
            benefitEval.setEvalTitle( benefitEvalVO.getEvalTitle() );
            benefitEval.setHasDept( benefitEvalVO.getHasDept() );
            benefitEval.setTplID( benefitEvalVO.getTplID() );
            benefitEval.setCreator(procCreator);
            benefitEval.setCreateDate(new Date());
            benefitEvalRepo.save(benefitEval);
            evalID =  benefitEval.getEvalID();

            for (BenefitEvalItemVO benefitEvalItemVO : benefitEvalForm) {
                benefitEvalItem = new BenefitEvalItem();
                benefitEvalItem.setEvalID(evalID);
                BeanUtils.copyProperties(benefitEvalItemVO, benefitEvalItem);
                benefitEvalItemRepo.save(benefitEvalItem);
                logger.info("保存Item-----------:  "+ benefitEvalItemVO.getEvalValue()+"----"+benefitEvalItemVO.getEvalNote());
            }

        } else {
            logger.info("保存已有Eval！----------------------------: "); 
            //variables.put("vAssignee", benefitEvalVO.getAssignee());
            
            evalID = benefitEvalVO.getEvalID();
            benefitEval = benefitEvalRepo.getBenefitEvalByEvalID(evalID);
            processID = benefitEval.getProcessID();
            logger.info("获取-------------------processID: "+ processID); 
            benefitEval.setEvalTitle( benefitEvalVO.getEvalTitle() );
            benefitEval.setHasDept( benefitEvalVO.getHasDept() );
            benefitEval.setCreateDate(new Date());
            benefitEvalRepo.save(benefitEval);


            for (BenefitEvalItemVO benefitEvalItemVO : benefitEvalForm) {
                int itemID = benefitEvalItemVO.getItemID();
                benefitEvalItem = benefitEvalItemRepo.getBenefitEvalItemByItemID(itemID);
                BeanUtils.copyProperties(benefitEvalItemVO, benefitEvalItem);
                benefitEvalItemRepo.save(benefitEvalItem);
                logger.info("保存Item-----------:  "+ benefitEvalItemVO.getEvalValue()+"----"+benefitEvalItemVO.getEvalNote());
            }


        }
        logger.info("----------------------------savedEvalID:   "+benefitEval.getEvalID()); 
        logger.info("保存后的evalID----------------------------evalID: "+ benefitEval.getEvalID()); 

            logger.info("获取-------------------processID: "+ processID); 
        String taskID = taskService.createTaskQuery().processInstanceId(processID).singleResult().getId();
        logger.info("------------taskID:  "+ taskID+"   ----------------processID: "+ processID); 
        Map<String, Object> submitInfo = new HashMap<String, Object>();
        submitInfo.put("tAssignee", benefitEvalVO.getAssignee());
        submitInfo.put("dealRslt", benefitEvalVO.getDealRslt());
        submitInfo.put("rsltDesc", benefitEvalVO.getRsltDesc());
        submitInfo.put("dealOpinion", benefitEvalVO.getDealOpinion());
        taskService.setVariablesLocal(taskID, submitInfo);

        BeanUtils.copyProperties(benefitEval, benefitEvalVO);
        return benefitEvalVO;
    }

	@Transactional
	public String getEvalCode(String deptShortName, int  iCodeType){
        List<EvalCodeGen> evalCodeInfo = null;
        String evalCode = "";

        String codeType = null;
        if ( iCodeType == 0 ) {
            codeType = new String("BF"); 
        }else  {
            codeType = new String("AF"); 
        }

		evalCodeGenRepo.incrementEvalCode(deptShortName, codeType);
		evalCodeInfo=evalCodeGenRepo.getByDeptShortNameAndCodeType(deptShortName, codeType);
		evalCode = "000" + evalCodeInfo.get(0).getCurrValue();
		evalCode = deptShortName +"-" + codeType  + "-" + evalCodeInfo.get(0).getYearMonth() + "-" + evalCode.substring(evalCode.length()-3);
		return evalCode;
	}

    public BenefitEvalVO getBenefitEvalInfo(int evalID) {
        BenefitEvalVO benefitEvalVO = new BenefitEvalVO();
        BenefitEval benefitEval = benefitEvalRepo.getBenefitEvalByEvalID(evalID);
        String processID = benefitEval.getProcessID();
        Task task = taskService.createTaskQuery().processInstanceId(processID).singleResult();
        BenefitEvalTpl benefitEvalTpl = benefitEvalTplRepo.getBenefitEvalTplByTplID(benefitEval.getTplID());
        BeanUtils.copyProperties(benefitEval, benefitEvalVO);
        benefitEvalVO.setTplTitle(benefitEvalTpl.getTplTitle());
        benefitEvalVO.setEvalPhase(benefitEvalTpl.getEvalPhase());
        benefitEvalVO.setEvalFor(benefitEvalTpl.getEvalFor());



        Map<String, Object> variables = null;
        if (task != null){
            benefitEvalVO.setTaskName(task.getName());
            String taskID = task.getId();
            List<Attachment> attachments = taskService.getProcessInstanceAttachments(processID);

            if (attachments.size() != 0) {
                AttachmentVO attachmentVO = null;
                List<AttachmentVO> attachmentsVO = benefitEvalVO.getAttachments();
                for (Attachment attachment:attachments) {

                    attachmentVO = new AttachmentVO();
                    attachmentVO.setAttachID(attachment.getId());
                    attachmentVO.setAttachName(attachment.getName());
                    attachmentVO.setAttachType(attachment.getType());
                    attachmentsVO.add(attachmentVO);
                }
            }

            logger.info("-----------tttt-----------------taskID:   "+taskID); 
            variables = taskService.getVariablesLocal(taskID);
            if (variables != null && variables.size() !=0) {
                String assignee = variables.get("tAssignee").toString(); 
                String dealRslt = variables.get("dealRslt").toString(); 
                String rsltDesc= variables.get("rsltDesc").toString(); 
                String dealOpinion = variables.get("dealOpinion").toString(); 
                benefitEvalVO.setAssignee(assignee);
                benefitEvalVO.setDealRslt(dealRslt);
                benefitEvalVO.setDealOpinion(dealOpinion);
            }
        } else {
            benefitEvalVO.setTaskName("流程结束");
        }

        

        return benefitEvalVO;
    }
    public PageModel<TaskTodoItemVO> getTaskTodo(String loginName, int pageNo) {
            return benefitEvalRepo.getTaskTodo(loginName, pageNo);
    }
    public PageModel<TaskTodoItemVO> getTaskDone(String loginName, int pageNo) {
            return benefitEvalRepo.getTaskDone(loginName, pageNo);

    }
}
