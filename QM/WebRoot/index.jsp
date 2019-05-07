<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>宠物保护协会</title>
		<link rel="stylesheet" type="text/css" href="css/animate.css" />
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<script src="js/jquery-1.9.1.min.js"></script>
		<script src="js/wow.js"></script>
		<script src="js/indexWow.js"></script>
		<script src="js/reset.js"></script>	
		 <script src="js/index.js"></script>
		<script src="js/banner.js" type="text/javascript" charset="utf-8"></script>
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
								<a href="/QM/LeaveWordServlet">留言</a>
							</li>
						</ol>
					</li>
				</ul>
			</div>

			<!--banner-->
			<div class="bannerbox wow fadeInUp" data-wow-duration="4s">
				<ul class="banner">
					<li>
						<a href="/QM/NewsList?thispage=1"><img src="media/images/banner_1.jpg" /></a>
					</li>
					<li>
						<a href="/QM/NewsList?thispage=1"><img src="media/images/banner_5.jpg" /></a>
					</li>
					<li>
						<a href="/QM/NewsList?thispage=1"><img src="media/images/banner_3.jpg" /></a>
					</li>
					<li>
						<a href="/QM/NewsList?thispage=1"><img src="media/images/banner_4.jpg" /></a>
					</li>
					<li>
						<a href="/QM/NewsList?thispage=1"><img src="media/images/banner_2.jpg" /></a>
					</li>
				</ul>
				<ol class="point">
					<li class="now">1</li>
					<li>2</li>
					<li>3</li>
					<li>4</li>
					<li>5</li>
				</ol>
				<a href="javascript:;" id="prev" class="arrow"></a>
				<a href="javascript:;" id="next" class="arrow"></a>
			</div>

			<!--news-->
			<div class="news_box wow fadeInUp" data-wow-duration="2s">
				<div class="news_title">
					<span class="news_tip fl"></span>
					<span class="news_more fr"><a href="/QM/NewsList?thispage=1">更 多 >></a></span>
				</div>
				<ul class="clearfix">
				
					<li>
						<a href="/QM/newsContent?id=${newsList[0].id}">
						<img src="/QM/ImgServlet?imgurl=${newsList[0].news_img}" style="cursor: pointer;"/>
							<!--  <img src="${newsList[0].news_img}" alt="" />-->
						</a>
						<div>
							<a href="/QM/newsContent?id=${newsList[0].id}">
								<p class="black"><strong>${newsList[0].news_titles}</strong></p>
								<p>${newsList[0].news_content}</p>
								<p>详情&gt;&gt;</p>
							</a>
						</div>
					</li>
					<li>
						<a href="/QM/newsContent?id=${newsList[1].id}">
						<img src="/QM/ImgServlet?imgurl=${newsList[1].news_img}" style="cursor: pointer;"/>
						<!-- <img src="${newsList[1].news_img}" alt="" /> -->
						</a>
						<div>
							<a href="/QM/newsContent?id=${newsList[1].id}">
								<p class="black"><strong>${newsList[1].news_titles}</strong></p>
								<p>${newsList[1].news_content}</p>
								<p>详情&gt;&gt;</p>
							</a>
						</div>
					</li>
					<li>
						<a href="/QM/newsContent?id=${newsList[2].id}">
						<img src="/QM/ImgServlet?imgurl=${newsList[2].news_img}" style="cursor: pointer;"/>
						<!--  <img src="${newsList[2].news_img}" alt="" />-->
						</a>
						<div>
							<a href="/QM/newsContent?id=${newsList[2].id}">
								<p class="black"><strong>${newsList[2].news_titles}</strong></p>
								<p>${newsList[2].news_content}</p>
								<p>详情&gt;&gt;</p>
							</a>
						</div>
					</li>
					<li>
						<a href="/QM/newsContent?id=${newsList[3].id}">
						<img src="/QM/ImgServlet?imgurl=${newsList[3].news_img}" style="cursor: pointer;"/>
						<!--  <img src="${newsList[3].news_img}" alt="" />-->
						</a>
						<div>
							<a href="/QM/newsContent?id=${newsList[3].id}">
								<p class="black"><strong>${newsList[3].news_titles}</strong></p>
								<p>${newsList[3].news_content}</p>
								<p>详情&gt;&gt;</p>
							</a>
						</div>
					</li>
				</ul>
			</div>
			<!--协会-->
			<div class="association_box clearfix wow fadeInUp" data-wow-duration="2s">
				<div class="association_introduction fl wow fadeInLeft" data-wow-duration="4s">
					<div class="association_title clearfix">
						<span class="association_tip fl"></span>
					</div>
					<a href="">
						<img src="media/images/association_1.jpg" />
						<div class="introduction_text">
							<strong>宠 物 保 护 协 会</strong>
							<p>宠物保护协会（Pet Protection Association）是省级专业性社会团体，可在全国和境外吸收会员、建立地方性组织和开展国际文化交流活动。</p>
							<p>协会成立于2018年10月1日，协会以珍爱生命、倡导精神文明和发扬人道主义精神为思想基础，以保护动物、维护动物的生存权利和不受虐待的权利、以及改善和提高小动物的生命条件、饲养水平为宗旨，坚决反对任何虐待、残害动物的行为和思想。</p>
						</div>
					</a>
				</div>
				<div class="association_intro fr wow fadeInRight" data-wow-duration="4s">
					<div class="aco_intro_title clearfix">
						<span class="aco_intro__tip fl"></span>
						<span class="aco_intro_more fr"><a href="/QM/DynamicsList?thispage=1">更 多 >></a></span>
					</div>
					<ul>
						<li class="active">
							<a href="/QM/dynaContentServlet?id=${dynamicsList[0].id}"><span>${dynamicsList[0].dynamics_title }</span><span>${dynamicsList[0].dynamics_time }</span></a>
						</li>
						<li>
							<a href="/QM/dynaContentServlet?id=${dynamicsList[1].id}"><span>${dynamicsList[1].dynamics_title }</span><span>${dynamicsList[1].dynamics_time }</span></a>
						</li>
						<li>
							<a href="/QM/dynaContentServlet?id=${dynamicsList[2].id}"><span>${dynamicsList[2].dynamics_title }</span><span>${dynamicsList[2].dynamics_time }</span></a>
						</li>
						<li>
							<a href="/QM/dynaContentServlet?id=${dynamicsList[3].id}"><span>${dynamicsList[3].dynamics_title }</span><span>${dynamicsList[3].dynamics_time }</span></a>
						</li>
						<li>
							<a href="/QM/dynaContentServlet?id=${dynamicsList[4].id}"><span>${dynamicsList[4].dynamics_title }</span><span>${dynamicsList[4].dynamics_time }</span></a>
						</li>
						<li>
							<a href="/QM/dynaContentServlet?id=${dynamicsList[5].id}"><span>${dynamicsList[5].dynamics_title }</span><span>${dynamicsList[5].dynamics_time }</span></a>
						</li>
						<li>
							<a href="/QM/dynaContentServlet?id=${dynamicsList[6].id}"><span>${dynamicsList[6].dynamics_title }</span><span>${dynamicsList[6].dynamics_time }</span></a>
						</li>
						<li>
							<a href="/QM/dynaContentServlet?id=${dynamicsList[7].id}"><span>${dynamicsList[7].dynamics_title }</span><span>${dynamicsList[7].dynamics_time }</span></a>
						</li>
					</ul>
				</div>

			</div>

			<!--爱心领养-->
			<div class="adoption clearfix wow bounceInLeft" data-wow-duration="4s">
				<div class="adoption_sign fl"></div>
				<span class="adoption_more fr"><a href="/QM/LoveAdoption?thispage=1">更 多 >></a></span>
				<div class="adoption_banner fr clearfix">

					<div class="arrow">
						<a href="javascript:;" class="arrow_item prev" id="arrow_prev"></a>
					</div>
					<div class="adoption_box" id="adoption_box">
						<ul class="adoption_box_ul clearfix">
							<li>
								<a href="/QM/LoveAdoption?thispage=1">
								<img src="/QM/ImgServlet?imgurl=${petList[0].imgurl }" style="cursor: pointer;"/>
								<!--  <img src="${petList[0].imgurl }" alt="" />-->
									<p>姓名：${petList[0].name }</p>
									<div class="adoption_news">
										详 情
									</div>
								</a>
							</li>
							<li>
								<a href="/QM/LoveAdoption?thispage=1">
								<img src="/QM/ImgServlet?imgurl=${petList[1].imgurl }" style="cursor: pointer;"/>
								<!-- <img src="${petList[1].imgurl }" alt="" /> -->
									<p>姓名：${petList[1].name }</p>
									<div class="adoption_news">
										详 情
									</div>
								</a>
							</li>
							<li>
								<a href="/QM/LoveAdoption?thispage=1">
								<img src="/QM/ImgServlet?imgurl=${petList[2].imgurl }" style="cursor: pointer;"/>
								<!--  <img src="${petList[2].imgurl }" alt="" />-->
									<p>姓名：${petList[2].name }</p>
									<div class="adoption_news">
										详 情
									</div>
								</a>
							</li>
							<li>
								<a href="/QM/LoveAdoption?thispage=1">
								<img src="/QM/ImgServlet?imgurl=${petList[3].imgurl }" style="cursor: pointer;"/>
								<!--  <img src="${petList[3].imgurl }" alt="" />-->
									<p>姓名：${petList[3].name }</p>
									<div class="adoption_news">
										详 情
									</div>
								</a>
							</li>
							<li>
								<a href="/QM/LoveAdoption?thispage=1">
								<img src="/QM/ImgServlet?imgurl=${petList[4].imgurl }" style="cursor: pointer;"/>
								<!--  <img src="${petList[4].imgurl }" alt="" />-->
									<p>姓名：${petList[4].name }</p>
									<div class="adoption_news">
										详 情
									</div>
								</a>
							</li>
							<li>
								<a href="/QM/LoveAdoption?thispage=1">
								<img src="/QM/ImgServlet?imgurl=${petList[5].imgurl }" style="cursor: pointer;"/>
								<!--  <img src="${petList[5].imgurl }" alt="" />-->
									<p>姓名：${petList[5].name }</p>
									<div class="adoption_news">
										详 情
									</div>
								</a>
							</li>
						</ul>
					</div>
					<div class="arrow">
						<a href="javascript:;" class="arrow_item next" id="arrow_next"></a>
					</div>
				</div>
			</div>

			<!--线上义卖-->
			<div class="bazaar clearfix wow bounceInRight" data-wow-duration="4s">
				<div class="bazaar_sign fl"></div>
				<span class="bazaar_more fr"><a href="/QM/BazaarList?thispage=1">更 多 >></a></span>
				<div class="bazaar_banner fr clearfix">

					<div class="arrow">
						<a href="javascript:;" class="arrow_item prev" id="arrow_prev1"></a>
					</div>
					<div class="bazaar_box" id="bazaar_box">
						<ul class="bazaar_box_ul clearfix">
							<li>
								<a href="/QM/BazaarList?thispage=1">
								<img src="/QM/ImgServlet?imgurl=${goodList[0].imgurl }" style="cursor: pointer;"/>
								<!--  <img src="${goodList[0].imgurl }" alt="" />-->
									<p>商品：${goodList[0].name }</p>
									<div class="bazaar_news">
										详 情
									</div>
								</a>
							</li>
							<li>
								<a href="/QM/BazaarList?thispage=1">
								<img src="/QM/ImgServlet?imgurl=${goodList[1].imgurl }" style="cursor: pointer;"/>
								<!--  <img src="${goodList[1].imgurl }" alt="" />-->
									<p>商品：${goodList[1].name }</p>
									<div class="bazaar_news">
										详 情
									</div>
								</a>
							</li>
							<li>
								<a href="/QM/BazaarList?thispage=1">
								<img src="/QM/ImgServlet?imgurl=${goodList[2].imgurl }" style="cursor: pointer;"/>
								<!--  <img src="${goodList[2].imgurl }" alt="" />-->
									<p>商品：${goodList[2].name }</p>
									<div class="bazaar_news">
										详 情
									</div>
								</a>
							</li>
							<li>
								<a href="/QM/BazaarList?thispage=1">
								<img src="/QM/ImgServlet?imgurl=${goodList[3].imgurl }" style="cursor: pointer;"/>
								<!-- <img src="${goodList[3].imgurl }" alt="" /> -->
									<p>商品：${goodList[3].name }</p>
									<div class="bazaar_news">
										详 情
									</div>
								</a>
							</li>
							<li>
								<a href="/QM/BazaarList?thispage=1">
								<img src="/QM/ImgServlet?imgurl=${goodList[4].imgurl }" style="cursor: pointer;"/>
								<!--  <img src="${goodList[4].imgurl }" alt="" />-->
									<p>商品：${goodList[4].name }</p>
									<div class="bazaar_news">
										详 情
									</div>
								</a>
							</li>
							<li>
								<a href="/QM/BazaarList?thispage=1">
								<img src="/QM/ImgServlet?imgurl=${goodList[5].imgurl }" style="cursor: pointer;"/>
								<!-- <img src="${goodList[5].imgurl }" alt="" /> -->
									<p>商品：男装${goodList[5].name }</p>
									<div class="bazaar_news">
										详 情
									</div>
								</a>
							</li>
						</ul>
					</div>
					<div class="arrow">
						<a href="javascript:;" class="arrow_item next" id="arrow_next1"></a>
					</div>
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
			<!--结尾-->
		</div>

</body>
</html>