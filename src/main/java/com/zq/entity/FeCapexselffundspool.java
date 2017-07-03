package com.zq.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the fe_capexselffundspool database table.
 * 
 */
@Entity
@Table(name="fe_capexselffundspool")
public class FeCapexselffundspool implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String avifunds;

	@Column(name="`camp-onfunds`")
	private String camp_onfunds;

	private String initfunds;
	
	private String year;

	public FeCapexselffundspool() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvifunds() {
		return this.avifunds;
	}

	public void setAvifunds(String avifunds) {
		this.avifunds = avifunds;
	}

	public String getCamp_onfunds() {
		return this.camp_onfunds;
	}

	public void setCamp_onfunds(String camp_onfunds) {
		this.camp_onfunds = camp_onfunds;
	}

	public String getInitfunds() {
		return this.initfunds;
	}

	public void setInitfunds(String initfunds) {
		this.initfunds = initfunds;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}