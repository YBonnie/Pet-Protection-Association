<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>商品详情</title>
     <link rel="stylesheet" type="text/css" href="css/animate.css" />
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<script src="js/jquery-1.9.1.min.js"></script>
		<script src="js/wow.js"></script>
		<script src="js/indexWow.js"></script>
		<script src="js/reset.js"></script>
		<script type="text/javascript">
					 		function changeNum(id,obj,oldnum){
					 			if(!/^[1-9]\d*$/.test(obj.value)){
					 				alert("购买数量必须为正整数!");
					 				obj.value=oldnum;
					 				return;
					 			}
					 			window.location.href="/QM/ChangeCartServlet?id="+id+"&total_number="+obj.value;
					 		}
					 	</script>
		
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
			</div>

			<!--content-->
			<div class="content wow fadeInUp" data-wow-duration="4s">
				<h1 class="wow bounceInLeft" data-wow-duration="3s">购物车 <span style="float:right;">
						 <a class="shoppingBtn" href="/QM/OrderListServlet">查询订单</a>
				         <a class="shoppingBtn" href="/QM/BazaarList?thispage=1">继续购物</a>
  		                 <a class="shoppingBtn" href="/QM/ClearCartServlet">清空购物车</a>
  		                 </span>
				</h1>
				
					<ul class="shopping_item wow fadeInUp" data-wow-duration="4s">
				<c:if test="${not empty sessionScope.cartmap}">
				<c:if test="${empty sessionScope.cartmap}">
	  		            <a href="/QM/BazaarList?thispage=1">购物车空空如也,请先去挑点东西吧~~~</a>
	  	         </c:if>
						<li>
							<div class="car_theader clearfix">
								<div class="item_info fl">
									<div class="inner">商品信息</div>
								</div>
								<div class="unit-price fl">
									<div class="unit_name">商品名称</div>
								</div>
								<div class="unit-price fl">
									<div class="unit_price">单价</div>
								</div>
								<div class="amount fl">
									<div class="amount_box">数量</div>
								</div>
								<div class="amount fl">
									<div class="data">库存状态</div>
								</div>
								<div class="sum-price fl">
									<div class="sum_price">总金额</div>
								</div>
								<div class="operation fl">
									<div class="operation_box">操作</div>
								</div>
							</div>
						</li>
						
						<c:set var="money" value="0" />
			        <c:forEach items="${sessionScope.cartmap}" var="entry">
					
						
						<li class="item_box clearfix">
							<div class="item_img fl">
								<img src="/QM/ImgServlet?imgurl=${entry.key.imgurl }" alt="" />
							</div>
							<div class="item_infor fl">
								<p>${entry.key.name }</p>
							</div>
							<div class="item_unit fl">
								<p><span>¥</span> ${entry.key.price }</p>
							</div>
							<div class="item_num fl">
								<p><input type="text" value="${entry.value }" style="width: 30px" onchange="changeNum('${entry.key.id }',this,${entry.value })"/>件</p>
							</div>
							<div class="item_sum fl">
								<p>
									<c:if test="${entry.value <= entry.key.total_number}">
								      <font color="blue">有货</font>
							  		</c:if>
									<c:if test="${entry.value > entry.key.total_number}">
										<font color="red">缺货</font>
									</c:if>
								</p>
							</div>
							<div class="item_sum fl">
								<p><span>¥</span>${entry.key.price * entry.value }元
						       <c:set var="money" value="${money + entry.key.price * entry.value }"/></p>
							</div>
							<div class="item_operation fl">
								<p class="delect_item"><a class="delect_item_a" href="/QM/DelCartServlet?id=${entry.key.id }">删 除</a></p>
							</div>
						</li>
						
						
				</c:forEach>
						
					</ul>				
						<div class="sum_box wow fadeInUp" data-wow-duration="4s">
							<a href="bill_Page.jsp"><div class="allsum_money fr" id="allsum_money">结 算</div></a>
							<div class="allsum fr">合计：<span>${money }元</span></div>
						</div>
					</c:if>
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
						  <select >
						    <option value="#"> 友 情 链 接</option>
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