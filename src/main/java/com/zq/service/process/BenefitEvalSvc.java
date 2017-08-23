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
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;

@Component
public class BenefitEvalSvc{
    private static Log logger = LogFactory.getLog(BenefitEvalSvc.class);
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

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
            benefitEval.setCreator("Lenson");
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
        submitInfo.put("assignee", "Lenson");
        submitInfo.put("dealRslt", "提交");
        submitInfo.put("dealOpinion", "可以提交");
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
        BenefitEvalTpl benefitEvalTpl = benefitEvalTplRepo.getBenefitEvalTplByTplID(benefitEval.getTplID());
        BeanUtils.copyProperties(benefitEval, benefitEvalVO);
        benefitEvalVO.setTplTitle(benefitEvalTpl.getTplTitle());
        benefitEvalVO.setEvalPhase(benefitEvalTpl.getEvalPhase());
        benefitEvalVO.setEvalFor(benefitEvalTpl.getEvalFor());

        return benefitEvalVO;
    }
    public List<TaskTodoItemVO> getTaskTodo() {
            return benefitEvalRepo.getTaskTodo("lenson");
    }
    public List<TaskTodoItemVO> getTaskDone() {
            return benefitEvalRepo.getTaskDone("lenson");

    }
}
