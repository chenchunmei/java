var app = new Vue({
		el: "#app",
		data: {
			list: {},
			over: {},
			rec: {}
		},
		methods: {
			
		},
		created: function() {
				loadList();
				loadAddList();
				loadTimeList();
		}
	})

	//加载快递信息数据
	function loadList() {
		$.post("http://localhost:8888/QuickRun/query.action",function(result){
			app.list = result;
		})
	}
	
	//加载接收地址信息数据
	function loadAddList() {
		$.post("http://localhost:8888/QuickRun/queryAdd.action",function(result){
			app.over = result;
		})
	}
	
	//加载接收地址信息数据
	function loadTimeList() {
		$.post("http://localhost:8888/QuickRun/queryTime.action",function(result){
			app.rec = result;
		})
	}

	//添加发单信息
	$("#sendOrder").click(function() {

		//取值
		var ord_rec_name = $("#ord_rec_name").val();
		var ord_pick_code = $("#ord_pick_code").val();
		var ord_phone = $("#ord_phone").val();
		var com_id = $("#com_id").val();
		var add_id = $("#add_id").val();
		var ord_wight = $("#ord_wight").val();
		var rec_id = $("#rec_id").val();
		var ord_remark = $("#ord_remark").val();
		var orders = {
			"ord_rec_name": ord_rec_name,
			"ord_pick_code": ord_pick_code,
			"ord_phone": ord_phone,
			"com_id": com_id,
			"add_id": add_id,
			"ord_wight": ord_wight,
			"rec_id": rec_id,
			"ord_remark": ord_remark
		}

		$.ajax({
			type: "POST",
			url: "http://localhost:8888/QuickRun/insert.action",
			data: orders,
			dataType: "json",
			success: function(data) {
				console.log("添加发单信息成功");
			}
		});
	});