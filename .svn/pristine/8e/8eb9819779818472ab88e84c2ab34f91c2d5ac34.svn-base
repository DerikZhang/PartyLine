<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>注册界面</title>

<link rel="stylesheet" type="text/css" href="${ctx }/resources/static/css/bootstrap.min.css" />

<style type="text/css">
html,body {
	height: 100%;
}
.box {
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /*  IE */
	background-image:linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	
	margin: 0 auto;
	position: relative;
	width: 100%;
	height: 100%;
}
.login-box {
	width: 100%;
	max-width:500px;
	height: 400px;
	position: absolute;
	top: 50%;

	margin-top: -200px;
	/*ÉèÖÃ¸ºÖµ£¬ÎªÒª¶¨Î»×ÓºÐ×ÓµÄÒ»°ë¸ß¶È*/
	
}
@media screen and (min-width:500px){
	.login-box {
		left: 50%;
		/*ÉèÖÃ¸ºÖµ£¬ÎªÒª¶¨Î»×ÓºÐ×ÓµÄÒ»°ë¿í¶È*/
		margin-left: -250px;
	}
}	

.form {
	width: 100%;
	max-width:500px;
	height: 275px;
	margin: 25px auto 0px auto;
	padding-top: 25px;
}	
.login-content {
/* 	height: 300px; */
	height: 100%+50px;
	width: 100%;
	max-width:500px;
	background-color: rgba(255, 250, 2550, .6);
	float: left;
}		
	
	
.input-group {
	margin: 0px 0px 30px 0px !important;
}
.form-control,
.input-group {
	height: 40px;
}

.form-group {
	margin-bottom: 0px !important;
}
.login-title {
	padding: 20px 10px;
	background-color: rgba(0, 0, 0, .6);
}
.login-title h1 {
	margin-top: 10px !important;
}
.login-title small {
	color: #fff;
}

.link p {
	line-height: 20px;
	margin-top: 30px;
}
.btn-sm {
	padding: 8px 24px !important;
	font-size: 16px !important;
}
</style>


<script type="text/javascript" src="${ctx }/resources/static/js/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/static/js/jquery/jquery.cookies.2.2.0.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/static/js/common.js"></script>
<script type="text/javascript">
	var partyID = "<%=request.getParameter("partyID")%>";
	alert("<%=request.getParameter("partyID")%>");
	var cookietime = new Date(); 
	var regPhone = /^((\+?86)|(\(\+86\)))?1[3,5,8]\d{9}$/;
	var regvCode = /[0-9]{6}/;
// 	cookietime.setTime(date.getTime() + (60 * 60 * 1000));//coockie保存一小时
<%-- 	$.cookie('partyID',"<%=request.getParameter("partyID")%>",{expires:cookietime}); --%>
	var cookietime = 7;
	alert("loading");
	$(document).ready(function() {
		$("#getVerCode").bind("click", function() {
			alert("getVerCode click");
			var phoneNumber = $("#phone_number").val();
			if (phoneNumber == null || phoneNumber == "") {
				alert("电话号码不能为空");
			} else if (!regPhone.test(phoneNumber)) {
				alert("电话号码格式不正确");
			} else if (ajaxSendrVerCode(phoneNumber)) {
				alert("验证码发送成功");
			}else{
				alert("验证码获取失败");
			}

		});
		
		
	});
	function checkValid() {
		var regPhone = /^((\+?86)|(\(\+86\)))?1[3,5,8]\d{9}$/;
		var regvCode = /^\d{6}$/;
		var phoneNumber = $("#phone_number").val();
		var password = $("#password").val();
		var passwordConfirm = $("#passwordConfirm").val();
		var ver_code = $("#ver_code").val();
		if (phoneNumber == null || phoneNumber == "") {
			alert("电话号码不能为空");
			$("#phone_number").focus();
			return false;
		} else if (!regPhone.test(phoneNumber)) {
			alert("电话号码格式不正确");
			$("#phone_number").focus();
			return false;
		} else if (password != passwordConfirm) {
			alert("密码不一致");
			$("#pwdConfirm").focus();
			return false;
		} else if (!regvCode.test(ver_code)) {
			alert(ver_code);
			alert("验证码必须是六位数字");
			$("#ver_code").focus();
			return false;
		} else {
			$.cookie('phoneNumber',phoneNumber,{expires:cookietime});
			$.cookie('password',password,{expires:cookietime});
			return true;
		}
	}
	

	
</script>

</head>

<body>
<div class="box">
		<div class="login-box">
			<div class="login-title "style="text-align:center">
				<h1><small>注册</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form action="${ctx}/sign/web" method="post" onsubmit="return checkValid();">
				<div class="form-group">
					<div class="col-xs-12" style="padding-right:50px;padding-left:50px;">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input style="width:80%" type="text" id="phone_number" name="phone_number" class="form-control" placeholder="手机号码" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  " style="padding-right:50px;padding-left:50px;">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input maxlength="6" type="text" id="ver_code" name="ver_code" class="form-control" placeholder="验证码" />
							<button id="getVerCode" type="button" style="height: 40px;">获取验证码</button>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  " style="padding-right:50px;padding-left:50px;">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" id="password" name="password" class="form-control" placeholder="密码" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  " style="padding-right:50px;padding-left:50px;">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" id="passwordConfirm" name="passwordConfirm" class="form-control" placeholder="密码确认" />
						</div>
					</div>
				</div>
				<div class="form-group form-actions">
					<div class="col-xs-4 col-xs-offset-4 ">
						<input type="submit" style="width:103px"  class="btn btn-sm btn-info" value="注册" />
						<a href="${ctx}/login">
							<button style="width:120px" type="button" class="btn btn-sm btn-info">
								返回登录
							</button>
						</a>
					</div>
				</div>
<!-- 				<div class="form-group"> -->
<!-- 					<div class="col-xs-6 link"> -->
<!-- 						<p class="text-center remove-margin"><small>忘记密码？</small> <a href="javascript:void(0)" ><small>找回</small></a> -->
<!-- 						</p> -->
<!-- 					</div> -->
<!-- 					<div class="col-xs-6 link"> -->
<!-- 						<p class="text-center remove-margin"><small>还没注册?</small> <a href="javascript:void(0)" ><small>注册</small></a> -->
<!-- 						</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</form>
			</div>
		</div>
	</div>
</div>

<div style="text-align:center;">
</div>

</body>
<script type="text/javascript">
// $("#getVerCode").bind("click", function() {
// 	var phoneNumber = $("#phone_number").val();
// 	if (phoneNumber == null || phoneNumber == "") {
// 		alert("电话号码不能为空");
// 	} else if (!regPhone.test(phoneNumber)) {
// 		alert("电话号码格式不正确");
// 	} else if (ajaxSendrVerCode(phoneNumber)) {
// 		alert("验证码发送成功");
// 	}else{
// 		alert("验证码获取失败");
// 	}

// });
</script>
</html>