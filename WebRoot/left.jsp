<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>LEFT</title>
		<link href="css/stylesheet.css" rel="stylesheet" type="text/css"/>
		<script>
			function getpos(obj){
				//alert(obj.offsetTop);
				//alert(obj.offsetLeft);
				alert(obj.offsetWidth);
			}
			function menushow(divid,menuid){
				var menu = document.getElementById(menuid);
				var divzd = document.getElementById(divid);
				if(menu.className=="ulshow"){
					menu.className="ulhidden";
					divzd.innerHTML="展开";
				}else{
					menu.className="ulshow";
					divzd.innerHTML="折叠";
				}
			}
		</script>
		<style>
			.ulhidden{
				display:none;
			}
			.ulshow{
				display:block;
			}
		</style>
	</head>
	<body style="background-color:#B1DAF1">
		<div id="divzd1" style="border:thin solid #000000; text-align:center; margin:0px; padding:0px; background-color:#CCCCCC; cursor:pointer"onclick="menushow('divzd1','menu1');">
			折叠
		</div>
		<ul id="menu1" style="margin:0px; padding:0px; margin-left:50px" class="ulshow"> 
			<li><a href="<%=path %>/default.html" target="default">首页</a></li>
			<li>-----<a href="<%=path%>/dept/deptviewservlet" target="default">部门管理</a></li>
			<li>-----<a href="<%=path %>/job/jobviewservlet" target="default">职位管理</a></li>
			<li>-----<a href="<%=path%>/emp/empviewservlet" target="default">员工管理</a></li>
			<li><a href="<%=path %>/logout.jsp" target="_top">登出</a></li>
		</ul>
		
	</body>
</html>
