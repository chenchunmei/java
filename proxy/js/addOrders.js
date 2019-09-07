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
         
    //包裹重量框必须填写数字
    var oInp = document.getElementById('ord_wight');
    oInp.onblur=function(){
        if(isNaN(Number(oInp.value))){  
        	window.$$ = window.Zepto = Zepto;
			$$.toast("包裹重量必须数字！");
        }
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
	
	//手机号格式
	window.onload = function() {
			var inpEle = document.getElementById('ord_phone');
			var myreg = /^1[3456789]\d{9}$/;
			inpEle.onblur = function() {
				var inpVal = this.value;
				if(!myreg.exec(inpVal)) {
					window.$$ = window.Zepto = Zepto;
					$$.toast("手机号输入错误");
				} 
			}
		}

	//添加发单信息
	$("#sendOrder").click(function() {
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
				window.$$ = window.Zepto = Zepto;
				$$.toast("发布成功");
				location.reload();
				window.location.href="userOrder.html";
			}
		});
	});
	
