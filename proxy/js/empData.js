$(function(){
	
	window.$$=window.Zepto = Zepto;
	
	var app=new Vue({
		el:"#app",
		data:{
			emp:{},
			address:{}
		},
		methods: {
			cancel: function(pccode) {
				cancel();
			},
		},
		created:function(){
			loadList();
		}
	})
	
	function loadList(){
		var emp_id=localStorage.getItem("emp_id");
		$.post(server_url+"showEmp.action",{"emp_id":emp_id},function(result){
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
			app.emp = result;
		})
		
	}
	
	$("#back").click(function(){
		window.location.href="empset.html";
	})
	
	$("#update").click(function(){
		var emp_id=localStorage.getItem("emp_id");
		var emp_dormitory = $("#emp_dormitory").val();
		var emp_phone = $("#emp_phone").val();
		var u_birthday = $("#u_birthday").val();
		var reg=/^[1][3,4,5,7,8][0-9]{9}$/;
		var flag=reg.test(emp_phone);
		if(flag){
			var emp={
				"emp_id":emp_id,
				"emp_dormitory":emp_dormitory,
				"emp_phone": emp_phone
			}
			$.ajax({
				type:"post",
				url:server_url+"updateEmp.action",
				data:emp,
				success:function(data){
					$$.toast("修改成功");
					window.location.href="empset.html";
				}
			});
		}else{
			$$.toast("手机号码格式有误");
		}
	});
	
	function cancel() {
		window.location.href="empset.html";
	}
		
});
