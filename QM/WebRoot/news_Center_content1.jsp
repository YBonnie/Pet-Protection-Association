<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻中心内容</title>
<link rel="stylesheet" type="text/css" href="css/animate.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/wow.js"></script>
<script src="js/indexWow.js"></script>
<script src="js/reset.js"></script>
<script src="js/index.js"></script>
</head>
<body>
	<div class="main">
		<!--logo栏-->
		<div class="logo">
			<div class="logo_box"></div>
			<div class="Login_box clearfix">
				<a href="sign_In.jsp" class="Member_login">会员登录</a> <a
					href="register.jsp" class="Membership_registration">会员注册</a> <a
					href="administrator_Login.jsp" class="Administrator_login">管理员登录</a>

				<c:if test="${sessionScope.user2 != null}">
					<div class="welcome fr" id="welcome">
						欢迎回来：<span>${sessionScope.user2.username }</span> <a
							href="/QM/UserInfoServlet?id=${user2.id }" class="welcome_edit">编辑</a>
						<a href="/QM/LogoutServlet" class="welcome_edit">注销</a>
					</div>
				</c:if>

				<!--搜索框-->
				<div class="sousuo fr" id="sousuo">
					<form action="/QM/FindNewsList" method="post">
						<input class="search fl" id="kuang" name="search" type="text"
							value="" placeholder="  站内资讯" /> <input class="search_submit fr"
							name="search_submit" type="submit" value="" />
					</form>
				</div>
			</div>
		</div>
		<!--导航栏-->
		<div class="navBar wow fadeInUp" data-wow-duration="2s">
			<ul class="nav clearfix">
				<li class="nav_active"><a href="/QM/IndexList">首页</a></li>
				<li><a href="about_Us.jsp">关于我们</a>
					<ol>
						<li><a href="join_Us.jsp">加入我们</a></li>
						<li><a href="adopt_principle.jsp">救助原则</a></li>
					</ol></li>
				<li>
					<a href="/QM/NewsList?thispage=1">新闻中心</a>
					<ol>
						<li><a href="/QM/NewsList1?thispage=1">协会资讯</a></li>
						<li><a href="/QM/DynamicsList?thispage=1">协会动态</a></li>
					</ol>
				</li>
				<li><a href="base_Introduction.jsp">宠物基地</a>
					<ol>
						<li><a href="base_Introduction.jsp">基地介绍</a></li>
						<li><a href="/QM/PetInfoList?thispage=1">宠物介绍</a></li>
					</ol>
				</li>
				<li>
					<a href="/QM/LoveAdoption?thispage=1">爱心领养</a>
					<ol>
						<li><a href="adoption_Form.jsp">领养窗口</a></li>
						<li><a href="/QM/ReturnHome?thispage=1">回归家庭</a></li>
					</ol>
				</li>
				<li>
					<a href="/QM/BazaarList?thispage=1">线上义卖</a>
					<ol>
						<li><a href="donation_Account.jsp">募捐账户</a></li>
						<li><a href="/QM/AccountList?thispage=1">账目明细</a></li>
					</ol>
				</li>
				<li>
					<a href="cooperative_Partner.jsp">支持我们</a>
					<ol>
						<li><a href="cooperative_Partner.jsp">合作伙伴</a></li>
						<li><a href="leave_Word.jsp">留言</a></li>
					</ol>
				</li>
			</ul>
		</div>

		<!--面包屑-->
		<div class="breadcrumbs wow bounceInLeft" data-wow-duration="2s">
			<a href="/QM/IndexList">&nbsp;&nbsp;首页&nbsp;&nbsp;</a> <span> > </span> 
			<a href="/QM/NewsList?thispage=1">&nbsp;&nbsp;新闻中心&nbsp;&nbsp;</a> 
			<span> > </span> <a class="active" href="/QM/NewsList1?thispage=1">&nbsp;&nbsp;协会资讯&nbsp;&nbsp;</a>
		</div>

		<!--新闻内容-->
		<div class="content wow fadeInUp" data-wow-duration="4s">

			<div class="paragraph wow fadeInUp" data-wow-duration="4s">
				<p class="content-l-title">${requestScope.news.news_titles}</p>
				<p class="content-l-titleS"></p>
				<p class="content-l-time">发布日期：${requestScope.news.news_time}</p>
				<p class="content-l-titleS">
					<img src="/QM/ImgServlet?imgurl=${requestScope.news.news_img}"
						style="cursor: pointer;" />
				</p>
				<p style="text-indent:25px;margin: 10px 8px 15px; padding: 0px; clear: both; color: rgb(0, 0, 0); font-family: "
					text-align:="">
					<span style="font-size:16px; " ><span
						style="margin: 0px; padding: 0px;">${requestScope.news.news_content}</span>
					</span>
				</p>
				 <input id="p_content" type="hidden" value="${requestScope.news.news_allcont}">
				<p style="margin: 10px 8px 15px; padding: 0px; clear: both; color: rgb(0, 0, 0); text-indent:25px; line-height:50px;">
					<span style="font-size:16px;">
					   <span style="margin: 0px; padding: 0px;" id="p_content2"></span>
					</span>
				</p>
				<script>
						var p1 = document.getElementById("p_content").value;
						var p2 = document.getElementById("p_content2");
					var s=p1.split("。");
					for(var i=0;i<s.length;i++){
					s[i]="<p>"+s[i]+"。</p>";
				     
					}
					var ss="";
					for(var i=0;i<s.length;i++){
					ss+=s[i];
					}
			      p2.innerHTML=ss;
						</script>


				<section data-author="Wxeditor" font-size:="" helvetica=""
					hiragino="" microsoft="" sans=""> <article
					data-author="Wxeditor"> <section> <section
					35="" border-width:="" color:=""
					data-wxsrc="https://mmbiz.qlogo.cn/mmbiz_png/v4vz52CcB12gmzfo0DpWud5CZqUs9Ck0ckqZeJNyrFxj73gOKOngicDN2p2WbxDA8QfkjGRia1jzmLSEIedf8icgQ/0"
					fill="" https:="" mmbiz.qpic.cn="" mmbiz_png="" text-align:=""
					v4vz52ccb12gmzfo0dpwud5czqus9ck0ckqzejnyrfxj73gokongicdn2p2wbxda8qfkjgria1jzmlseiedf8icgq="">
				<section>
				<p style="text-align: center;">
					<strong><span style="font-size:16px;">鸣 &nbsp;谢</span>
					</strong>
				</p>
				<p style="text-align: center;">
					<span style="font-size:16px;">（排名不分先后）</span>
				</p>
				<p style="text-align: center;">
					<span style="font-size:16px;">中国儿童少年基金会少年公益学院</span>
				</p>
				<p style="text-align: center;">
					<span style="font-size:16px;">世界爱护动物协会</span>
				</p>
				<p style="text-align: center;">
					<span style="font-size:16px;">徐度时光宠物摄影工作室</span>
				</p>
				<p style="text-align: center;">
					<span style="font-size:16px;">长城国际展览有限责任公司</span>
				</p>
				<p style="text-align: center;">
					<span style="font-size:16px;">北京就爱它文化产业投资管理有限公司</span>
				</p>
				<p style="text-align: center;">
					<span style="color:#0000ff;"><span style="font-size:16px;">北京金佳骏犬行为训练技术培训中心</span>
					</span>
				</p>
				<p style="text-align: center;">
					<span style="font-size:16px;">烟台中宠食品股份有限公司</span>
				</p>
				<p style="text-align: center;">&nbsp;</p>
				<p style="text-align: center;">
					<strong><span style="font-size:16px;">特 别 感 谢</span>
					</strong>
				</p>
				<p style="text-align: center;">
					<span style="font-size:16px;">秦天先生</span>
				</p>
				<p style="text-align: center;">
					<span style="font-size:16px;">徐嘉琦女士</span>
				</p>
				<p style="text-align: center;">&nbsp;</p>
				<p style="text-align: center;">
					<span style="font-size:16px;">对本次活动的大力支持！</span>
				</p>
				</section> </section> </section> </article> </section>

			</div>
		</div>

		<!--footer-->
		<div class="footer">
			<div class="footer_box clearfix">
				<img class="fl" src="media/images/logo.png" alt="" />
				<div class="address fl">
					<p>地址：广东省惠州市西乡塘区大学西路189号</p>
					<p>邮编：516300</p>
					<p>电话：0752-8733732</p>
					<p>传真：0752-8953571</p>
					<p>电子邮件：chuangwubaohu@163.com</p>
				</div>

				<a class="btn-select fr" id="btn_select"> <select
					onchange="window.location.href=this.value">
						<option value="#" onchange="true">友 情 链 接</option>
						<option value="http://www.gwng.edu.cn/web/portal/index">广东外语外贸大学南国商学院</option>
						<option value="http://www.csapa.org/index.jhtml">中国小动物保护协会</option>
						<option value="http://www.cqsapa.com/index.htm">
							重庆小动物保护协会</option>
						<option value="http://www.zjsapa.org/portal.php">浙江省小动物保护协会</option>
						<option value="http://www.shwildlife.org/">上海市野生动物保护协会</option>
						<option value="http://www.sos12345.com/main.asp">宁夏小动物保护协会</option>
						<option value="http://www.590pet.com/">武汉市小动物保护协会</option>
				</select> </a> <a class="code fr" href=""><img src="media/images/code.png"
					alt="" />
					<p>协会二维码2</p> </a> <a class="code fr" href=""><img
					src="media/images/code1.png" alt="" />
					<p>协会二维码1</p> </a>
			</div>
		</div>

		<!--悬浮栏-->
		<div class="fix_box">
			<ul>
				<li><a href="sign_In.jsp">会 员 登 录</a>
				</li>
				<li><a href="register.jsp">会 员 注 册</a>
				</li>
				<li><a href="#"><img src="media/images/code.png"
						width="100px" height="100px">
				</a>
				</li>
				<li><a href="#">0752-8733732</a>
				</li>
				<li class="return_top"><a href="#"></a>
				</li>
			</ul>
		</div>

		<!--结束-->
	</div>

</body>
</html>