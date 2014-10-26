package com.icss.hr.admin.vo;

public class Admin {
	private String adminName;
	private String adminPwd;
	private int level;
	
	public Admin() {
		super();
	}
	
	public Admin(String adminName, String adminPwd, int level) {
		super();
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.level = level;
	}

	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminPwd=" + adminPwd
				+ ", level=" + level + "]";
	}
	
}
