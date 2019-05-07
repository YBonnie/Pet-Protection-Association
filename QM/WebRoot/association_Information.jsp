<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>协会咨询</title>
    <link rel="stylesheet" type="text/css" href="css/animate.css" />
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<script src="js/jquery-1.9.1.min.js"></script>
		<script src="js/wow.js"></script>
		<script src="js/indexWow.js"></script>
		<script src="js/reset.js"></script>
		<script src="js/index.js"></script>
		<script>
			function changePage(obj){
  			if(isNaN(obj.value)){
  				alert("必须是数字!");
  				obj.value=${page.thispage}
  				return;
  			}else{
  				window.location.href="/QM/NewsList1?thispage="+obj.value;
  			}
  		}
		</script>
</head>
<body>
  			<div class="main">
			<!--logo栏-->
			<div class="logo">
				<div class="logo_box"></div>
				<div class="Login_box clearfix">
					<a href="sign_In.html" class="Member_login">会员登录</a>
					<a href="register.html" class="Membership_registration">会员注册</a>
					<a href="administrator_Login.html" class="Administrator_login">管理员登录</a>
					
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
							<input class="search fl" id="kuang" name="search" type="text" value="${search }" placeholder="  站内资讯" />
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
				<a href="/QM/NewsList?thispage=1">&nbsp;&nbsp;新闻中心&nbsp;&nbsp;</a>
				<span> > </span>
				<a class="active" href="/QM/NewsList1?thispage=1">&nbsp;&nbsp;协会资讯&nbsp;&nbsp;</a>
			</div>

			<!--新闻内容-->
			<div class="content wow fadeInUp" data-wow-duration="4s">
				
				<div class="new_box wow fadeInUp" data-wow-duration="4s">
					<ul>
						<c:forEach items="${requestScope.page.list}" var="news">
						<li class="">
							<a href="/QM/newsContent?id=${news.id}" target="_blank" title="“尊重生命 宠爱童行” 儿童与宠物相处安全教育项目">
									<img src="/QM/ImgServlet?imgurl=${news.news_img }" width="234" height="159" alt="“尊重生命 宠爱童行” 儿童与宠物相处安全教育项目">
								<p class="news-title">
									${news.news_titles }
								</p>
								<p class="news-time">
									发布日期：${news.news_time}
								</p>
								<p>
									${news.news_content}
								</p>
							</a>
						</li>
						</c:forEach>
						
					</ul>
				<div class="ep-pages">		
					  	<a>共${page.countrow }条记录</a>
					  	<a>共${page.countpage }页</a>
					  	<a href="/QM/NewsList1?thispage=${page.firstpage}&&search=${search}">首页</a>
					  	<a href="/QM/NewsList1?thispage=${page.prepage}&&search=${search}">上一页</a>
					  	
					  	<!-- 分页逻辑开始 -->
					  	<c:if test="${page.countpage<=5}">
					  	
					  		<c:set var="begin" value="1" scope="page"></c:set>
					  		<c:set var="end" value="${page.countpage}" scope="page"></c:set>
					  		
					  	</c:if>
					  	<c:if test="${page.countpage>5}">
					  		
							<c:choose>
								<c:when test="${page.thispage<=3}">
									<c:set var="begin" value="1" scope="page"></c:set>
					  				<c:set var="end" value="5" scope="page"></c:set>
								</c:when>
								<c:when test="${page.thispage>=page.countpage-2}">
									<c:set var="begin" value="${page.countpage-4}" scope="page"></c:set>
					  				<c:set var="end" value="${page.countpage}" scope="page"></c:set>
					  			</c:when>
					  			<c:otherwise>
					  				<c:set var="begin" value="${page.thispage-2}" scope="page"></c:set>
					  				<c:set var="end" value="${page.thispage+2}" scope="page"></c:set>
					  			</c:otherwise>
							</c:choose>
							
					  	</c:if>
					  	
					  	<c:forEach begin="${begin}" end="${end}" step="1" var="i">
					  
					  		<c:if test="${i == page.thispage}">
					  			<a class="current">${i }</a>
					  		</c:if>
					  		
					  		<c:if test="${i != page.thispage}">
					  			<a href="/QM/FindNewsList?thispage=${i}&&search=${search}">${i }</a>
					  		</c:if>
					  	</c:forEach>
					  	
					  	<!-- 分页逻辑结束 -->
					  	
					  	<a href="/QM/NewsList1?thispage=${page.nextpage }&&search=${search}">下一页</a>
					  	<a href="/QM/NewsList1?thispage=${page.lastpage }&&search=${search}">尾页</a>
					  	<a>跳到<input type="text" value="${page.thispage}" style="width: 40px" onchange="changePage(this)"/>页</a>
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

			<!--结束-->
		</div>
  	
</body>
</html>