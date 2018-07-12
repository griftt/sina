package com.action;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dao.AdminDao;
import com.data.ResultMap;
import com.entity.Admin;
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
	List<Admin> admins;
	private int page;
	private int limit;
	private int pagesizes;
	ResultMap resultMap;
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
			admin =adminDao.checkAdmin(account, pwd);
			if(admin==null){
				return "error";
			}
			System.out.println(admin);
			session.put("admin", admin);
			
			return "admin";
		}	
		return "error";
	}
	public String unlogin(){		
		session.clear();
		return "success";
		
	}
	public String checkCode() {
		System.out.println(inputCode);
		if(code.toUpperCase().equals(inputCode.toUpperCase())){
			flag=true;
		}
		
		return "success";
		
	}
	//创建普通管理员
	public String createAdmin(){
		
		adminDao.createAdmin(admin);
		
		return "succcess";
		
	}
	public String showAdmin(){
		System.out.println(page+"----"+limit);
		
		List<Admin> admins=adminDao.adminPage(page,limit);
		pagesizes=adminDao.countAll(limit);
		if(pagesizes==0){
			pagesizes=1;
		}
		System.out.println(admins);
		resultMap=new ResultMap(0,"",admins,pagesizes);
	
		return "success";
	}

	
	public ResultMap getResultMap() {
		return resultMap;
	}

	public void setResultMap(ResultMap resultMap) {
		this.resultMap = resultMap;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPagesizes() {
		return pagesizes;
	}

	public void setPagesizes(int pagesizes) {
		this.pagesizes = pagesizes;
	}

	

}
