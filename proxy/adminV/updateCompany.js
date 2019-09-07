layui.use(['form','laydate','layer','jquery'],function(){
	var form = layui.form;
	form.render();
	
	var com_id = getQueryString("com_id");
	
	var laydate=layui.laydate;
		laydate.render({
			elem: "#date",
			trigger: "click"
		});
		
	$(function(){
			$.post("http://localhost:8888/QuickRun/selectCompanyByid.action",{"com_id":getQueryString("com_id")},
			function(result){
			console.log(result);
			//请求正常
			var company = result;
			$(".com_name").val(company.com_name);
			$(".com_content").val(company.com_content);
			$(".com_state option[value="+company.com_state+"]").prop("selected","selected");
				
		//表单重新渲染
		form.render();
	});
	
		
	$("button[lay-filter='updateCompany']").click(function() {
		
		var com_name = $(".com_name").val();
		var com_content = $(".com_content").val();
		var com_state = $(".com_state").val();
		
		var company = {
			"com_id":com_id,
			"com_name": com_name,
			"com_content": com_content,
			"com_state": com_state
		}
		console.log(company)
		$.post("http://localhost:8888/QuickRun/updateCompany.action", company,
			function(result) {	
//					layer.closeAll("iframe");
					setTimeout(function(){//设置定时器
						parent.location.reload(true);//刷新父级页面
						var index = parent.layer.getFrameIndex(window.name);获取当前弹窗的Id
						parent.layer.close(index);关闭
					},500);
					layer.msg("添加成功");
			});
	});
		
			
	})
	
});



		