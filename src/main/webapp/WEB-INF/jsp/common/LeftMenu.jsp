<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div class="leftAllDIV  null" id="bodyLeftAllDIV">
			<div class="leftsidebar null" id="bodyStart_leftsidebar">
				<div class="sidebar" id="bodyStart__menuDIV">
					<div id="defaultLeftMenuDIV"
						style="position: absolute; top: 0px; bottom: 37px; width: 100%; overflow: hidden;"
						class=" dumascroll">
						<div class="dumascroll_area showYScroll">
							<div uid="8101" id="8101MenuDIVSpan" parentid="81" level="1" childsize="0" 	url="/CMCCAction.do?operation=cmccList&amp;schemaID=1031" class="menuDIV menuLevel1 menuSelected " style="display:">
								<img id="8101urlImgOn" class="sidebarimg"	src="/static/images/16x16/projectProposalAdmin_.png" style="display: none"><img id="8101urlImgOff"	class="sidebarimg" src="/static/images/16x16/projectProposalAdmin__on.png" 	style="display:">CAPEX投资计划
							</div>
							<div uid="8106" id="8106MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1042"
								class="menuDIV menuLevel1  " style="display:">
								<img id="8106urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display:"><img id="8106urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display: none">CAPEX自主资金池

							</div>

							<div uid="8103" id="8103MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1043"
								class="menuDIV menuLevel1  " style="display:">
								<img id="8103urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display:"><img id="8103urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display: none">CAPEX需求

							</div>
							<div uid="8102" id="8102MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1029"
								class="menuDIV menuLevel1  " style="display:">
								<img id="8102urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display:"><img id="8102urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display: none">CAPEX项

							</div>
							<div uid="6617" id="6617MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;&amp;schemaID=1079"
								class="menuDIV menuLevel1  " style="display:">
								<img id="6617urlImgOn" class="sidebarimg"
									src="/static/images/16x16/expense_info_template_.png"
									style="display:"><img id="6617urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/expense_info_template__on.png"
									style="display: none">CAPEX项与投资计划

							</div>
							<div uid="8105" id="8105MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1044"
								class="menuDIV menuLevel1  " style="display:">
								<img id="8105urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display:"><img id="8105urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display: none">CAPEX资本开支计划

							</div>
							<div uid="8104" id="8104MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1046"
								class="menuDIV menuLevel1  " style="display:">
								<img id="8104urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display:"><img id="8104urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display: none">CAPEX转资计划

							</div>
							<div uid="8108" id="8108MenuDIVSpan" parentid="81" level="1"
								childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1073"
								class="menuDIV menuLevel1  " style="display:">
								<img id="8108urlImgOn" class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin_.png"
									style="display:"><img id="8108urlImgOff"
									class="sidebarimg"
									src="/static/images/16x16/projectProposalAdmin__on.png"
									style="display: none">投资计划总额信息管理

							</div>
						</div>
						<div class="dumascroll_barY" style="">
							<div class="dumascroll_arrow_up"></div>
							<div class="dumascroll_handleY"
								style="height: 69.0313px; top: 0px;"></div>
							<div class="dumascroll_arrow_down"></div>
						</div>
						<div class="dumascroll_barX showYScroll" style="display: none;">
							<div class="dumascroll_arrow_left"></div>
							<div class="dumascroll_handleX"></div>
							<div class="dumascroll_arrow_right"></div>
						</div>
						<div class="duma_rightButtom showYScroll"></div>
					</div>
					<div id="leftMenuSettingDIV">
						<div id="leftMenu_splitOpen" class="split_Open"
							onclick="toggleLeft();"></div>
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

			<div id="bodyStart_simpleMenuDiv" class="simpleMenuDiv  null">
				<div class="simpleContainer">
					<div class="simpleLevelMenu  menuSelected" uid="8101"
						id="8101simpleLevelMenu" parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1031">
						<div showimg="true" class="simpleMenuImgDIV  menuSelected"
							uid="8101">
							<img class="simpleLevelMenuImg" id="8101SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display: none"> <img class="simpleLevelMenuImg"
								id="8101SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display:">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8101simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8101"
								id="8101SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1031">
								<div>CAPEX投资计划</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="8106" id="8106simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1042">
						<div showimg="true" class="simpleMenuImgDIV  " uid="8106">
							<img class="simpleLevelMenuImg" id="8106SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="8106SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8106simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8106"
								id="8106SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1042">
								<div>CAPEX自主资金池</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="8103" id="8103simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1043">
						<div showimg="true" class="simpleMenuImgDIV  " uid="8103">
							<img class="simpleLevelMenuImg" id="8103SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="8103SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8103simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8103"
								id="8103SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1043">
								<div>CAPEX需求</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="8102" id="8102simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1029">
						<div showimg="true" class="simpleMenuImgDIV  " uid="8102">
							<img class="simpleLevelMenuImg" id="8102SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="8102SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8102simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8102"
								id="8102SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1029">
								<div>CAPEX项</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="6617" id="6617simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;&amp;schemaID=1079">
						<div showimg="true" class="simpleMenuImgDIV  " uid="6617">
							<img class="simpleLevelMenuImg" id="6617SimpleUrlImgOn"
								src="/static/images/16x16/expense_info_template_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="6617SimpleUrlImgOff"
								src="/static/images/16x16/expense_info_template__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="6617simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="6617"
								id="6617SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;&amp;schemaID=1079">
								<div>CAPEX项与投资计划</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="8105" id="8105simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1044">
						<div showimg="true" class="simpleMenuImgDIV  " uid="8105">
							<img class="simpleLevelMenuImg" id="8105SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="8105SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8105simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8105"
								id="8105SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1044">
								<div>CAPEX资本开支计划</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="8104" id="8104simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1046">
						<div showimg="true" class="simpleMenuImgDIV  " uid="8104">
							<img class="simpleLevelMenuImg" id="8104SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="8104SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8104simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8104"
								id="8104SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1046">
								<div>CAPEX转资计划</div>
							</div>

						</div>
					</div>

					<div class="simpleLevelMenu  " uid="8108" id="8108simpleLevelMenu"
						parentid="81"
						url="/CMCCAction.do?operation=cmccList&amp;schemaID=1073">
						<div showimg="true" class="simpleMenuImgDIV  " uid="8108">
							<img class="simpleLevelMenuImg" id="8108SimpleUrlImgOn"
								src="/static/images/16x16/projectProposalAdmin_.png"
								style="display:"> <img class="simpleLevelMenuImg"
								id="8108SimpleUrlImgOff"
								src="/static/images/16x16/projectProposalAdmin__on.png"
								style="display: none">
						</div>
						<div class="simpleLevelMenuChildren onlyOne "
							name="level2Container" id="8108simpleLevelMenuChildren">

							<div class="level2SimpleOnly" level="1" uid="8108"
								id="8108SimpleMenuDIVSpan" childsize="0"
								url="/CMCCAction.do?operation=cmccList&amp;schemaID=1073">
								<div>投资计划总额信息管理</div>
							</div>

						</div>
					</div>

					<div id="simpleContainer2">

						<div
							style="border-top: 1px solid #BAC4CC; height: 36px; position: relative; cursor: pointer;"
							onclick="toggleLeft();">
							<div id="leftMenu_splitClose" class=" split_close"></div>
						</div>
					</div>
				</div>

			</div>

		</div>