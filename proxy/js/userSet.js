$(function(){
	
	var app=new Vue({
		el:"#app",
		data:{
			list:{},
		},
		methods:{
			
		},
		created:function(){
			loadList();
		}
	})
	
	function loadList(){
		$.post("http://127.0.0.1:8888/QuickRun/showUser.action",function(result){
			app.list = result;
		});
	}
		
	$("#btn").click(function(){
		if($("#menu").css("display")=="block"){
			$("#menu").css("display","none");
		}else{
			$("#menu").css("display","block");
		}
	});
	
	$(document).on('click','.confirm-ok', function () {
	      $.confirm('Are you sure?', function () {
	          $.alert('You clicked Ok button');
	      });
	 });
});