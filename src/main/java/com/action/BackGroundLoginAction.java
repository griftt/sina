package com.action;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.Admin;
import com.entity.AdminDao;
import com.util.CodeUtil;

@Controller
@Scope("prototype")
public class BackGroundLoginAction implements SessionAware {
	private InputStream input;
	private String code;
	private Map<String,Object> session;
	private String inputCode;
	private boolean flag=false;
	private String account;
	private String pwd;
	private Admin admin;
	@Resource
	private AdminDao adminDao;
	public String code() {
		code = CodeUtil.number();
		BufferedImage image = CodeUtil.codeImg(code);
		input = CodeUtil.handCode(image);
		System.out.println(1);
		System.out.println(code);
		System.out.println(input);
		session.put("code", code);
		return "success";
	}

	public String login() {
		
		code=(String) session.get("code");
		System.out.println(inputCode +"and"+ code); 
		if(code.toUpperCase().equals(inputCode.toUpperCase())){
			flag=true;
		}else{
			flag=false;
		}
		if(flag){
			admin =adminDao.checkAdmin(account, pwd);
			if(admin==null){
				return "error";
			}
			System.out.println(admin);
			return "success";
		}	
		return "error";
	}
	
	
	
	public String checkCode() {
		System.out.println(inputCode);
		if(code.toUpperCase().equals(inputCode.toUpperCase())){
			flag=true;
		}
		
		return "success";
		
	}

	
	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getAccount() {
		return account;
	}
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session=arg0;
	}

}
