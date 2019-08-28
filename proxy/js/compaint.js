$(function(){
	window.$$=window.Zepto = Zepto;
	$("#ord_submit").click(function(){
		var ord_complaint = $("#ord_complaint").val();
		var detial = {
			"ord_complaint": ord_complaint
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
