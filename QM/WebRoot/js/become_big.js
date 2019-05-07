window.onload=function(){
	
	//图片放大效果
	var bbox = document.getElementsByClassName("Commodity_details_box")[0];
//	console.log(bbox);
	var bmove = document.querySelector("#move");
	var bbimg = document.querySelector("#bimg");
	var b_bimg = document.querySelector("#b_bimg");
	bbox.onmouseover = function(){
        // 鼠标移动到box上显示大图片和选框
        bmove.style.display="block";
        bbimg.style.display="block";
    };
     bbox.onmouseout = function(){
        // 鼠标移开box不显示大图片和选框
        bmove.style.display="none";
        bbimg.style.display="none";
    };
    bbox.onmousemove=function(event){
        event=event||window.event;
        // 获取鼠标位置  鼠标相对于视口的位置
        var x = event.clientX;
        var y = event.clientY;
        //box相对于视口的位置
        var t = this.offsetTop;
        var l = this.offsetLeft;
        //计算move的位置
        var _left=x - l - bmove.offsetWidth/2;
        var _top=y - t - bmove.offsetHeight/2;
        //限定move移动的位置
        if(_top<=0){
            _top=0;
        }
        else if(_top>=bbox.offsetHeight - bmove.offsetHeight){
            _top=bbox.offsetHeight - bmove.offsetHeight;
        }
         if(_left<=0){
            _left=0;
        }
        else if(_left>=bbox.offsetWidth - bmove.offsetWidth){
            _left=bbox.offsetWidth - bmove.offsetWidth;
        }
        // 设置move的位置
        bmove.style.top=_top+"px";
        bmove.style.left=_left+"px";



        //计算移动的比例
        var w = _left / (bbox.offsetWidth - bmove.offsetWidth);
        var h = _top / (bbox.offsetHeight - bmove.offsetHeight);


        // 计算大图的位置
        var b_bimg_top = (b_bimg.offsetHeight - bbimg.offsetHeight) * h;
        var b_bimg_left = (b_bimg.offsetWidth - bbimg.offsetWidth) * w;

        // 设置大图的位置信息
        b_bimg.style.left=-b_bimg_left+"px";
        b_bimg.style.top=-b_bimg_top+"px";
    };
	 

	
};
