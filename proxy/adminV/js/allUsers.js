
layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	
	//监听指定开关
	var ustate=0;
   	form.on('switch(switchTest)', function(data){
   		
  	//开关是否开启，true或者false
  	
    console.log(data.elem.checked)
        if(data.elem.checked){
           	ustate=0;
           	loadList();
        }else{
           	ustate=-1;
           	loadList();
        }
	});
	//创建VUEAPP 
	var app=new Vue({
		el:"#app",//app作用域
		data:{
			list:{}//定义一个数据
		},
		methods:{//定义VUE中函数
			lockUser:function(uname,uid,state){
				//调用自已的
				lockUser(uname,uid,state);
			},
			deleteUser:function(uname,uid){
				//调用自已的
				deleteUser(uname,uid);
			},
			editUser:function(uid){
				editUser(uid);
			}
		},
		created:function(){
			//调用加载数据
			loadList();
		}
	})
	

	
	//锁定与解锁
	function lockUser(uname,uid,state){
		//为0 则进行注销
		if(state==0){
			layer.confirm('确定注销['+uname+']用户？',{
				icon:3, 
				title:'提示信息'
				},function(index){
				sendRequest("post","upload/UserServlet",{
					"m":"lock",
					"uid":uid
				},function(result){
				if(result.code==0){
					layer.msg("注销成功");
					//重新加载
					loadList();
				}else{
					layer.msg("注销失败");
				}
				layer.close(index);
			})
		});
		}else{//其它为1则进行复原
			layer.confirm('确定复原['+uname+']用户？',{
				icon:3, title:'提示信息'
				},function(index){
				sendRequest("post","upload/UserServlet",{
					"m":"unlock",
					"uid":uid}
				,function(result){
					if(result.code==0){
						layer.msg("复原成功");
						//重新加载
						loadList();
					}else{
						layer.msg("复原失败");
					}
					layer.close(index);
				})
			});
		}
		
	}
	
	
	//删除用户
	function deleteUser(uname,uid){
		layer.confirm('确定删除['+uname+']用户？',{
			icon:3, 
			title:'提示信息'
			},function(index){
			sendRequest("POST","upload/UserServlet",{
				"m":"delete",
				"uid":uid
			},function(result){
					if(result.code==0){
						layer.msg("删除成功");
						//重新加载
						loadList();
					}else{
						layer.msg("删除失败");
					}
					layer.close(index);
			});
		});
	
	}
	//重置
	$(".reset_btn").click(function(){
		$(".search_name").val("");
		$(".search_phone").val("");
		form.render();
		loadList();
	});
	//添加用户
	$(".usersAdd_btn").click(function(){
		
		var index = layui.layer.open({
			title: "添加用户",
			area: ['500px', '480px'],
			type: 2,
			content: "user-add.html"
		})
	})
	//编辑用户
	function editUser(uid){
		var index = layui.layer.open({
			title: "编辑用户",
			area: ['500px', '480px'],
			type: 2,
			content: "uesr-edit.html?uid="+uid
		})
	}
	 //监听指定开关
	
	
	//查询
	$(".search_btn").click(function(){
		loadList();
	});
	
	$(".search_name").keypress(function(){
		loadList();
	});
	//存储当前页的信息
	$(".search_state_btn").click(function(){
		
	});
	var curr;
	function loadList(){
		
		//如果当前分页对象无值则进行赋值
		if(curr==undefined){ 
		      curr=1;
		}
		var searchName=$(".search_name").val();
		var searchPhone=$(".search_phone").val();
//		var ustate=$(".search_state-btn").val();
		
		var index = layer.load(4);
		//加载页面数据
		sendRequest("POST","upload/UserServlet",
		{"m":"list","page":curr,"searchName":searchName,"searchPhone":searchPhone,"ustate":ustate}, function(result){
			//执行加载数据的方法
			app.list=result.data.data;
			var pageUtils=result.data;
			
			
			//分页代码
			laypage.render({
				elem: "laypage", //当前要显示的dom对象[laypage]
				count: pageUtils.rowCount, //总共多少页
				limit: pageUtils.pageSize, //显示页码的的显示总分
				curr: curr, //当前页是第几页 便于分页插件显示
				next: "下一页", //显示的文字
				prev: "上一页", //显示的文字
				skip: true, //是否显示跳转的UI
				jump: function(obj, first) { //跳转时调用的函数
					if(!first) { //first一个Boolean类，检测页面是否初始加载。非常有用，可避免无限刷新。
						//将当前页赋给全局变量存储 便于下一次跳转
						curr = obj.curr;
						loadList();
					}
				}
			});
			layer.close(index);
		})
	}
	
	form.render();
})