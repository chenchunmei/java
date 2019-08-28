layui.use(['form', 'layer', 'jquery', 'laypage'], function() {
			var form = layui.form,
				layer = parent.layer === undefined ? layui.layer : parent.layer,
				laypage = layui.laypage,
				$ = layui.jquery;

			var app = new Vue({
				el: "#app", //app作用域
				data: {
					list: {} //定义一个数据
				},
				methods: { //定义VUE中函数
					lockProxyBack: function(pcid, pstate) {
						//调用自已的
						lockProxyBack(pcid, pstate);
					},
					deleteProxyBack: function(pcid) {
						//调用自已的
						deleteProxyBack(pcid);
					},
					showProxyPcontent: function(pcid) {
						showProxyPcontent(pcid);
					},

				},
				created: function() {
					//调用加载数据
					loadList();
				}
			})

			var curr;

			function loadList() {
				//localStorage.removeItem("accountjwt");
				//如果当前分页对象无值则进行赋值
				if(curr == undefined) {
					curr = 1;
				}

				var searchContent = $(".search_Content").val();
				var searchCode = $(".search_Code").val();

				var index = layer.load(4);
				//加载页面数据
				sendRequest("POST", "back/ProxyBackServlet", {
					"m": "List",
					"page": curr,
					"searchContent": searchContent,
					"searchCode": searchCode
				}, function(result) {
					//执行加载数据的方法
					app.list = result.data.data;
					var pageUtils = result.data;

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
			//查询
			$(".search_btn").click(function() {
				loadList();
			});

			function lockProxyBack(pcid, pstate) {

				//为0 则进行注销
				if(pstate == 0) {
					layer.confirm('确定下架编号为[' + pcid + ']单号？', {
						icon: 3,
						title: '提示信息'
					}, function(index) {
						sendRequest("POST", "back/ProxyBackServlet", {
							"m": "lock",
							"pcid": pcid
						}, function(result) {
							if(result.code == 0) {
								layer.msg("下架成功");
								//重新加载
								loadList();
							} else {
								layer.msg("下架失败");
							}
							layer.close(index);
						})
					});
				} else if(pstate == 4) { //其它为1则进行复原
					layer.confirm('确定派发编号为[' + pcid + ']单号？', {
						icon: 3,
						title: '提示信息'
					}, function(index) {
						sendRequest("POST", "back/ProxyBackServlet", {
							"m": "unlock",
							"pcid": pcid
						}, function(result) {
							if(result.code == 0) {
								layer.msg("派发成功");
								//重新加载
								loadList();
							} else {
								layer.msg("派发失败");
							}
							layer.close(index);
						})
					});
				}

			}

			//删除用户 
			function deleteProxyBack(pcid) {
				layer.confirm('确定删除[' + pcid + ']订单？', {
					icon: 3,
					title: '提示信息'
				}, function(index) {
					sendRequest("POST", "back/ProxyBackServlet", {
						"m": "delete",
						"pcid": pcid
					}, function(result) {
						if(result.code == 0) {
							layer.msg("删除成功");
							//重新加载
							loadList();
						} else {
							layer.msg("删除成功");
							loadList();
						}
						layer.close(index);
					});
				});

			}

			function showProxyPcontent(pcid) {
				sendRequest("POST", "back/ProxyBackServlet", {
						"m": "find",
						"pcid": pcid
					}, function(result) {
						var fdesc = result.data.pcontent;
						//$("#lbl2").html(fdesc);
						var index = layer.open({
						type: 1
						,offset:'auto' 
						,id: 'layerDemo' + 'auto' //防止重复弹出
						,area: ['500px', '400px']
						,content: '<div style="padding: 20px 100px;">' + fdesc + '</div>'
						,btn: '关闭'
						,btnAlign: 'c' //按钮居中
						,shade: 0 //不显示遮罩,
						,yes: function() {
							layer.closeAll();
						}
				   });
				});
			}

				$(".search_Content").keypress(function() {
					loadList();
				});
				$(".search_Code").keypress(function() {
					loadList();
				});

			})