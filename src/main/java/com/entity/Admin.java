package com.entity;

public class Admin {
	 	private int id ;
	 	private String account;
	 	private String pwd;
	 	private int roleId;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public int getRoleId() {
			return roleId;
		}
		public void setRoleId(int roleId) {
			this.roleId = roleId;
		}
		@Override
		public String toString() {
			return "Admin [id=" + id + ", account=" + account + ", pwd=" + pwd + ", roleId=" + roleId + "]";
		} 
	 	
	
}
