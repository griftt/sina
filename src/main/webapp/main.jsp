<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		
		<title></title>
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="layui/layui.js"></script>
		<script type="text/javascript" src="js/main.js"></script>
		<link rel="stylesheet" href="layui/css/layui.css" />
		<style>
			
			.search{width: 400px;position: relative;}
			.search input{vertical-align: middle;}
			.search div{vertical-align: middle;position: absolute;top: 0;right: 0;}
			.layui-btn{border-radius: none;}
			.layui-body{}
			#other{height:500px;width:1000px;z-index:1000;}
			
			.show{opacity:1;}
		</style>
	</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">layui 后台布局</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">用户管理</a></li>
      <li class="layui-nav-item"><a href="">信息管理</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">审核系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          admin
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-shrink="all" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">所有商品</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="javascript:;">列表三</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">解决方案</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="">云市场</a></li>
        <li class="layui-nav-item"><a href="">发布商品</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body" >
    <!-- 内容主体区域 -->
    <div style="padding: 15px;" class="m">
    	<div class="search">
    		<input type="text" name="title" required lay-verify="required" id="sea" placeholder="请输入账号" value="" class="layui-input">   	
  			<!-- 搜索框 -->
  				<div>
		  			<button class="layui-btn">
		  				<i class="layui-icon layui-icon-search" style="font-size: 30px; color: white;"></i>
					</button>
  				</div>
  		</div>
   		 <table class="layui-table"  lay-filter="test" id="demo">
		 </table>

 
  </div>
  <div id="other" class="content show">
  		
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
</body>
<script>
	

//列表的重载


	
	
	
layui.use(['table','element'], function(){
  var table = layui.table,laypage=layui.laypage;
  
//转换静态表格
//table.init('demo', {
//height: 400 //设置高度
//,limit: 3 //注意：请务必确保 limit 参数（默认：10）是与你服务端限定的数据条数一致
////支持所有基础参数
//,page:'true'
//}); 


  //第一个实例
 	var tableins= table.render({
    elem: '#demo'
    ,height: 500
    ,url: 'user/loadUser' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {checkbox: true, fixed: true,align:'center' ,width:40}
     , {field: 'id',type:'numbers' ,title: 'ID', width:80, sort: true,align:'center'}
     ,{field: 'account', title: '账号', width: 200,align:'center'}
      ,{field: 'pwd', title: '密码', width: 200,align:'center'}
      ,{field: 'name', title: '用户名', width:220,align:'center'}
      ,{field: 'gender', title: '性别', width:80,align:'center'}
      ,{field: 'province', title: '省份', width:80,align:'center'} 
      ,{field: 'city', title: '城市', width:80,align:'center'} 
      ,{field: 'birthday', title: '生日', width:80,align:'center'} 
      ,{field: 'pic', title: '头像', width: 100,align:'center'}
      ,{field: 'statement', title: '签名', width: 200,align:'center'}
      ,{field: 'dao', title: '操作', width: 260,toolbar:"#barDemo",align:'center'}
      
    ]]
	,id:'first'
	,request: {
     pageName: 'page' //页码的参数名称，默认：page
	,limitName: 'limit' //每页数据量的参数名，默认：limit
	}   
 
  
  });
   
  var $search_in=$("#sea");
  $search_in.keyup(function(){
  
  	var account=$(this).val();
  	/* $.ajax({
  		url:'user/searchUser',
  		type:"post",
  		data:"account="+$(this).val(),
  		dataType:"json",
  		success:function(obj){
  			
  			
  			
  		}
  		 		
  	})*/
  tableins.reload({
  			elem: '#demo'
  		    ,height: 500
  		    ,where:{
  		    	account:account
  		    	
  		    }
  		    ,url: 'user/searchUser' //数据接口
  		    ,page: true //开启分页
  		    
  		    ,cols: [[ //表头
  		      {checkbox: true, fixed: true,align:'center' ,width:40}
  		     , {field: 'id',type:'numbers' ,title: 'ID', width:80, sort: true,align:'center'}
  		     ,{field: 'account', title: '账号', width: 200,align:'center'}
  		      ,{field: 'pwd', title: '密码', width: 200,align:'center'}
  		      ,{field: 'name', title: '用户名', width:220,align:'center'}
  		      ,{field: 'gender', title: '性别', width:80,align:'center'}
  		      ,{field: 'province', title: '省份', width:80,align:'center'} 
  		      ,{field: 'city', title: '城市', width:80,align:'center'} 
  		      ,{field: 'birthday', title: '生日', width:80,align:'center'} 
  		      ,{field: 'pic', title: '头像', width: 100,align:'center'}
  		      ,{field: 'statement', title: '签名', width: 200,align:'center'}
  		      ,{field: 'dao', title: '操作', width: 260,toolbar:"#barDemo",align:'center'}
  		      
  		    ]]
  			
  			,page:{
  				curr:1
  			}
  			
  		
  		
  	})
  })
  
  



table.on('checkbox(test)', function(obj){
	  console.log(obj.checked); //当前是否选中状态
	  console.log(obj.data); //选中行的相关数据
	  console.log(obj.type); 
	  alert(obj.data.id)//如果触发的是全选，则为：all，如果触发的是单选，则为：one
	});

table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
	  var data = obj.data; //获得当前行数据
	  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
	  var tr = obj.tr; //获得当前行 tr 的DOM对象
	  if(layEvent=="del"){
		  table.reload('first',{
			  url:'one'
			  ,where:{name:'hello'}
		  	 ,page:{
			  curr:1
		  }
		  })
		  
	  }
	 
	 
});


});
</script>

</html>

