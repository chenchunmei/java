$(function(){
	
	var app = new Vue({
		el: "#userorder_app",
		data: {
			list: {}
		},
		methods: {
			
		},
		created: function() {
				loadList();
				
		}
	})

	//加载快递信息数据
	function loadList() {
		$.post("http://127.0.0.1:8888/QuickRun/selectorderbyuid.action",function(result){
			app.list = result;
			console.log(result);
		})
	}
	
	
});



