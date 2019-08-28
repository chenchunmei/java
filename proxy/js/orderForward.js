var app = new Vue({
		el:"#app",
		data:{
			putList:{},//收到转交的所有订单
			sendList:{},//转交的所有订单
		},
		methods:{
			showDetail:function(pub_id){
				showDetail(pub_id);
			}
		},
		created:function(){
			orderPut();
		}
	})

	//查询骑手收到转交的所有订单
	function orderPut(){
		$.post("http://localhost:8080/QuickRun/orderForwardPut.action",function(result){
			app.putList = result;
		});
	}
	
	//查询骑手转交的所有订单
	function orderSend(){
		$.post("http://localhost:8080/QuickRun/orderForwardSend.action",function(result){
			app.sendList = result;
		});
	}
	
	$("#orderPut").click(function(){
		orderPut();
	});
	
	$("#orderSend").click(function(){
		orderSend();
	});

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
	$("#picker-address1").picker({
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