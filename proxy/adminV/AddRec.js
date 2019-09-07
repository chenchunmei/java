layui.use(['form', 'layer', 'jquery', 'laypage'], function() {
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		var laydate = layui.laydate;
		

	$("button[lay-filter='addRec']").click(function() {
		var rec_detail = $(".rec_detail").val();
		var rec_state = $(".rec_state").val();
		
		var rec = {
			"rec_detail": rec_detail,
			"rec_state": rec_state
		}
		$.post("http://localhost:8888/QuickRun/insertRec.action",rec,
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