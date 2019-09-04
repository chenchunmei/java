$(function(){
	window.$$=window.Zepto = Zepto
	$("#res-btn").click(function(){
		//window.$$ = window.Zepto = Zepto;
		var u_id=current_id;
		var oldpassword=$("#oldpassword").val();
		var newpassword=$("#newpassword").val();
		var user={
			"u_id":u_id,
			"u_pwd":newpassword,
			"u_oldPwd":oldpassword
		}
		$.ajax({
			type: "post",
			url: "http://127.0.0.1:8888/QuickRun/updatePwd.action",
			data: user,
			success: function(result) {
				if(result==1){
					$$.toast("修改密码成功");
					//window.location.href="userV/login/login.html";
				}else{
					$$.toast("原密码不正确");
				}
			}
		})
	});
});
