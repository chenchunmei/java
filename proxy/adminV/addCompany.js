layui.use(['form', 'layer', 'jquery', 'laypage'], function() {
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		var laydate = layui.laydate;
		

	$("button[lay-filter='addCompany']").click(function() {
		var com_name = $(".com_name").val();
		var com_content = $(".com_content").val();
		var com_state = $(".com_state").val();
		
		var company = {
			"com_name": com_name,
			"com_content": com_content,
			"com_state": com_state
		}
		$.post("http://localhost:8888/QuickRun/insertCompany.action", company,
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
});