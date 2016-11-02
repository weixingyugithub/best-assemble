package com.beijing.wei.login.model;

import java.util.Date;

public class ProjectUserAll {
    private String userAllId;

    private String userAllName;

    private String userAllPass;

    private String userAllSurname;

    private String userAllFirstname;

    private String userAllCompellation;

    private Date userAllBirthday;

    private String userAllEmail;

    private String userAllPhone;

    private String userAllNative;

    private String userAllProvince;

    private String userAllCity;

    private String userAllCounty;

    private ProjectUserAll() {
		super();
		// TODO Auto-generated constructor stub
	}

	private ProjectUserAll(String userAllId, String userAllName,
			String userAllPass, String userAllSurname, String userAllFirstname,
			String userAllCompellation, Date userAllBirthday,
			String userAllEmail, String userAllPhone, String userAllNative,
			String userAllProvince, String userAllCity, String userAllCounty) {
		super();
		this.userAllId = userAllId;
		this.userAllName = userAllName;
		this.userAllPass = userAllPass;
		this.userAllSurname = userAllSurname;
		this.userAllFirstname = userAllFirstname;
		this.userAllCompellation = userAllCompellation;
		this.userAllBirthday = userAllBirthday;
		this.userAllEmail = userAllEmail;
		this.userAllPhone = userAllPhone;
		this.userAllNative = userAllNative;
		this.userAllProvince = userAllProvince;
		this.userAllCity = userAllCity;
		this.userAllCounty = userAllCounty;
	}

	public String getUserAllId() {
        return userAllId;
    }

    public void setUserAllId(String userAllId) {
        this.userAllId = userAllId;
    }

    public String getUserAllName() {
        return userAllName;
    }

    public void setUserAllName(String userAllName) {
        this.userAllName = userAllName;
    }

    public String getUserAllPass() {
        return userAllPass;
    }

    public void setUserAllPass(String userAllPass) {
        this.userAllPass = userAllPass;
    }

    public String getUserAllSurname() {
        return userAllSurname;
    }

    public void setUserAllSurname(String userAllSurname) {
        this.userAllSurname = userAllSurname;
    }

    public String getUserAllFirstname() {
        return userAllFirstname;
    }

    public void setUserAllFirstname(String userAllFirstname) {
        this.userAllFirstname = userAllFirstname;
    }

    public String getUserAllCompellation() {
        return userAllCompellation;
    }

    public void setUserAllCompellation(String userAllCompellation) {
        this.userAllCompellation = userAllCompellation;
    }

    public Date getUserAllBirthday() {
        return userAllBirthday;
    }

    public void setUserAllBirthday(Date userAllBirthday) {
        this.userAllBirthday = userAllBirthday;
    }

    public String getUserAllEmail() {
        return userAllEmail;
    }

    public void setUserAllEmail(String userAllEmail) {
        this.userAllEmail = userAllEmail;
    }

    public String getUserAllPhone() {
        return userAllPhone;
    }

    public void setUserAllPhone(String userAllPhone) {
        this.userAllPhone = userAllPhone;
    }

    public String getUserAllNative() {
        return userAllNative;
    }

    public void setUserAllNative(String userAllNative) {
        this.userAllNative = userAllNative;
    }

    public String getUserAllProvince() {
        return userAllProvince;
    }

    public void setUserAllProvince(String userAllProvince) {
        this.userAllProvince = userAllProvince;
    }

    public String getUserAllCity() {
        return userAllCity;
    }

    public void setUserAllCity(String userAllCity) {
        this.userAllCity = userAllCity;
    }

    public String getUserAllCounty() {
        return userAllCounty;
    }

    public void setUserAllCounty(String userAllCounty) {
        this.userAllCounty = userAllCounty;
    }
}