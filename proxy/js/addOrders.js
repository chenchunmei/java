/**
 * 用户发布下单
 */
var app = new Vue({
		el: "#app",
		data: {
			list: {},
			over: {},
			rec: {}
		},
		methods: {
			
		},
		created: function() {
				loadList();
				loadAddList();
				loadTimeList();
		}
	})

	//备注限字数
 	LimitedNnumber("#ord_remark", "#viewBox", 200)//调用函数需要传入三个参数，分别为，输入框、显示框、限制的长度
            function LimitedNnumber(eventBox, viewBox, textLength) {//调用函数需要传入三个参数，分别为，输入框、显示框、限制的长度
                $(document).on('input propertychange paste keyup', eventBox, function(event) {
                    this.value = this.value.replace(this.value.slice(textLength), "")//超出长度的部分替换为空
                    $(viewBox).html(this.value.length + "/" + textLength)
                })
            }
         
	//加载快递信息数据
	function loadList() {
		$.post(server_url+"query.action",function(result){
			app.list = result;
		})
	}
	
	//加载接收地址信息数据
	function loadAddList() {
		$.post(server_url+"queryAdd.action",function(result){
			app.over = result;
		})
	}
	
	//加载接收地址信息数据
	function loadTimeList() {
		
		$.post(server_url+"queryTime.action",function(result){
			app.rec = result;
		})
	}
	
	//发布订单格式
	function myFunction(){
		//取货码格式
		var pick_code = $("#ord_pick_code").val();
		var valicode = /^[a-zA-Z0-9_\\-\u4e00-\u9fa5]+$/;
		if(pick_code!='' && pick_code!=null){
			if(!valicode.test(pick_code)){
			window.$$ = window.Zepto = Zepto;
				$$.toast("取货码格式输入错误");
			}
		}
	}
	
	//发布订单格式
	function myFunction2(){
		//手机号格式
		var inpEle = $("#ord_phone").val();
		var myreg = /^1[3456789]\d{9}$/;
		if(inpEle != '' && inpEle != null){
			if(!myreg.test(inpEle)){
			window.$$ = window.Zepto = Zepto;
				$$.toast("手机号输入错误");
			}
		}
	}
	
	//发布订单格式
	function myFunction3(){
		//包裹重量框必须填写数字
		var oInp = $("#ord_wight").val();
		if(oInp!='' && oInp!=null){
		    if(isNaN(Number(oInp))){  
		    	window.$$ = window.Zepto = Zepto;
				$$.toast("包裹重量必须为数字！");
		    }
	    }
	}

	//添加发单信息
	$("#sendOrder").click(function() {
		window.$$ = window.Zepto = Zepto;
		//电话正则
		var myreg = /^1[3456789]\d{9}$/;
		//取货码正则
		var valicode = /^[a-zA-Z0-9_\\-\u4e00-\u9fa5]+$/;
		//取值
		var u_id =current_id;
		var ord_rec_name = $("#ord_rec_name").val();
		var ord_pick_code = $("#ord_pick_code").val();
		var ord_phone = $("#ord_phone").val();
		var com_id = $("#com_id").val();
		var add_id = $("#add_id").val();
		var ord_wight = $("#ord_wight").val();
		var rec_id = $("#rec_id").val();
		var ord_remark = $("#ord_remark").val();
		
		if(ord_rec_name == null || ord_rec_name == ''){
			$$.toast("收件人不能为空！")
		}else if(ord_pick_code == null || ord_pick_code == ''){
			$$.toast("取货码不能为空！")
		}else if(ord_phone == null || ord_phone == ''){
			$$.toast("电话号码不能为空！")
		}else if(com_id == null || com_id == ''){
			$$.toast("快递公司不能为空！")
		}else if(add_id == null || add_id == ''){
			$$.toast("收货地址不能为空！")
		}else if(ord_wight == null || ord_wight == ''){
			$$.toast("包裹重量不能为空！")
		}else if(rec_id == null || rec_id == ''){
			$$.toast("接收时间不能为空！")
		}else if(ord_remark == null || ord_remark == ''){
			$$.toast("备注不能为空！")
		}else{
			if(!valicode.test(ord_pick_code)){
				$$.toast("取货码填写错误！")
			}else if(!myreg.test(ord_phone)){
				$$.toast("手机号填写错误！")
			}else if(isNaN(Number(ord_wight))){
				$$.toast("包裹重量必须数字！")
			}else{
				var orders = {
					"u_id":current_id,
					"ord_rec_name": ord_rec_name,
					"ord_pick_code": ord_pick_code,
					"ord_phone": ord_phone,
					"ord_state": 1,
					"com_id": com_id,
					"add_id": add_id,
					"ord_wight": ord_wight,
					"rec_id": rec_id,
					"ord_remark": ord_remark
				}
				$.ajax({
					type: "POST",
					url: server_url+"insert.action",
					data: orders, 
					/*用于跨域处理*/
					xhrFields:{
				        withCredentials:true
				    },
				    crossDomain: true,
					success: function(data) {
						$$.toast("发布成功");
						location.reload();
					}
				});
			}
		}
	});
	
