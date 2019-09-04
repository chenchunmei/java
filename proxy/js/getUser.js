var current_id;
var username;
var u_phone;
$.ajax({
		type: "POST",
		url: "http://127.0.0.1:8888/QuickRun/getUser.action",
		xhrFields:{
	        withCredentials:true
	    },
		dataType: "JSON",
		success: function(result) {
			
			username = result.u_nickname;
		  		current_id = result.u_id;
		  		u_phone = result.u_phone;
		  		
		}
	});