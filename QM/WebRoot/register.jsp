<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>会员注册界面</title>
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
				<a class="active" href="sign_In.jsp">&nbsp;&nbsp;会员登录&nbsp;&nbsp;</a>
			</div>

			<!--content-->
			<div class="content wow fadeInUp" data-wow-duration="4s">
				<h1 class="wow fadeInUp" data-wow-duration="4s">会员登录</h1>
				<div class="register wow fadeInUp" data-wow-duration="4s">
					<div class="register_box wow bounce" data-wow-duration="4s">
						<!--用户账户和密码的表单-->
						<h2 class="h2_1">欢迎您，请注册</h2>
							<form id="form2" name="form2" action="/QM/Register" onsubmit=""  method="POST" >
								<p class="p7"><span>登录账户：</span><input type="text" name="username" id="" value="" required="required" title="登录账户不能为空,请输入6-16数字、字母、下划线" pattern="[0-9A-Za-z]{6-16}"  placeholder="账户名"/></p>
								<p class="p8"><span>用户密码：</span><input type="password" name="password1" id="" value="" maxlength="6" required="required" title="用户密码不能为空,请输入6位数字、字母" pattern="[0-9a-zA-Z]{6}" placeholder="6位数密码"/></p>
								<p class="p9"><span>确定密码：</span><input type="password" name="password2" id="" value=""required="required" title="请与密码保持一致" pattern="[0-9A-Za-z]{6}" placeholder="6位数密码"/></p>
								<p class="p10"><span>真实姓名：</span><input type="text" name="truename" id="" value="" required="required" title="请输入真实姓名" placeholder="姓名"/></p>
								<p class="p11"><span>身份证号：</span><input type="text" name="chineseId" id="" value="" required="required" title="请输入身份证号" placeholder="身份证号" pattern="^([0-9]){7,18}(x|X)?$"/></p>
								<p class="p12"><span>电子邮箱：</span><input type="text" name="email" id="" value="" required="required" title="请输入邮箱号码" placeholder="邮箱号码" pattern="^([a-zA-Z0-9_\.\-]+)@([a-zA-Z0-9_\.\-]+)\.([a-zA-Z]{2,4})$"/></p>
								<p class="p13"><span>联系方式：</span><input type="text" name="phone" id="" value="" maxlength="11" placeholder="手机号码" required="required" title="请输入11位手机号码" pattern="^((13)|(15)|(18)|(17)|(19))\d{9}$"/></p>
								<p>
									<input type="submit" name="" id="register_submit" class="register_submit" value="注册" />
									<input type="reset" name="" id="register_reset" class="register_reset" value="重 置" />
								</p>
							</form>
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
              	   <a class="code fr" href=""><img  src="media/images/code.png" alt="" /><p>协会二维码2</p></a>
					   <a class="code fr" href=""><img  src="media/images/code1.png"  alt="" /><p>协会二维码1</p></a>				
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