package com.zq.service.process;

import com.zq.vo.process.*;
import com.zq.entity.process.*;
import com.zq.dao.process.*;

import java.util.*;
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
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import java.io.*;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.FormService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.activiti.engine.task.Task;
import org.activiti.engine.form.FormProperty;

@Component
public class BenefitEvalSvc{
    private static Log logger = LogFactory.getLog(BenefitEvalSvc.class);
    @Autowired
    private RuntimeService runtimeService;

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

    @Transactional
    public BenefitEvalVO submitBenefitEvalInfo(BenefitEvalVO benefitEvalVO, List<BenefitEvalItemVO> benefitEvalForm) {
        Map<String, String> variables = new HashMap<String, String>();
        this.saveBenefitEvalInfo(benefitEvalVO, benefitEvalForm);   


        String processID = benefitEvalVO.getProcessID();
        Task task = taskService.createTaskQuery().processInstanceId(processID).singleResult();
        String taskID = task.getId();

        variables.put("assignee", "lenson");
        variables.put("dealRslt", benefitEvalVO.getDealRslt());
        //variables.put("rsltVal", benefitEvalVO.getDealRslt());
        variables.put("dealOpinion", benefitEvalVO.getDealOpinion());
        //taskService.addComment(taskID, processID, "BenefitEval", benefitEvalVO.getDealOpinion());
        taskService.setVariablesLocal(taskID, variables);
        variables.clear();

        String dealRsltPropName = null;
        variables.put("vAssignee", "lenson");
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
        variables.put("vAssignee", "lenson");

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
        identityService.setAuthenticatedUserId("lenson");
        */
        
        if (evalCode == null || evalCode.length() == 0 ) {
            evalCode = this.getEvalCode("XYPG", evalPhase);
            logger.info("获取EvalCode！----------------------------evalCode: "+ evalCode); 
            logger.info("获取EvalCode！----------------------------hasDept: "+ benefitEvalVO.getHasDept()); 
            ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("BenefitEvalProcess", evalCode, variables);
            benefitEval = new BenefitEval();
            processID = processInstance.getProcessInstanceId();
            logger.info("获取-------------------processID: "+ processID); 
            benefitEval.setProcessID(processID);
            benefitEval.setEvalCode(evalCode);
            benefitEval.setEvalTitle( benefitEvalVO.getEvalTitle() );
            benefitEval.setHasDept( benefitEvalVO.getHasDept() );
            benefitEval.setTplID( benefitEvalVO.getTplID() );
            benefitEval.setCreator("lenson");
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
        submitInfo.put("assignee", "lenson");
        submitInfo.put("dealRslt", benefitEvalVO.getDealRslt());
        submitInfo.put("dealOpinion", benefitEvalVO.getDealOpinion());
        taskService.setVariablesLocal(taskID, submitInfo);
        //taskService.addComment(taskID, processID, "BenefitEval", benefitEvalVO.getDealOpinion());

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
        benefitEvalVO.setTaskName(task.getName());
        logger.info("-----------dddddd-----------------createDate:   "+benefitEvalVO.getCreateDate()); 
        logger.info("-----------dddddd-----------------createDate:   "+benefitEval.getCreateDate()); 

        Map<String, Object> variables = null;
        if (task != null){
            String taskID = task.getId();
            logger.info("-----------tttt-----------------taskID:   "+taskID); 
            variables = taskService.getVariablesLocal(taskID);
            if (variables != null && variables.size() !=0) {
                String assignee = variables.get("assignee").toString(); 
                String dealRslt = variables.get("dealRslt").toString(); 
                String dealOpinion = variables.get("dealOpinion").toString(); 
                //String dealOpinion = taskService.getTaskComments(taskID, "BenefitEval").get(0).getFullMessage();
                benefitEvalVO.setAssignee(assignee);
                benefitEvalVO.setDealRslt(dealRslt);
                benefitEvalVO.setDealOpinion(dealOpinion);
            }
        }

        

        return benefitEvalVO;
    }
    public List<TaskTodoItemVO> getTaskTodo() {
            return benefitEvalRepo.getTaskTodo("lenson");
    }
    public List<TaskTodoItemVO> getTaskDone() {
            return benefitEvalRepo.getTaskDone("lenson");

    }
}
