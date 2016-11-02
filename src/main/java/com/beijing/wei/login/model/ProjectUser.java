package com.beijing.wei.login.model;

public class ProjectUser {
    private String userId;

    private String userName;

    private String userPass;

    private String userAllId;
    
    private String validate;

    
	private ProjectUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectUser(String userId, String userName, String userPass,
			String userAllId, String validate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userAllId = userAllId;
		this.validate = validate;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserAllId() {
        return userAllId;
    }

    public void setUserAllId(String userAllId) {
        this.userAllId = userAllId;
    }

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}
   
}