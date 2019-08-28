layui.use(['form','laydate','layer','jquery'],function(){
	var form = layui.form;
	form.render();
	
	var laydate=layui.laydate;
		laydate.render({
			elem: "#date",
			trigger:"click"
		});
		
		
	
		
	$("button[lay-filter='addUser']").click(function(){
		var uname=$(".userName").val();
		var sex=$("input[name='sex'][type='radio']:checked").val();
		var birthday=$(".userBirthday").val();
		var phone=$(".userPhone").val();
		var email=$(".userEmail").val();
		var schoolid=$(".userSchool").val();
		var major=$(".userMajor").val();
		var state=$(".userStatus").val();
		
		if(schoolid!=-1&&major!=-1){
			
			var jsonObject={
				"uname":uname,
				"sex":sex,
				"birthday":birthday,
				"phone":phone,
				"email":email,
				"schoolid":schoolid,
				"umajor":major,
				"ustate":state,
				"m":"add"
			}
			
			sendRequest("POST","upload/UserServlet",jsonObject,function(result){
	
				if(result.code==0){
//					layer.closeAll("iframe");
					setTimeout(function(){//设置定时器
						parent.location.reload(true);//刷新父级页面
						var index = parent.layer.getFrameIndex(window.name);获取当前弹窗的Id
						parent.layer.close(index);关闭
					},500);
					layer.msg(result.msg);
				}
			});
		}else{
			layer.alert('请选择学校或者专业', {
				icon: 5,
				title: "提示"
			});
		}
		
	});
	
	sendRequest("POST","upload/SchoolServlet",
		{"m":"schoolList"
	},function(result){
			if(result.code == 0){//请求正常
				var schoolList = result.data;
				for(var i=0;i<schoolList.length;i++){
					//取得专业的select
					var html = "<option value='"+(i+1)+"'>"+schoolList[i].sname+"</option>";
					$(".userSchool").append(html);
					}
			}else{
				layer.open({
				type: 1,
				title: false,
				closeBtn: 1,
				area: ['200px', '150px'],
				content: result.msg
				});
			}
		//表单重新渲染
		form.render();
	});

	sendRequest("POST","upload/MajorServlet",
		{"m":"majorList"
	},function(result){
			if(result.code == 0){//请求正常
				var majorList = result.data;
				for(var i=0;i<majorList.length;i++){
					//取得专业的select
					var html = "<option value='"+(i+1)+"'>"+majorList[i].mname+"</option>";
					$(".userMajor").append(html);
					}
			}else{
				layer.open({
				type: 1,
				title: false,
				closeBtn: 1,
				area: ['200px', '150px'],
				content: result.msg
				});
			}
		//表单重新渲染
		form.render();
	});
});