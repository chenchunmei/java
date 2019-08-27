	
	$("#picker-name").picker({
	  toolbarTemplate: '<header class="bar bar-nav">\
	  <button class="button button-link pull-left">取消</button>\
	  <button class="button button-link pull-right close-picker">确定</button>\
	  <h1 class="title">快递公司</h1>\
	  </header>',
	  cols: [
	    {
	      textAlign: 'center',
	      values: ['全部', '中通快递', '圆通快递', '韵达快递', '顺丰快递']
	    }
	  ]
	});
	$("#picker-name1").picker({
	  toolbarTemplate: '<header class="bar bar-nav">\
	  <button class="button button-link pull-right close-picker">确定</button>\
	  <h1 class="title">请选择区域</h1>\
	  </header>',
	  cols: [
	    {
	      textAlign: 'center',
	      values: ['全部', 'A1', 'A2', 'A3', 'A4', 'A5', 'A6']
	    }
	  ]
	});