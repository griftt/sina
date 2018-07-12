window.onload=function(){
	alert(11)
	layui.use([ 'table', 'element' ], function() {
		var table = layui.table, laypage = layui.laypage;
		var tableins="" 
		//转换静态表格
		//table.init('demo', {
		//height: 400 //设置高度
		//,limit: 3 //注意：请务必确保 limit 参数（默认：10）是与你服务端限定的数据条数一致
		////支持所有基础参数
		//,page:'true'
		//}); turn.js

		//第一个实例
		tableins = table.render({
			elem : '#demo',
			height : 500,
			url : '/sina/user/loadUser' //数据接口
			,
			page : true //开启分页
			,
			cols : [ [ //表头
			{
				checkbox : true,
				fixed : true,
				align : 'center',
				width : 40
			}, {
				field : 'id',
				type : 'numbers',
				title : 'ID',
				width : 80,
				sort : true,
				align : 'center'
			}, {
				field : 'account',
				title : '账号',
				width : 200,
				align : 'center'
			}, {
				field : 'pwd',
				title : '密码',
				width : 200,
				align : 'center'
			}, {
				field : 'name',
				title : '用户名',
				width : 220,
				align : 'center'
			}, {
				field : 'gender',
				title : '性别',
				width : 80,
				align : 'center'
			}, {
				field : 'province',
				title : '省份',
				width : 80,
				align : 'center'
			}, {
				field : 'city',
				title : '城市',
				width : 80,
				align : 'center'
			}, {
				field : 'birthday',
				title : '生日',
				width : 80,
				align : 'center'
			}, {
				field : 'pic',
				title : '头像',
				width : 100,
				align : 'center'
			}, {
				field : 'statement',
				title : '签名',
				width : 200,
				align : 'center'
			}, {
				field : 'dao',
				title : '操作',
				width : 260,
				toolbar : "#barDemo",
				align : 'center'
			}

			] ],
			id : 'first',
			request : {
				pageName : 'page' //页码的参数名称，默认：page
				,
				limitName : 'limit' //每页数据量的参数名，默认：limit
			}

		});

		var $search_in = $("#sea");
		$search_in.keyup(function() {

			var account = $(this).val();
			tableins.reload({
				elem : '#demo',
				height : 500,
				where : {
					account : account

				},
				url : '/sina/user/searchUser' //数据接口
				,
				page : true //开启分页

				,
				cols : [ [ //表头
				{
					checkbox : true,
					fixed : true,
					align : 'center',
					width : 40
				}, {
					field : 'id',
					type : 'numbers',
					title : 'ID',
					width : 80,
					sort : true,
					align : 'center'
				}, {
					field : 'account',
					title : '账号',
					width : 200,
					align : 'center'
				}, {
					field : 'pwd',
					title : '密码',
					width : 200,
					align : 'center'
				}, {
					field : 'name',
					title : '用户名',
					width : 220,
					align : 'center'
				}, {
					field : 'gender',
					title : '性别',
					width : 80,
					align : 'center'
				}, {
					field : 'province',
					title : '省份',
					width : 80,
					align : 'center'
				}, {
					field : 'city',
					title : '城市',
					width : 80,
					align : 'center'
				}, {
					field : 'birthday',
					title : '生日',
					width : 80,
					align : 'center'
				}, {
					field : 'pic',
					title : '头像',
					width : 100,
					align : 'center'
				}, {
					field : 'statement',
					title : '签名',
					width : 200,
					align : 'center'
				}, {
					field : 'dao',
					title : '操作',
					width : 260,
					toolbar : "#barDemo",
					align : 'center'
				}

				] ]

				,
				page : {
					curr : 1
				}

			})
		})
	//管理员列表
	$("#empower").click(function(){		
		tableins.reload({
			elem : '#demo',
			height : 500,			
			url : '/sina/adminLogin/showAdmin' //数据接口
			,page : true //开启分页
			,cols : [ [ //表头
			{
				checkbox : true,
				fixed : true,
				align : 'center',
				width : 40
			}, {
				field : 'id',
				type : 'numbers',
				title : 'ID',
				width : 80,
				sort : true,
				align : 'center'
			}, {
				field : 'account',
				title : '账号',
				width : 200,
				align : 'center'
			}, {
				field : 'pwd',
				title : '密码',
				width : 200,
				align : 'center'
			}, {
				field : 'name',
				title : '用户名',
				width : 220,
				align : 'center'
			}, {
				field : 'roleId',
				title : '性别',
				width : 80,
				align : 'center'
			},{
				field : 'dao',
				title : '操作',
				width : 260,
				toolbar : "#barDemo",
				align : 'center'
			}
			] ]
			,done:function(){
				alert(222)
			}
			,page : {
				curr : 1
			}

			

			})
		
		
		})
	


		table.on('checkbox(test)', function(obj) {
			console.log(obj.checked); //当前是否选中状态
			console.log(obj.data); //选中行的相关数据
			console.log(obj.type);
			alert(obj.data.id)//如果触发的是全选，则为：all，如果触发的是单选，则为：one
		});

		table.on('tool(test)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的DOM对象
			if (layEvent == "del") {
				table.reload('first', {
					url : 'one',
					where : {
						name : 'hello'
					},
					page : {
						curr : 1
					}
				})

			}

		});

	});
	
	

	

	
	
	
	
	$(".page").css({"opacity":"0","z-index":"1",});
	$(".users").css({"opacity": "1" , "z-index":"1000",});
	$("#userAdmin").click(function() {
		$(".page").css({"opacity":"0","z-index":"1",});
		$(".users").css({"opacity": "1" , "z-index":"1000",});
	})
	$("#control").click(function() {
		$(".page").css({"opacity":"0","z-index":"1",});
		$(".userdetail").css({"opacity": "1" , "z-index":"1000",});
	})
	$("#wei").click(function() {
		$(".page").css({"opacity":"0","z-index":"1",});
		$(".weibo").css({"opacity": "1" , "z-index":"1000",});
	})
	$("#message").click(function() {
		$(".page").css({"opacity":"0","z-index":"1",});
		$(".adminpage").css({"opacity": "1" , "z-index":"1000",});
	})
}
