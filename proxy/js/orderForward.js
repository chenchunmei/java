var app = new Vue({
		el:"#app",
		data:{
			putList:{},//收到转交的所有订单
			sendList:{},//转交的所有订单
			orderDetailList:{},//订单详情
			orderCompany:{},//订单中公司
			orderAddress:{},//订单中地址
			orderRectime:{},//订单中送达时间
			orderEmp:{},//订单中骑手
			orderEmpForward:{},//订单中转交骑手
			orderUser:{},//订单中用户
		},
		methods:{
			delivery:function(ord_id){
				delivery(ord_id);
			},
			orderDetail:function(ord_id){
				orderDetail(ord_id);
			}
		},
		created:function(){
			orderPut();
		}
	})

	//查询骑手收到转交的所有订单
	function orderPut(){
		$.post(server_url+"orderForwardPut.action",function(result){
			app.putList = result;
		});
	}
	
	//查询骑手转交的所有订单
	function orderSend(){
		$.post(server_url+"orderForwardSend.action",function(result){
			app.sendList = result;
		});
	}
	
	//点击分类显示订单
	$("#orderPut").click(function(){
		orderPut();
	});
	
	$("#orderSend").click(function(){
		orderSend();
	});

	//确认送达
	function delivery(ord_id){
		$.post(server_url+"updateOrderDelivery.action",{"ord_id":ord_id},function(result){
			if(result != 0){
				$.confirm('确定送达?','完成订单',function(){
					$.alert('已送达');
					orderPut();
					orderSend();
				});
			}else{
				$.alert("确认失败");
			}
		});
	}
	
	//查询订单详情
	function orderDetail(ord_id){
		$.post(server_url+"QuickRun/orderDetailEmp.action",{"ord_id":ord_id},function(result){
			console.log(result);
			app.orderDetailList = result;
			app.orderCompany = result.company;
			app.orderAddress = result.address;
			app.orderEmp = result.emp;
			app.orderUser = result.user;
			app.orderRectime = result.rectime;
			app.orderEmpForward = result.empForward;
		});
	}

	$("#picker-company1").picker({
	  toolbarTemplate: '<header class="bar bar-nav">\
	  <button class="button button-link pull-right close-picker">确定</button>\
	  <h1 class="title">快递公司</h1>\
	  </header>',
	  cols: [
	    {
	      textAlign: 'center',
	      values: ['全部', '中通快递', '圆通快递', '韵达快递', '顺丰快递']
	    }
	  ]
	});
	
	$("#picker-company2").picker({
	  toolbarTemplate: '<header class="bar bar-nav">\
	  <button class="button button-link pull-right close-picker">确定</button>\
	  <h1 class="title">快递公司</h1>\
	  </header>',
	  cols: [
	    {
	      textAlign: 'center',
	      values: ['全部', '中通快递', '圆通快递', '韵达快递', '顺丰快递']
	    }
	  ]
	});
	$("#picker-address2").picker({
	  toolbarTemplate: '<header class="bar bar-nav">\
	  <button class="button button-link pull-right close-picker">确定</button>\
	  <h1 class="title">请选择区域</h1>\
	  </header>',
	  cols: [
	    {
	      textAlign: 'center',
	      values: ['全部', 'A1', 'A2', 'A3', 'A4', 'A5', 'A6']
	    }
	  ]
	});