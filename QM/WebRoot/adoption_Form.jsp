<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>领养表格</title>
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
  			<div class="main1">
  			
  			
			<div class="adoption_form_box wow fadeInUp" data-wow-duration="4s">
				<h3 class="h3-head">
                  <div class="title">领养申请表</div>
				</h3>
				<div class="clearfix"></div>
				<form action="/QM/AdoptionList" method="post" class="form_box" enctype="multipart/form-data">
					<input type="hidden" value="${sessionScope.user2.id }" name="id"/>
					<ul>
				
						<li id="form_tip" class="form_tip">
							<span>根据你的过往填写记录，已为你自动填充表单，
							<a class="btn_clear" id="btn_clear" onclick="clearInput()" >点击清除</a>
						</span>
						</li>
						<li id="li_name" class="li_name">
							<div class="control-group">
								<label class="control-label">姓名&nbsp;<span style="color:red">*</span></label>
								<div class="controls">
									<input class="form-control" type="text" name="aptName" id="name" value="" require="true" datatype="require" msg="必填 " lastvalue="你很美">
									<div class="clearfix"></div>
								</div>
							</div>
						</li>
						<li id="li_gender" class="">
							<div class="control-group">
								<label class="control-label">性别&nbsp;<span style="color:red">*</span></label>
								<div class="controls">
									<label id="label_option_gender" class="radio"><input require="true" datatype="group" min="1" msg="必填 " type="radio" name="aptGender" id="" value="男"> 男</label>
									<label id="label_option_gender" class="radio"><input require="true" datatype="group" min="1" msg="必填 " type="radio" name="aptGender" id="" value="女"> 女</label>
									<div class="clearfix"></div>
								</div>
							</div>
						</li>
						<li id="li_identity_id" class="">
							<div class="control-group">
								<label class="control-label">身份证号&nbsp;<span style="color:red">*</span></label>
								<div class="controls">
									<input class="form-control" type="text" name="aptId" id="identity_id" value="" require="true" datatype="idcard" msg=" 格式有误">
									<div class="clearfix"></div>
								</div>
							</div>
						</li>
						<li id="li_birthday" class="">
							<div class="control-group">
								<label class="control-label">出生日期&nbsp;<span style="color:red">*</span></label>
								<div class="controls">
									<input type="text" class="form-control" name="aptBirthday" id="aptBirthday" value="" require="true" datatype="require" msg="必填 ">
									<div class="clearfix"></div>
								</div>
							</div>
						</li>
						<li id="li_address_id" class="">
							<div class="control-group">
								<label class="control-label">居住地址&nbsp;<span style="color:red">*</span></label>
								<div class="controls">
									<input class="form-control" type="text" name="aptAddress" id="aptAddress" value="" require="true" datatype="require" msg="必填 ">
									<div class="clearfix"></div>
								</div>
							</div>
						</li>
						<li id="li_mobile" class="">
							<div class="control-group">
								<label class="control-label">手机&nbsp;<span style="color:red">*</span></label>
								<div class="controls">
									<input class="form-control" type="text" name="aptMobile" id="aptMobile" value="" require="true" datatype="require" msg=" 格式有误">
									<div class="clearfix"></div>
								</div>
							</div>
						</li>
						<li id="li_email" class="">
							<div class="control-group">
								<label class="control-label">邮箱&nbsp;<span style="color:red">*</span></label>
								<div class="controls">
									<input class="form-control" type="text" name="aptEmail" id="aptEmail" value="" require="true" datatype="email" msg=" 格式有误">
									<div class="clear"></div>
								</div>
							</div>
						</li>
						<li id="li_images" class="li_images">
							<div class="control-group">
								<label class="control-label">上传相关证明&nbsp;<span style="color:red">*</span></label>
								<div class="muted">注：<br> 产权房：请提供房产证复印件；
									<br> 独立租房： 请提供租房协议复印件及房主同意书；<br> 合租房： 请提供租房协议复印件、房主同意书及其他合租人员的同意书。<br> *图片格式： .jpg 。</div>
								<div class="controls">
									<input class="form-control" type="file" name="aptImage" id="aptImage" value="" require="true" datatype="image" msg="必填 ">
									<div class="clearfix"></div>
								</div>
							</div>
						</li>
						<li id="li_pet_name" class="">
							<div class="control-group">
								<label class="control-label">宠物姓名&nbsp;<span style="color:red">*</span></label>
								<div class="controls">
									<input class="form-control" type="text" name="pet_name" id="pet_name" value="" require="true" datatype="pet_name" msg="必填 ">
									<div class="clear"></div>
								</div>
							</div>
						</li>
						<li id="li_pet_id" class="">
							<div class="control-group">
								<label class="control-label">宠物芯片&nbsp;<span style="color:red">*</span></label>
								<div class="controls">
									<input class="form-control" type="text" name="pet_id" id="pet_id" value="" require="true" datatype="pet_id" msg="必填 ">
									<div class="clear"></div>
								</div>
							</div>
						</li>

					</ul>
					<input class="form_btn" type="submit" value="领养提交" />
				</form>

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
		</div>
  	
</body>
</html>