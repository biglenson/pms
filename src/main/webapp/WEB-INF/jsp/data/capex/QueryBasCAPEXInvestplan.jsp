<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%
	String path = request.getContextPath();
	String pageTitle = "CAPEX投资计划";
%>
<%-- 输出Head模块 --%>
<jsp:include page="../../common/Head.jsp" />
<script type="text/javascript">
function editFun(id) {
	var arg = new Array();
	arg.src = "<%=path%>/capex/bascapexinvestplan/edit?id="+id;
	arg.title = "<%= pageTitle %>";
	arg.width = 840;
	arg.height = document.body.clientHeight - 20;
	parent.ET.showNewWindow(arg, function (ret) { 
		if(ret != null){
			document.frm.submit();
		}
	});	
}
</script>
<form name="frm" action="<%=path%>/SimpleFormAction.do" method="post">
<div class="toolbar" id="toolbarDIV" >
	<table class="toolbarTable" style="margin-left:30px;">
		<tbody>
			<tr>
				<%=UIUtils.toolbarButton(true,"javascript:editFun(\"0\");", "编辑", "save.gif",false,false, request)%>
				<%=UIUtils.toolbarButton(true,"javascript:cancel();", "取消", "back.gif", false,false,request)%>
			</tr>
		</tbody>
	</table>
</div>
	<div id="propDIV" class="propTableDIV" style="overflow: auto;">
		<div style="width: 760px; margin: 0 auto;">
			<table class="formTable" id="fieldTable">
				<tbody>
					<tr>
						<td class="label white_background-color"></td>
						<td class="content white_background-color"></td>
						<td class="seperator"></td>
						<td class="label white_background-color"></td>
						<td class="content white_background-color"></td>
					</tr>
					<tr>
						<td class="label">投资计划编号</td>
						<td class="content" id="codetd">
							<div class="content-line" id="div-codeName">17000004<input type="hidden" name="code" value="17000004">
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="5" height="5"></td>
					</tr>
					<tr>
						<td colspan="5"><div class="formTitleRow" onclick="javascript:ET.toggleFormTitlePanel(this);">
								<div class="togglePanelHeader">
									<table style="width: 100%">
										<tbody>
											<tr>
												<td><div class="toogleFormImg"></div></td>
												<td nowrap="nowrap">总部下达</td>
												<td style="width: 100%">
												<div class=" togglePanelHeaderLine"></div></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div></td>
					</tr>
					<tr>
						<td colspan="5" height="5"></td>
					</tr>
					<tr>
						<td class="label">年份</td>
						<td class="content  " id="num01td"><div class="content-line" id="div-num01Name">2017</div></td>
						<td class="seperator"></td>
						<td class="label">版本</td>
						<td class="content  " id="enum02td"><div class="content-line" id="div-enum02Name"></div></td>
					</tr>
					<tr>
						<td colspan="5" height="5"></td>
					</tr>
					<tr>
						<td class="label">一级专业</td>
						<td class="content  " id="enum01td"><div class="content-line" id="div-enum01Name">&nbsp;</div></td>
						<td class="seperator"></td>
						<td class="label">二级专业</td>
						<td class="content  " id="str06td"><div class="content-line" id="div-str06Name">&nbsp;</div></td>
					</tr>
					<tr>
						<td colspan="5" height="5"></td>
					</tr>
					<tr>
						<td class="label">三级专业</td>
						<td class="content  " id="str07td"><div class="content-line" id="div-str07Name">&nbsp;</div></td>
						<td class="seperator"></td>
						<td class="label">四级专业</td>
						<td class="content  " id="str08td"><div class="content-line" id="div-str08Name">&nbsp;</div></td>
					</tr>
					<tr>
						<td colspan="5" height="5"></td>
					</tr>
					<tr>
						<td class="label">属性</td>
						<td class="content  " id="enum04td"><div class="content-line" id="div-enum04Name">其他&nbsp;</div></td>
						<td class="seperator"></td>
						<td class="label">投资项目集/项目名称</td>
						<td class="content  " id="str18td"><div class="content-line" id="div-str18Name">徐晓秋&nbsp;</div></td>
					</tr>
					<tr>
						<td colspan="5" height="5"></td>
					</tr>
					<tr>
						<td class="label">投资项目集/项目编码</td>
						<td class="content  " id="str01td"><div class="content-line" id="div-str01Name">ssss&nbsp;</div></td>
						<td class="seperator"></td>
						<td class="label">部门</td>
						<td class="content  " id="sys01td"><div class="content-line" id="div-sys01Name">&nbsp;</div></td>
					</tr>
					<tr>
						<td colspan="5" height="5"></td>
					</tr>
					<tr>
						<td class="label">项目集总投资（元）</td>
						<td class="content  " id="num02td"><div class="content-line" id="div-num02Name">&nbsp;</div></td>
						<td class="seperator"></td>
						<td class="label">项目集当年资本开支计划（元）</td>
						<td class="content  " id="num03td"><div class="content-line" id="div-num03Name">&nbsp;</div></td>
					</tr>
					<tr>
						<td colspan="5" height="5"></td>
					</tr>
					<tr>
						<td class="label">上年累计已完成资本开支（元）</td>
						<td class="content  " id="num06td"><div class="content-line" id="div-num06Name">&nbsp;</div></td>
						<td class="seperator"></td>
						<td class="label">项目集结转资本开支（元）</td>
						<td class="content  " id="num04td"><div class="content-line" id="div-num04Name">&nbsp;</div></td>
					</tr>
					<tr>
						<td colspan="5" height="5"></td>
					</tr>
					<tr>
						<td class="label">项目主要建设内容</td>
						<td colspan="4" class="content" id="text01td"><div
								class="content-textarea" id="div-text01Name">
								<div style="overflow-x: auto; overflow-y: auto; height: 60px;"></div>
							</div></td>
					</tr>
					<tr>
						<td colspan="5" height="5"></td>
					</tr>
					<tr>
						<td height="10">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="5" height="5"></td>
					</tr>
					<tr>
						<td class="label">创建人</td>
						<td class="content  " id="createBytd">
							<div class="content-line" id="div-createByName">管理员</div>
						</td>
						<td class="seperator"></td>
						<td class="label">创建时间</td>
						<td class="content  " id="createTimetd"><div
								class="content-line" id="div-createTimeName">
								<input type="hidden" name="createTime" value="2017-05-09">2017-05-09&nbsp;
							</div></td>
					</tr>
					<tr>
						<td colspan="5" height="5"></td>
					</tr>
					<tr>
						<td class="label">修改人</td>
						<td class="content  " id="lastUpdateBytd">
							<div class="content-line" id="div-lastUpdateByName">管理员</div>
						</td>
						<td class="seperator"></td>
						<td class="label">最后修改时间</td>
						<td class="content  " id="lastUpdateTimetd"><div
								class="content-line" id="div-lastUpdateTimeName">
								<input type="hidden" name="lastUpdateTime" value="2017-05-09">2017-05-09&nbsp;
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</form>