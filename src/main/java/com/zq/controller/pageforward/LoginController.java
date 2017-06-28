package com.zq.controller.pageforward;

import javax.servlet.http.HttpServletRequest;

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
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.utils.CMCCConstant;
import com.zq.commons.utils.StringUtils;
import com.zq.service.SysMenuService;


/** 
* @ClassName: LoginController 
* @Description: TODO(登陆) 
* @author shujukuss 
* @date 2017年6月18日 下午7:01:35 
*  
*/
@Controller
@RequestMapping("/") 
public class LoginController {	
	private static Logger logger = Logger.getLogger(LoginController.class);  
	
	@Autowired
	SysMenuService sysMenuService;	
	
	@RequestMapping(value = "login", method = RequestMethod.GET)  
	 public String login(){  
		logger.info("登录中！"); 
		return CMCCConstant.LOGIN;  
	 } 
	/** 
	* @Title: login 
	* @Description: TODO(登录校验) 
	* @author shujukuss 
	* @date 2017年6月25日 下午6:56:04 
	* @param @param user
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {		 	
		    String msg = "";  
		    String userName = request.getParameter("userName");  
		    String password = request.getParameter("password");  
		    logger.info("userName:" + userName + "请求登录！"); 
		    if (StringUtils.isBlank(userName)) {
		    	 logger.warn("用户名不能为空");
		    	 throw new RuntimeException("用户名不能为空");
	        }
	        if (StringUtils.isBlank(password)) {
	        	 logger.warn("密码不能为空");
	        	 throw new RuntimeException("密码不能为空");
	        }
		    UsernamePasswordToken token = new UsernamePasswordToken(userName, password);  
		    token.setRememberMe(true);  
		    Subject subject = SecurityUtils.getSubject();  
		    try {  
		        subject.login(token);  
		        if (subject.isAuthenticated()) { 
		        	logger.info("userName:" + userName + "登录成功！"); 
		        	request.getSession().setAttribute("userName", userName);
		            return CMCCConstant.CVDashBoard;  
		        } else {  
		            return CMCCConstant.LOGIN;  
		        }  
		    } catch (IncorrectCredentialsException e) {  
		        msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
		        model.addAttribute("message", msg);  
		        logger.warn(msg);  
		    } catch (ExcessiveAttemptsException e) {  
		        msg = "登录失败次数过多";  
		        model.addAttribute("message", msg);  
		        logger.warn(msg);  
		    } catch (LockedAccountException e) {  
		        msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";  
		        model.addAttribute("message", msg);  
		        logger.warn(msg);  
		    } catch (DisabledAccountException e) {  
		        msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";  
		        model.addAttribute("message", msg);  
		        logger.warn(msg);  
		    } catch (ExpiredCredentialsException e) {  
		        msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";  
		        model.addAttribute("message", msg);  
		        logger.warn(msg);   
		    } catch (UnknownAccountException e) {  
		        msg = "帐号不存在. There is no user with username of " + token.getPrincipal();  
		        model.addAttribute("message", msg);  
		        logger.warn(msg);   
		    } catch (UnauthorizedException e) {  
		        msg = "您没有得到相应的授权！" + e.getMessage();  
		        model.addAttribute("message", msg);  
		        logger.warn(msg);   
		    }  
		    return CMCCConstant.LOGIN;
	}
    
	/** 
	* @Title: unauth 
	* @Description: TODO(未授权) 
	* @author shujukuss 
	* @date 2017年6月27日 下午6:07:00 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "unauth", method = RequestMethod.POST)
    public String unauth() {
        if (SecurityUtils.getSubject().isAuthenticated() == false) {
            return CMCCConstant.LOGIN;
        }
        return "unauth";
    }


    /** 
    * @Title: logout 
    * @Description: TODO(退出) 
    * @author shujukuss 
    * @date 2017年6月27日 下午6:08:03 
    * @param @return    设定文件 
    * @return Object    返回类型 
    * @throws 
    */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        logger.info("登出");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return CMCCConstant.LOGIN;
    }
}
