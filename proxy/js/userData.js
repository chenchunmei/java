$(function(){
	//这个可以找到
	window.$$=window.Zepto = Zepto;
	var app=new Vue({
		el:"#app",
		data:{
			user:{},
		},
		methods:{
			cancel:function(pccode){
				cancel();
			},
		},
		created:function(){
			loadList();
		}
	})
	
	function loadList(){
		$.post("http://127.0.0.1:8888/QuickRun/showUser.action",function(result){
			var da = result.u_birthday;
		    da = new Date(da);
		    var year = da.getFullYear();
		    var month = da.getMonth()+1;
			var date = da.getDate();
			if(month < 10){
				var time = year+"-0"+month+"-"+date;
			}else{
				var time = year+"-"+month+"-"+date;
			}
			result.u_birthday = time;
			$("#u_birthday").val(time);
			app.user = result;
			console.log(result)
		})
	}
	
	$("#back").click(function(){
		window.history.back(-1);
	})
	
	$("#update").click(function(){
		var u_phone = $("#u_phone").val();
		var u_nickname = $("#u_nickname").val();
		var u_birthday = $("#u_birthday").val();
		var u_sex = $("#u_sex").val();
		var user={
				"u_phone":u_phone,
				"u_nickname": u_nickname,
				"u_birthday": u_birthday,
				"u_sex":u_sex
		}
		$.ajax({
			type:"post",
			url:"http://127.0.0.1:8888/QuickRun/updateUser.action",
			data:user,
			success:function(data){
				$$.toast("修改成功");
				loadList();
			}
		});
		
	});
	
	function cancel(){
		window.history.back(-1);
	}
		
});
