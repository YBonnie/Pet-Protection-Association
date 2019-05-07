$(function(){
	//导航栏效果
	$(".nav>li").mouseenter(function(){
		
		$(this).css("background","#53b664");
		$(this).find("ol").slideDown(200).find("li").mouseenter(function(){
			$(this).css("background","#1D602C")
		});
		
		$(this).find("li").mouseleave(function(){
			$(this).css("background","#53b664")
		})
	});
	$(".nav>li").mouseleave(function(){
		$(this).css("background","transparent");
		$(this).find("ol").slideUp(200);
		$(".nav>li:nth-child(1)").css("background","#53b664")
	})
	
	//banner
	//显示第一张
	$(".banner li").eq(0).show();
	//鼠标滑过手动切换，淡入淡出
	$(".point li").mouseover(function(){
		$(this).addClass("now").siblings().removeClass("now");
		var index=$(this).index();
		i=index;//不加这句有个bug，鼠标移出小圆点后，自动轮播不是小圆点的后一个
		$(".banner li").eq(index).fadeIn(500).siblings().fadeOut(500);
	});
	 //自动轮播
	 var i=0;
	 var timer=setInterval(playRight,2000);
	  //向右切换
	 var playRight=function(){
	 	i++;
	 	i=i>4?0:i;
	 	$(".point li").eq(i).addClass("now").siblings().removeClass("now");
	 	$(".banner li").eq(i).fadeIn(500).siblings().fadeOut(500);
	 }
	 
	 //向左切换
	 var playLeft=function(){
	 	i--;
	 	i=i<0?4:i;
	 	$(".point li").eq(i).addClass("now").siblings().removeClass("now");
	 	$(".banner li").eq(i).fadeIn(500).siblings().fadeOut(500);
	 }
	  //鼠标移入移出效果
	  $(".bannerbox").hover(function(){
	  	clearInterval(timer);
	  },function(){
	  	 timer=setInterval(playRight,2000);
	  });
	 //左右点击切换
	 $("#prev").click(function(){
	 	playLeft();
	 });
	 $("#next").click(function(){
	 	playRight();
	 });
	
	
		   
        	
		
	
	
	
	
	
	
	
	
	
	//结尾
	
});