<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>加入我们</title>
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
				<a href="about_Us.jsp">&nbsp;&nbsp;关于我们&nbsp;&nbsp;</a>
				<span> > </span>
				<a class="active" href="join_Us.jsp">&nbsp;&nbsp;协会介绍&nbsp;&nbsp;</a>
			</div>

				<!--content-->
			<div class="content wow fadeInUp" data-wow-duration="4s">
				<h1>协会介绍</h1>
				<div class="paragraph">
					<p>&nbsp;</p>
					<p align="center"><span style="font-size:24px;"><strong>宠物保护协会简介</strong></span></p>
					<p>&nbsp;</p>
					<p><strong>成立时间及隶属关系</strong></p>
					<p>　　宠物保护协会（Pet Protection Association）是国家一级专业性社会团体，可在全国和境外吸收会员、建立地方性组织和开展国际文化交流活动。</p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp; 协会自1988年11月开始筹备，1992年9月，经农业部批准正式成立，同年12月，经民政部注册登记（社证字第3685号）。具独立法人资格。2000年1月，又通过了清理整顿，再次注册登记。中国小动物保护协会以珍爱生命、倡导精神文明和发扬人道主义精神为思想基础，以保护动物、维护动物的生存权利和不受虐待的权利、以及改善和提高小动物的生活条件、饲养水平为宗旨，坚决反对任何虐待、残害动物的行为和思想。协会的这个宗旨，得到了文化界老前辈的支持。筹备伊始，已故的全国政协副主席、佛教界领袖、著名的书法家、诗人赵朴初先生便写来贺信，说：“成立小动物保护组织，我极为赞成”，并慷慨解囊，捐赠资金。已故的夏衍先生和冰心女士，担任了协会的名誉会长，并曾执笔作书，希望为协会募集资金。8月，农业部召开社团管理工作大会，部领导在会上的讲话中，赞扬“中国小动物保护协会的活动”，“体现了中华民族修德行善、珍爱生命的传统美德”。</p>
					<p>　　协会总部在北京，设有组织、宣传、研究、联络、开发、救护收容、医疗保健等部和办公室。二十多年来，协会在组织、宣传和救护动物等方面做了大量的工作。</p>
					<p>&nbsp;</p>
					<p><strong>协会宗旨</strong></p>
					<p>&nbsp;　　宠物保护协会以珍爱生命、倡导精神文明和发扬人道主义精神为思想基础，以保护动物、维护动物的生存权利和不受虐待的权利、以及改善和提高小动物的生命条件、饲养水平为宗旨，坚决反对任何虐待、残害动物的行为和思想。</p>
					<p>&nbsp;</p>
					<p><strong>大事记</strong></p>
					<p>　　宣传工作张扬文明，发扬人道主义精神，保障动物的生存权利和不受虐待的权利，这是中国小动物保护协会的宣传工作的主题曲。由于小动物的表帅——犬在我国的处境不幸，所以协会的宣传往往受到限制。尽管如此，协会仍通过种种方式，为灿烂的文明之光，能早日照进包括犬在内的悲惨的动物世界而奔走奋争。</p>
					<p>　　1993年，协会成立不久，便到北京市政府，向当时负责“禁犬”的单位和领导，反复陈说“禁犬”正策违反科学、文明的野蛮性和残暴性，反映珍爱生命、提倡精神文明建设的人们对灭犬行为的反感。1995年，在北京市限养法规草案讨论期间，协会曾召开各种类型座谈会达七次之多。在给市政府的意见书上，2000多人签了名。大家在拥护养犬管理原则的同时，就征收奇高的养犬费用和禁养品种以及遛犬时间规定、没收无证犬等一系列问题，都提出意见和多方面的建议。1996年11月，限养法规实施一周年之际，协会又召开邀有市执法部门有关领导参加的各界人士座谈会，就科学管理和犬费等问题交流了意见。四年之后的2000年11月，根据党的“实践是检验真理的唯一标准”的思想路线，协会再一次邀请各界知名人士和养犬人，对北京市已经实施5年的“犬限养法规”，实事求是地进行了总结。与会者，在肯定限养、管理的进步意义和成绩的同时，又反复强调高额的养犬收费标准、犬型、遛狗时间及残暴收捕无证犬的问题，提出意见和建议。几家新闻媒体也都为之作了反映。</p>
					<p>　　为了消除人们对狂犬病的恐惧心理，协会于1996年2月，举办了狂犬病国际学术研讨会，邀请国内外的专家作了专题报告。各区防疫站均曾派人参加，效果很好。同年，为了了解北京市民对养犬问题的各种态度，协会又与人民大学社会学系合作，对海淀、朝阳、崇文三区共300户养犬人和300户非养犬人做了抽样问卷调查。结果表明：现在的城区养犬者中，86%是工薪族，人均月收入多在800元以下。居民中极端厌犬、坚决反对养犬的，只占极少数。拿海淀来说，120中只有6人，占5%；朝阳区更少，150人之中只有2人，占1.3%；特别令人鼓舞的是，被调查的青少年都喜欢狗。这说明中国的动物保护事业是很有希望的。宠物保护协会在养狗问题上所做的这份调查研究，在中国历史上是首次。</p>
					<p>　　当动物们混身血污、睁大恐怖的双眼，战栗在屠刀之前、挣扎在酷刑之中的时候，宠物保护协会首次把每年的10月4日为国际所公认的“世界动物日”引进了中国人的社会生活。1996年10月4日，在农大操场成功地举办了首届世界动物日纪念周。男女老少，闻讯而至。欢度佳节的动物，活泼友善，赶来庆祝的人群，欢声笑语，无限生机，一片天真，孩子们在各条爱护动物的标语布上争先签名，老人们抱着自己的爱犬，热泪盈眶。这是当年意大利的一位牧师费朗西斯在西西里岛创造的人与小动物和谐、亲善相处的“天堂”图景，也是今日文明曙光中所展示的未来世界。</p>
					<p>　　但纪念周活动中的这种欢笑和美好，只是小小天地中的一瞬，只能是希望的象征。可悲的现实是，广大动物仍在血泊中呻吟。中国如此，世界如此。1999年5月，就小动物的生存现状，协会曾和美国动物与环境保护协会聚首北京，对于共同关注、探讨的问题亲切地交流了经验。</p>
					<p>&nbsp;</p>
					<p><strong>经验教训</strong></p>
					<p>　　救护动物救护动物的实践是体现协会宗旨的重要方式之一。十多年来，我们在备历艰辛，受尽磨难的情况下，共救护了三百多条狗和三百多只猫，还有鸟类、兔和国家二级保护动物猕猴等等。至今，还有四百多条生命生活在我们的爱心教育基地。这样持久地、远远超过负荷地救护和收容动物，使协会更加步履艰难，困苦不堪。但是，当被截去舌头的“运儿”、被重击昏死的“黑子”、浑身流脓的可卡“罗奇”、双目失明被抛弃荒郊的“丢丢”、被主人弃置于医院的“豆豆”、瘫痪了的“大、小卫卫”、“欢欢”、被摩托轧伤臀部，年轻美丽的小猫“摩拉”、两眼全瞎的白猫“阿霞”、命悬一线的猕猴“苍苍”等等，一个个从死亡线上回来，重新恢复了旺盛的生命力的时候，我们不仅感到欣慰，而且不断体验到生命复苏的欢乐。同时，踏进了这悲惨的世界，愤怒、悲悯、痛楚、正义和人生，交织成重大的“人”的内疚感、责任感，也愈益成为督促我们坚持前进、义无反顾的推动力。</p>
					<p>&nbsp;</p>
					<p><b>流浪动物基地</b></p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp; 协会的组织机构，也有很大发展。在国际动物组织的帮助下，建立了救护收容小动物的基地——爱心教育基地，结束了多年来带着动物东奔西窜的险难生活，使备受虐待摧残，被抛弃追杀的小动物们有了一座避难所。1999年，又在南京的佛门弟子的帮助下，在风景秀美的北京西山附近，租得占地十七亩之广的庭院，改善了动物的生活条件。1998年，协会还历尽艰辛，建立了小动物防疫、保健、治疗中心。解决了动物的保健、医疗问题。这两个实体，为协会的进一步发展创造了良好的条件。</p>
					<p>&nbsp;</p>
					<p><strong>会员概况</strong></p>
					<p>　　多年来，宠物保护协会尽管经历了种种险难，其组织仍然能不断发展壮大，勃发出旺盛的生命力，主要是热爱动物的知音遍而全国。现在除北京市外、上海、天津、哈尔滨等大城市和江浙、两广、四川、安徽等省都有不少热爱生活、关注小动物命运的仁人善士，加入会员的行列。其中，既有革命老前辈，也有干部、新闻工作者、职员、教师、医生、工人、农民、学生等，他们满腔热情，怀着崇高的人道主义精神，通过种种方式，给了协会以有力的支持。</p>
					<p>&nbsp;</p>
					<p><strong>传媒朋友遍天下</strong></p>
					<p>　　由于时代和敏感和倡导精神文明的责任感，我们的宣传工作，还得到新闻媒体的支持。十多年来，全国性的大报：《中国青年报》、《工人日报》、《工商时报》、《人民日报·海外版》等都有专题采访；地方性的报纸，除北京市如《北京日报》、《北京晚报》、《精品购物指南》、《经济导报》、《北京青年》、《一周便利》等报刊外，外地如《华西日报》、《上海论坛》、《羊城晚报》、《南宁早报》、《沈阳晚报》等也都有专题报道。同时，中央电视台的《东方时空》和北京电视台的“新闻部”、“专题部”、《东芝动物乐园》都把我们的工作和事迹，反映给了全国和北京市的民众。此外，基于关注动物生命的时代思潮，外国驻中国北京的媒体，如美国的《约纽时报》、《芝加哥论坛报》、美联社和CNN有线电台，英国的空中电视台、澳大利亚有线电视台、加拿大电视网有限公司、德国电视台，荷兰《人民报》都专题采访了协会珍爱生命、救护动物的情况。媒体是帮助协会营造爱心长城的重要力量。</p>
					<p>&nbsp;</p>
					<p><strong>不可更易的航向</strong></p>
					<p>　　我们的理想是崇高而现实的，我们的任务是光荣而艰辛的，我们的道理是漫长而荆棘丛生的。但我们坚信：在以科学、文明、民主、自由为主旋律的二十一世纪的社会生活中，保护环境、人与自然、人与动物应和谐相处的思想，尊重生命、珍惜生命的思想，必将成为人们的共识，并成为推动中国的动物保护事业发展壮大的巨大力量。</p>
					<p>　　我们的理想一定会实现，我们的事业必定胜利，愿一切有爱心，有良知的朋友和我们一起，携手并进，让布满动物血污的神州大地，焕发出清纯、和谐、温馨、美丽的容光。</p>
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