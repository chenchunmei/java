$(function(){
	//提示框的转换
	window.$$=window.Zepto = Zepto;
	
	var app=new Vue({
		el:"#app",
		data:{
			list:{},
		},
		methods:{
			
		},
		created:function(){
			loadList();
		}
	})
	
	//加载用户信息
	function loadList(){
		$.post(server_url+"showUser.action",function(result){
			app.list = result.user;
			var srcpath=result.ima_address;
			var path=server_url+srcpath.substr(srcpath.indexOf("upload"))
			$("#img").attr("src",path)
		});
	}
	
	//显示账号管理的下拉
	$("#btn").click(function(){
		if($("#menu").css("display")=="block"){
			$("#menu").css("display","none");
		}else{
			$("#menu").css("display","block");
		}
	});
	
	//退出
	$(document).on('click','.create-actions', function () {
      var buttons1 = [
        {
          text: '退出登录',
          label: true
        },
        {
          text: '退出',
          bold: true,
          color: 'danger',
          onClick: function() {
		      $$.confirm('你确定退出吗?', function () {
		         window.location.href = "userV/login/login.html";
		      });
          }
        }
      ];
      var buttons2 = [
        {
          text: '取消',
          bg: 'danger'
        }
      ];
      var groups = [buttons1, buttons2];
      $$.actions(groups);
  });
	 
});