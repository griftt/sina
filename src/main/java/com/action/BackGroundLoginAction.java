package com.action;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.util.CodeUtil;
@Controller
@Scope("prototype")
public class BackGroundLoginAction {
	private InputStream input;
	
	public String  code(){
		String code =CodeUtil.number();
		BufferedImage image= CodeUtil.codeImg(code);
		input=CodeUtil.handCode(image);
		System.out.println(1);
		System.out.println(code);
		System.out.println(input);
		return "success";
	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}
	
	
	
	
}
