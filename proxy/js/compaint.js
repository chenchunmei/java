$(function(){
	window.$$=window.Zepto = Zepto;
	var code = location.search ;
	var ord_code=code.substr(code.indexOf("=")+1);
	$("#ord_submit").click(function(){
		var ord_complaint = $("#ord_complaint").val();
		var detial = {
			"ord_complaint": ord_complaint,
			"ord_code":ord_code
		}
		$.ajax({
			type: "post",
			url: "http://localhost:8888/QuickRun/insertComplaint.action",
			data: detial,
			success: function(result) {
				if(result == 1){
					$$.toast("投诉成功");
				}
			}
		});
	});
});
