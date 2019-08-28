layui.use(['form', 'layer', 'jquery', 'laypage'], function() {
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

	var app = new Vue({
		el: "#app", //app作用域
		data: {
			list: {} //定义一个数据
		},
		methods: { //定义VUE中函数
			lockComoanyState: function(com_id, add_state) {
				//调用自已的
				lockComoanyState(com_id, add_state);
			},
			deleteCompany: function(com_id) {
				//调用自已的
				deleteCompany(com_id);
			},
			showCompanycontent: function(com_id){
				showCompanycontent(com_id);
			},
		},
		created: function() {
			//调用加载数据
			loadList();
		}
	})

	
	
	
		var curr;
		
		function loadList() {
			var index = layer.load(4)
		$.post("http://localhost:8888/QuickRun/company1.action",function(result){		
			app.list = result.list;		
			//分页代码
			laypage.render({
				elem: "laypage", //当前要显示的dom对象[laypage]				
				count: result.total, //总共多少页
				limit: result.pageSize, //显示页码的的显示总分
				curr: curr, //当前页是第几页 便于分页插件显示
			    next: "下一页", //显示的文字
				prev: "上一页", //显示的文字
				skip: true, //是否显示跳转的UI
				jump: function(obj, first) { //跳转时调用的函数
					//将当前页赋给全局变量存储 便于下一次跳转
					curr = obj.curr;
					$.post("http://localhost:8888/QuickRun/company1.action",{"page":curr,"pageSize":result.pageSize,"com_name":com_name},function(result){
						app.list = result.list;
					});
				}
			});
			layer.close(index);
		})
	}

	var com_name;
	//查询
	$(".search_btn").click(function() {
		com_name = $(".com_name").val();
		loadList();
	});

	function lockComoanyState(com_id, add_state) {
		//为0 则进行注销
		if(add_state == 1) {
			layer.confirm('确定修改公司编号为[' + com_id + ']的公司？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.post("http://localhost:8888/QuickRun/companyUpdateState.action",{"com_id":com_id,"add_state":0},
				function(result) {					
					layer.msg("修改为营业成功");						
					loadList();										
					layer.close(index);
				})
			});
		} else if(add_state == 0){ //其它为1则进行复原
			layer.confirm('确定修改公司编号为[' + com_id + ']的公司？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.post("http://localhost:8888/QuickRun/companyUpdateState.action",{"com_id":com_id,"add_state":1},
				function(result) {
					layer.msg("修改为打烊成功");						
					loadList();	
					layer.close(index);
				})
			});
		}

	}

	//删除用户 
	function deleteCompany(com_id) {
		layer.confirm('确定删除[' + com_id + ']公司？', {
			icon: 3,
			title: '提示信息'
		}, function(index) {
			$.post("http://localhost:8888/QuickRun/companydelete.action",{"com_id":com_id},
			function(result){				
					layer.msg("删除成功");				
					loadList();				
					layer.close(index);
			});
		});

	}
	function showCompanycontent(com_id) {
				$.post("http://localhost:8888/QuickRun/selectCompanyByid.action",{"com_id":com_id},
				function(result) {
						var fdesc = result.com_content;
						var index = layer.open({
						type: 1
						,offset:'auto' 
						,id: 'layerDemo' + 'auto' //防止重复弹出
						,area: ['500px', '400px']
						,content: '<div style="padding: 20px 100px;">' + fdesc + '</div>'
						,btn: '关闭'
						,btnAlign: 'c' //按钮居中
						,shade: 0 //不显示遮罩,
						,yes: function() {
							layer.closeAll();
						}
				   });
				});
			}

	$(".com_name").keypress(function() {
		loadList();
	});
})