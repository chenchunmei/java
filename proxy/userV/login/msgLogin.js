function loginEmp() {
	var emp_sno = $("#emp_sno").val();
	if(emp_sno == "") {
		alert("手机号不能为空！");
		return;
	};
	var pwd = $("#pwd").val();
	if(pwd == "") {
		alert("密码不能为空！");
		return;
	}

	$.ajax({
		type: "POST",
		url: "http://127.0.0.1:8888/QuickRun/loginEmp.action",
		data: {
			emp_sno: emp_sno,
			pwd: pwd
		},
		/*用于跨域处理*/
		xhrFields: {
			withCredentials: true
		},
		crossDomain: true,
		dataType: "JSON",
		success: function(result) {
			if(result != null) {
				//跳转到成功页面
				location.href = "../orderEmp.html";
			} else {
				alert("用户名或者密码不正确!");
			}
		}
	});
}