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
			lockOrderState: function(ord_code, ord_state) {
				//调用自已的
				lockOrderState(ord_code, ord_state);
			},
			deleteOrder: function(ord_code) {
				//调用自已的
				deleteOrder(ord_code);
			},
			showOrdercontent: function(ord_code){
				showOrdercontent(ord_code);
			},
			addOrder: function(){
				addOrder();
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
		$.post("http://localhost:8888/QuickRun/orderManage.action",function(result){		
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
					$.post("http://localhost:8888/QuickRun/orderManage.action",{"page":curr,"pageSize":result.pageSize,"ord_code":ord_code,"ord_rec_name":ord_rec_name},function(result){
						app.list = result.list;
					});
				}
			});
			layer.close(index);
		})
	}

	var ord_code;
	var ord_rec_name;
	//查询
	$(".search_btn").click(function() {
		ord_code = $(".ord_code").val();
		ord_rec_name= $(".ord_rec_name").val();
		loadList();
	});
	$(".ord_code").keypress(function() {
		loadList();
	});
	$(".ord_rec_name").keypress(function() {
		loadList();
	});

	function lockComoanyState(ord_code, ord_state) {
		//为0 则进行注销
		if(ord_state == 1) {
			layer.confirm('确定修改公司编号为[' + ord_code + ']的公司？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.post("http://localhost:8888/QuickRun/companyUpdateState.action",{"ord_code":ord_code,"ord_state":0},
				function(result) {					
					layer.msg("修改为营业成功");						
					loadList();										
					layer.close(index);
				})
			});
		} else if(ord_state == 0){ //其它为1则进行复原
			layer.confirm('确定修改公司编号为[' + ord_state + ']的公司？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.post("http://localhost:8888/QuickRun/companyUpdateState.action",{"ord_code":ord_code,"ord_state":1},
				function(result) {
					layer.msg("修改为打烊成功");						
					loadList();	
					layer.close(index);
				})
			});
		}

	}

	//删除用户 
	function deleteOrder(ord_code) {
		layer.confirm('确定删除订单编号为[' + ord_code + ']的订单？', {
			icon: 3,
			title: '提示信息'
		}, function(index) {
			$.post("http://localhost:8888/QuickRun/orderManagedelete.action",{"ord_code":ord_code},
			function(result){				
					layer.msg("删除成功");				
					loadList();				
					layer.close(index);
			});
		});

	}
	function showOrdercontent(ord_code) {
				$.post("http://localhost:8888/QuickRun/orderDetails.action",{"ord_code":ord_code},
				function(result) {
						var com_name = result.com_name;
						var emp_name = result.emp_name;
						var add_detail = result.add_detail;
						var u_nickname = result.u_nickname;
						var rec_detail = result.rec_detail;
						var index = layer.open({
						type: 1
						,offset:'auto' 
						,id: 'layerDemo' + 'auto' //防止重复弹出
						,area: ['500px', '400px']
						,content: '<div style="padding: 25px; font-size: 22px; line-height: 25px; font-size=30px;  font-weight: 300; align-self:center;">快递公司名为:' +com_name+'<br><br>快递收件人昵称为: '+u_nickname+'<br><br>快递送达地址为:' +add_detail+'<br><br>骑手姓名为:'+emp_name+'<br><br>接收时间为:'+rec_detail+'</div>'
						,btn: '关闭'
						,btnAlign: 'c' //按钮居中
						,shade: 0 //不显示遮罩,
						,yes: function() {
							layer.closeAll();
						}
				   });
				});
			}
})