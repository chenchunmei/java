$(function(){
	
	var app = new Vue({
		el: "#userorder_app",
		data: {
			list: {}
		},
		methods: {
			
		},
		created: function() {
				loadOrderList();
				
		}
	})

	//加载订单数据
	function loadOrderList() {
		$.post("http://127.0.0.1:8888/QuickRun/selectorderbyuid.action",function(result){
			app.list = result;
			console.log(result);
		})
	}
	
	
});



