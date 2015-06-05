<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>In Party</title>
<script type="text/javascript" src="${ctx }/resources/static/js/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/static/js/common.js"></script>
<script type="text/javascript">
	var userID = "${requestScope.userID}";
	var partyID = "${requestScope.partyID}";
	ajaxJoinParty(userID,partyID);
</script>
</head>
<body>
	<div id="partyName"></div>
	<div id="userList"></div>
	<img id="qrimg" />
</body>
</html>