/**
 * 显示快递信息
 */
var app = new Vue({
		el: "#userorder_app",
		data: {
			list: {},
			userorderEmp:{}
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
			},
			oversend: function(ord_code) {
				oversend(ord_code)
			}
		},
		created: function() {
				loadOrderList();
		}
	})
	
	//删除订单记录
	function deleteUserOrder(ord_code){
		window.$$ = window.Zepto = Zepto;
		$$.confirm('确定删除【'+ord_code+'】吗?', function () {
		 $.post(server_url+"deleteUserOrder.action",{"ord_code":ord_code},function(result){
		 	if(result != 0){
			        $$.alert('已删除');
					loadOrderList();
			}else{
				$$.alert("删除失败");
				loadOrderList();
			}
			});
		});
	}
	
	//投诉
	function complaint(ord_code){
		window.location.href="compaint.html?ord_code="+ord_code;
	}
	
	//回车键搜索
	$('#code').bind('keypress', function (event) { 
	   if (event.keyCode == "13") { 
	    $("#searchBtn").click();
	   }
	  })

	$("#searchBtn").click(function(){
		loadOrderList();
		
	});
	

	//用户确认完成
	function oversend(ord_code){
		window.$$ = window.Zepto = Zepto;
		$$.confirm('确定完成【'+ord_code+'】吗?', function () {
		 $.post(server_url+"overSendOrder.action",{"ord_code":ord_code},function(result){
		 	if(result != 0){
			        $$.alert('已完成');
					loadOrderList();
			}else{
				$$.alert("确认完成失败");
				loadOrderList();
			}
			});
		});
	}

	//加载订单数据
	function loadOrderList() {
		var ord_code = $("#code").val();
		$.post(server_url+"selectorderbyuid.action",{"ord_code":ord_code},function(result){
			var data=result.ord_send_time;
			app.list= result;
			console.log(result)
			app.userorderEmp = result.emp;
		})
	}
	
	//订单详情跳转
	function details(ord_code){
		window.location.href="userOrderDetails.html?ord_code="+ord_code;
	}




