function exitLogin() {
	localStorage.removeItem("accountjwt");
	parent.location.href = "login/login.html"
}

var accountjwt = localStorage.getItem("accountjwt");

$(function() {
		var accountjwt = localStorage.getItem("accountjwt");
		if(accountjwt == null) {
			//跳转
			window.location.href = "login/login.html";
		}
	});