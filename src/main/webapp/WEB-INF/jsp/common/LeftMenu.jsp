<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.result.Tree"%>
<%@ page import=" org.apache.shiro.session.Session"%>
<%
	List<Tree> menuList = (List<Tree>)session.getAttribute("NavMenu");
%>
<div class="leftAllDIV  null" id="bodyLeftAllDIV">
	<!-- 展开菜单 -->
	<div class="leftsidebar null" id="bodyStart_leftsidebar">
		<div class="sidebar" id="bodyStart_menuDIV">
			<div id="defaultLeftMenuDIV" style="position: absolute; top: 0px; bottom: 37px; width: 100%; overflow: hidden;" class="dumascroll">
				<!-- 菜单项 -->
				<div class="dumascroll_area showYScroll">	
				<ul>			
				<%for(Tree menu : menuList){
					if(menu.getAppid()== Integer.parseInt(request.getParameter("appid"))&& menu.getPid() == Integer.parseInt(request.getParameter("pid"))){%>
					<li>
						<a class="menuDIV menuLevel1 <%=request.getParameter("url").equals(menu.getAttributes())?"menuSelected":""%>" href="<%=menu.getAttributes() %>">
							<img class="sidebarimg" src="<%= menu.getIconCls() %>"><%= menu.getText() %>
						</a>					
					</li>
				<%}} %>
				</ul>
				</div>				
				<div class="dumascroll_barY">
					<div class="dumascroll_arrow_up"></div>
					<div class="dumascroll_handleY" style="height: 69.0313px; top: 0px;"></div>
					<div class="dumascroll_arrow_down"></div>
				</div>
				<div class="dumascroll_barX showYScroll" style="display: none;">
					<div class="dumascroll_arrow_left"></div>
					<div class="dumascroll_handleX"></div>
					<div class="dumascroll_arrow_right"></div>
				</div>
				<div class="duma_rightButtom showYScroll"></div>
			</div>
			<!-- 左侧打开时的箭头 -->
			<div id="leftMenuSettingDIV">
				<div id="leftMenu_splitOpen" class="split_Open" onclick="toggleLeft();"></div>
			</div>
			<script type="text/javascript">
					function outMenuWrapScrollBar_Fun(){
						var divMenu1=document.getElementById("defaultLeftMenuDIV");
						var divMenu2=document.getElementById('leftMenuSettingDIV');
						var height= divMenu2!=null?divMenu2.offsetHeight:0;
						if(height<20&&divMenu2!=null){
							height=36;
						}
						divMenu1.style.bottom=height+"px";
						var leftScrollDIVID="defaultLeftMenuDIV";
						
						window.menu_Scroll_Bar=new ET.ScrollBar(leftScrollDIVID);
					}
					outMenuWrapScrollBar_Fun();
			</script>
		</div>
	</div>
	<!-- 缩略菜单 -->
	<div id="bodyStart_simpleMenuDiv" class="simpleMenuDiv  null">
		<div class="simpleContainer">
			<ul>			
			<%for(Tree menu : menuList){
				if(menu.getAppid()== Integer.parseInt(request.getParameter("appid"))&& menu.getPid() == Integer.parseInt(request.getParameter("pid"))){%>					
					<li class="simpleLevelMenu <%=request.getParameter("url").equals(menu.getAttributes())?"menuSelected":""%>">			
						<div class="simpleMenuImgDIV <%=request.getParameter("url").equals(menu.getAttributes())?"menuSelected":""%>"><a href="<%=menu.getAttributes() %>">
							<img class="simpleLevelMenuImg" src="<%= menu.getIconCls() %>"></a>
						</div>
						<div class="simpleLevelMenuChildren onlyOne">
							<div class="level2SimpleOnly">
								<div><a href="<%=menu.getAttributes() %>"><%= menu.getText() %></a></div>
							</div>
						</div>				
					</li>
			<%} }%>
			</ul>			
			<!-- 左侧收起时的箭头 -->
			<div id="simpleContainer2">
				<div style="border-top: 1px solid #BAC4CC; height:36px; position: relative; cursor: pointer;" onclick="toggleLeft();">
					<div id="leftMenu_splitClose" class="split_close"></div>
				</div>
			</div>
		</div>
	</div>
</div>