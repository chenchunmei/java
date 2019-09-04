
function ps() {
	if(this.loginFrom.pwd.type = "password")
		box.innerHTML = "<input type=\"html\" name=\"pwd\" size=\"20\" value=" + this.loginFrom.pwd.value + ">";
	click.innerHTML = "<a href=\"javascript:txt()\" class=\"iconfont icon-open-eye\"></a>"
}

function txt() {
	if(this.loginFrom.pwd.type = "text")
		box.innerHTML = "<input type=\"password\" name=\"pwd\" size=\"20\" value=" + this.loginFrom.pwd.value + ">";
	click.innerHTML = "<a href=\"javascript:ps()\" class=\"iconfont icon-biyan\"></a>"
}

function login() {
	
	var current_id=localStorage.getItem("current_id");
	//alert(current_id);
	console.log(current_id);
	
	var phone = $("#phone").val();
	if(phone == "") {
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
		url: "http://127.0.0.1:8888/QuickRun/login.action",
		data: {
			phone: phone,
			pwd: pwd
		},
		/*用于跨域处理*/
		xhrFields:{
	        withCredentials:true
	    },
	    crossDomain: true,
		dataType: "JSON",
		success: function(result) {
			
			if(result == "1") {
				//跳转到成功页面
				location.href = "../addOrders.html";
			} else {
				alert("用户名或者密码不正确!");
			}
		}
	});
}