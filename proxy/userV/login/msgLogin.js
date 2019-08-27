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

function ps() {
	if(this.forms.password.type = "password")
		box.innerHTML = "<input type=\"html\" name=\"password\" size=\"20\" value=" + this.forms.password.value + ">";
	click.innerHTML = "<a href=\"javascript:txt()\" class=\"iconfont icon-open-eye\"></a>"
}

function txt() {
	if(this.forms.password.type = "text")
		box.innerHTML = "<input type=\"password\" name=\"password\" size=\"20\" value=" + this.forms.password.value + ">";
	click.innerHTML = "<a href=\"javascript:ps()\" class=\"iconfont icon-biyan\"></a>"
}
