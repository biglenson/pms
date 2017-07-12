package com.zq.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.zq.commons.shiro.ShiroUser;
import com.zq.commons.utils.StringEscapeEditor;
import com.zq.entity.system.Resource;
import com.zq.service.system.IResourceService;


/** 
* @ClassName: BaseController 
* @Description: TODO(基础controller，公共功能) 
* @author shujukuss 
* @date 2017年7月2日 上午11:46:47 
*  
*/
public abstract class BaseController {	
	
	private static Logger logger = Logger.getLogger(BaseController.class);  

    @Autowired
    private IResourceService iResourceService;
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        /**
         * 自动转换日期类型的字段格式
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        /**
         * 防止XSS攻击
         */
        binder.registerCustomEditor(String.class, new StringEscapeEditor());
    }

    /**
     * 获取当前登录用户对象
     * @return {ShiroUser}
     */
    public ShiroUser getShiroUser() {
        return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取当前登录用户id
     * @return {Long}
     */
    public Long getUserId() {
        return this.getShiroUser().getId();
    }

    /**
     * 获取当前登录用户名
     * @return {String}
     */
    public String getStaffName() {
        return this.getShiroUser().getName();
    }
    
    /** 
    * @Title: setLeftMenu 
    * @Description: TODO(侧边栏赋值) 
    * @author shujukuss 
    * @date 2017年7月12日 上午10:25:46 
    * @param @param request
    * @param @param url
    * @param @return    设定文件 
    * @return HttpServletRequest    返回类型 
    * @throws 
    */
    public HttpServletRequest setLeftMenu(HttpServletRequest request,String url){    	
    	Resource res = iResourceService.findByUrlNotRoot(url);
    	request.setAttribute("pageTitle",res.getName());
    	request.setAttribute("appid",res.getAppid());
    	request.setAttribute("pid",res.getPid());
    	request.setAttribute("url",url);
    	logger.info(res.getName() + "侧边栏赋值完成");
		return request;
    	
    }
}
