var app = new Vue({
		el:"#app",
		data:{
			list:{},
		},
		methods:{
		},
		created:function(){
			loadList();
		}
	})

	//查询订单详情
	function loadList(){
		//var ord_id
		$.post("http://localhost:8080/QuickRun/orderDetailEmp.action",function(result){
			app.list = result;
		});
	}
