$(function(){
	var app = new Vue({
		el: "#userorder_app",
		data: {
			list: {},
		},
		methods: {
			deleteUserOrder: function(ord_code) {
				deleteUserOrder(ord_code)
			},
			complaint:function(ord_code){
				complaint(ord_code)
			},
			details:function(ord_code){
				details(ord_code);
			}
		},
		created: function() {
				loadOrderList();
				
		}
	})
	
	//删除订单记录
	function deleteUserOrder(ord_code){
		 $.post("http://127.0.0.1:8888/QuickRun/deleteUserOrder.action",{"ord_code":ord_code},function(result){
			app.list= result;
			console.log(result);
			loadOrderList();
		});
	}
	
	function complaint(ord_code){
		window.location.href="compaint.html?ord_code="+ord_code;
	}
	
	$('#code').bind('keypress', function (event) { 
	   if (event.keyCode == "13") { 
	    $("#searchBtn").click();
	   }
	  })

	$("#searchBtn").click(function(){
		loadOrderList();
		
	});


	//加载订单数据
	function loadOrderList() {
		var ord_code = $("#code").val();
		$.post("http://127.0.0.1:8888/QuickRun/selectorderbyuid.action",{"ord_code":ord_code},function(result){
			/*var da=result.ord_send_time;
			da = new Date(da);  
			var year = da.getFullYear();  
			var month = da.getMonth() + 1;
			var date = da.getDate();
			var hour =da.getHours();
			var minute=da.getMinutes();
			var seconde=da.getSeconds();
			if(month < 10) {
				var time = year + "-0" + month + "-" + date + " " +hour+":"+minute+":"+seconde;
			} else {
				var time = year + "-" + month + "-" + date + " " +hour+":"+minute+":"+seconde;
			}*/
			app.list= result;
		})
	}
	
	function details(ord_code){
		window.location.href="userOrderDetails.html?ord_code="+ord_code;
	}
});



