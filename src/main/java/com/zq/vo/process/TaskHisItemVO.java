package com.zq.vo.process;

import java.util.*;
import java.sql.Timestamp;

public class TaskHisItemVO {

	private String taskName;
	private String assignee;
	private Timestamp dealTime;
	private String dealResult;
	private String dealOpinion;

	public String getTaskName() {
		return this.taskName;
	}

	/**
	 * 
	 * @param taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getAssignee() {
		return this.assignee;
	}

	/**
	 * 
	 * @param assignee
	 */
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Timestamp getDealTime() {
		return this.dealTime;
	}

	/**
	 * 
	 * @param dealTime
	 */
	public void setDealTime(Timestamp dealTime) {
		this.dealTime = dealTime;
	}

	public String getDealResult() {
		return this.dealResult;
	}

	/**
	 * 
	 * @param dealResult
	 */
	public void setDealResult(String dealResult) {
		this.dealResult = dealResult;
	}

	public String getDealOpinion() {
		return this.dealOpinion;
	}

	/**
	 * 
	 * @param dealOpinion
	 */
	public void setDealOpinion(String dealOpinion) {
		this.dealOpinion = dealOpinion;
	}

}
