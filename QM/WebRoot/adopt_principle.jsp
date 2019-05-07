<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>救助原则</title>
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
				<a href="about_Us.jsp">&nbsp;&nbsp;协会介绍&nbsp;&nbsp;</a>
				<span> > </span>
				<a class="active" href="adopt_principle.jsp">&nbsp;&nbsp;救助原则&nbsp;&nbsp;</a>
			</div>

			<!--content-->
			<div class="content wow fadeInUp" data-wow-duration="4s">
				<h1 class="wow fadeInUp" data-wow-duration="4s">救助原则</h1>
				<div class="paragraph wow fadeInUp" data-wow-duration="4s">
					<p>&nbsp;</p>
					<p align="center"><span style="font-size:24px;"><strong>宠物保护协会救助原则</strong></span></p>
					<p>&nbsp;</p>
					<p>
						第一救助人原则<br>
						<br> 经常接到一些求助电话，在某地发现流浪猫狗，请前去救助……面对这种情况，有必要对所有关注流浪动物的朋友进行说明，重庆小动物保护协会，是纯粹的民间救助团队，提供一个救助平台，所有资金来源均是爱心人士捐助。且救助不是某个人的事情，需要社会力量的支持与参与。我们只是一群爱动物的义工，我们没有义务为你所谓的“爱心”来买单。
						<br>
						<br> 小动物保护协会救助对象为：被人为恶意遗弃、抛弃、虐杀，伤害的小动物。
						<br>
						<br> 第一救助人：通俗来讲，即发现流浪动物并参与他整个救助过程的人。整个救助过程包括救助、安顿和领养三个过程。有人用“监护人”来概括第一救助人。
						<br> 很多人以为自己看见流浪猫狗了，然后给协会一个电话打过去，或者一个qq消息一个微博@过去就算是救助了，其实不然！真正的救助，其过程包括：发现--安顿--领养！（安顿过程中，有病、受伤的需要治疗。如果自己能力不够，可以发动网络及社会帮助）。只有完成以上过程，才能算是一个完整的救助！而很多第一发现人只做到了发现，但是除了发现外还可以送被发现的动物去医院等等。如果你发现一个需要救助的动物，只是发现了，并没有做其他相关的救助，那么，你不算是真正就救了它。
						<br> 如果你是一个爱小动物的人，请完成所有的救助过程，真正救助它们。其间我们小动物协会愿意提供各个方面的平台，最终达到小动物被完全救助的目的。
						<br>
						<br> 我是否可以圣任第一救助人？
						<br>
						<br> 如果您确实具有爱心和责任心，并且真心的希望救助您发现的流浪动物，那么，您就可以完全可以胜任第一救助人。
						<br> 你在救助过程中大部分我们是可以协助完成的，包括联系医院，募捐治疗费，后续寻找审核领养人等等。我们有庞大的义工团队，以及丰富的救助经验，相信我们，可以让您的救助工作变得简单轻松。
						<br>
						<br> 第一救助人需要做的事情
						<br>
						<br> 第一：发现（发现时尽量做到以下几点）
						<br> 1、远距离观察：观察被救助的流浪动物是否有行动能力；观察被救助的流浪动物是否受伤；观察被救助的流浪动物鼻头是否湿润；观察狗狗的情绪等。
						<br> 2、尝试接触：通过远距离观察后，如觉得狗狗可以亲近，可以尝试性接触。此过程需要巨大的耐心，有一定的危险性，要注意自身安全，做好防护措施，比如戴厚手套。
						<br> 3、尝试性接触狗狗后，如果狗狗接受你了，就可以找东西把狗带走。有条件的可以临时找个狗笼。
						<br>
						<br> 第二：安顿
						<br> 1、如果被救助的流浪动物没有生病，就可以临时安顿在自己家里，或者宠物店寄养的地方。
						<br> 2、如果被救助的流浪动物生病了，赶紧送医院检查、治疗。当然如果第一救助人能够自主处理好救助--治疗---领养的过程，则更好！
						<br> 3、如果第一救助人不能完成以上事项，再到协会的qq群，或者论坛进行求助，大家互相帮忙一起完成救助、领养的过程.
						<br> 4、在以上都没有更好的处理情况下，向协会求助才是作为最后的渠道！（协会目前，只对处于紧急状态的流浪动物，在协会本身有救助资源，包括人手，资金的情况下，对第一救助人尽心协助救助。）
						<br>
						<br> 第三：领养
						<br> 把所有的问题解决好了，最后当然是帮它找一个温暖的家。第一救助人可以发动自己身边所有的资源来帮它找一个温暖的家。如果实在是找不到了，小动物协会愿意帮助第一救助人寻找。
						<br>
						<br> 第一救助人需要为救助对象募捐时，请做到以下几点：
						<br>
						<br> 1、救助人须告知医疗所需的费用，并至少负担部分的医疗费用。
						<br> 2、凡在“重庆小动物保护协会”求助募捐，我们将用协会账户统一收付，求助人不得公布自己帐户。
						<br> 3、救助人需至少每3-5天公布更新一次救助情况和照片。
						<br> 4、结案后，协会会公布医院收费明细和单据，若有剩余，转入救助基金。
						<br>
						<br> 什么情况下协会才会介入第一救助人的救助？
						<br> 第一：所有救助过程应尽量由第一救助人来完成，协会负责其中的指引，并提供互相交流，互助，发布领养信息的平台！
						<br> 第二：第一救助人因为各种原因无法完成救助过程，协会才会进行直接的参与。
						<br>
						<br> 题外话：
						<br> 如果我们能够发动一千个热心的第一救助人参与，即一天内可以救助一千只流浪动物，而如果完全指望协会就的话，一千只流浪猫狗进来，任何一个协会都会直接垮掉！
						<br>
						<br> 协会协助第一救助人救助动物原则：
						<br> 一、因财力、人力所限，遵循谁救的动物谁负责的原则，协会支持多人合作救助一只动物，以保持救助的持续性，也可减轻第一救助人的负担。协会负责提供联系宠物医院，所产生的治疗费用由第一救助人承担，在第一救助人能力有限的情况下，我们可以帮忙呼吁募捐一部分。
						<br> 二、第一救助人应主动负责对所救流浪猫、狗上网发帖、寻找领养人，在被救猫狗被领养后，应主动加入和我们的义工进行跟踪回访，并做好回访记录。
						<br> 三、对身体残疾、生活无法自理、治疗费用较高等，第一救助人如果有能力应主动承担其长期的生活及治疗费用，也可以求助协会号召多人救助一只猫、狗，一起分担医疗和助养的费用。避免将所有费用落在一个人身上。如果第一救助人经济上无法单独承担，可以向协会申请网上进行募捐。
						<br> 四、经治疗痊愈且已注射疫苗及绝育的猫狗，如仍未被领养的，可考虑由协会暂时寄养，但暂寄期间如猫狗如果出现问题还需第一救助人协助协会解决，并每月支付150元寄养费用，用于支付狗狗的日常开支，若经济实在困难，协会可酌情考虑。
						<br>
						<br> 给救助人的一封信
						<br> 亲爱的朋友：
						<br> 非常感谢您关注身边的流浪动物，并愿意向它们伸出援助之手，给它们一次重生的机会。也非常感谢您对协会的信任，其实我们和您一样，也是普通的爱动物人士，只是自发的组织在一起，没有政府和财团的支持，所以的一切都是由义工们无偿承担。
						<br> 动物救助不是某个人的责任，而是全社会的责任，需要大家共同参与，为这些无助的生命撑起一片避风的港湾，所以我们需要您的支持和理解。我们也和您一样，深深体会到救助一只动物的不易和困难，正因为如此，我们非常乐意给予您帮助，但请不要将责任完全推给我们，因为我们能力有限，过多的责任只会让我们举步维艰，甚至面临无法维持的困境。
						<br> 一个人救助一只动物是快乐轻松的，可是如果是十只，上百只呢？这样的困难和压力又有谁能承受？又有谁知道一只猫、狗从救助到领养，这期间需要花费多少时间、精力、金钱和感情？而一只没有领养前途的猫、狗，更是我们永远的责任。我们恳请，当您想把猫、狗交给我们时，请想想我们的难处，请在自己能力范围内接受我们的《第一救助人原则》，如果您能力有限，我们可以一起帮您解决分担，但请不要一走了之，不闻不问，你的冷漠会让等待救助的动物和我们感到心灰意冷。正因为有越来越多善良的人的加入，我们才能步履艰难地走到今天，如果您真的愿意帮助这些可怜的动物，请与我们站在一起，分担救助中的困难，共享狗狗们带给我们的快乐！
						<img src="media/images/dong_1.jpg" alt=""  />
					</p>
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