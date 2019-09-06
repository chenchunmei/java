layui.use(['form','laydate','layer','jquery'],function(){
	var form = layui.form;
	form.render();
	
	var laydate=layui.laydate;
		laydate.render({
			elem: "#date",
			trigger: "click"
		});
		
		
		var add_id = getQueryString("add_id");
		//文件类型列表
		$(function(){
			$.post("http://localhost:8888/QuickRun/SelectEmpname.action",
			function(result)  {
				console.log(result);
				//找到分类下拉框
				var fileType = $("select[name='emp_name']");
				for(var i = 0; i < result.length; i++) {
					var type = result[i];
					//组装选项
					var opt = "<option value='" + type.emp_id + "'>" + type.emp_name + "</option>";
					//添加到选项中
					fileType.append(opt);
				}
				
				//表单重新渲染
				form.render('select');
		});
		$("button[lay-filter='UpdateEmpAdd']").click(function() {
		var emp_id = $("#emp").val();
		$.post("http://localhost:8888/QuickRun/AddManagerEmpid.action",{"add_id":getQueryString("add_id"),"emp_id":emp_id},
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
	