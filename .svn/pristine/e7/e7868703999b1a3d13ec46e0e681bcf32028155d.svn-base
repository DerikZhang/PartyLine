<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>Home</title>
<script type="text/javascript" src="${ctx }/resources/static/js/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/static/js/geocoder.js"></script>
<script type="text/javascript" src="${ctx }/resources/static/js/ajaxfileupload.js"></script>
<script type="text/javascript">//照片生成缩略图
//图片上传预览    IE是用了滤镜。
function previewImage(file)
{
  var MAXWIDTH  = 260; 
  var MAXHEIGHT = 180;
  var div = document.getElementById('preview');
  if (file.files && file.files[0])
  {
      div.innerHTML ='<img id=imghead>';
      var img = document.getElementById('imghead');
      img.onload = function(){
        var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
        img.width  =  rect.width;
        img.height =  rect.height;
//         img.style.marginLeft = rect.left+'px';
        img.style.marginTop = rect.top+'px';
      }
      var reader = new FileReader();
      reader.onload = function(evt){img.src = evt.target.result;}
      reader.readAsDataURL(file.files[0]);
  }
  else //兼容IE
  {
    var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
    file.select();
    var src = document.selection.createRange().text;
    div.innerHTML = '<img id=imghead>';
    var img = document.getElementById('imghead');
    img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
    var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
    status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
    div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
  }
}
function clacImgZoomParam( maxWidth, maxHeight, width, height ){
    var param = {top:0, left:0, width:width, height:height};
    if( width>maxWidth || height>maxHeight )
    {
        rateWidth = width / maxWidth;
        rateHeight = height / maxHeight;
         
        if( rateWidth > rateHeight )
        {
            param.width =  maxWidth;
            param.height = Math.round(height / rateWidth);
        }else
        {
            param.width = Math.round(width / rateHeight);
            param.height = maxHeight;
        }
    }
     
    param.left = Math.round((maxWidth - param.width) / 2);
    param.top = Math.round((maxHeight - param.height) / 2);
    return param;
}
</script>
<script type="text/javascript">
// $(function () {
//     'use strict';
//     // Change this to the location of your server-side upload handler:
//     var url = window.location.hostname === 'blueimp.github.io' ?
//                 '//jquery-file-upload.appspot.com/' : 'server/php/';
//     $('#fileupload').fileupload({
//         url: url,
//         dataType: 'json',
//         done: function (e, data) {
//             $.each(data.result.files, function (index, file) {
//                 $('<p/>').text(file.name).appendTo('#files');
//             });
//         },
//         progressall: function (e, data) {
//             var progress = parseInt(data.loaded / data.total * 100, 10);
//             $('#progress .progress-bar').css(
//                 'width',
//                 progress + '%'
//             );
//         }
//     }).prop('disabled', !$.support.fileInput)
//         .parent().addClass($.support.fileInput ? undefined : 'disabled');
// });
</script>
<script type="text/javascript">//session verify
function sessionVerify(){
	alert("into session verify");
	$.ajax({
		url:getContextPath()+"/sessionVerify.do",
		type:"post",
		async:false,
		success:function(data){
		},
		error:function(data){
		}
	});
}

$(document).ready(function (){
// 	sessionVerify();
// 	window.setInterval(sessionVerify, 5000);
});
</script>
<script> 
	function whatBrowser() {
		document.Browser.Name.value = navigator.appName;
		document.Browser.Version.value = navigator.appVersion;
		document.Browser.Code.value = navigator.appCodeName;
		document.Browser.Agent.value = navigator.userAgent;
	}
