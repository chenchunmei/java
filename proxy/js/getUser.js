$.ajax({
		type: "POST",
		url: "http://127.0.0.1:8888/QuickRun/getUser.action",
		xhrFields:{
	        withCredentials:true
	    },
		dataType: "JSON",
		success: function(result) {
			
			var username = result.u_nickname;
		  		var userid = result.u_id;
		  		var u_phone = result.u_phone;
		  		
		  		alert(u_phone);
		}
	});