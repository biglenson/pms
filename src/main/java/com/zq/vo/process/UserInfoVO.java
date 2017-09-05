package com.zq.vo.process;

public class UserInfoVO {

	private long deptID;
	private String deptName;
	private long userID;
	private String userName;

	public UserInfoVO() {
		// TODO - implement UserInfoVO.UserInfoVO
	}

	public long getDeptID() {
		return this.deptID;
	}

	/**
	 * 
	 * @param deptID
	 */
	public void setDeptID(long deptID) {
		this.deptID = deptID;
	}

	public String getDeptName() {
		return this.deptName;
	}

	/**
	 * 
	 * @param deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public long getUserID() {
		return this.userID;
	}

	/**
	 * 
	 * @param userID
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return this.userName;
	}

	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
