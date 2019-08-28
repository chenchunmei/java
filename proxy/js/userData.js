layui.use(['form', 'layedit', 'upload'], function(){
		  var $ = layui.jquery
		  ,upload = layui.upload;

	//这个可以找到
	window.$$ = window.Zepto = Zepto;

	var app = new Vue({
		el: "#app",
		data: {
			user: {},
		},
		methods: {
			cancel: function(pccode) {
				cancel();
			},
		},
		created: function() {
			loadList();
		}
	})

	function loadList() {
		$.post("http://127.0.0.1:8888/QuickRun/showUser.action", function(result) {
			var da = result.user.u_birthday;  
			da = new Date(da);  
			var year = da.getFullYear();  
			var month = da.getMonth() + 1;
			var date = da.getDate();
			if(month < 10) {
				var time = year + "-0" + month + "-" + date;
			} else {
				var time = year + "-" + month + "-" + date;
			}
			result.u_birthday = time;
			$("#u_birthday").val(time);
			app.user = result.user;
			console.log(result)
		})
	}

	$("#back").click(function() {
		window.history.back(-1);
	})

	$("#update").click(function() {
		var u_phone = $("#u_phone").val();
		var u_nickname = $("#u_nickname").val();
		var u_birthday = $("#u_birthday").val();
		var u_sex = $("#u_sex").val();
		var user = {
			"u_phone": u_phone,
			"u_nickname": u_nickname,
			"u_birthday": u_birthday,
			"u_sex": u_sex
		}
		$.ajax({
			type: "post",
			url: "http://127.0.0.1:8888/QuickRun/updateUser.action",
			data: user,
			success: function(data) {
				$$.toast("修改成功");
				loadList();
			}
		});

	});

	function cancel() {
		window.history.back(-1);
	}

	  //普通图片上传
	  var uploadInst = upload.render({
	    elem: '#test1'
	    ,url: 'http://127.0.0.1:8888/QuickRun/uploadImage.action'
	    ,before: function(obj){
	      //预读本地文件示例，不支持ie8
	      obj.preview(function(index, file, result){
	        $('#demo1').attr('src', result); //图片链接（base64）
	      });
	    }
	    ,done: function(res){
	      //如果上传失败
	      if(res.code > 0){
	        return layer.msg('上传失败');
	      }
	      //上传成功
	      alert("上传成功");
	    }
	    ,error: function(){
	      //演示失败状态，并实现重传
	      var demoText = $('#demoText');
	      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
	      demoText.find('.demo-reload').on('click', function(){
	        uploadInst.upload();
	      });
	    }
	  });
});