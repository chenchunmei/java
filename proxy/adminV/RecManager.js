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
			lockRecState: function(rec_id, rec_state,rec_detail) {
				//调用自已的
				lockRecState(rec_id, rec_state,rec_detail);
			},
			deleteRec: function(rec_id,rec_detail) {
				//调用自已的
				deleteRec(rec_id,rec_detail);
			},
			addRec: function(){
				addRec();
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
		$.post("http://localhost:8888/QuickRun/RecManager.action",function(result){		
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
					$.post("http://localhost:8888/QuickRun/RecManager.action",{"page":curr,"pageSize":result.pageSize},function(result){
						app.list = result.list;
					});
				}
			});
			layer.close(index);
		})
	}

	function lockRecState(rec_id, rec_state,rec_detail) {
		//为0 则进行注销
		if(rec_state == 1) {
			layer.confirm('确定启用配送时间为[' + rec_detail + ']的时间？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.post("http://localhost:8888/QuickRun/RecManagerUpdate.action",{"rec_id":rec_id,"rec_state":0},
				function(result) {					
					layer.msg("启用成功");						
					loadList();										
					layer.close(index);
				})
			});
		} else if(rec_state == 0){ //其它为1则进行复原
			layer.confirm('确定停止配送时间为[' + rec_detail + ']的时间？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.post("http://localhost:8888/QuickRun/RecManagerUpdate.action",{"rec_id":rec_id,"rec_state":1},
				function(result) {
					layer.msg("停止成功");						
					loadList();	
					layer.close(index);
				})
			});
		}

	}

	//删除用户 
	function deleteRec(rec_id,rec_detail) {
		layer.confirm('确定删除[' + rec_detail + ']用户？', {
			icon: 3,
			title: '提示信息'
		}, function(index) {
			$.post("http://localhost:8888/QuickRun/RecManagerDelete.action",{"rec_id":rec_id},
			function(result){				
					layer.msg("删除成功");				
					loadList();				
					layer.close(index);
			});
		});

	}
	function addRec(){
		var index = layui.layer.open({
			title: "添加接受时间",
			area: ['500px', '400px'],
			type: 2,
			content: "addRec.html"
		})
		
	}
})