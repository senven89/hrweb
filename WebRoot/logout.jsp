<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登出</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css"/>
<script>
	var tid = null;
	function setmyinterval(){
		tid = window.setInterval("updatesend();",1000);
	}
	
	function updatesend(){
		var send = document.getElementById("send");
		var intsen = parseInt(send.innerHTML);
		send.innerHTML = (intsen-1);
		if(intsen-1==1){
			window.clearInterval(tid);
			//location.href跳转
			location.href="<%=path%>/login.jsp";
		}
	}
</script>
</head>
<body onload="setmyinterval();">
	<p><span id="send">10</span>秒之后自动跳转到登录页面</p>
	<p>如果没有跳转，请点击连接<a href="<%=path%>/login.jsp">回到登录页面</a></p>
	<p>请点击连接回到前页面<a href="javascript:window.history.back();">回到前页</a></p>
</body>
</html>
