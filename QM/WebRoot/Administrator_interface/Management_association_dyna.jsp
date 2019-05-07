<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>管理协会动态</title>
		<link rel="stylesheet" type="text/css" href="./css/Administrator_interface.css" />
		<link rel="stylesheet" type="text/css" href="./css/reset.css" />
<script type="text/javascript">
		  		function checkAll(allC){
		  			var otherCs = document.getElementsByName("delId");
		  			for(var i=0;i<otherCs.length;i++){
		  				otherCs[i].checked = allC.checked;
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
					
					<a href="/QM/IndexList" class="Member_login">回到首页</a>
				    <a href="administrator_Login.jsp" class="Administrator_login">管理员登录</a>
				      <c:if test="${sessionScope.admin2 != null}">
							<div class="welcome fr" id="welcome">
								欢迎回来：<span>${sessionScope.admin2.ad_name}</span>
								<a href="/QM/AdminInfoServlet?id=${admin2.id }" class="welcome_edit">编辑</a>
								<a href="/QM/AdminLogoutServlet" class="welcome_edit">注销</a>
							</div>
			          </c:if>
					<!--搜索框-->
					<div class="sousuo fr" id="sousuo">
						<form action="/QM/FindNewsTitle" method="post">
							<input class="search fl" id="kuang" name="FindNewsTitle" type="text" placeholder="  站内新闻资讯" />
							<input class="search_submit fr" name="search_submit" type="submit" value="" />
						</form>
					</div>
				</div>
			</div>
			<!--导航栏-->
			<div class="navBar_1">
				<ul class="nav_1 clearfix">
					<li class="nav_active_1">
						<a href="/QM/AdminNewsServlet">新闻管理</a>
					</li>
					<li>
						<a href="/QM/AdminDynaServlet">动态管理</a>
					</li>
					<li>
						<a href="/QM/AdminUserServlet">用户管理</a>
					</li>
					<li>
						<a href="/QM/AdminPetsServlet">宠物管理</a>
					</li>
					<li>
						<a href="/QM/AdminAdoptionServlet">领养管理</a>
					</li>
					<li>
						<a href="/QM/AdminGoodsServlet">商品管理</a>
					</li>
					<li>
						<a href="/QM/AdminOrderServlet">订单管理</a>
					</li>
					<li>
						<a href="/QM/AdminMgmentServlet">留言管理</a>
					</li>
					<li>
						<a href="/QM/AdminAccountServlet">账目管理</a>
					</li>
				</ul>
			</div>
			<div class="content_1">
			

					<div class="check_table_1">
						<form action="/QM/FindDynaTitle"  method="post">
						<label>协会动态查询：</label>
						<input type="text" class="text_1" name="FindDynaTitle" id="FindDynaTitle" value="" placeholder="请输入动态标题" style="height:30px;" />
							<input type="submit" value="查 询" class="FindUserNameBtn">
							<a href="/QM/Administrator_interface/AdminAddDyna.jsp">
								<span class="add_btn" id="add_btn" >添加协会动态</span> 
							</a>
					</form>
					</div>
					<form action="/QM/BatchDelDynaServlet" method="POST">
					<table class="table_5" border="0">
						<tr>
						 <th><input type="checkbox" onclick="checkAll(this)"/>全选</th>
						    <th>动态图片</th>
							<th>动态标题</th>
							<th>动态时间</th>
							<th>动态内容</th>
							<th>动态链接</th>
							<th>操作</th>
						</tr>
							<c:forEach items="${requestScope.DynamicsList}" var="dynamics">
						<tr class="tbody">
						  <td><input type="checkbox" name="delId" value="${dynamics.id }" style="width:65px;" /></td>
						 <td><img src="/QM/ImgServlet?imgurl=${dynamics.dynamics_img }" style="cursor: pointer;"/></td>
							<td class="dynamicsTd" >${dynamics.dynamics_title }</td>
							<td>${dynamics.dynamics_time }</td>
							<td class="newTd" style="margin-top:20px;">${dynamics.dynamics_allcont }</td>
							<td class="dynamicsTd"><a href="/QM/dynaContentServlet?id=${dynamics.id}" style="color:red">${dynamics.dynamics_content }</a></td>
							<td>
								<a href="/QM/DelDynaServlet?id=${dynamics.id }"><span class="delect_btn" id="delect_btn">删除</span></a>
								<a href="/QM/EditDynaServlet?id=${dynamics.id }"><span class="edit_btn" id="edit_btn">修改</span></a>
							</td>
							
						</tr>
						</c:forEach>
					</table>
					<input class="BatchDelBtn" type="submit" value="批 量 删 除"/>
  			</form>
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

			
			<!--结尾-->
			
			
		</div>

</body>
</html>