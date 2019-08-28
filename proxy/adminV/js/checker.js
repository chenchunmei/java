var url = "http://127.0.0.1:8080/share/upload/";

layui.config({
	base: "js/"
}).use(['form', 'layer', 'laypage', 'jquery'], function() {
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

	//创建VUEAPP 
	var app = new Vue({
		el: "#app", //app作用域
		data: {
			list: {} //定义一个数据
		},
		methods: { //定义VUE中函数
			updateUstate: function(uname,uid, ustate) {
				// 更改用户状态
				updateUstate(uname,uid, ustate);
			},
			showUserDesc: function(uid) {
				// 查看个人业绩
				showUserDesc(uid);
			}
		},
		created: function() {
			//调用加载数据
			loadList();
		}
	});

	var curr;
	// 自动加载审核员列表
	function loadList() {
		//如果当前分页对象无值则进行赋值
		if(curr == undefined) {
			curr = 1;
		}

		$.post(url + "UserServlet", {
			"m": "findCheckList",
			"curr": curr
		}, function(result) {

			if(result.code == 0) {
				// 填值
				app.list = result.data.data;
				//分页工具类
				var pageUtils = result.data;

				//分页代码
				laypage.render({
					elem: 'laypage', //当前要显示的dom对象[laypage]
					count: pageUtils.rowCount, //总共多少页
					limit: pageUtils.pageSize, //显示页码的的显示总分
					curr: curr, //当前页是第几页 便于分页插件显示
					next: "下一页", //显示的文字
					prev: "上一页", //显示的文字
					skip: true, //是否显示跳转的UI
					jump: function(obj, first) { //跳转时调用的函数
						if(!first) { //first一个Boolean类，检测页面是否初始加载。非常有用，可避免无限刷新。
							//将当前页赋给全局变量存储 便于下一次跳转
							curr = obj.curr;
							loadList();
						}
					}
				});
			} else {
				layer.msg("加载失败");
			}
		})
	}

	// 更改用户状态
	function updateUstate(uname,uid, ustate) {
		var action = "下撤";
		// 更改用户的状态
		if(ustate != 2) {
			ustate = 0; //下撤后成为正常用户
		} else {
			ustate = 3; //审核通过成为审核员
			action = "通过";
		}
		layer.confirm('确定' + action + '[' + uname + ']用户？', {
			icon: 3,
			title: '提示信息'
		}, function(index) {
			$.post(url + "UserServlet", {
					"m": "updateState",
					"ustate": ustate,
					"uid": uid
				},
				function(result) {
					if(result.code == 0) { //正常
						layer.msg("更改成功");
					} else {
						layer.msg("更改失败");
					}
					layer.close(index);
				}
			);
			//更改后加载一下
			loadList();
		});

	}

	// 查看个人审核业绩
	function showUserDesc(uid) {
		// 转到报表页面
		layui.layer.open({
			title: "个人报表详情",
			area: ['500px', '480px'],
			type: 2,
			content: "echartsUser.html?uid=" + uid
		})
	}

});