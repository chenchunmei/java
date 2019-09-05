$(function(){
	window.$$=window.Zepto = Zepto
	$("#res-btn").click(function(){
		//取得用户的id和密码
		var u_id=current_id;
		var phone=$("#phone").val();
		var mima=$("#mima").val();
		var repeatmima=$("#repeatmima").val();
		//json数据传输
		var user={
			"u_id":u_id,
			"phone":phone,
			"repeatmima":repeatmima
		}
		$.ajax({
			type: "post",
			url: "http://127.0.0.1:8888/QuickRun/returnPwd.action",
			data: user,
			success: function(result) {
				if(result==1){
					$$.toast("修改密码成功");
					window.location.href="login.html";
				}else{
					$$.toast("原密码不正确");
				}
			}
		})
	});
});
