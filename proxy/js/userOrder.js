$(function(){
	
	var app = new Vue({
		el: "#userorder_app",
		data: {
			list: {}
		},
		methods: {
			deleteUserOrder: function(ord_id) {
				deleteUserOrder(ord_id)
			}
		},
		created: function() {
				loadOrderList();
				
		}
	})

	//加载订单数据
	function loadOrderList() {
		$.post("http://127.0.0.1:8888/QuickRun/selectorderbyuid.action",function(result){
			app.list= result;
			console.log(result);
		})
	}
	
	//删除发单记录
	function deleteUserOrder(pccode) {
		sui.confirm('确定删除['+pccode+']发单信息？',{icon:2, title:'提示信息'},function(index){
			$.post("http://127.0.0.1:8888/QuickRun/deleteUserOrder.action",function(result){
				app.list= result;
				if(result.code == 0) {
					layer.msg("删除发单信息成功");
					findAllOver();
				} else {
					layer.msg("删除发单信息失败");
					findAllOver();
				}
				layer.close(index);
			})
			
			
		})
	}
	
		
		
		
		
	
	
});



