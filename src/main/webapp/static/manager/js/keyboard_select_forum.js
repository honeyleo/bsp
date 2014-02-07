$(function(){
	//一级版面
	setInterval(function(){
		$('#op_combox_lv1Forum a').first().focus();
		$("#op_combox_lv1Forum a").die();
		$("#op_combox_lv1Forum a").live({
			keydown: function(e) {
				var key = e.keyCode;
				var target = $(e.currentTarget);
				key = parseInt(key);
				//添加键盘字母响应  start
				var charKeyCodes=[65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90];
				  	for( x in charKeyCodes){
				  		if(key == charKeyCodes[x]){
				  			$("#op_combox_lv1Forum a").each(function(i){
									var forumTitle = $(this).text();
									var capital = forumTitle.charAt(0);
									if(capital.toLocaleLowerCase() == String.fromCharCode(key).toLocaleLowerCase()){
										$('#op_combox_lv1Forum').scrollTop($(this).parent().height()*i);
										$(this).parent().parent().find('a').removeClass("selected");
										$(this).addClass("selected");
										return false;
									}
				  			});
				  		}
		       }
				//添加键盘字母响应  end
				
				  	/*switch(key) {
					case 38:
						target.parent().prev().find('a').focus();
						break;
					case 40:
						target.parent().next().find('a').focus();
						break;
				}*/
			},
			focusin: function(e) {
				$(e.currentTarget).parent().parent().find('a').removeClass("selected");
				$(e.currentTarget).addClass("selected");
			}
		});
	},1000);
	
	//二级版面
	setInterval(function(){
		$('#op_combox_lv2Forum a').first().focus();
		$("#op_combox_lv2Forum a").die();
		$("#op_combox_lv2Forum a").live({
			keydown: function(e) {
				var key = e.keyCode;
				var target = $(e.currentTarget);
				key = parseInt(key);
				//添加键盘字母响应  start
				var charKeyCodes=[65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90];
				  	for( x in charKeyCodes){
				  		if(key == charKeyCodes[x]){
				  			$("#op_combox_lv2Forum a").each(function(i){
				  				    
									var forumTitle = $(this).text();
									var capital = forumTitle.charAt(0);
									if(capital.toLocaleLowerCase() == String.fromCharCode(key).toLocaleLowerCase()){
										$('#op_combox_lv2Forum').scrollTop($(this).parent().height()*i);
										$(this).parent().parent().find('a').removeClass("selected");
										$(this).addClass("selected");
										return false;
									}
				  			});
				  		}
		       }
				//添加键盘字母响应  end
				
				/*switch(key) {
					case 38:
						target.parent().prev().find('a').focus();
						break;
					case 40:
						target.parent().next().find('a').focus();
						break;
				}*/
			},
			focusin: function(e) {
				$(e.currentTarget).parent().parent().find('a').removeClass("selected");
				$(e.currentTarget).addClass("selected");
			}
		});
	},1000);
	
	//三级版面
	setInterval(function(){
		$('#op_combox_lv3Forum a').first().focus();
		$("#op_combox_lv3Forum a").die();
		$("#op_combox_lv3Forum a").live({
			keydown: function(e) {
				var key = e.keyCode;
				var target = $(e.currentTarget);
				key = parseInt(key);
				//添加键盘字母响应  start
				var charKeyCodes=[65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90];
				  	for( x in charKeyCodes){
				  		if(key == charKeyCodes[x]){
				  			$("#op_combox_lv3Forum a").each(function(i){
									var forumTitle = $(this).text();
									var capital = forumTitle.charAt(0);
									if(capital.toLocaleLowerCase() == String.fromCharCode(key).toLocaleLowerCase()){
										$('#op_combox_lv3Forum').scrollTop($(this).parent().height()*i);
										$(this).parent().parent().find('a').removeClass("selected");
										$(this).addClass("selected");
										return false;
									}
				  			});
				  		}
		       }
				//添加键盘字母响应  end
				
				  	/*switch(key) {
					case 38:
						target.parent().prev().find('a').focus();
						break;
					case 40:
						target.parent().next().find('a').focus();
						break;
				}*/
			},
			focusin: function(e) {
				$(e.currentTarget).parent().parent().find('a').removeClass("selected");
				$(e.currentTarget).addClass("selected");
			}
		});
	},1000);

})
