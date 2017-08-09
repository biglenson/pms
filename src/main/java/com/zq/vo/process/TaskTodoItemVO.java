package com.zq.vo.process;

import java.util.*;
import java.sql.Timestamp;

public class TaskTodoItemVO {

	private String processID;
	private String evalTitle;
	private String taskName;
	private int evalPhase;
	private String tplTitle;
	private String assignee;
	private Timestamp createTime;

	public String getEvalTitle() {
		return this.evalTitle;
	}

	/**
	 * 
	 * @param processID
	 */
	public void setProcessID(String processID) {
		this.processID = processID;
	}

	public String getProcessID() {
		return this.processID;
	}
	/**
	 * 
	 * @param evalTitle
	 */
	public void setEvalTitle(String evalTitle) {
		this.evalTitle = evalTitle;
	}

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

	public int getEvalPhase() {
		return this.evalPhase;
	}

	/**
	 * 
	 * @param evalPhase
	 */
	public void setEvalPhase(int evalPhase) {
		this.evalPhase = evalPhase;
	}

	public String getTplTitle() {
		return this.tplTitle;
	}

	/**
	 * 
	 * @param tplTitle
	 */
	public void setTplTitle(String tplTitle) {
		this.tplTitle = tplTitle;
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

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	/**
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
