	var app = new Vue({
		el:"#app",
		data:{
			list:{},//全部订单
			noList:{},//未送达订单
			yesList:{},//已送达订单
			companyList:{},//公司
			addressList:{},//派发地址
			empList:{},//骑手
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
			forward:function(ord_id){
				forward(ord_id);
			},
			orderDetail:function(ord_id){
				orderDetail(ord_id);
			}
		},
		created:function(){
			orderList();
		}
	})
	
	//加载全部订单信息
	function orderList(){
		/*var search1=$("#search1").val();
		var picker_company1=$("#picker-company1").val();
		var picker_address1=$("#picker-address1").val();
		var order1 = {
			"ord_code":search1,
			"com_id":picker_company1,
			"add_id":picker_address1
		}*/
		$.post(server_url+"orderEmpAll.action"/*,order1*/,function(result){
			app.list = result;
		})
	}
	
	//加载未送达订单信息
	function orderListNo(){
		/*var search2=$("#search2").val();
		var picker_company2=$("#picker-company2").val();
		var picker_address2=$("#picker-address2").val();
		var order2 = {
			"ord_code":search2,
			"com_id":picker_company2,
			"add_id":picker_address2
		}*/
		$.post(server_url+"orderEmpNo.action"/*,order2*/,function(result){
			app.noList = result;
		})
	}
	
	//加载已送达订单信息
	function orderListYes(){
		/*var search3=$("#search3").val();
		var picker_company3=$("#picker-company3").val();
		var picker_address3=$("#picker-address3").val();
		var order3 = {
			"ord_code":search3,
			"com_id":picker_company3,
			"add_id":picker_address3
		}*/
		$.post(server_url+"orderEmp.action"/*,order3*/,function(result){
			app.yesList = result;
		})
	}
	
	//点击分类显示订单
	$("#orderAll").click(function(){
		orderList();
	});
	
	$("#orderNo").click(function(){
		orderListNo();
	});
	
	$("#orderYes").click(function(){
		orderListYes();
	});
	
	//查询订单详情
	function orderDetail(ord_id){
		$.post(server_url+"orderDetailEmp.action",{"ord_id":ord_id},function(result){
			console.log(result);
			app.orderDetailList = result;
			app.orderCompany = result.company;
			app.orderAddress = result.address;
			app.orderEmp = result.emp;
			app.orderUser = result.user;
			app.orderRectime = result.rectime;
			if(result.empForward == null){
				app.orderEmpForward = '未转交';
			}else{
				app.orderEmpForward = result.empForward.emp_name;
			}
		});
	}
	
	//确认送达
	function delivery(ord_id){
		$.post(server_url+"updateOrderDelivery.action",{"ord_id":ord_id},function(result){
			if(result != 0){
				$.confirm('确定送达?', '完成订单', function () {
			        $.alert('已送达');
			        orderList();
					orderListNo();
					orderListYes();
			    });
			}else{
				$.alert("确认失败");
			}
		})
	}
	
	//转交
	function forward(ord_id){
		$.post(server_url+"findEmpAll.action",function(result){
			app.empList = result;
			var str;
			$(result).each(function(){
				str += "<option value="+this.emp_id+">"+this.emp_name+"</option>";
			});
			var modal = $.modal({
			    title: '转交订单',
			    text: '请选择转交的骑手',
			    afterText:  '<select id="emp_id">'+str+'</select>',
			    buttons: [
			        {
			          text: '取消'
			        },
			        {
			          text: '确认',
			          bold: true,
			          onClick: function () {
			          	var emp_id = $("#emp_id").val();
			          	alert(emp_id);
			          	$.post(server_url+"updateOrderForward.action",{"ord_id":ord_id,"ord_forward":emp_id},function(result){
			          		if(result != 0){
				          		orderList();
								orderListNo();
								orderListYes();
								$.alert('转交成功！')
			          		}else{
			          			$.alert('转交失败！')
			          		}
			          	});
			          }
			        },
			    ]
			})
		});
		//$.swiper($$(modal).find('.swiper-container'), {pagination: '.swiper-pagination'});
	}
	
	//加载所有快递公司
	function companyAll(){
		$.post(server_url+"companyAll.action",function(result){
			//app.companyList = result;
			cols[0].values = new Array();
			$(result).each(function(){
				cols[0].values.push($(this));
			});
		});
	}
	
	//加载骑手派送地址
	function addressAll(){
		$.post(server_url+"addressEmp.action",function(result){
			app.addressList = result;
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