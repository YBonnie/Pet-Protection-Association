/**
 * Created by Administrator on 2018/11/6 0006.
 */
$(function() {

	//新闻
	$(".news_box ul li ").mouseover(function() {
		$(this).css("background", "#CCCCCC");
	});
	$(".news_box ul li ").mouseout(function() {
		$(this).css("background", "transparent");
	});
	$(".news_box ul li img").mouseover(function() {
		$(this).stop().animate({ width: "300", height: "220" }, 500).siblings().stop();
	});
	$(".news_box ul li img").mouseout(function() {
		$(this).stop().animate({ width: "282", height: "200" }, 500).siblings().stop();
	});

	//分页的效果
	$(".ep-pages a").mouseenter(function() {
		$(this).addClass("current");
	});
	$(".ep-pages a").mouseleave(function() {
		$(this).removeClass("current");

	});

	//新闻中心
	$(".new_box ul li a").mouseenter(function() {
		$(this).parent('li').addClass("active1");
	});
	$(".new_box ul li a").mouseout(function() {
		$(this).parent('li').removeClass("active1");
		$(this).parent('li:first-child').addClass("active1");
	});

	//协会动态
	$(".content-l .list li a").mouseenter(function() {
		$(this).parent("li").addClass("active2");
	});
	$(".content-l .list li a").mouseout(function() {
		$(this).parent("li").removeClass("active2");
		$(this).parent('li:first-child').addClass("active2");
	});

	//宠物介绍
	$(".content .pet_list li a .p3").mouseenter(function() {
		$(this).css("background", "#7CFC00");
	});
	$(".content .pet_list li a .p3").mouseout(function() {
		$(this).css("background", "#228B22");
	});

	$(".yema p").mouseenter(function() {
		$(this).addClass("current1");
	});
	$(".yema p").mouseout(function() {
		$(this).removeClass("current1");
	});

	$(".pet_list li img").mouseover(function() {
		$(this).stop().animate({ width: "320", height: "250" }, 500).siblings().stop();
	});
	$(".pet_list li img").mouseout(function() {
		$(this).stop().animate({ width: "297", height: "200" }, 500).siblings().stop();
	});

	//love_adoption.html
	$(".love_adoption_box .love_adop_list li img").mouseenter(function() {
		$(this).siblings(".arise_up").stop().animate({ top: 0 }, 1000).siblings().stop();
	});
	$(".love_adoption_box .love_adop_list li .arise_up").mouseout(function() {
		$(this).stop().animate({ top: 295 }, 1000).siblings().stop();
	});
	



	



});



	//adoption_form.html 表格清楚功能
function clearInput() {
		$('form input').each(function(key, object) {
			var type = $(object).prop('type');
			if(type == 'text') {
				$(object).val('');
			} else if(type == 'checkbox') {
				var checked = $(object).prop('checked');
				if(checked) {
					$(object).trigger('click');
				}
			} else {
				$(object).prop('checked', false);
			}
		});
	}

//js
window.onload = function() {
	
	

	//回到顶部按钮
	var return_top = document.querySelector(".return_top");
	var fix_box = document.querySelector(".fix_box");
	window.onscroll = function() {
		var ttop = document.body.scrollTop || document.documentElement.scrollTop;

		if(ttop > 500) {
			fix_box.style.display = "block";
		} else {
			fix_box.style.display = "none";
		}
		return_top.onclick = function() {

			window.scrollTo(0, 0);
		};
	};

	

};