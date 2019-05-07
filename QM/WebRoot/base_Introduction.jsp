<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>基地介绍</title>
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
					<a href="sign_In.jsp" class="Member_login">会员登录</a>
					<a href="register.jsp" class="Membership_registration">会员注册</a>
					<a href="administrator_Login.jsp" class="Administrator_login">管理员登录</a>
					
					
					<c:if test="${sessionScope.user2 != null}">
						<div class="welcome fr" id="welcome">
							欢迎回来：<span>${sessionScope.user2.username }</span>
							<a href="/QM/UserInfoServlet?id=${user2.id }" class="welcome_edit">编辑</a>
							<a href="/QM/LogoutServlet" class="welcome_edit">注销</a>
						</div>
			       </c:if>
			       
					<!--搜索框-->
					<div class="sousuo fr" id="sousuo">
						<form action="/QM/FindNewsList" method="post">
							<input class="search fl" id="kuang" name="search" type="text" value="" placeholder="  站内资讯" />
							<input class="search_submit fr" name="search_submit" type="submit" value="" />
						</form>
					</div>
				</div>
			</div>
			<!--导航栏-->
			<div class="navBar wow fadeInUp" data-wow-duration="2s">
				<ul class="nav clearfix">
					<li class="nav_active">
						<a href="/QM/IndexList">首页</a>
					</li>
					<li>
						<a href="about_Us.jsp">关于我们</a>
						<ol>
							<li>
								<a href="join_Us.jsp">加入我们</a>
							</li>
							<li>
								<a href="adopt_principle.jsp">救助原则</a>
							</li>
						</ol>
					</li>
					<li>
						<a href="/QM/NewsList?thispage=1">新闻中心</a>
						<ol>
							<li>
								<a href="/QM/NewsList1?thispage=1">协会资讯</a>
							</li>
							<li>
								<a href="/QM/DynamicsList?thispage=1">协会动态</a>
							</li>
						</ol>
					</li>
					<li>
						<a href="base_Introduction.jsp">宠物基地</a>
						<ol>
							<li>
								<a href="base_Introduction.jsp">基地介绍</a>
							</li>
							<li>
								<a href="/QM/PetInfoList?thispage=1">宠物介绍</a>
							</li>
						</ol>
					</li>
					<li>
						<a href="/QM/LoveAdoption?thispage=1">爱心领养</a>
						<ol>
							<li>
								<a href="adoption_Form.jsp">领养窗口</a>
							</li>
							<li>
								<a href="/QM/ReturnHome?thispage=1">回归家庭</a>
							</li>
						</ol>
					</li>
					<li>
						<a href="/QM/BazaarList?thispage=1">线上义卖</a>
						<ol>
							<li>
								<a href="donation_Account.jsp">募捐账户</a>
							</li>
							<li>
								<a href="/QM/AccountList?thispage=1">账目明细</a>
							</li>
						</ol>
					</li>
					<li>
						<a href="cooperative_Partner.jsp">支持我们</a>
						<ol>
							<li>
								<a href="cooperative_Partner.jsp">合作伙伴</a>
							</li>
							<li>
								<a href="leave_Word.jsp">留言</a>
							</li>
						</ol>
					</li>
				</ul>
			</div>

			<!--面包屑-->
			<div class="breadcrumbs wow bounceInLeft" data-wow-duration="2s">
				<a href="/QM/IndexList">&nbsp;&nbsp;首页&nbsp;&nbsp;</a>
				<span> > </span>
				<a href="base_Introduction.jsp">&nbsp;&nbsp;宠物基地&nbsp;&nbsp;</a>
				<span> > </span>
				<a class="active" href="base_Introduction.jsp">&nbsp;&nbsp;基地介绍&nbsp;&nbsp;</a>
			</div>

			<!--新闻内容-->
			<div class="content wow fadeInUp" data-wow-duration="4s">
				<div class="paragraph-jd">
					<p align="center"><span style="font-size:24px;"><strong>宠物保护协会</strong></span></p>
					<p align="center"><span style="font-size:24px;"><strong>流浪动物保护基地 * 爱心教育基地</strong></span></p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp; 宠物保护协会一直以保护动物、维护动物的生存权利和不受虐待的权利、以及改善和提高小动物的生命条件、饲养水平为宗旨，坚决反对任何虐待、残害动物的行为和思想。而眼下，流浪动物问题日益严重，它们的生存环境愈加恶劣，协会本着这一理念，为了改善流浪动物的生存条件，在国际动物组织的帮助下，建立了救护收容小动物的基地——爱心教育基地，结束了多年来带着动物东奔西窜的险难生活，使备受虐待摧残，被抛弃追杀的小动物们有了一座避难所。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp;1999年，协会在南京的佛门弟子的帮助下，在风景秀美的北京西山附近，租得占地十七亩之广的庭院，改善了动物的生活条件。1998年，协会还历尽艰辛，建立了小动物防疫、保健、治疗中心。解决了动物的保健、医疗问题。这两个实体，为协会的进一步发展创造了良好的条件。</p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp;2014年9月，协会完成换届工作后，又投入了大量资金用于修缮基地，加盖犬舍，为流浪动物提供更宽松的生活以及活动空间，改善它们的生存环境。我们希望这些流浪动物可以在基地找到家的感觉，不再忍饥受冻，幸福、快乐的在这里生活着。</p>
					<p>&nbsp;</p>
					<p style="text-align: center;"><img src="media/images/base/base_2.jpg"></p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp;2016年9月，越来越的自愿者开始对协会里面的小动物进行献爱心行动，他们相继组织起了“关于如何更加好的对待流浪小动物的问题”进行了一系列有意义的讨论。</p>
					<p style="text-align: center; margin-top:20px;"><img src="media/images/base/base_1.jpg"></p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp;2017年6月，用心呵护是每一个宠物寄养和宠物训练基地常年遵守的使命。宠爱到家以家庭寄养为理念、人性化的寄养方式服务您，让宠物与经验丰富的训犬师生活在一起，精心照料，随时关注宠物的身体健康及情绪变化，保障宠物的安全，保持宠物快乐的心情。</p>
					<p style="text-align: center; margin-top:20px;"><img src="media/images/base/base_3.jpg"></p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp;日常生活保证每只狗儿的娱乐和户外活动时间，在寄养期间我们采用量化的管理模式，根据宠物自身的性格制定不同的娱乐方式及照料方式，工作人员都是有丰富的培训经历。确保狗儿能得到专业、用心的照顾。"人犬同住，人犬同玩的服务，为广大宠物家长提供温馨，舒适，的宠物寄养最佳场所。</p>
					<p style="text-align: center; margin-top:20px;"><img src="media/images/base/base_4.jpg"></p>
					<p style="text-align: center; margin-top:20px;"><img src="media/images/base/base_5.jpg"></p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp;我们用心为每一只小动物打造属于他们快乐的家园，希望社会上有更加多的爱心人士，可以积极的加入我们。期待你们的到来！！！</p>
					
				</div>
			</div>

			<!--footer-->
			<div class="footer">
				<div class="footer_box clearfix">
					<img class="fl" src="media/images/logo.png" alt="" />
					<div class="address fl">
						<p>地址：广东省惠州市西乡塘区大学西路189号 </p>
						<p>邮编：516300</p>
						<p>电话：0752-8733732</p>
						<p>传真：0752-8953571</p>
						<p>电子邮件：chuangwubaohu@163.com</p>
					</div>

					<a class="btn-select fr" id="btn_select">
						<select onchange="window.location.href=this.value">
							<option value="#" onchange="true"> 友 情 链 接</option>
							<option value="http://www.gwng.edu.cn/web/portal/index">广东外语外贸大学南国商学院</option>
							<option value="http://www.csapa.org/index.jhtml">中国小动物保护协会</option>
							<option value="http://www.cqsapa.com/index.htm"> 重庆小动物保护协会</option>
							<option value="http://www.zjsapa.org/portal.php">浙江省小动物保护协会</option>
							<option value="http://www.shwildlife.org/"> 上海市野生动物保护协会​</option>
							<option value="http://www.sos12345.com/main.asp">宁夏小动物保护协会</option>
							<option value="http://www.590pet.com/">武汉市小动物保护协会</option>
						</select>
					</a>
					<a class="code fr" href=""><img src="media/images/code.png" alt="" />
						<p>协会二维码2</p>
					</a>
					<a class="code fr" href=""><img src="media/images/code1.png" alt="" />
						<p>协会二维码1</p>
					</a>
				</div>
			</div>

			<!--悬浮栏-->
			<div class="fix_box">
				<ul>
					<li><a href="sign_In.jsp">会  员  登  录</a></li>
					<li><a href="register.jsp">会  员  注  册</a></li>
					<li><a href="#"><img src="media/images/code.png" width="100px" height="100px"></a></li>
					<li><a href="#">0752-8733732</a></li>
					<li class="return_top"><a href="#"></a></li>
				</ul>
			</div>

			<!--结束-->
		</div>
  	
</body>
</html>