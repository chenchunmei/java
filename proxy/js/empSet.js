$(function(){
	
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
	
	function loadList(){
		var emp_id=localStorage.getItem("emp_id");
		$.post("http://127.0.0.1:8888/QuickRun/showEmp.action",{"emp_id":emp_id},function(result){
			app.list = result;
		});
	}
	
	$("#btn").click(function(){
		if($("#menu").css("display")=="block"){
			$("#menu").css("display","none");
		}else{
			$("#menu").css("display","block");
		}
	})
	
	$(document).on('click','.confirm-ok', function () {
	      $.confirm('Are you sure?', function () {
	          $.alert('You clicked Ok button');
	      });
	 });
	 
	 
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