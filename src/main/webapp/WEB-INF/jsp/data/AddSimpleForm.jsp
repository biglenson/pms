<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.zq.commons.utils.UIUtils" %>
<%
	String path = request.getContextPath();
%>
<%-- 输出Head模块 --%>
<jsp:include page="../common/Head.jsp" />
<form name="frm" action="<%=path%>/SimpleFormAction.do" method="post">
<div class="toolbar" id="toolbarDIV" >
	<table class="toolbarTable" style="margin-left:30px;">
		<tbody>
			<tr>
				<%=UIUtils.toolbarButton(true,"javascript:save(\"0\");", "保存", "save.gif",false,false, request)%>
				<%=UIUtils.toolbarButton(true,"javascript:cancel();", "取消", "back.gif", false,false,request)%>
			</tr>
		</tbody>
	</table>
</div>
<div style="overflow: auto;" class='relativeDIV' id="contentDIV">
	<div id='propDIV' class='propTableDIV'>
		<div style='width: 760px; margin: 0 auto;'>
				<table id="fieldTable" class='formTable'>
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
								<div class="content-line" id="div-codeName"></div>
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
													<div class=" togglePanelHeaderLine"></div>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="5" height="5"></td>
						</tr>
						<tr>
							<td class="label">年份</td>
							<td class="content  " id="num01td"><select name="num01" id="select-num01"><option value="">&nbsp;</option>
									<option value="2007">2007</option>
									<option value="2008">2008</option>
									<option value="2009">2009</option>
									<option value="2010">2010</option>
									<option value="2011">2011</option>
									<option value="2012">2012</option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015">2015</option>
									<option value="2016">2016</option>
									<option value="2017" selected="selected">2017</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									<option value="2020">2020</option>
									<option value="2021">2021</option>
									<option value="2022">2022</option>
									<option value="2023">2023</option>
									<option value="2024">2024</option>
									<option value="2025">2025</option>
									<option value="2026">2026</option>
									<option value="2027">2027</option></select></td>
							<td class="seperator"></td>
							<td class="label">版本</td>
							<td class="content  " id="enum02td"><select name="enum02"> 
							<option value="">&nbsp;</option>
									<option value="3273">年中</option>
									<option value="3274">年初</option></select></td>
						</tr>
						<tr>
							<td colspan="5" height="5"></td>
						</tr>
						<tr>
							<td class="label">一级专业</td>
							<td class="content  " id="enum01td"><input type="hidden"
								name="CodeTableType" value="1"><input type="hidden"
								name="CodeTableID" value="6"><select name="enum01"><option
										value="">&nbsp;</option>
									<option value="1">业务网</option>
									<option value="2">传输网</option>
									<option value="3">支撑网</option>
									<option value="4">其他</option>
									<option value="5">移动通信网</option>
									<option value="6">局房土建及动力配套</option>
									<option value="7">管信</option></select></td>
							<td class="seperator"></td>
							<td class="label">二级专业</td>
							<td class="content  " id="str06td"><input type="text"
								class="text" name="str06" value="" maxlength="100"></td>
						</tr>
						<tr>
							<td colspan="5" height="5"></td>
						</tr>
						<tr>
							<td class="label">三级专业</td>
							<td class="content  " id="str07td"><input type="text"
								class="text" name="str07" value="" maxlength="100"></td>
							<td class="seperator"></td>
							<td class="label">四级专业</td>
							<td class="content  " id="str08td"><input type="text"
								class="text" name="str08" value="" maxlength="100"></td>
						</tr>
						<tr>
							<td colspan="5" height="5"></td>
						</tr>
						<tr>
							<td class="label">属性</td>
							<td class="content  " id="enum04td"><input type="hidden"
								name="CodeTableType" value="1"><input type="hidden"
								name="CodeTableID" value="502"><select name="enum04"><option
										value="">&nbsp;</option>
									<option value="1">新建</option>
									<option value="2">续建</option>
									<option selected="" value="0">其他</option></select></td>
							<td class="seperator"></td>
							<td class="label">投资项目集/项目名称<font class="red">*</font></td>
							<td class="content  " id="str18td"><input type="text"
								class="text" name="str18" value="" maxlength="250"
								altstr="投资项目集/项目名称"></td>
						</tr>
						<tr>
							<td colspan="5" height="5"></td>
						</tr>
						<tr>
							<td class="label">投资项目集/项目编码<font class="red">*</font></td>
							<td class="content  " id="str01td"><input type="text"
								class="text" name="str01" value="" maxlength="50"
								altstr="投资项目集/项目编码"></td>
							<td class="seperator"></td>
							<td class="label">部门</td>
							<td class="content  " id="sys01td"><div class="content-div"
									style="cursor: pointer;" id="div-sys01DIV">
									<input type="hidden" name="sys01" value=""><input
										type="text" class="text" name="sys01Name" value="" readonly=""
										style="cursor: pointer;"><img
										src="/pm/images/16x16/department.gif">
								</div> <script type="text/javascript">
									ET.Utils .addEvent(document.getElementById('div-sys01DIV'),'click',
													function() {
														treeSelectUtils
																.showTreeSelect(
																		document.frm['sys01'],
																		document.frm['sys01Name'],
																		7, 69);
													})
								</script></td>
						</tr>
						<tr>
							<td colspan="5" height="5"></td>
						</tr>
						<tr>
							<td class="label">项目集总投资（元）</td>
							<td class="content  " id="num02td"><input type="text"
								class="text" name="num02" value="" contenttype="N18.2"></td>
							<td class="seperator"></td>
							<td class="label">项目集当年资本开支计划（元）</td>
							<td class="content  " id="num03td"><input type="text"
								class="text" name="num03" value="" contenttype="N18.2"></td>
						</tr>
						<tr>
							<td colspan="5" height="5"></td>
						</tr>
						<tr>
							<td class="label">上年累计已完成资本开支（元）</td>
							<td class="content  " id="num06td"><input type="text"
								class="text" name="num06" value="" contenttype="N18.2"></td>
							<td class="seperator"></td>
							<td class="label">项目集结转资本开支（元）</td>
							<td class="content  " id="num04td">
							<input type="text" class="text" name="num04" value="" contenttype="N18.2"></td>
						</tr>
						<tr>
							<td colspan="5" height="5"></td>
						</tr>
						<tr>
							<td class="label">项目主要建设内容</td>
							<td colspan="4" class="content" id="text01td">
							<textarea style="resize: none; height: 60px" rows="1" name="text01" value=""></textarea></td>
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
								<div class="content-line" id="div-createByName">zhengqi1</div>
							</td>
							<td class="seperator"></td>
							<td class="label">创建时间</td>
							<td class="content  " id="createTimetd">
							<div class="content-line" id="div-createTimeName">
								<input type="hidden" name="createTime" value="2017-07-16">2017-07-16&nbsp;
							</div>
							</td>
						</tr>
						<tr>
							<td colspan="5" height="5"></td>
						</tr>
						<tr>
							<td class="label">修改人</td>
							<td class="content  " id="lastUpdateBytd">
								<div class="content-line" id="div-lastUpdateByName">zhengqi1</div>
							</td>
							<td class="seperator"></td>
							<td class="label">最后修改时间</td>
							<td class="content  " id="lastUpdateTimetd">
							<div class="content-line" id="div-lastUpdateTimeName">
								<input type="hidden" name="lastUpdateTime" value="2017-07-16">2017-07-16&nbsp;
							</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
</div>
</form>