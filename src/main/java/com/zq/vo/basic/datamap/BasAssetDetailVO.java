package com.zq.vo.basic.datamap;

/**
 * 资产明细
 */

public class BasAssetDetailVO {
	
	private int id;
		
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String assetCode;
	
	private String assetTagNum;
	
	private String assetName;
	
	private String projCode;
	
	private String categoryDesc;
	
	private String assetKeyword;
	
	private String supplier;
	
	private String model;
		
	private String amount;
	
	private String unit;
	
	private java.sql.Timestamp enableDate;
	
	private java.sql.Timestamp prorateDistriDate;
	
	private String depreciationWay;
	
	private String durableYear;
	
	private String residualMonth;
		
	private String cost;
	
	private String assetsValue;
	
	private String netAssets;
		
	private String residualVlaue;
	
	private java.sql.Timestamp createDate;
		
	private String currentDepreciation;
	
	private String yearDepreciation;
		
	private String accumulateDepreciation;
		
	private String currentImpairPrep;
	
	private String yearImpairPrep;
	
	private String accumulateImpairPrep;
	
	private String staffCode;
	
	private String staffName;
	
	private String location;
	
	private String locationDesc;
	
	private String initAssetCardNum;
	
	private String initAssetLabelNum;
		
	private String initEstiexpLprojCode;
	
	private Integer constructStatus;
	
	private String orderAddInfo;
	
	private String elasticDomainInfo7;
	
	private String elasticDomainInfo8;
	
	private String elasticDomainInfo9;
		
	private String elasticDomainInfo10;
	
	private String costAccount;
	
	private Integer assetSource;
	
	private String costAccountDesc;
	
	private String deprecationAccount;
	
	private String serialNumber;
	
	private String deprecationAccountDesc;
	
	private String accuAepreAccount;
	
	private String tags;
	
	private String accuDepreAccountDesc;
	
	private String assetInstruct;
	

	/**
	 * ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 公司ID
	 */
	public void setCompanyId(int value) {
		setCompanyId(new Integer(value));
	}
	
	/**
	 * 公司ID
	 */
	public void setCompanyId(Integer value) {
		this.companyId = value;
	}
	
	/**
	 * 公司ID
	 */
	public Integer getCompanyId() {
		return companyId;
	}
	
	/**
	 * 创建时间
	 */
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	/**
	 * 创建时间
	 */
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	
	/**
	 * 创建人
	 */
	public void setCreator(String value) {
		this.creator = value;
	}
	
	/**
	 * 创建人
	 */
	public String getCreator() {
		return creator;
	}
	
	/**
	 * 最后修改时间
	 */
	public void setModifyTime(java.sql.Timestamp value) {
		this.modifyTime = value;
	}
	
	/**
	 * 最后修改时间
	 */
	public java.sql.Timestamp getModifyTime() {
		return modifyTime;
	}
	
	/**
	 * 修改人
	 */
	public void setLastReviser(String value) {
		this.lastReviser = value;
	}
	
	/**
	 * 修改人
	 */
	public String getLastReviser() {
		return lastReviser;
	}
	
	/**
	 * 资产编号 
	 */
	public void setAssetCode(String value) {
		this.assetCode = value;
	}
	
	/**
	 * 资产编号 
	 */
	public String getAssetCode() {
		return assetCode;
	}
	
	/**
	 * 资产标签号 
	 */
	public void setAssetTagNum(String value) {
		this.assetTagNum = value;
	}
	
	/**
	 * 资产标签号 
	 */
	public String getAssetTagNum() {
		return assetTagNum;
	}
	
	/**
	 * 资产名称 
	 */
	public void setAssetName(String value) {
		this.assetName = value;
	}
	
	/**
	 * 资产名称 
	 */
	public String getAssetName() {
		return assetName;
	}
	
	/**
	 * 项目编号 
	 */
	public void setProjCode(String value) {
		this.projCode = value;
	}
	
	/**
	 * 项目编号 
	 */
	public String getProjCode() {
		return projCode;
	}
	
