$(function() {
	var code = location.search;
	var flag = code.substr(code.indexOf("=") + 1);
	window.$$ = window.Zepto = Zepto
	
	$("#back").click(function(){
		if(flag==1){
			window.location.href = "../../userset.html";
		}else {
			window.location.href = "../../emprset.html";
		}
		
	});
	
	$("#res-btn").click(function() {
		//取得用户的id和密码
		var u_id = current_id;
		var oldpassword = $("#oldpassword").val();
		var newpassword = $("#newpassword").val();
		var emp_id=localStorage.getItem("emp_id");
		
		//json数据传输
		var user = {
			"u_id": u_id,
			"u_pwd": newpassword,
			"u_oldPwd": oldpassword
		}

		var emp = {
			"emp_id":emp_id,
			"emp_pwd": newpassword,
			"emp_oldPwd": oldpassword
		}
		if(flag==1) {
			if(oldpassword.length>=6 && oldpassword.length<=12 && newpassword.length>=6 && newpassword.length<=12){
				
				$.ajax({
					type: "post",
					url: "http://127.0.0.1:8888/QuickRun/UserUpdatePwd.action",
					data: user,
					success: function(result) {
						if(result == 1) {
							$$.alert('修改成功！请重新登录', function () {
					         window.location.href = "login.html";
					      });
						} else {
							$$.toast("原密码不正确");
						}
					}
				});
			}else{
				$$.toast("密码格式有误");
			}

		} else {
			if(oldpassword.length>=6 && oldpassword.length<=12 && newpassword.length>=6 && newpassword.length<=12){
				$.ajax({
					type: "post",
					url: "http://127.0.0.1:8888/QuickRun/EmpUpdatePwd.action",
					data: emp,
					success: function(result) {
						if(result == 1) {
							//$$.toast('操作成功，正在跳转...');
							$$.alert('修改成功！请重新登录', function () {
					         window.location.href = "login.html";
					      });
						} else {
							$$.toast("原密码不正确");
						}
					}
				});
				
			}else{
				$$.toast("密码格式有误");
			}
		}

	});
});