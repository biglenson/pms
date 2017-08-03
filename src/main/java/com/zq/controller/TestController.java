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

import java.util.*;



/** 
* @ClassName: TestController 
* @Description: TODO(登陆) 
* @author shujukuss 
* @date 2017年6月18日 下午7:01:35 
*  
*/
@Controller
@RequestMapping("/") 
public class TestController extends BaseController{	
	private static Logger logger = Logger.getLogger(TestController.class);  
	
    @Autowired
    private CMCCCaptcha cmccCaptcha;
    @Autowired
    private IResourceService iResourceService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private BenefitEvalTplSvc benefitEvalTplSvc;
	
	@RequestMapping(value = "test", method = RequestMethod.GET)  
	public String test(HttpServletRequest request, HttpServletResponse response, Model model,String captcha, 
            @RequestParam(value = "rememberMe", defaultValue = "0") Integer rememberMe) {		 	
        logger.info("测试中！----------------------------service begin"); 
        Map<String, Object> variables = new HashMap<String, Object>();
        List<BenefitEvalTplVO> benefitEvalTplVOList = benefitEvalTplSvc.getBenefitEvalTplList(0, 1);
        logger.info("测试中！----------------------------service 2"); 
        for (BenefitEvalTplVO benefitEvalTplVO : benefitEvalTplVOList) {
            logger.info("测试中！"+ benefitEvalTplVO.getTplTitle()); 
            

        }
        logger.info("测试中！----------------------------service 3"); 
        /*
        variables.put("subType", 1);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("ppp", "1", variables);
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey("ppp").taskAssignee("lenson").list();
        String taskName = new String("abc");
        for (Task task : tasks) {
            logger.info(task.getName());
            taskName = new String(task.getName());
        }
        identityService.setAuthenticatedUserId("lenson");
        model.addAttribute("message", "from controller");
        model.addAttribute("taskName", taskName);
        */

        model.addAttribute("message", "from controller");
        model.addAttribute("taskName", "message");
		return CMCCConstant.TEST;  
	 } 

}
