//=============================ajax通用请求工具包
var url = "http://localhost:8080/share/";
var ajax;

//不带JWT
function sendRequestNoJWT(method, urlAddress, jsonData, func) {

	//发送ajax请求
	ajax = $.ajax({
		type: method, //提交类型
		url: url + "/" + urlAddress,
		dataType: "json", //数据类型 返回来的数据类型
		data: jsonData,
		timeout: 5000, //超时时间 2秒,
		success: function(result) {
			layer.closeAll('loading');
			top.layer.closeAll('loading');
			func(result);
		},
		complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数
			layer.closeAll('loading');
			top.layer.closeAll('loading');
			if(status == 'timeout') { //超时,status还有success,error等值的情况
				ajax.abort();
				layer.alert('网络超时', {
					icon: 1
				});　　　
			}
			if(status == 'error') {
				layer.alert('服务器异常', {
					icon: 1
				});　
			} else {

			}
		}
	});
}

function sendRequest(method, urlAddress, jsonData, func) {

	//如果发现没有数据 则创建一个json对象
	if(jsonData == null) {
		jsonData = {
			"accountjwt": localStorage.getItem("accountjwt")
		};
	} else {
		jsonData.jwt = localStorage.getItem("accountjwt");
	}
	//创建对象为了给服务端返回一个jwt
	//jsonData.token = sessionStorage.getItem("token");
	//alert(url +"/"+urlAddress);
	//发送ajax请求
	ajax = $.ajax({
		type: method, //提交类型
		url: url + "/" + urlAddress,
		dataType: "json", //数据类型 返回来的数据类型
		data: jsonData,
		timeout: 5000, //超时时间 2秒,
		success: function(result) {
			layer.closeAll('loading');
			top.layer.closeAll('loading');
			if(result != null && result.code == 2) {
				layer.alert('请登录后再操作', {
					icon: 1,
					yes:function(){
						parent.window.location.href = "../background/login.html";
					},
					cancel:function(){
						parent.window.location.href = "../background/login.html";
					}
				});
			} else {
				func(result);
			}

		},
		complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数
			layer.closeAll('loading');
			top.layer.closeAll('loading');
			if(status == 'timeout') { //超时,status还有success,error等值的情况
				ajax.abort();
				layer.alert('网络超时', {
					icon: 1
				});　　　
			}
			if(status == 'error') {
				layer.alert('服务器异常', {
					icon: 1
				});　
			} else {

			}　
		}
	});
}

function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return unescape(r[2]);
	return null;
}