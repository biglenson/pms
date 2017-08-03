package com.zq.commons.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.zq.commons.result.PageInfo;
import com.zq.entity.system.SysForm;
import com.zq.entity.system.User;

/** 
* @ClassName: UIUtils 
* @Description: TODO(表单页面样式和按钮) 
* @author shujukuss 
* @date 2017年7月14日 下午2:45:32 
*  
*/
public class UIUtils {
	public static Pattern FUNCTION_PATTERN = Pattern.compile("['\"]");
	/** 
	* @Title: toolbarButton 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author shujukuss 
	* @date 2017年7月14日 下午3:34:13 
	* @param @param enabled 启用
	* @param @param function js函数
	* @param @param label 显示名称
	* @param @param image 图片
	* @param @param isDown 下箭头（基线比较）
	* @param @param isSearch 搜索图标（搜索框）
	* @param @param request 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public static String toolbarButton(boolean enabled, String function, String label, String image, boolean isDown,boolean isSearch, HttpServletRequest request)
	  {
		String path = request.getContextPath();
	    StringBuilder sb = new StringBuilder();
	    if ((image != null) && (image.equals("search.gif"))) {
	      image = "search.png";
	    }
	    boolean isEmpty = false;
	    String messageLabel = TypeUtils.nullToString(label).length() > 0 ? TypeUtils.nullToString(label) : "";
	    if (messageLabel == null) {
	      messageLabel = label;
	    }
	    isEmpty = messageLabel.isEmpty();
	    if (isEmpty) {
	      return sb.toString();
	    }
	    sb.append("<td id=\"ET_ToolbarButton\"  ");
	    sb.append(" class='").append(enabled ? "toolbarEnable" : "toolbarDisable");
	    sb.append("' ");
	    sb.append(" align='center' nowrap");
	    sb.append(" >");
	    sb.append("<div class=\"ET_ToolbarButtonContainer ");
	    if (!enabled) {
	      sb.append(" labelDisable ");
	    }
	    if (isDown) {
	      sb.append(" ET_ToolbarButtonContainerNoBackGround ");
	    }
	    sb.append("\" ");
	    if (enabled) {
	      sb.append("  onclick=\"");
	      sb.append(escapeFunction(function));
	      sb.append("\"");
	    }
	    sb.append(">");

	    File imageFile = null;
	    File on_imageFile = null;
	    boolean hasImage = false;
	    if ((image != null) && (image.length() > 0)) {
	      imageFile = new File(request.getSession().getServletContext().getRealPath("/static/images/newui"), image);
	      if (imageFile.exists()) {
	        hasImage = true;
	        int current_imageIndex = image.lastIndexOf(".");
	        String current_menuImg_on = image.substring(0, current_imageIndex) + "_on" + image.substring(current_imageIndex);
	        on_imageFile = new File(request.getSession().getServletContext().getRealPath("/static/images/newui"), current_menuImg_on);
	        sb.append("<span class=\"ET_ToolbarButtonImg\"><img src=\"").append(request.getContextPath()).append("/static/images/newui/").append(image);
	        sb.append(" \" ");
	        if ((on_imageFile != null) && (on_imageFile.exists())) {
	          sb.append(" overImg=\"").append(path).append("/static/images/newui/").append(on_imageFile.getName()).append("\"");
	        }
	        sb.append("/>");
	        sb.append("</span>");
	      }
	    }

	    sb.append("<span id=\"ET_ToolbarButtonLabel\"  ");
	    sb.append("class=\"");
	    if (!hasImage) {
	      sb.append(" labelNoImg ");
	    }
	    else if (isSearch)
	      sb.append(" labelSearch");
	    else {
	      sb.append(" labelWidthImg ");
	    }

	    sb.append(" \" ");
	    sb.append(" >");
	    if (TypeUtils.nullToString(label).length() > 0) {
	      sb.append(messageLabel);
	    }
	    sb.append("</span>");
	    if (isDown) {
	      sb.append("<span class='dropDowImg'>");
	      sb.append("<img src='");
	      sb.append(path);
	      sb.append("/static/images/16x16/toolbar-dropDown.png'  >");
	      sb.append("</span>");
	    }
	    sb.append("</div>");
	    sb.append("</td>");

	    return sb.toString();
	  }
	  public static String escapeFunction(String function) {
		    return FUNCTION_PATTERN.matcher(function).replaceAll("&quot;");
	}
	  /** 
	* @Title: searchToolButton 
	* @Description: TODO(搜索框) 
	* @author shujukuss 
	* @date 2017年7月14日 下午3:35:37 
	* @param @param function
	* @param @param label
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public static String searchToolButton(String function, String label, HttpServletRequest request) {
		    return toolbarButton(true, function, label, "search.png", false ,true, request);
	}
	
	  public static String pageToolbar(PageInfo pageInfo, HttpServletRequest request)
	  {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<script type='text/javascript'>");
	    sb.append("function changePage (page) {");
	    sb.append("document.frm.page.value=page;");
	    sb.append("document.frm.submit();");
	    sb.append("}");
	    sb.append("</script>");

	    sb.append(pageFunctionToolbar("changePage", pageInfo, request));
	    return sb.toString();
	  }
	  
	  public static String pageFunctionToolbar(String function, PageInfo pageInfo, HttpServletRequest request)
	  {
	    String path = request.getContextPath();
	    StringBuffer sb = new StringBuffer();
	    if ("changeOtherPage".equals(function))
	      sb.append("<div class=\"pageFooter\" id=\"otherPageToolbarDIV\">");
	    else {
	      sb.append("<div class=\"pageFooter\" id=\"pageToolbarDIV\">");
	    }
	    sb.append("<span>");
	    if (pageInfo.getCurrentPage() > 1) {
	      sb.append("<a class=\"pageToolBarLink page_first\" href=\"javascript:" + function + "(1);\"><img ");
	      sb.append(" src='");
	      sb.append(path);
	      sb.append("/static/images/16x16/arrow_first.png'  ");
	      sb.append(" overImg='");
	      sb.append(path);
	      sb.append("/static/images/16x16/arrow_first_over.png'  ");
	      sb.append("  border='0'>");
	      sb.append("</a><a   class=\"pageToolBarLink page_prev \"  href=\"javascript:" + function + "('");
	      sb.append(pageInfo.getCurrentPage() - 1);
	      sb.append("');\"><img ");
	      sb.append(" src='");
	      sb.append(path);
	      sb.append("/static/images/16x16/arrow_prev.png'  ");
	      sb.append(" overImg='");
	      sb.append(path);
	      sb.append("/static/images/16x16/arrow_prev_over.png'  ");
	      sb.append(" border='0'></a>");
	    }
	    else {
	      sb.append("<a class=\"pageToolBarLink page_first \"> <img src='");
	      sb.append(path);
	      sb.append("/static/images/16x16/arrow_first_disable.png'  border='0'>");
	      sb.append("</a>");
	      sb.append("<a  class=\"pageToolBarLink page_prev\">");
	      sb.append("<img src='");
	      sb.append(path);
	      sb.append("/static/images/16x16/arrow_prev_disable.png'  border='0'>");
	      sb.append("</a>");
	    }

	    sb.append("<select name='pageNo'  onchange='" + function + "(this.value);'>");
	    for (int i = 1; i <= pageInfo.getPageCount(); i++) {
	      sb.append("<option value='");
	      sb.append(i);
	      if (i == pageInfo.getCurrentPage())
	        sb.append("' selected>");
	      else {
	        sb.append("'>");
	      }
	      sb.append(i);
	      sb.append("</option>");
	    }
	    sb.append("</select>");
	    sb.append(" <div class='pageCount'>").append("/").append(pageInfo.getPageCount()).append("页").append("</div>");

	    if ((pageInfo.getCurrentPage() < pageInfo.getPageCount()) && (pageInfo.getPageSize() < pageInfo.getTotalRows()))
	    {
	      sb.append("<a  class=\"pageToolBarLink page_next\" href=\"javascript:" + function + "('");
	      sb.append(pageInfo.getCurrentPage() + 1);
	      sb.append("');\"><img ");
	      sb.append(" src='");
	      sb.append(path);
	      sb.append("/static/images/16x16/arrow_next.png' ");

	      sb.append(" overImg='");
	      sb.append(path);
	      sb.append("/static/images/16x16/arrow_next_over.png' ");

	      sb.append(" border='0'>");
	      sb.append("</a><a class=\"pageToolBarLink page_end\" href=\"javascript:" + function + "('");
	      sb.append(pageInfo.getPageCount());
	      sb.append("');\"><img  ");
	      sb.append(" src='");
	      sb.append(path);
	      sb.append("/static/images/16x16/arrow_last.png' ");

	      sb.append(" overImg='");
	      sb.append(path);
	      sb.append("/static/images/16x16/arrow_last_over.png' ");
	      sb.append(" border='0'></a>");
	    }
	    else {
	      sb.append("<a class=\"pageToolBarLink page_next\" ><img src='");
	      sb.append(path);
	      sb.append("/static/images/16x16/arrow_next_disable.png'  border='0'>");
	      sb.append("</a> <a class=\"pageToolBarLink page_end\" ><img src='");
	      sb.append(path);
	      sb.append("/static/images/16x16/arrow_last_disable.png'  border='0'></a>");
	    }
	    sb.append("</span>");
	    sb.append("<span class='pageText' >");

	    sb.append("共");
	    sb.append(pageInfo.getTotalRows());
	    sb.append("条");

	    sb.append("</span>");

	    sb.append("</div>");
	    String resultStr = sb.toString();
	    if (pageInfo.getTotalRows() == 0) {
	      if ("changeOtherPage".equals(function))
	        resultStr = pageTotal_other(pageInfo.getTotalRows(), request);
	      else {
	        resultStr = pageTotal(pageInfo.getTotalRows(), request);
	      }
	    }
	    return resultStr;
	  }
	  
	  public static String pageTotal_other(int rowCount, HttpServletRequest request) {
		    StringBuffer sb = new StringBuffer();
		    sb.append("<div id=\"otherPageToolbarDIV\" class='tableFooter'>");
		    sb.append(TypeUtils.xmlEncoderForIE("共"));
		    sb.append("&nbsp;<span id='pageTotal'>");
		    sb.append(rowCount);
		    sb.append("</span>&nbsp;");
		    sb.append(TypeUtils.xmlEncoderForIE("条"));
		    sb.append("</div>");
		    return sb.toString();
	  }
	  public static String pageTotal(int rowCount, HttpServletRequest request) {
		    StringBuffer sb = new StringBuffer();
		    sb.append("<div id=\"pageTotalDIV\" class='tableFooter'>");
		    sb.append(TypeUtils.xmlEncoderForIE("共"));
		    sb.append("&nbsp;<span id='pageTotal'>");
		    sb.append(rowCount);
		    sb.append("</span>&nbsp;");
		    sb.append(TypeUtils.xmlEncoderForIE("条"));
		    sb.append("</div>");
		    return sb.toString();
	 }
	  public static String outFormHeadRow() {
		    return "<tr><td  class='label white_background-color'  ></td><td class='content white_background-color' ></td><td  class='seperator'></td><td  class='label white_background-color'></td><td  class='content white_background-color' ></td></tr>";
	}
	  public static String outFormTitleRow(String title)
	  {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<td colspan='5' >");
	    sb.append("<div class=\"formTitleRow\" onclick=\"javascript:ET.toggleFormTitlePanel(this);\" > ");
	    sb.append("<div class=\"togglePanelHeader\"> <table style='width:100%'  ><tbody><tr>");

	    sb.append("<td><div class='toogleFormImg'></div> </td>");
	    sb.append("<td nowrap=\"nowrap\">");
	    sb.append(title).append("</td><td style=\"width:100%\"><div class=\" togglePanelHeaderLine\"></div></td>");

	    sb.append("</tr></tbody></table></div>");
	    sb.append("</div>");
	    sb.append("</td>");
	    return sb.toString();
	  }
	  
	/**
	* @Title: tabPanelStart
	* @Description: TODO(Tab页签开始)
	* @author Administrator
	* @date 2017年7月26日 上午11:32:39
	* @param @param request
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	public static String tabPanelStart(HttpServletRequest request){
	  	StringBuilder sb = new StringBuilder();
	  	sb.append("<div class='topnav' >");
	  	sb.append(" <div class='hd' >");
	  	sb.append("   <ul>");
	  	return sb.toString();
	}
	
	/**
	* @Title: tabPanelEnd
	* @Description: TODO(Tab页签结束)
	* @author Administrator
	* @date 2017年7月26日 上午11:31:11
	* @param @param request
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	public static String tabPanelEnd(HttpServletRequest request){
	  	StringBuilder sb = new StringBuilder();
	  	sb.append("</ul>");
	  	sb.append(" </div>");
	  	sb.append("</div>");
	  	return sb.toString();
	}
	    
	/**
	* @Title: tabPanel
	* @Description: TODO(Tab页签)
	* @author Administrator
	* @date 2017年7月26日 上午11:31:54
	* @param @param enabled 是否启用
	* @param @param function 回调函数
	* @param @param label 显示的标签
	* @param @param name 属性值
	* @param @param isOn 是否选中
	* @param @param request 请求参数
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	public static String tabPanel(boolean enabled, String function, String label, String name, boolean isOn, HttpServletRequest request) {
	  	String labelStr = label == null ? "" : label;
	  	labelStr = TypeUtils.xmlEncoderForIE(labelStr);
	  	StringBuffer sb = new StringBuffer();
	  	sb.append("<li ");
	  	sb.append(" class='");
	  	if (isOn) {
	  	  sb.append(" on ");
	  	}
	  	if (!enabled) {
	  	  sb.append(" disable ");
	  	}
	  	sb.append("' ");
	  	sb.append("> ");
	  	sb.append("<a ");
	  	if ((enabled) && (!isOn) && (function != null)) {
	  	  sb.append(" href='");
	  	  sb.append(function);
	  	  sb.append("'");
	  	}
	  	sb.append(" >");
	
	  	sb.append(labelStr);
	
	  	if ((name != null) && (name.trim().length() > 0)) {
	  	  name = name.trim();
	  	  if (name.startsWith("(")) {
	  		name = name.substring(1);
	  	  }
	  	  if (name.endsWith(")")) {
	  		name = name.substring(0, name.length() - 1);
	  	  }
	  	  sb.append("<span class='countClass'>");
	  	  sb.append(name);
	  	  sb.append("</span>");
	  	}
	  	sb.append("</a>");
	
	  	sb.append("</li>");
	  	return sb.toString();
	}
	  
	/**
	* @Title: spacerDIV
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author Administrator
	* @date 2017年7月27日 下午4:52:19
	* @param @param height
	* @param @param request
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	public static String spacerDIV(String height, HttpServletRequest request) {
	    StringBuffer sb = new StringBuffer();
	    String heightStr = height == null ? "5" : height;
	    sb.append("<div style=\"");
	    sb.append("height:" + heightStr + "px;");
	    sb.append("\"");
	    sb.append(">&nbsp;</div>");
	    return sb.toString();
	}
	
	/**
	* @Title: formBodyStart
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author Administrator
	* @date 2017年7月30日 下午3:53:50
	* @param @param request
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	public static String formBodyStart(HttpServletRequest request) {
	    StringBuffer sb = new StringBuffer();
	    sb.append("<div id='propDIV' class='propTableDIV'>");
	    sb.append("<div style='width:760px;margin:0 auto;'>");
	    return sb.toString();
	}
	
	/**
	* @Title: formBodyEnd
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author Administrator
	* @date 2017年7月30日 下午3:53:53
	* @param @param request
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	public static String formBodyEnd(HttpServletRequest request) {
	    StringBuffer sb = new StringBuffer();
	    sb.append("</div></div>");
	    return sb.toString();
	}
	
	/**
	* @Title: toolbarStart
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author Administrator
	* @date 2017年7月30日 下午4:27:27
	* @param @param request
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	public static String toolbarStart(HttpServletRequest request){
	    StringBuffer sb = new StringBuffer();
	    sb.append("<div class='toolbar' id=\"toolbarDIV\">");
	    sb.append("<table class='toolbarTable' cellspacing='0' cellpadding='0'>");
	    sb.append("<tr>");
	    return sb.toString();
	}
	
	/**
	* @Title: toolbarEnd
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author Administrator
	* @date 2017年7月30日 下午4:27:30
	* @param @param request
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	public static String toolbarEnd(HttpServletRequest request){
	    StringBuffer sb = new StringBuffer();
	    sb.append("</tr>");
	    sb.append("</table>");
	    sb.append("</div>");
	    sb.append("<div class=\"Toolbar-spacing\"></div> ");
	    return sb.toString();
	}
	
	/**
	* @Title: toolbarFloatRight
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author Administrator
	* @date 2017年7月30日 下午4:52:38
	* @param @param request
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	public static String toolbarFloatRight(HttpServletRequest request) {
	    StringBuilder sb = new StringBuilder("<td width='100%'></td>");
	    return sb.toString();
	}
	
	/**
	* @Title: togglePanelStart
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author Administrator
	* @date 2017年7月30日 下午9:26:54
	* @param @param title
	* @param @param isToggle
	* @param @param request
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	public static String togglePanelStart(String title, boolean isToggle, HttpServletRequest request) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<div  class='togglePanelTable'> ");
	
	    sb.append("<div class='togglePanelHeader'> ");
	    sb.append("<table ");
	    if (isToggle) {
	      sb.append(" onclick=\"javascript:togglePanelNew(this);\"  style='cursor:pointer;' ");
	    }
	    sb.append(" >");
	    if (isToggle) {
	      sb.append("<td>");
	      sb.append("<div class='toogleFormImg'></div>");
	
	      sb.append("</td>");
	    }
	    sb.append("<td nowrap=\"nowrap\">");
	    sb.append(title);
	    sb.append("</td>");
	    sb.append("<td style='width:100%'><div class=\" togglePanelHeaderLine\"  ></div></td>");
	    sb.append("</table>");
	    sb.append("</div>");
	    sb.append("<div class='togglePanelContent'  > ");
	    return sb.toString();
	}
	
	/**
	* @Title: togglePanelEnd
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author Administrator
	* @date 2017年7月30日 下午9:26:50
	* @param @param request
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	public static String togglePanelEnd(HttpServletRequest request) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("</div>");
	    sb.append("</div>");
	    return sb.toString();
	}
}
