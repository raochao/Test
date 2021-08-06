package com.yuanqi.powernt.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserInfo implements java.io.Serializable{
	private String userid;
	private String username;
	private String password;
	private int disabled;
	private int lockpassword;
	private int neverexpired;
	private Date expireddate;
	private String usernote;
	private String linkid;
	
	private List userModelOperation;
	
	public List getUserModelOperation() {
		return userModelOperation;
	}
	public void setUserModelOperation(List userModelOperation) {
		this.userModelOperation = userModelOperation;
	}
	public int getDisabled() {
		return disabled;
	}
	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}
	public Date getExpireddate() {
		return expireddate;
	}
	public void setExpireddate(Date expireddate) {
		this.expireddate = expireddate;
	}
	public String getLinkid() {
		return linkid;
	}
	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}
	public int getLockpassword() {
		return lockpassword;
	}
	public void setLockpassword(int lockpassword) {
		this.lockpassword = lockpassword;
	}
	public int getNeverexpired() {
		return neverexpired;
	}
	public void setNeverexpired(int neverexpired) {
		this.neverexpired = neverexpired;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsernote() {
		return usernote;
	}
	public void setUsernote(String usernote) {
		this.usernote = usernote;
	}
	//是否拥有访问权限
	public boolean validateOperation(String menuid, String operation){
		if(this.userModelOperation == null || this.userModelOperation.size() == 0)
			return false;
		else{
			boolean b = false;
			int s = this.userModelOperation.size();
			for(int i = 0;i < s; i++){
				HashMap map = (HashMap)this.userModelOperation.get(i);
				String operationcode = (String)map.get("operationcode");
				String linkid = (String)map.get("linkid");
				if(menuid.equalsIgnoreCase(linkid) && operation.equalsIgnoreCase(operationcode)){
					b = true;
					break;
				}
			}
			return b;
		}
	}
	//是否拥有访问权限
	public boolean validateOperation(String menulid){
		if(this.userModelOperation == null || this.userModelOperation.size() == 0)
			return false;
		else{
			boolean b = false;
			int s = this.userModelOperation.size();
			for(int i = 0;i < s; i++){
				HashMap map = (HashMap)this.userModelOperation.get(i);
				String operationcode = (String)map.get("operationcode");
				String linkid = (String)map.get("linkid");
				if(menulid.equalsIgnoreCase(linkid) && operationcode.equalsIgnoreCase("open")){
					b = true;
					break;
				}
			}
			return b;
		}
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"userid='" + userid + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", disabled=" + disabled +
				", lockpassword=" + lockpassword +
				", neverexpired=" + neverexpired +
				", expireddate=" + expireddate +
				", usernote='" + usernote + '\'' +
				", linkid='" + linkid + '\'' +
				", userModelOperation=" + userModelOperation +
				'}';
	}
}