	/**
	 * 类别描述 
	 */
	public void setCategoryDesc(String value) {
		this.categoryDesc = value;
	}
	
	/**
	 * 类别描述 
	 */
	public String getCategoryDesc() {
		return categoryDesc;
	}
	
	/**
	 * 资产关键字 
	 */
	public void setAssetKeyword(String value) {
		this.assetKeyword = value;
	}
	
	/**
	 * 资产关键字 
	 */
	public String getAssetKeyword() {
		return assetKeyword;
	}
	
	/**
	 * 厂商 
	 */
	public void setSupplier(String value) {
		this.supplier = value;
	}
	
	/**
	 * 厂商 
	 */
	public String getSupplier() {
		return supplier;
	}
	
	/**
	 * 规格型号 
	 */
	public void setModel(String value) {
		this.model = value;
	}
	
	/**
	 * 规格型号 
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * 数量 
	 */
	public void setAmount(String value) {
		this.amount = value;
	}
	
	/**
	 * 数量 
	 */
	public String getAmount() {
		return amount;
	}
	
	/**
	 * 单位 
	 */
	public void setUnit(String value) {
		this.unit = value;
	}
	
	/**
	 * 单位 
	 */
	public String getUnit() {
		return unit;
	}
	
	/**
	 * 启用日期 
	 */
	public void setEnableDate(java.sql.Timestamp value) {
		this.enableDate = value;
	}
	
	/**
	 * 启用日期 
	 */
	public java.sql.Timestamp getEnableDate() {
		return enableDate;
	}
	
	/**
	 * 按比例分摊日期 
	 */
	public void setProrateDistriDate(java.sql.Timestamp value) {
		this.prorateDistriDate = value;
	}
	
	/**
	 * 按比例分摊日期 
	 */
	public java.sql.Timestamp getProrateDistriDate() {
		return prorateDistriDate;
	}
	
	/**
	 * 折旧方法 
	 */
	public void setDepreciationWay(String value) {
		this.depreciationWay = value;
	}
	
	/**
	 * 折旧方法 
	 */
	public String getDepreciationWay() {
		return depreciationWay;
	}
	
	/**
	 * 使用年限 
	 */
	public void setDurableYear(String value) {
		this.durableYear = value;
	}
	
	/**
	 * 使用年限 
	 */
	public String getDurableYear() {
		return durableYear;
	}
	
	/**
	 * 剩余月数 
	 */
	public void setResidualMonth(String value) {
		this.residualMonth = value;
	}
	
	/**
	 * 剩余月数 
	 */
	public String getResidualMonth() {
		return residualMonth;
	}
	
	/**
	 * 成本 
	 */
	public void setCost(String value) {
		this.cost = value;
	}
	
	/**
	 * 成本 
	 */
	public String getCost() {
		return cost;
	}
	
	/**
	 * 资产净值 
	 */
	public void setAssetsValue(String value) {
		this.assetsValue = value;
	}
	
	/**
	 * 资产净值 
	 */
	public String getAssetsValue() {
		return assetsValue;
	}
	
	/**
	 * 资产净额 
	 */
	public void setNetAssets(String value) {
		this.netAssets = value;
	}
	
	/**
	 * 资产净额 
	 */
	public String getNetAssets() {
		return netAssets;
	}
	
	/**
	 * 残值 
	 */
	public void setResidualVlaue(String value) {
		this.residualVlaue = value;
	}
	
	/**
	 * 残值 
	 */
	public String getResidualVlaue() {
		return residualVlaue;
	}
	
	/**
	 * 创建日期 
	 */
	public void setCreateDate(java.sql.Timestamp value) {
		this.createDate = value;
	}
	
	/**
	 * 创建日期 
	 */
	public java.sql.Timestamp getCreateDate() {
		return createDate;
	}
	
	/**
	 * 本期折旧额 
	 */
	public void setCurrentDepreciation(String value) {
		this.currentDepreciation = value;
	}
	
