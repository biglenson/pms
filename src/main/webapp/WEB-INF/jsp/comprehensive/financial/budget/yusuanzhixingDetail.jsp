<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zq.commons.utils.TypeUtils"%>
<%--
Map<Integer,YuSuanKeMu> allKemus = (Map<Integer,YuSuanKeMu>) request.getAttribute("allKemus");
List<Map.Entry<Integer,CMCCBudgetFenjie>> firstYusuanList = (List<Map.Entry<Integer,CMCCBudgetFenjie>>)request.getAttribute("firstYusuanList");
Map<Integer,Map<Integer,CMCCBudgetFenjie>> secondYusuanMap = (Map<Integer,Map<Integer,CMCCBudgetFenjie>>)request.getAttribute("secondYusuanMap");
Map<Integer,Double> allKemuCost = (Map<Integer,Double>)request.getAttribute("allKemuCost");
--%>
<script type="text/javascript">
	function expandedFun(imgObj,parentID){
		var display=null;
		if(imgObj.src.lastIndexOf("expanded.png")==-1){//说明现在的状态为close的
			var newSrc=imgObj.src.replace(/close\.png/g,"expanded.png");
			imgObj.src=newSrc;		
			display="";
		}else{
			var newSrc=imgObj.src.replace(/expanded\.png/g,"close.png");
			imgObj.src=newSrc;		
			display="none";
		}
		var tbodyObj = document.getElementById(parentID);
		if(display=="none"){
			tbodyObj.style.display="none";
		}else{
			tbodyObj.style.display="";
		}
		yusuanzhixingDetailTable.resize(true);
	}
</script>
<div class="tabContent">
<div style="text-align:right">
	<div class="showHelpe" onclick="showTips(this,'caiwuYusuanTipNameDIV')"></div>
</div>
<div class="helpFloatDIV" id="caiwuYusuanTipNameDIV" style="line-height: 22px;">
	<div class="showHelpeContent" style="line-height: 23px;">
		<div>与预算差额：累计完成额度-预算额度</div>
		<div>完成进度：累计完成额度/预算额度</div>
	</div>
</div>
<div style="height:250px;">
	<table id="yusuanzhixingDetailTable" class="listTable"  cellpadding="0" cellspacing="0" border="0">
		<thead>
			<tr>
				<th width="100%" ><div style='width:170px'>费用类别</div></th>
				<th ><div style='width:120px'>预算额度</div></th>
				<th><div style='width:120px'>预算完成</div></th>
				<th><div style='width:120px'>累计完成额度</div></th>
				<th><div style='width:120px'>与预算差额</div></th>
				<th><div style='width:200px'>完成进度</div></th>
			</tr>
		</thead>
		<%-- <%for(Map.Entry<Integer,CMCCBudgetFenjie> entry:firstYusuanList){
			int kemuID = entry.getKey();
			CMCCBudgetFenjie firstyusuan = entry.getValue();
			double yusuanmoney = FormBaseResove.getNotNullDoubleValue(user, firstyusuan, "num05");
			double yujimoney = FormBaseResove.getNotNullDoubleValue(user, firstyusuan, "num06");
			double finishmoney = allKemuCost.get(kemuID)==null?0:allKemuCost.get(kemuID);
			Map<Integer,CMCCBudgetFenjie> secondYusuans = secondYusuanMap.get(kemuID);
		%>
			<tr>
				<td>
	  				<img src="<%=path%><%if(secondYusuans==null){%>/images/16x16/empty.gif<%}else{%>/images/newui/close.png<%}%>" border="0" <%if(secondYusuans!=null){%>onclick="javascript:expandedFun(this,<%=kemuID%>);" style="cursor: pointer"<%}%> />
	  				<b><%=TypeUtils.xmlEncoderForIE(allKemus.get(kemuID).getTitle())%></b>
			  	</td>
				<td align="center"><%=FormBaseResove.formatWanMoney(yusuanmoney)%></td>
				<td align="center"><%=FormBaseResove.formatWanMoney(yujimoney)%></td>
				<td align="center"><%=FormBaseResove.formatWanMoney(finishmoney)%></td>
				<td align="center"><%=FormBaseResove.formatWanMoney(finishmoney-yusuanmoney)%></td>
				<td>
					<div style='width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;'>
					<%
						Integer totalpercent = 0;
						if(yusuanmoney != 0){
							Double percent = finishmoney/yusuanmoney*100;
							totalpercent = percent.intValue();
							if(totalpercent > 100){
								totalpercent = 100;
							}
						}
					%>
						<div style='height:100%;width:<%=totalpercent%>%;background-color:#0ACC4B;''></div>
					</div>
				</td>
			</tr>
			<%if(secondYusuans != null){ %>
				<tbody id="<%=kemuID%>" style="display: none;">
					<%for(Integer secondkemuID : secondYusuans.keySet()){ 
						CMCCBudgetFenjie secondyusuan = secondYusuans.get(secondkemuID);
						double yusuanmoney2 = FormBaseResove.getNotNullDoubleValue(user, secondyusuan, "num05");
						double yujimoney2 = FormBaseResove.getNotNullDoubleValue(user, secondyusuan, "num06");
						double finishmoney2 = allKemuCost.get(secondkemuID)==null?0:allKemuCost.get(secondkemuID);
					%>
						<tr>
							<td align="left">
								<div style="margin-left:55px;">
									<%=TypeUtils.xmlEncoderForIE(allKemus.get(secondkemuID).getTitle())%>
								</div>
							</td>
							<td align="center"><%=FormBaseResove.formatWanMoney(yusuanmoney2)%></td>
							<td align="center"><%=FormBaseResove.formatWanMoney(yujimoney2)%></td>
							<td align="center"><%=FormBaseResove.formatWanMoney(finishmoney2)%></td>
							<td align="center"><%=FormBaseResove.formatWanMoney(finishmoney2-yujimoney2)%></td>
							<td>
								<div style='width:80%;margin:5px auto;height:8px;background-color:#E8E9ED;'>
								<%
									Integer totalpercent2 = 0;
									if(yusuanmoney2 != 0){
										Double percent2 = finishmoney2/yusuanmoney2*100;
										totalpercent2 = percent2.intValue();
										if(totalpercent2 > 100){
											totalpercent2 = 100;
										}
									}
								%>
									<div style='height:100%;width:<%=totalpercent2%>%;background-color:#0ACC4B;''></div>
								</div>
							</td>
						</tr>
					<%} %>
				</tbody>
			<%} %>
		<%} %>
		<%if(firstYusuanList.size()==0) {%>
			<tr>
				<td colspan="6" style="padding-left:100px;"> 暂无数据</td>
			</tr>
		<%} %> --%>
	</table>
</div>
</div>
<script type="text/javascript">
	window.yusuanzhixingDetailTable=new EasyTrack.DataTable("yusuanzhixingDetailTable",{
		autoHeight:false
	})
</script>