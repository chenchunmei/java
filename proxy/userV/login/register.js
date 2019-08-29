var times = 10;

function roof() {
	if(times == 0) {
		$('.yanzhengma').text('发送验证码(' + times + 's)');
		$('.yanzhengma').prop('disabled', false);
		$('.yanzhengma').text('发送验证码');
		times = 10;
		return
	}
	$('.yanzhengma').text('发送验证码(' + times + 's)');
	times--;

	setTimeout(roof, 1000);
}
$('.yanzhengma').on('click', function() {

	$(this).prop('disabled', true);
	roof();

});


$('#res-btn').on('click', function() {
	var phone = $('.phone').val();
	var code = $('.yanzheng').val();
	var pwd = $('.pwd').val();
	var repeatpwd = $('.repeatpwd').val();
	if(phone.length!=11) {
		$('.phone').val("");
		$('.phone').focus();
		document.querySelector('.phone').placeholder = '请填写11位的手机号码';
		return
	}
	if(!code) {
		$('.yanzheng').focus();
		document.querySelector('.yanzheng').placeholder = '请填写验证码';
		return
	}
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

/*	$.ajax({
		type: "POST",
		url: "http://127.0.0.1:8888/QuickRun/register.action",
		data: {
			phone: phone,
			pwd: pwd
		},
		dataType: "JSONP",
		success: function(result) {
			if(result == 1) {
				//跳转到成功页面
				location.href = "userV/login/registerSuccess.html";
			} else {
				alert("注册失败！");
			}
		}
	});
*/	
	var data = {
		"phone": phone,
		"pwd": pwd
	}
	$.post("http://127.0.0.1:8888/QuickRun/register.action",data,function(result){
		if(result == 1) {
			//跳转到成功页面
			location.href = "../login/registerSuccess.html";
		} else {
			alert("注册失败！");
		}
	})
})