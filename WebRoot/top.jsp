<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>TOP</title>
		<!--CSS内联样式表-->
		<link href="css/stylesheet.css" rel="stylesheet" type="text/css"/>
		<script>
			var tid=null;//定义定时器id
			function setmyinterval(){
				showtime();
				tid = setInterval("showtime();",1000);			
			}
			function showtime(){
				var now = new Date();
				var sptime = document.getElementById("sptime");
				sptime.innerHTML = now.toLocaleString();
			}
		</script>
	</head>
	<!--onload设定定时器，定时器1秒调用一次showtime()函数-->
	<body id="body1" onload="setmyinterval();">
		<div id="div1"> 
			<img src="img/bannal.jpg" width="100%" height="100%"/>
		</div>
		<div id="div2"> 
			
			<p id="pt" class="pt">当前用户：${admin.adminName } 身份：${admin.level==1?"管理员":"操作员"}&nbsp; <span id="sptime"></span></p>
		</div>
	</body>
</html>