	/**
	 * 本期折旧额 
	 */
	public String getCurrentDepreciation() {
		return currentDepreciation;
	}
	
	/**
	 * 本年折旧额 
	 */
	public void setYearDepreciation(String value) {
		this.yearDepreciation = value;
	}
	
	/**
	 * 本年折旧额 
	 */
	public String getYearDepreciation() {
		return yearDepreciation;
	}
	
	/**
	 * 累计折旧额 
	 */
	public void setAccumulateDepreciation(String value) {
		this.accumulateDepreciation = value;
	}
	
	/**
	 * 累计折旧额 
	 */
	public String getAccumulateDepreciation() {
		return accumulateDepreciation;
	}
	
	/**
	 * 本期减值准备 
	 */
	public void setCurrentImpairPrep(String value) {
		this.currentImpairPrep = value;
	}
	
	/**
	 * 本期减值准备 
	 */
	public String getCurrentImpairPrep() {
		return currentImpairPrep;
	}
	
	/**
	 * 本年减值准备 
	 */
	public void setYearImpairPrep(String value) {
		this.yearImpairPrep = value;
	}
	
	/**
	 * 本年减值准备 
	 */
	public String getYearImpairPrep() {
		return yearImpairPrep;
	}
	
	/**
	 * 累计减值准备 
	 */
	public void setAccumulateImpairPrep(String value) {
		this.accumulateImpairPrep = value;
	}
	
	/**
	 * 累计减值准备 
	 */
	public String getAccumulateImpairPrep() {
		return accumulateImpairPrep;
	}
	
	/**
	 * 员工编号 
	 */
	public void setStaffCode(String value) {
		this.staffCode = value;
	}
	
	/**
	 * 员工编号 
	 */
	public String getStaffCode() {
		return staffCode;
	}
	
	/**
	 * 员工姓名 
	 */
	public void setStaffName(String value) {
		this.staffName = value;
	}
	
	/**
	 * 员工姓名 
	 */
	public String getStaffName() {
		return staffName;
	}
	
	/**
	 * 地点 
	 */
	public void setLocation(String value) {
		this.location = value;
	}
	
	/**
	 * 地点 
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * 地点说明 
	 */
	public void setLocationDesc(String value) {
		this.locationDesc = value;
	}
	
	/**
	 * 地点说明 
	 */
	public String getLocationDesc() {
		return locationDesc;
	}
	
	/**
	 * 期初资产卡片编号 
	 */
	public void setInitAssetCardNum(String value) {
		this.initAssetCardNum = value;
	}
	
	/**
	 * 期初资产卡片编号 
	 */
	public String getInitAssetCardNum() {
		return initAssetCardNum;
	}
	
	/**
	 * 期初资产标签编号 
	 */
	public void setInitAssetLabelNum(String value) {
		this.initAssetLabelNum = value;
	}
	
	/**
	 * 期初资产标签编号 
	 */
	public String getInitAssetLabelNum() {
		return initAssetLabelNum;
	}
	
	/**
	 * 期初估列项目编号 
	 */
	public void setInitEstiexpLprojCode(String value) {
		this.initEstiexpLprojCode = value;
	}
	
	/**
	 * 期初估列项目编号 
	 */
	public String getInitEstiexpLprojCode() {
		return initEstiexpLprojCode;
	}
	
	/**
	 * 建设状态 
	 */
	public void setConstructStatus(int value) {
		setConstructStatus(new Integer(value));
	}
	
	/**
	 * 建设状态 
	 */
	public void setConstructStatus(Integer value) {
		this.constructStatus = value;
	}
	
	/**
	 * 建设状态 
	 */
	public Integer getConstructStatus() {
		return constructStatus;
	}
	
	/**
	 * 其他附加信息 
	 */
	public void setOrderAddInfo(String value) {
		this.orderAddInfo = value;
	}
	
	/**
	 * 其他附加信息 
	 */
	public String getOrderAddInfo() {
		return orderAddInfo;
	}
	
