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
	var mobile = $('.mobile').val();
	var yanzheng = $('.yanzheng').val();
	var mima = $('.mima').val();
	var repeatmima = $('.repeatmima').val();
	if(!mobile) {
		$('.mobile').focus();
		document.querySelector('.mobile').placeholder = '请填写手机号码';
		return
	}
	if(!yanzheng) {
		$('.yanzheng').focus();
		document.querySelector('.yanzheng').placeholder = '请填写验证码';
		return
	}
	if(!mima) {
		$('.mima').focus();
		document.querySelector('.mima').placeholder = '请填写密码';
		return
	}
	if(!repeatmima) {
		$('.repeatmima').focus();
		document.querySelector('.repeatmima').placeholder = '请填写重复密码';
		return
	}
	if(repeatmima !== mima) {
		$('.repeatmima').focus();
		document.querySelector('.repeatmima').value = '';
		document.querySelector('.repeatmima').placeholder = '两次密码不一致';
		return
	}

	$(this).prop('disabled', true);
	alert('注册成功');
})