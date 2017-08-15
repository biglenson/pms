package com.zq.entity.process;

import java.io.Serializable;
import javax.persistence.*;


/**
 *  * The persistent class for the d_eval_code_gen database table.
 *   * 
 *    */
@Entity
@Table(name="d_eval_code_gen")
public class EvalCodeGen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int codeID;

	@Column(name="codeType")
	private String codeType;

	@Column(name="currValue")
	private int currValue;

	@Column(name="deptShortName")
	private String deptShortName;

	@Column(name="yearMonth")
	private String yearMonth;

	public EvalCodeGen() {
	}

	public int getCurrValue() {
		return this.currValue;
	}

	public void setCurrValue(int currValue) {
		this.currValue = currValue;
	}

	public String getCodeType() {
		return this.codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getDeptShortName() {
		return this.deptShortName;
	}

	public void setDeptShortName(String deptShortName) {
		this.deptShortName = deptShortName;
	}

	public int getCodeId() {
		return this.codeID;
	}

	public String getYearMonth() {
		return this.yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}

}
