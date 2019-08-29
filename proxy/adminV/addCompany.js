layui.use(['form', 'laydate', 'layer', 'jquery'], function() {
var form = layui.form;
form.render();

var laydate = layui.laydate;
laydate.render({
	elem: "#date",
	trigger: "click"
});

$("button[lay-filter='addCompany']").click(function() {
	var com_id = $(".com_id").val();
	var com_name = $(".com_name").val();
	var com_content = $("com_content").val();
	var add_state = $(".add_state").val();
	var company = {
		"com_id": com_id,
		"com_name": com_name,
		"com_content": com_content,
		"add_state": add_state
	}

	$.post("http://localhost:8888/QuickRun/insertCompany.action", {
			"data": company
		},

		function(data) {
			lay.msg("添加公司信息成功");
		});
	});
})