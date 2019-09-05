$(function() {
	var code = location.search;
	var flag = code.substr(code.indexOf("=") + 1);
	window.$$ = window.Zepto = Zepto
	$("#res-btn").click(function() {
		//取得用户的id和密码
		var u_id = current_id;
		var oldpassword = $("#oldpassword").val();
		var newpassword = $("#newpassword").val();
		//json数据传输
		var user = {
			"u_id": u_id,
			"u_pwd": newpassword,
			"u_oldPwd": oldpassword
		}

		var emp = {
			"emp_pwd": newpassword,
			"emp_oldPwd": oldpassword
		}
		if(flag==1) {
			$.ajax({
				type: "post",
				url: "http://127.0.0.1:8888/QuickRun/UserUpdatePwd.action",
				data: user,
				success: function(result) {
					if(result == 1) {
						$$.toast("修改密码成功");
						window.location.href = "login.html";
					} else {
						$$.toast("原密码不正确");
					}
				}
			});

		} else {
			$.ajax({
				type: "post",
				url: "http://127.0.0.1:8888/QuickRun/EmpUpdatePwd.action",
				data: emp,
				success: function(result) {
					if(result == 1) {
						$$.toast('操作成功，正在跳转...');
						window.location.href = "login.html";
					} else {
						$$.toast("原密码不正确");
					}
				}
			});
		}

	});
});