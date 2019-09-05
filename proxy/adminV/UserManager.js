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
			lockUserState: function(u_id, u_state) {
				//调用自已的
				lockUserState(u_id, u_state);
			},
			deleteUser: function(u_id) {
				//调用自已的
				deleteUser(u_id);
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
		$.post("http://localhost:8888/QuickRun/UserManager11.action",function(result){		
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
					$.post("http://localhost:8888/QuickRun/UserManager11.action",{"page":curr,"pageSize":result.pageSize,"u_phone":u_phone,"u_nickname":u_nickname},function(result){
						app.list = result.list;
					});
				}
			});
			layer.close(index);
		})
	}

	var u_phone;
	var u_nickname;
	//查询
	$(".search_btn").click(function() {
		u_phone = $(".u_phone").val();
		u_nickname = $(".u_nickname").val();
		loadList();
	});
	

	function lockUserState(u_id, u_state) {
		//为0 则进行注销
		if(u_state == 1) {
			layer.confirm('确定修改用户编号为[' + u_id + ']的用户？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.post("http://localhost:8888/QuickRun/suibiangai.action",{"u_id":u_id,"u_state":0},
				function(result) {					
					layer.msg("修改为正常成功");						
					loadList();										
					layer.close(index);
				})
			});
		} else if(u_state == 0){ //其它为1则进行复原
			layer.confirm('确定修改用户编号为[' + u_id + ']的用户？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.post("http://localhost:8888/QuickRun/suibiangai.action",{"u_id":u_id,"u_state":1},
				function(result) {
					layer.msg("修改为注销成功");						
					loadList();	
					layer.close(index);
				})
			});
		}

	}

	//删除用户 
	function deleteUser(u_id) {
		layer.confirm('确定删除[' + u_id + ']用户？', {
			icon: 3,
			title: '提示信息'
		}, function(index) {
			$.post("http://localhost:8888/QuickRun/suibianshan.action",{"u_id":u_id},
			function(result){				
					layer.msg("删除成功");				
					loadList();				
					layer.close(index);
			});
		});

	}
	
	$(".u_phone").keypress(function() {
		loadList();
	});
	$(".u_nickname").keypress(function() {
		loadList();
	});
})