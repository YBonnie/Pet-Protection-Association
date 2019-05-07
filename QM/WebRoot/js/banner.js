window.onload = function(){
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
	
	
	
	
	//领养轮播
	var oDiv = document.getElementById('adoption_box');
	var oUl = oDiv.getElementsByTagName('ul')[0];
	var aLi = oUl.getElementsByTagName('li');
	
	
	var oDiv1 = document.getElementById('bazaar_box');
	var oUl1 = oDiv1.getElementsByTagName('ul')[0];
	var aLi1 = oUl1.getElementsByTagName('li');
	
	var speed = 3;
	var speed1 = -3;

	oUl.innerHTML = oUl.innerHTML + oUl.innerHTML;
	oUl1.innerHTML = oUl1.innerHTML + oUl1.innerHTML;
	// ul的长度就是等于随便一个li的长度乘li的个数
	oUl.style.width = aLi[0].offsetWidth * aLi.length + 'px';
	oUl1.style.width = aLi1[0].offsetWidth * aLi1.length + 'px';

	function move() {
		// 当ul.offsetLeft滚到ul长度的一半的时候，就回到原来的地方	
		if(oUl.offsetLeft < -oUl.offsetWidth / 2) {
			oUl.style.left = '0';
		}
		if(oUl.offsetLeft > 0) {
			//要是2是+，那就会往右滚；-的话就会往左滚
			oUl.style.left = -oUl.offsetWidth / 2 + 'px';
		}
		oUl.style.left = oUl.offsetLeft + speed + 'px';
	}

	function move1() {
		// 当ul.offsetLeft滚到ul长度的一半的时候，就回到原来的地方	
		if(oUl1.offsetLeft < -oUl1.offsetWidth / 2) {
			oUl1.style.left = '0';
		}
		if(oUl1.offsetLeft > 0) {
			//要是2是+，那就会往右滚；-的话就会往左滚
			oUl1.style.left = -oUl1.offsetWidth / 2 + 'px';
		}
		oUl1.style.left = oUl1.offsetLeft + speed1 + 'px';
	}
	var timer = setInterval(move, 40);
	var timer1 = setInterval(move1, 40);

	oDiv.onmouseover = function() {
		clearInterval(timer);
	};
	oDiv1.onmouseover = function() {
		clearInterval(timer1);
	};

	oDiv.onmouseout = function() {
		timer = setInterval(move, 40);
	};
	oDiv1.onmouseout = function() {
		timer1 = setInterval(move1, 40);
	};

	document.getElementById("arrow_prev").onclick = function() {
		speed = -3;
	}
	document.getElementById("arrow_next").onclick = function() {
		speed = 3;
	}
	document.getElementById("arrow_prev1").onclick = function() {
		speed1 = -3;
	}
	document.getElementById("arrow_next1").onclick = function() {
		speed1 = 3;
	}
	
	


	


}
