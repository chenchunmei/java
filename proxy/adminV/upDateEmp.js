layui.use(['form','laydate','layer','jquery'],function(){
	var form = layui.form;
	form.render();
	
	var emp_id = getQueryString("emp_id");
	
	var laydate=layui.laydate;
		laydate.render({
			elem: "#date",
			trigger: "click"
		});
		
	$(function(){
			$.post("http://localhost:8888/QuickRun/selectEmpManagerByid.action",{"emp_id":getQueryString("emp_id")},
			function(result){
			console.log(result);
			//请求正常
			var emp = result;
			$(".emp_name").val(emp.emp_name);
			$(".emp_major").val(emp.emp_major);
			$(".emp_dormitory").val(emp.emp_dormitory);
			$(".emp_sno").val(emp.emp_sno);
			$(".emp_credit").val(emp.emp_credit);
			$(".emp_phone").val(emp.emp_phone);
			$(".emp_state option[value="+emp.emp_state+"]").prop("selected","selected");
				
		//表单重新渲染
		form.render();
	});
	
		
	$("button[lay-filter='updateEmp']").click(function() {
		var emp_name = $(".emp_name").val();
		var emp_major = $(".emp_major").val();
		var emp_dormitory = $(".emp_dormitory").val();
		var emp_sno = $(".emp_sno").val();
		var emp_credit = $(".emp_credit").val();
		var emp_phone = $(".emp_phone").val();
		var emp_state = $(".emp_state").val();
		var emp = {
			"emp_id":emp_id,
			"emp_name": emp_name,
			"emp_major": emp_major,
			"emp_dormitory": emp_dormitory,
			"emp_sno": emp_sno,
			"emp_credit": emp_credit,
			"emp_phone": emp_phone,
			"emp_state": emp_state
		}
		$.post("http://localhost:8888/QuickRun/updateEmpManager.action",emp,
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



		