</script>
</head>
<body onLoad="whatBrowser()">
	<h1>Hello world!</h1>
	<p>${ctx }</p>
	<%-- 	<p>${ctxpt }</p> --%>
	<P>The time on the server is ${serverTime}.</P>
	<div id="divAjax"></div>
	<button id="btn_ajax" type="button">getAjax</button>
	<img id="qrimg"
		src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJYAAACWCAIAAACzY+a1AAAEQUlEQVR42u3cS3IbMQxFUe1/0/Yw
				Gbi6RLwLELKvhnIsNXlYBvGpvL58ffjr5Rb8EsJX9vr3cW/86Ogf44/xwxZAz/zWdkMr/f9zJJRQ
				wm2E4QO986NwO0LLo9+iNoH6rh9/S0IJJVxLGH79wN6FIScMeOGxq0VHCSWU8C8Q1sJS327iJylc
				RZhmSCihhH+KkHp63IkqLV2p10gooYSfRdj39aE3VdSmatC1te8tsEkooYQxIRVOfOf0nXUtX9+R
				UMJDQmyair58h0eqFoCpPKH2hMUJNgkllPA2Ybj4oxQCzyXConZfn486mlheKKGEEnYSUg222tPj
				LUBKBd/xcOjkraRCQgklvERI/fkO5cIgRB2F2ib0ZTLP3yWhhBIuIcRffRlI+Dx4IxM/E6ebIKGE
				Ei4hDAcLamsO0ww8AIf7S7VR0wKbhBJKeJswTCHC9VCVIOpM4HXz8NJwlhdKKKGEawjDskgYTqjm
				4t3MgcptzgYvJJRQwtuE+J/vgagWDnDg0xVgCeaBSUIJJdxGiN/Cayegb+IhbIhS6wILSRJKKOES
				QmpogMouyjds5AOpBVITIc8/klBCCZcQUuWMV/YKM5ltrcS+2FzMCyWUUMIRwslZinDLqNmFK8Vx
				6qohoYQS7iHsu/XiMSOMstRhpepZ+dZJKKGESwjzrhUyWBCONfTNf1DfTvUMJJRQwoWE4XZQF/Qw
				GuHNRTzfwB9VQgklXEhIXbX7yit4MtBRei7sTznXklBCCZcQUluGR6Nw8X1PiJ/a8hVBQgklXEI4
				GWmoUsUkM1USosLtxHVGQgkljJtN1AsfxcAfDK9ThwWgYnVGQgklvE1IlQ/C2IO3AKkwGUbiMG8p
				FtgklFDCNYS1YsrdmYyQmYrx1DvF6oyEEkp4iRAvZ1CVjsm4i582vIIjoYQSLiTE97cWJic3erI4
				TuUkEkoo4WZCaqlh37EmF54tqlpUO1vhSiWUUMI9hLW/4wOTXlSAAS/x3UWZ0wxNQgklXEKI3+/7
				sgv8go5PV4T5z+kqJJRQwiWEfQ02fJZiYKPxwQu86iShhBIuJKQuzdR4RPg5YetuoP4Opk8SSijh
				EkK8P4cPMfRlIFRov3WOJZRQwiWE+CwFdYkf6BdSPc6BInuxzC2hhBKuIezrIIZzEiFzLXPAS+rl
				35JQQgnXEuKVYmoX8CEwqkre11N8/hwJJZRwCeFAPQJvp+HlcrzWP1DZl1BCCRf+709UwaWvPI0X
				o2slmPDbwX8joYQSLiGktiy8hYdb3zcj0lctyqOshBJKuI1wYOtrDbaBStDAuEZHF0FCCSVcS1h7
				IHziIVzqQAYSHk2+wCahhBJ+OCFVzqDC5BUn6j5R7BdKKKGEv4WQKmcMjGL0tUipnsHz2iWUUMK1
				hAPVmSuBE6+Sgxi1DZdQQgm3EVL9QnyFAw925STlyZKEEkq4hNDX576+AbrgMQ8dohdYAAAAAElF
				TkSuQmCC
