<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
 %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加员工</title>
<link href="../css/stylesheet.css" rel="stylesheet" type="text/css"/>
<script src="../js/dept.js" language="javascript" type="text/javascript"></script>
</head>
<body id="bd">
<form action="<%=path %>/dept/deptaddservlet" method="post">
<table align="center" width="500px" border="0" cellspacing="1" cellpadding="5px" class="datatable">
		<tr class="tabletitle">
			<td colspan="2">请输入部门信息</td>
		</tr>
		<tr>
			<td class="tablelable">部门名称</td>
			<td class="tableinfo"><input type="text" id="deptname" name="deptname" maxlength="20" />*</td>
		</tr>
		<tr>
			<td class="tablelable">部门编号</td>
			<td class="tableinfo"><input type="text" id="deptid" name="deptid" maxlength="20" />*</td>
		</tr>
		<tr>
			<td class="tablelable">部门位置</td>
			<td class="tableinfo"><input type="text" id="deptloc" name="deptloc" maxlength="10" />*</td>
		</tr>
		<tr>
			<td class="tablelable" colspan="2">
				<input type="submit" value="增加" />
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
