<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>账单页面</title>
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
				<a href="/QM/BazaarList?thispage=1">&nbsp;&nbsp;线上义卖&nbsp;&nbsp;</a>
				<span> > </span>
				<a href="/QM/AddShoppingCar">&nbsp;&nbsp;购物车&nbsp;&nbsp;</a>
				<span> > </span>
				<a href="/QM/OrderListServlet" class="active">&nbsp;&nbsp;订单页面&nbsp;&nbsp;</a>
			</div>

			<!--新闻内容-->
			<div class="content">
				<h1>订单页面  
						 <span style="float:right;">
						 <a href="/QM/OrderListServlet">查询订单</a>
				         <a href="/QM/BazaarList?thispage=1">继续购物</a>
  		                 <a href="/QM/ClearCartServlet">清空购物车</a>
  		                 </span>
  		        </h1>
				<div class="bill_Interface clearfix wow fadeInUp" data-wow-duration="4s" id="bill_Interface">
					<table class="table_1" id="table_1" border="" cellspacing="" cellpadding="">
						<tr>
							<th>商品图片</th>
							<th>商品名称</th>
							<th>单价</th>
							<th>数量</th>
							<th>库存状态</th>
							<th>总价</th>
						</tr>
						<c:set var="money" value="0" />
			        <c:forEach items="${sessionScope.cartmap}" var="entry">
						<tr>
							<td><img src="/QM/ImgServlet?imgurl=${entry.key.imgurl }"/></td>
							<td><span>${entry.key.name }</span></td>
							<td><span>¥</span><span>${entry.key.price }</span></td>
								<td><span>${entry.value }件</span></td>
							<td>
								<span>
									<c:if test="${entry.value<=entry.key.total_number}">
									   <font color="blue">有货</font>
									</c:if>
									<c:if test="${entry.value>entry.key.total_number}">
										<font color="red">缺货</font>
									</c:if>
								</span>
							</td>
							<td>
								<span>${entry.key.price * entry.value }元
							        <c:set var="money" value="${money + entry.key.price * entry.value }"/>
							    </span>
						   </td>			
						</tr>
					</c:forEach>
						
					</table>
					<div align="right">
							<font color="red" size=6">总价:${money }元</font>
						</div>
					
					<form action="/QM/AddOrderServlet" method="post">
				  	 <div class="conaction_box" id="address_box">		
							 <p class="conaction_box1" id="conaction_box3">
								<span>收货人姓名：</span>
								<input type="text" name="receivername" id="contact_Infor" class="contact_Infor" />
							</p>
							<p class="conaction_box2" id="conaction_box2">
								<span>联 系 方 式  ：</span>
								<input type="text" name="receiverphone" id="contact_Infor" class="contact_Infor" />
							</p>
							<p class="conaction_box3" id="conaction_box1">
								<span>收货人地址：</span>
								<input type="text" name="receiverinfo" id="address_info" class="address_info" value="" />
							</p>
							<p class="conaction_box4" id="conaction_box4">
								<span>支  付  方  式 ：</span>
								<input type="radio" name="typex" checked="checked" id="address_typex" class="address_typex" value="" />在线支付<br>
							</p>
							<p class="conaction_box5" id="conaction_box5">
							<input type="submit" class="subit1"  value="生成订单"/>
							</p>
						</div> 
				  		
				  		
				  	</form>
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