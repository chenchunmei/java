$(function(){
	
	var app = new Vue({
		el: "#userorder_app",
		data: {
			list: {}
		},
		methods: {
			deleteUserOrder: function(ord_id) {
				deleteUserOrder(ord_id)
			},
			complaint:function(ord_code){
				complaint(ord_code)
			}
		},
		created: function() {
				loadOrderList();
				
		}
	})
	
	//删除订单记录
	function deleteUserOrder(ord_id){
		alert(1234)
		$.post("http://127.0.0.1:8888/QuickRun/deleteUserOrder.action",function(result){
			app.list= result;
			console.log(result);
			loadOrderList();
		});
	}
	
	function complaint(ord_code){
		window.location.href="compaint.html?ord_code="+ord_code;
	}


	

	//加载订单数据
	function loadOrderList() {
		$.post("http://127.0.0.1:8888/QuickRun/selectorderbyuid.action",function(result){
			app.list= result;
			console.log(result);
		})
	}
});



