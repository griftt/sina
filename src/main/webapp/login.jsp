<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="layui/layui.js"></script>
		<link rel="stylesheet" href="layui/css/layui.css" />
		<script type="text/javascript" src="js/iconfont.js" ></script>
		<link rel="stylesheet" href="css/iconfont.css" />
		<style type="text/css">
			* {
				margin: 0;
				padding: 0;
				outline: none;
			}
			
			.box {
				width: 100%;
				height: 1000px;
				background-color: #daecee;
				padding: 0.1px;
			}
			
			.box form {
				height: 400px;
				width: 600px;
				margin: 100px auto;
				background-color: #daecee;
				padding-top: 25px;
				text-align: center;
			}
			
			form p:nth-child(1)>img {
				border-radius: 50%;
				width: 100px;
				height: 100px;
			}
			
			form .one {
				font-size: 0;
				margin-top: 20px;
			}
			
			form .one .fir {
				height: 28px;
				width: 35px;
				background-color: #CCCCCC;
				display: inline-block;
				vertical-align: middle;
				padding-top:3px;
			}
			
			form .one input {
				font-size: 14px;
				height: 31px;
				width: 230px;
				vertical-align: middle;
				border: none;
				padding-left: 8px;
				letter-spacing: 2px;
				
			}
			
			form .r {
				margin-top: 2px;
				margin-left: 191px;
				font-size: 14px;
				margin-bottom: 10px;
			}
			
			form .r input {
				vertical-align: middle;
				padding-left: 10px;
			}
			
			form .r span {
				vertical-align: middle;
			}
			
			form .code {
				margin-top: 15px;
			}
			
			form .code input {
				height: 29px;
				width: 159px;
				vertical-align: middle;
				margin-left: -5px;
				padding-left: 8px;
			}
			
			form .code img {
				height: 29px;
				width: 100px;
				vertical-align: middle;
			}
			
			form p:last-of-type {
				padding-top: 30px;
			}
			
			form .login {
				height: 30px;
				width: 200px;
			}
			
			.iconfont{font-size: 20px;color:gray;margin-top: 3px;}
			
		</style>
	</head>
<body>
		<div class="box">

			<form  >

				<p style="display: none;"><img src="resources/images/bg-sidebar.gif" /></p>
				<div class="one">
					<div class="fir">
						<i class="iconfont icon-zhanghu"></i>
					</div>
					<input type="text" name="account"  placeholder="请输入账号"/>
				</div>
				<div class="one">
					<div class="fir">
						<i class="iconfont icon-zhanghuanquan"></i>
					</div>
					<input type="password" name="pwd" placeholder="请输入密码" />
				</div>
				
				<p class="code"><input type="text" placeholder="请输入验证码" /><img src="login/code"/></p>
				<p class="r" ><input type="checkbox" name="" id="rem" /><span>记住密码</span></p>
					<p><input type="submit" value="登录" class="login" /></p>
			</form>

			</div>

	</body>
</html>