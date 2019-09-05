layui.use(['form', 'layer', 'jquery', 'laypage'], function() {
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		var laydate = layui.laydate;
		

	$("button[lay-filter='addEmp']").click(function() {
		var emp_name = $(".emp_name").val();
		var emp_major = $(".emp_major").val();
		var emp_dormitory = $(".emp_dormitory").val();
		var emp_sno = $(".emp_sno").val();
		var emp_credit = $(".emp_credit").val();
		var emp_phone = $(".emp_phone").val();
		var emp_state = $(".emp_state").val();
		var emp = {
			"emp_name": emp_name,
			"emp_major": emp_major,
			"emp_dormitory": emp_dormitory,
			"emp_sno": emp_sno,
			"emp_credit": emp_credit,
			"emp_phone": emp_phone,
			"emp_state": emp_state
		}
		$.post("http://localhost:8888/QuickRun/insertEmpManager.action",emp,
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