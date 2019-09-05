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
			delivery:function(ord_id){//确认送达
				delivery(ord_id);
			},
			forward:function(ord_id){//转交
				forward(ord_id);
			},
			orderDetail:function(ord_id){//查询订单详情
				orderDetail(ord_id);
			}
		},
		created:function(){
			orderList();//加载全部订单信息
			companyAll();//加载所有快递公司
			addressAll();//加载骑手派送地址
		}
	})
	
	
	//快递公司
	var companyMap = {};
	//派送地址
	var addressMap = {};
	//加载全部订单信息
	function orderList(){
		//骑手id
		var emp_id = localStorage.getItem("emp_id");
		//订单编号
		var ord_code=null;
		var search1=$("#search1").val();
		if(search1 != null && search1 != ''){
			
			ord_code="%"+search1+"%";
			alert(ord_code);
		}
		//公司id
		var com_id=0;
		var company1=$("#company1").val();
		if(company1 != null && company1 != ''){
			com_id=companyMap[company1];
		}
		//地址id
		var add_id=0;
		var address1=$("#address1").val();
		if(address1 != null && address1 != ''){
			add_id=addressMap[address1];
		}
		//用JSON格式传送后端
		var order1 = {
			"emp_id":emp_id,
			"ord_code":ord_code,
			"com_id":com_id,
			"add_id":add_id
		}
		//Ajax
		$.post(server_url+"orderEmpAll.action",order1,function(result){
			app.list = result;
		})
	}
	
	//加载未送达订单信息
	function orderListNo(){
		//骑手id
		var emp_id = localStorage.getItem("emp_id");
		//订单编号
		var ord_code=null;
		var search2=$("#search2").val();
		if(search2 != null && search2 != ''){
			ord_code="%"+search2+"%";
		}
		//公司id
		var com_id=0;
		var company2=$("#company2").val();
		if(company2 != null && company2 != ''){
			com_id=companyMap[company2];
		}
		//地址id
		var add_id=0;
		var address2=$("#address2").val();
		if(address2 != null && address2 != ''){
			add_id=addressMap[address2];
		}
		//用JSON格式传送后端
		var order2 = {
			"emp_id":emp_id,
			"ord_code":ord_code,
			"com_id":com_id,
			"add_id":add_id
		}
		//Ajax
		$.post(server_url+"orderEmpNo.action",order2,function(result){
			app.noList = result;
		})
	}
	
	//加载已送达订单信息
	function orderListYes(){
		//骑手id
		var emp_id = localStorage.getItem("emp_id");
		//订单编号
		var ord_code=null;
		var search3=$("#search3").val();
		if(search3 != null && search3 != ''){
			ord_code="%"+search3+"%";
		}
		//公司id
		var com_id=0;
		var company3=$("#company3").val();
		if(company3 != null && company3 != ''){
			com_id=companyMap[company3];
		}
		//地址id
		var add_id=0;
		var address3=$("#address3").val();
		if(address3 != null && address3 != ''){
			add_id=addressMap[address3];
		}
		//用JSON格式传送后端
		var order3 = {
			"emp_id":emp_id,
			"ord_code":ord_code,
			"com_id":com_id,
			"add_id":add_id
		}
		//Ajax
		$.post(server_url+"orderEmp.action",order3,function(result){
			app.yesList = result;
		})
	}
	
	//点击分类显示全部订单
	$("#orderAll").click(function(){
		$("#search1").val("");
		$("#company1").val("");
		$("#address1").val("");
		orderList();
	});
	//点击分类显示未送达订单
	$("#orderNo").click(function(){
		$("#search2").val("");
		$("#company2").val("");
		$("#address2").val("");
		orderListNo();
	});
	//点击分类显示已送达订单
	$("#orderYes").click(function(){
		$("#search3").val("");
		$("#company3").val("");
		$("#address3").val("");
		orderListYes();
	});
	//全部订单点击搜索查询
	$("#searchbtn1").click(function(){
		orderList();
	});
	//未送达订单点击搜索查询
	$("#searchbtn2").click(function(){
		orderListNo();
	});
	//已送达订单点击搜索查询
	$("#searchbtn3").click(function(){
		orderListYes();
	});
	
	//查询订单详情
	function orderDetail(ord_id){
		//Ajax
		$.post(server_url+"orderDetailEmp.action",{"ord_id":ord_id},function(result){
			//取得后台传过来的数据
			app.orderDetailList = result;
			app.orderCompany = result.company;
			app.orderAddress = result.address;
			app.orderEmp = result.emp;
			app.orderUser = result.user;
			app.orderRectime = result.rectime;
			//判断订单是否转交
			if(result.empForward == null){
				app.orderEmpForward = '未转交';
			}else{
				app.orderEmpForward = result.empForward.emp_name;
			}
		});
	}
	
	//确认送达
	function delivery(ord_id){
		//提示框
		$.confirm('确定送达?', '完成订单', function () {
			$.post(server_url+"updateOrderDelivery.action",{"ord_id":ord_id},function(result){
				//判断是否确认送达
				if(result != 0){
			        $.alert('已送达');
			        orderList();
					orderListNo();
					orderListYes();
				}else{
					$.alert("确认失败");
				}
			})
		});
	}
	
	//转交
	function forward(ord_id){
		//骑手id
		var emp_id = localStorage.getItem("emp_id");
		//查询所有骑手
		$.post(server_url+"findEmpAll.action",{"emp_id":emp_id},function(result){
			//取得后台传过来的数据
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
	}
	
	/*cols[0].values = new Array();
	$(result).each(function(){
		cols[0].values.push($(this));
	});*/
	//加载所有快递公司
	function companyAll(){
		$.post(server_url+"companyAll.action",function(result){
			//创建一个数组装遍历的内容
			var company = new Array();
			company.push("全部");
			//把公司遍历到数组
			$(result).each(function(){
				company.push(this.com_name);
			});
			
			companyMap['全部'] = 0;
			//把公司以及id遍历给自定义的Map
			$(result).each(function(){
				companyMap[this.com_name] = this.com_id;
			});
			//弹出框
			$("#company1").picker({
			  	toolbarTemplate: '<header class="bar bar-nav">\
			  	<button class="button button-link pull-right close-picker">确定</button>\
			  	<h1 class="title">快递公司</h1>\
			  	</header>',
			  	cols: [
				    {
				      	textAlign: 'center',
				      	values: company
				    }
			  	]
			});
			$("#company2").picker({
			  	toolbarTemplate: '<header class="bar bar-nav">\
			  	<button class="button button-link pull-right close-picker">确定</button>\
			  	<h1 class="title">快递公司</h1>\
			  	</header>',
			  	cols: [
				    {
				      	textAlign: 'center',
				      	values: company
				    }
			  	]
			});
			$("#company3").picker({
			  	toolbarTemplate: '<header class="bar bar-nav">\
			  	<button class="button button-link pull-right close-picker">确定</button>\
			  	<h1 class="title">快递公司</h1>\
			  	</header>',
			  	cols: [
				    {
				      	textAlign: 'center',
				      	values: company
				    }
			  	]
			});
		});
	}
	
	//加载骑手派送地址
	function addressAll(){
		$.post(server_url+"addressEmp.action",function(result){
			//创建一个数组装遍历的内容
			var address = new Array();
			address.push("全部");
			//把派送地址遍历到数组
			$(result).each(function(){
				address.push(this.add_detail);
			});
			
			addressMap['全部'] = 0;
			//把派送地址以及id遍历给自定义的Map
			$(result).each(function(){
				addressMap[this.add_detail] = this.add_id;
			});
			//弹出框
			$("#address1").picker({
			  	toolbarTemplate: '<header class="bar bar-nav">\
			  	<button class="button button-link pull-right close-picker">确定</button>\
			  	<h1 class="title">请选择区域</h1>\
			  	</header>',
			  	cols: [
			    	{
			      		textAlign: 'center',
			      		values: address
			    	}
			  	]
			});
			$("#address2").picker({
			  	toolbarTemplate: '<header class="bar bar-nav">\
			  	<button class="button button-link pull-right close-picker">确定</button>\
			  	<h1 class="title">请选择区域</h1>\
			  	</header>',
			  	cols: [
			    	{
			      		textAlign: 'center',
			      		values: address
			    	}
			  	]
			});
			$("#address3").picker({
			  	toolbarTemplate: '<header class="bar bar-nav">\
			  	<button class="button button-link pull-right close-picker">确定</button>\
			  	<h1 class="title">请选择区域</h1>\
			  	</header>',
			  	cols: [
			    	{
			      		textAlign: 'center',
			      		values: address
			    	}
			  	]
			});
		});
	}