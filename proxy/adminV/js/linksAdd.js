layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
		var form = layui.from,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;
		
		//$.post("http://lolocalhost:8080/share/upload/MajorServlet",{"m":"find"})
		
		//创建一个编辑器
 		$("button[lay-filter='addLinks']").click(function(){
			var mname=$(".mname").val();
			//var tid=$(".tid").val()
			var vid=$(".tname").val();
			var jsonObject={
				"mname":mname,
				"id":vid,
				"m":"save"
			}
			
			sendRequest("POST","upload/MajorServlet",jsonObject,function(result){
				if(result.code == 0){
					alert("添加成功")
					//刷新父页面
					parent.location.reload();
					var index = parent.layer.getFrameIndex(window.name); 
					parent.layer.close(index);
				}else{
					alert("添加失败")
				}
				
			})
			//var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
//			sendRequest("POST","major/MajorServlet",jsonObject,function(result){
//				alert(result.code);
//			top.layer.close(index);
//				if(result.code==0){
//					layer.msg("添加成功");
//					 var index = parent.layer.getFrameIndex(window.name);  
//					 parent.layer.close(index); //再执行关闭 
//				}else{
//					layer.msg("添加失败:"+result.msg);
//			}
//			});
		});
		
	
})
