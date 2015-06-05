/**
 * need <img id="qrimg" /> in InParty.jsp
 * need <div id="location" /> in login.jsp
 * need <div id="partyName" /> in InParty.jsp
 * need <div id="userList" /> in InParty.jsp
 * ajaxSendrVerCode
 * ajaxSignUser
 * ajaxLoginUser
 * ajaxTestBaiduMap
 * ajaxCreateParty
 * ajaxJoinParty
 * getLocation
 */

	var lat;
	var lng;
	//发送验证码到手机
	function ajaxSendrVerCode(phoneNumber) {
		$.ajax({
			url : "SendVerificationCode",
			type : "POST",
			dataType : "json",
			data : {
				"phone_number" : phoneNumber
			},
			async : false,
			success : function(data) {
				return true;
			},
			error : function() {
//				alert("error");
				return false;
			}
		});
		return true;
	}
	
	//注册
	function ajaxSignUser(phoneNumber,password,verCode){
		$.ajax({
			url:"sign/Android",
			type:"POST",
			dataType:"json",
			data : {
				"phone_number" : phoneNumber,
				"password" : password,
				verificationCode : verCode
			},
			async : false,
			success : function(data) {
				var objdata = eval(data);
				alert(objdata.errorCode);
				alert(objdata.user.u_id);
				alert(objdata.user.phone_number);
				return true;
			},
			error : function() {
				alert("error");
				return false;
			}
		});
		return false;
	}
	//登录
	function ajaxLoginUser(phoneNumber,password) {
		$.ajax({
			url : "login/Android",
			type : "POST",
			dataType : "json",
			data : {
				"phone_number" : phoneNumber,
				"password" : password
//				,verificationCode : "456788"
			},
			async : false,
			success : function(data) {
				var objdata = eval(data);
				alert(objdata.errorCode);
				alert(objdata.user.u_id);
				alert(objdata.user.phone_number);
				return true;
			},
			error : function() {
				alert("error");
				return false;
			}

		});
		return false;
	}
	//百度地图转换经纬度
	function ajaxTestBaiduMap() {
		$.ajax({
			url : "http://api.map.baidu.com/geocoder/v2/?ak=VqPcHsZqSPDXVopGgxPURzfI&location=39.983424,116.322987&output=json&pois=1",
			type : "POST",
			dataType : "jsonp",
			data:{},
			async : false,
			success : function(data) {
				var objdata = eval(data);
				lat = objdata.result.location.lat;
				lng = objdata.result.location.lng;
				alert(objdata.result.formatted_address);
				return true;
				},
			error : function() {
				alert("baidu map error");
				return false;
			}

		});
		return false;

	}
	
	function ajaxCreateParty(uid,partyName,introduction,fun,longitude,latitude){
		//申请注册Party
		$.ajax({
			url:"Party/CreateParty",
			type:"POST",
			dataType:"json",
			async : false,
			data : {
					"u_id" : uid,
					"party_name" : partyName,
					"introduction" : introduction,
					"function" : fun,
					"longitude" : longitude,
					"latitude" : latitude
			},
			success : function(data) {
				var objdata = data;
				alert(objdata.errorCode);
				alert(objdata.message);
				var objparty = objdata.params.outParty;
				$("#qrimg").attr("src",objparty.qrcode);
				return true;
			},
			error : function() {
				alert("create party error");
				return false;
			}
		});
		return false;
	}
	
	function ajaxJoinParty(uid,pid){
		$.ajax({
			url:"Party/JoinPartyInAndroid/"+pid+"/"+uid,
			type:"POST",
			dataType:"json",
			async : false,
			data : {},
			success : function(data) {
				alert(data.errorCode);
				alert(data.message);
				var objparty = data.params.party;
				var userList = data.params.userList;
//				alert(objparty.party_name);
				$("#partyName")[0].innerHTML = objparty.party_name;
				$.each(userList, function (i,user){
					$("#userList")[0].innerHTML += "userID:"+user.u_id+"\n phoneNumber:"+user.phone_number;
//					alert("userID:"+user.u_id+"\n phoneNumber:"+user.phone_number);
				});
				return true;
			},
			error : function() {
				alert("Into party error");
				return false;
			}
		});
		return false;
	}
	
	var x = document.getElementById("location");
	function getLocation() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(showPosition);
		} else {
			x.innerHTML = "Geolocation is not supported by this browser.";
		}
	}
	function showPosition(position) {
		x.innerHTML = "Latitude: " + position.coords.latitude + "<br />Longitude: "
				+ position.coords.longitude;
		lng = position.coords.longitude;
		lat = position.coords.latitude;
	}
