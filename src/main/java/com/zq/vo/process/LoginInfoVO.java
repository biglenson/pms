package com.zq.vo.process;

public class LoginInfoVO {

    private long loginID;
    private String loginName;

    public long getLoginID() {
        return this.loginID;
    }

    /**
     * 
     * @param loginID
     */
    public void setLoginID(long loginID) {
        this.loginID = loginID;
    }

    public String getLoginName() {
        return this.loginName;
    }

    /**
     * 
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

}
