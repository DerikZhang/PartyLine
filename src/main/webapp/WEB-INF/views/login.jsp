<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>登录界面</title>

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
	/*设置负值，为要定位子盒子的一半高度*/
	
}
@media screen and (min-width:500px){
	.login-box {
		left: 50%;
		/*设置负值，为要定位子盒子的一半宽度*/
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
<script type="text/javascript">
	if ($.cookie('phoneNumber') != null) {
		$("#phone_number")[0].innerHTML = $.cookie('phoneNumber');	
		if ($.cookie('password') != null) {
			$("#password")[0].innerHTML = $.cookie('password');
		}
	}
	if($.cookie('partyID')!=null){
		$("#partyID")[0].innerHTML = $.cookie('partyID');
	};
</script>
</head>

<body>
<div class="box">
		<div class="login-box">
			<div class="login-title "style="text-align:center">
				<h1><small>登录</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form action="${ctx}/login/web"  method="post">
				<div class="form-group">
					<div class="col-xs-12  "style="padding-right:50px;padding-left:50px;">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" value="" id="phone_number" name="phone_number" class="form-control" placeholder="电话号码" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  "style="padding-right:50px;padding-left:50px;">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="text" id="password" value=""  name="password" class="form-control" placeholder="密码" />
						</div>
					</div>
				</div>
				<div class="form-group form-actions">
					<div class="col-xs-4 col-xs-offset-4 "style="padding-right:50px;padding-left:50px;">
						<button type="submit" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-off"></span> 登录</button>
					</div>
				</div>
				<input type="hidden" id="location"/>
				<div class="form-group">
					<div class="col-xs-6 link"style="padding-right:50px;padding-left:50px;">
						<p class="text-center remove-margin"><small>忘记密码？</small> <a href="javascript:void(0)" ><small>找回</small></a>
						</p>
					</div>
					<div class="col-xs-6 link"style="padding-right:50px;padding-left:50px;">
						<p class="text-center remove-margin"><small>还没注册?</small> <a href="${ctx}/sign" ><small>注册</small></a>
						</p>
					</div>
				</div>
				<inpupt type="hidden" id="partyID" value=""/>
			</form>
			</div>
		</div>
	</div>
</div>

<div style="text-align:center;">
</div>

</body>

</html>