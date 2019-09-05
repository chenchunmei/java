function change() {
	
	var phone = $("#phone").val();
	if(phone == "") {
		alert("手机号不能为空！");
		return;
	};
	var repeatpwd = $("#repeatpwd").val();
	if(repeatpwd == "") {
		alert("密码不能为空！");
		return;
	};
	var pwd = $("#pwd").val();
	if(pwd == "") {
		alert("请确认密码！");
		return;
	}
	
	if(phone.length!=11) {
		$('.phone').val("");
		$('.phone').focus();
		document.querySelector('.phone').placeholder = '请填写11位的手机号码';
		return
	}
	/*if(!code) {
		$('.yanzheng').focus();
		document.querySelector('.yanzheng').placeholder = '请填写验证码';
		return
	}*/
	if(!pwd) {
		$('.pwd').focus();
		document.querySelector('.pwd').placeholder = '请填写密码';
		return
	}
	if(!repeatpwd) {
		$('.repeatpwd').focus();
		document.querySelector('.repeatpwd').placeholder = '请填写重复密码';
		return
	}
	if(repeatpwd !== pwd) {
		$('.repeatpwd').focus();
		document.querySelector('.repeatpwd').value = '';
		document.querySelector('.repeatpwd').placeholder = '两次密码不一致';
		return
	}

	$.ajax({
		type: "POST",
		url: "http://127.0.0.1:8888/QuickRun/returnPwd.action",
		data: {
			"phone": phone,
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
				location.href = "../../userV/login/login.html";
			}
		}
	});
}