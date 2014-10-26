<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>登录页面</title>
	<link href="css/stylesheet.css" rel="stylesheet" type="text/css"/>
	<script>
		function checkYanzhengma(){
			var inputyzm = document.getElementById("inputyzm");
			var spyzm = document.getElementById("spyzm");
			if(inputyzm.value==spyzm.innerHTML){
				return true;
			}else{
				alert('验证码输入错误');
				return false;
			}
		}
	</script>
</head>
<body style="background-image:url(img/bg_dot.gif); margin-top:20px">
	<form action="<%=path %>/adminservlet" method="post" target="_top">
		<table align="center" width="350px" border="0" cellspacing="1px" cellpadding="5px" class="datatable">
			<tr class="tabletitle">
				<td colspan="2">管理员登录</td>
			</tr>
			<tr>
				<td class="tablelable">管理账号</td>
				<td class="tableinfo"><input type="text" name="adminname" maxlength="8" value="${cookie.adminName.value }"/></td>
			</tr>
			<tr>
				<td class="tablelable">管理密码</td>
				<td class="tableinfo"><input type="password" name="adminpwd" maxlength="8"/></td>
			</tr>
			<tr>
				<td class="tablelable">管理级别</td>
				<td class="tableinfo">
					<input type="radio" name="adminlevel" value="1" checked="checked"/>管理员
					<input type="radio" name="adminlevel" value="2"/>操作员
				</td>
			</tr>
			<tr>
				<td class="tablelable">验证码</td>
				<td class="tableinfo">
					<input id="inputyzm" type="text" maxlength="4"/>
					<span id="spyzm" style="background-color:#CCCCCC; border:thin solid #000000">
					</span>
				</td>
			</tr>
			<tr class="tablelable">
				<td colspan="2">
					<input type="submit" value="进入系统" onclick="return checkYanzhengma();"/>
					${inputmsg}
				</td>
			</tr>
		</table>
		<script>
			///////生成验证码，同时将值赋值给span////////
			var yanzhengma = Math.floor(Math.random()*10000);
			var stryzm = yanzhengma.toString();
			for(var i=1;i<=4-stryzm.length;i++){
				stryzm = '0' + stryzm;
			}
			var spyzm = document.getElementById("spyzm");
			spyzm.innerHTML = stryzm;
			/////////////////////////////////////////
	</script>
	</form>
</body>
</html>
