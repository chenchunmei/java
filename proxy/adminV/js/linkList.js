var url = "http://127.0.0.1:8888/share/upload/";

layui.config({
	base: "js/"
}).use(['form', 'layer', 'jquery', 'laypage'], function() {
		var form = layui.from,
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
			deletMajor: function(mname, maid) {
				deletMajor(mname, maid);
			}

		},
		created: function() {
			//调用加载数据
			loadList();
		}
	})
	
	
	//删除
	function deletMajor(mname, maid) {
		layer.confirm('确定删除[' + mname + ']专业？', {
			icon: 3,
			title: '提示信息'
		}, function(index) {
			sendRequest("POST", "MajorServlet", {
				"m": "delet",
				"maid": maid
			}, function(result) {
				if(result.code == 0) {
					layer.msg("删除成功");
					//重新加载
					loadList();
				} else {
					layer.msg("删除失败");
				}
				layer.close(index);
			});
		});

	}

	//查询
	$(".search_btn").click(function() {
		loadList();
	});

	$(".search_name").keypress(function() {
		loadList();
	});



	//添加友情链接
	$(".linksAdd_btn").click(function() {
		var index = layui.layer.open({
			title: false,
			type: 2,
			area:['300px','200px'],
			content: "Add.html",
			success: function(layero, index) {
				layui.layer.tips( {
					tips: 3
				});
			}
		})
	
	})

	//存储当前页的信息
	var curr;
	
	function loadList() {
		//如果当前分页对象无值则进行赋值
		if(curr == undefined) {
			curr = 1;
		}

		var searchName = $(".search_input").val();
		//加载页面数据
		sendRequest("POST","upload/MajorServlet", {
			"m": "list",
			"page": curr,
			"searchName": searchName
		}, function(result) {
			
			
			//执行加载数据的方法
			app.list = result.data.data;
			
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
		//layer.close(index);
		})
	}
})