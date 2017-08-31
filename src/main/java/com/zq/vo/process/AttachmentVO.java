package com.zq.vo.process;

public class AttachmentVO {

	private String attachID;
	private String attachName;
	private String attachType;

	public AttachmentVO() {
	}

	public String getAttachID() {
		return this.attachID;
	}

	/**
	 * 
	 * @param attachID
	 */
	public void setAttachID(String attachID) {
		this.attachID = attachID;
	}

	public String getAttachName() {
		return this.attachName;
	}

	/**
	 * 
	 * @param attachName
	 */
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	public String getAttachType() {
		return this.attachType;
	}

	/**
	 * 
	 * @param attachType
	 */
	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}

}