	/**
	 * 弹性域信息7 
	 */
	public void setElasticDomainInfo7(String value) {
		this.elasticDomainInfo7 = value;
	}
	
	/**
	 * 弹性域信息7 
	 */
	public String getElasticDomainInfo7() {
		return elasticDomainInfo7;
	}
	
	/**
	 * 弹性域信息8 
	 */
	public void setElasticDomainInfo8(String value) {
		this.elasticDomainInfo8 = value;
	}
	
	/**
	 * 弹性域信息8 
	 */
	public String getElasticDomainInfo8() {
		return elasticDomainInfo8;
	}
	
	/**
	 * 弹性域信息9 
	 */
	public void setElasticDomainInfo9(String value) {
		this.elasticDomainInfo9 = value;
	}
	
	/**
	 * 弹性域信息9 
	 */
	public String getElasticDomainInfo9() {
		return elasticDomainInfo9;
	}
	
	/**
	 * 弹性域信息10 
	 */
	public void setElasticDomainInfo10(String value) {
		this.elasticDomainInfo10 = value;
	}
	
	/**
	 * 弹性域信息10 
	 */
	public String getElasticDomainInfo10() {
		return elasticDomainInfo10;
	}
	
	/**
	 * 成本账户 
	 */
	public void setCostAccount(String value) {
		this.costAccount = value;
	}
	
	/**
	 * 成本账户 
	 */
	public String getCostAccount() {
		return costAccount;
	}
	
	/**
	 * 资产来源 代码表：资产明细资本来源
	 */
	public void setAssetSource(int value) {
		setAssetSource(new Integer(value));
	}
	
	/**
	 * 资产来源 代码表：资产明细资本来源
	 */
	public void setAssetSource(Integer value) {
		this.assetSource = value;
	}
	
	/**
	 * 资产来源 代码表：资产明细资本来源
	 */
	public Integer getAssetSource() {
		return assetSource;
	}
	
	/**
	 * 成本账户描述 
	 */
	public void setCostAccountDesc(String value) {
		this.costAccountDesc = value;
	}
	
	/**
	 * 成本账户描述 
	 */
	public String getCostAccountDesc() {
		return costAccountDesc;
	}
	
	/**
	 * 折旧账户 
	 */
	public void setDeprecationAccount(String value) {
		this.deprecationAccount = value;
	}
	
	/**
	 * 折旧账户 
	 */
	public String getDeprecationAccount() {
		return deprecationAccount;
	}
	
	/**
	 * 序列号 
	 */
	public void setSerialNumber(String value) {
		this.serialNumber = value;
	}
	
	/**
	 * 序列号 
	 */
	public String getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * 折旧账户描述 
	 */
	public void setDeprecationAccountDesc(String value) {
		this.deprecationAccountDesc = value;
	}
	
	/**
	 * 折旧账户描述 
	 */
	public String getDeprecationAccountDesc() {
		return deprecationAccountDesc;
	}
	
	/**
	 * 累计折旧账户 
	 */
	public void setAccuAepreAccount(String value) {
		this.accuAepreAccount = value;
	}
	
	/**
	 * 累计折旧账户 
	 */
	public String getAccuAepreAccount() {
		return accuAepreAccount;
	}
	
	/**
	 * 标识 
	 */
	public void setTags(String value) {
		this.tags = value;
	}
	
	/**
	 * 标识 
	 */
	public String getTags() {
		return tags;
	}
	
	/**
	 * 累计折旧账户描述 
	 */
	public void setAccuDepreAccountDesc(String value) {
		this.accuDepreAccountDesc = value;
	}
	
	/**
	 * 累计折旧账户描述 
	 */
	public String getAccuDepreAccountDesc() {
		return accuDepreAccountDesc;
	}
	
	/**
	 * 资产说明 
	 */
	public void setAssetInstruct(String value) {
		this.assetInstruct = value;
	}
	
	/**
	 * 资产说明 
	 */
	public String getAssetInstruct() {
		return assetInstruct;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