">
	<input id="fileupload" type="file" onchange="previewImage(this)" />
	<div id="preview"></div>
	<!-- 	<div onclick="" id="div_iconFile" -->
	<!-- 		style="float: left; background-color: rgb(0, 162, 50); height: 30px; line-height: 30px; width: 80px;" -->
	<!-- 		class="uploadify-button iconDiv"> -->
	<!-- 		<span class="uploadify-button-text">选择文件</span>  -->
	<!-- 		<span -->
	<!-- 			style="width: 80px; height: 30px; font-size: 12px;">  -->
	<!-- 			<input style="padding-left: 10px; padding-right: 10px; height: 24px; line-height: 24px;  -->
	<!-- 			border: 1px solid rgb(204, 204, 204); margin-top: 5px; vertical-align: middle;"value="click" type="button"> -->
	<!-- 			<input aria-invalid="false" name="iconFile" style="opacity: 0; right: 0px; top: 0px; position: absolute; z-index: 100;  -->
	<!-- 			 font-size: 60px; cursor: pointer;" class="uploadify valid" id="iconFile" onchange="previewImage(this);"type="file"> -->
	<!-- 		</span> -->
	<!-- 	</div> -->

	<form id="ua_form" action="http://localhost:8080/party/#" name="Browser">
		<table>
			<tr>
				<td>浏览器名称：</td>
				<td><input type="text" name="Name" size="110%"></td>
			</tr>
			<tr>
				<td>版本号：</td>
				<td><input type="text" name="Version" size="110%"></td>
			</tr>
			<tr>
				<td>代码名称：</td>
				<td><input type="text" name="Code" size="110%"></td>
			</tr>
			<tr>
				<td>用户代理标识：</td>
				<td><input type="text" name="Agent" size="110%"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">//发送验证码
	//发送验证码到手机
	function ajaxSendrVerCode() {
		$.ajax({
			url : "http://localhost:8080/party/SendVerificationCode",
			type : "POST",
			dataType : "json",
			data : {
				//"user_name" : "ajax",
				"phone_number" : "15820588570"
			},
			async : false,
			success : function(data) {
				alert("Success,data=" + data.errorCode);
				//alert("String data="+data.toString());
				var ti = 0;
				$.each(data, function(index, user) {
					ti++;
					//alert("user_name = " + user.user_name);
					//alert("Phone number = "+user.phone_Number);
				});
				//alert(ti);
			},
			error : function() {
				alert("error");
			}
		})
	}
	
	//注册
	function ajaxSignUser(){
		$.ajax({
			url:"http://localhost:8080/party/sign/Android",
			type:"POST",
			dataType:"json",
			data : {
				"phone_number" : "15820588570",
				"password" : "123456",
				verificationCode : "395810"
			},
			async : false,
			success : function(data) {
				var objdata = eval(data);
				alert(objdata.errorCode);
				alert(objdata.user.u_id);
				alert(objdata.user.phone_number);
				// 				alert("Success,data="+data.errorCode);
				// 				$.each(data.user, function(index, user) {
				// 					alert("user_name = " + user.u_id);
				// 					alert("Phone number = "+user.phone_number);
				// 				});
			},
			error : function() {
				alert("error");
			}

		})
	}
	//登录
	function ajaxLoginUser() {
		$.ajax({
			url : "http://localhost:8080/party/login/Android",
			type : "POST",
			dataType : "json",
			data : {
				"phone_number" : "15820588570",
				"password" : "123456",
				verificationCode : "456788"
			},
			async : false,
			success : function(data) {
				var objdata = eval(data);
				alert(objdata.errorCode);
				alert(objdata.user.u_id);
				alert(objdata.user.phone_number);

				// 				alert("Success,data="+data.errorCode);
				// 				$.each(data.user, function(index, user) {
				// 					alert("user_name = " + user.u_id);
				// 					alert("Phone number = "+user.phone_number);
				// 				});
			},
			error : function() {
				alert("error");
			}

		})
	}
	//百度地图转换经纬度
	function ajaxCreateParty() {
		var lat;
		var lng;
		$.ajax({
			url : "http://api.map.baidu.com/geocoder/v2/?ak=VqPcHsZqSPDXVopGgxPURzfI&location=39.983424,116.322987&output=json&pois=1",
			type : "POST",
			dataType : "jsonp",
			data:{},
			async : false,
			success : function(data) {
				var objdata = eval(data);
// 				alert(objdata.status);
				lat = objdata.result.location.lat;
				lng = objdata.result.location.lng;
				alert(objdata.result.formatted_address);
// 				$.each(objdata.result.pois,function(index,pois){
// 					$("#divAjax")[0].innerHTML += pois.addr+"\n";
// 				});
				},
			error : function() {
				alert("baidu map error");
			}

		});
		//申请注册Party
		$.ajax({
			url:"Party/CreateParty",
			type:"POST",
			dataType:"json",
			async : false,
			data : {
// 				inParty : {
					"u_id" : "2",
					"party_name" : "SecondParty",
					"introduction" : "For Test",
					"function" : "0",
					"longitude" : "1.001",
					"latitude" : "1.002"
// 				}
			},
			success : function(data) {
				var objdata = data;
				alert(objdata.errorCode);
				alert(objdata.message);
				var objparty = objdata.params.outParty;
// 				alert(objparty.p_id);
// 				alert(objparty.party_name);
// 				alert(objparty.qrcode);
				$("#qrimg").attr("src",objparty.qrcode);
			},
			error : function() {
				alert("create party error");
			}
		});
	}
	
	function ajaxJoinParty(){
		$.ajax({
			url:"Party/JoinPartyInAndroid/50/2",
			type:"POST",
			dataType:"json",
			async : false,
			data : {},
			success : function(data) {
				alert(data.errorCode);
				alert(data.message);
				var objparty = data.params.party;
				var userList = data.params.userList;
				alert(objparty.party_name);
				$.each(userList, function (i,user){
					alert("userID:"+user.u_id+"\n phoneNumber:"+user.phone_number);
				});
			},
			error : function() {
				alert("Into party error");
			}
		});
	}
	
	function ajaxGetPartyList(){
		$.ajax({
			url:"Party/GetPartyList",
			type:"POST",
			dataType:"json",
			async:false,
			data:{},
			success:function(data){
				alert(data.errorCode);
				alert(data.message);
				var partylist = data.params.partyLists;
				$.each(partyList,function(i,party){
					alert("partyID:"+party.p_id+"\npartyName:"+party.party_name);
				})
			}
		})
	}
	
	
</script>
</html>
	