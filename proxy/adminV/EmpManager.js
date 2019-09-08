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
			lockEmpState: function(emp_id, emp_state,emp_name) {
				//调用自已的
				lockEmpState(emp_id, emp_state,emp_name);
			},
			deleteEmp: function(emp_id,emp_name) {
				//调用自已的
				deleteEmp(emp_id,emp_name);
			},
			addEmp: function(){
				addEmp();
			},
			updateEmp: function(emp_id){
				updateEmp(emp_id);
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
		$.post("http://localhost:8888/QuickRun/EmpManager.action",function(result){		
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
					$.post("http://localhost:8888/QuickRun/EmpManager.action",{"page":curr,"pageSize":result.pageSize,"emp_name":emp_name,"emp_phone":emp_phone},function(result){
						app.list = result.list;
					});
				}
			});
			layer.close(index);
		})
	}

	var emp_name;
	var emp_phone;
	//查询
	$(".search_btn").click(function() {
		emp_name = $(".emp_name").val();
		emp_phone = $(".emp_phone").val();
		loadList();
	});

	function lockEmpState(emp_id, emp_state,emp_name) {
		//为0 则进行注销
		if(emp_state == 1) {
			layer.confirm('确定启用骑手为[' + emp_name + ']的骑手？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.post("http://localhost:8888/QuickRun/EmpManagerUpdateState.action",{"emp_id":emp_id,"emp_state":0},
				function(result) {					
					layer.msg("启用成功");						
					loadList();										
					layer.close(index);
				})
			});
		} else if(emp_state == 0){ //其它为1则进行复原
			layer.confirm('确定停用骑手为[' + emp_name + ']的骑手？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.post("http://localhost:8888/QuickRun/EmpManagerUpdateState.action",{"emp_id":emp_id,"emp_state":1},
				function(result) {
					layer.msg("停用成功");						
					loadList();	
					layer.close(index);
				})
			});
		}

	}

	//删除用户 
	function deleteEmp(emp_id,emp_name) {
		layer.confirm('确定删除[' + emp_name + ']骑手？', {
			icon: 3,
			title: '提示信息'
		}, function(index) {
			$.post("http://localhost:8888/QuickRun/EmpManagerDelete.action",{"emp_id":emp_id},
			function(result){				
					layer.msg("删除成功");				
					loadList();				
					layer.close(index);
			});
		});

	}
	
	function addEmp(){
		var index = layui.layer.open({
			title: "添加骑手",
			area: ['500px', '500px'],
			type: 2,
			content: "addEmp.html"
		})
		
	}
	function updateEmp(emp_id){
		var index = layui.layer.open({
			title: "更新骑手",
			area: ['500px', '500px'],
			type: 2,
			content: "upDateEmp.html?emp_id="+emp_id
		})
		
	}

	$(".emp_name").keypress(function() {
		loadList();
	});
		$(".emp_phone").keypress(function() {
		loadList();
	});
})