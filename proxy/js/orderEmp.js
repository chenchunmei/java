	var app = new Vue({
		el:"#app",
		data:{
			list:{},//全部订单
			noList:{},//未送达订单
			yesList:{},//已送达订单
		},
		methods:{
			showDetail:function(pub_id){
				showDetail(pub_id);
			}
		},
		created:function(){
			orderList();
		}
	})
	
	//加载全部订单信息
	function orderList(){
		$.post("http://localhost:8080/QuickRun/orderEmpAll.action",function(result){
			app.list = result;
		})
	}
	
	//加载未送达订单信息
	function orderListNo(){
		$.post("http://localhost:8080/QuickRun/orderEmpNo.action",function(result){
			app.noList = result;
		})
	}
	
	//加载已送达订单信息
	function orderListYes(){
		$.post("http://localhost:8080/QuickRun/orderEmp.action",function(result){
			app.yesList = result;
		})
	}
	
	$("#orderAll").click(function(){
		orderList();
	});
	
	$("#orderNo").click(function(){
		orderListNo();
	});
	
	$("#orderYes").click(function(){
		orderListYes();
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
	
$("#picker-company3").picker({
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
	$("#picker-address3").picker({
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