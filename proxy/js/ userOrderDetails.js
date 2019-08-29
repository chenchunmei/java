$(function(){
	var app = new Vue({
		el: "#userorderdetails_app",
		data: {
			list: {},
			listCompany:{},
			listAddress:{},
			listRectime:{},
			listEmp:{}
		},
		methods: {
			
		},
		created: function() {
				loadOrderDetailsList();
		}
	})

	//加载订单数据
	function loadOrderDetailsList() {
		var code = location.search ;
		var ord_code=code.substr(code.indexOf("=")+1);
		$.post("http://127.0.0.1:8888/QuickRun/findOrderdetailsByordId.action",{"ord_code":ord_code},function(result){
			app.list= result;
			app.listCompany = result.company;
			app.listAddress = result.address;
			app.listRectime = result.rectime;
			app.listEmp = result.emp;
			console.log(result);
		})
	}
});



