function change() {
	
	var emp_sno = $("#emp_sno").val();
	if(emp_sno == "") {
		alert("学号不能为空！");
		return;
	};
	var emp_pwd = $("#emp_pwd").val();
	if(emp_pwd == "") {
		alert("密码不能为空！");
		return;
	};
	var repeatpwd = $("#repeatpwd").val();
	if(repeatpwd == "") {
		alert("请确认密码！");
		return;
	}
	
	if(emp_sno.length!=11) {
		$('.emp_sno').val("");
		$('.emp_sno').focus();
		document.querySelector('.emp_sno').placeholder = '请填写11位的学号';
		return
	}
	/*if(!code) {
		$('.yanzheng').focus();
		document.querySelector('.yanzheng').placeholder = '请填写验证码';
		return
	}*/
	if(!emp_pwd) {
		$('.emp_pwd').focus();
		document.querySelector('.emp_pwd').placeholder = '请填写密码';
		return
	}
	if(!repeatpwd) {
		$('.repeatpwd').focus();
		document.querySelector('.repeatpwd').placeholder = '请填写重复密码';
		return
	}
	if(repeatpwd !== emp_pwd) {
		$('.repeatpwd').focus();
		document.querySelector('.repeatpwd').value = '';
		document.querySelector('.repeatpwd').placeholder = '两次密码不一致';
		return
	}

	$.ajax({
		type: "POST",
		url: "http://127.0.0.1:8888/QuickRun/returnEmpPwd.action",
		data: {
			"emp_sno": emp_sno,
			"repeatpwd": repeatpwd
		},
		/*用于跨域处理*/
		xhrFields:{
	        withCredentials:true
	    },
	    crossDomain: true,
		dataType: "JSON",
		success: function(result) {
			
			if(result == 1) {
				//跳转到成功页面
				location.href = "../../userV/login/msgLogin.html";
			}
		}
	});
}