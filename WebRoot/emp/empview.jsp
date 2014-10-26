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
		<title>员工管理</title>
		<link href="../css/stylesheet.css" rel="stylesheet" type="text/css"/>
		<script>
			function deleteconfirm(){
				return confirm('确定删除吗？');
			}
		</script>
	</head>
	<body background="../img/bg_dot.gif" id="bd">
		<table width="900px" align="center" border="0" cellspacing="1" cellpadding="5px" class="datatable">
			<tr class="tabletitle">
				<td>员工编号</td>
				<td>员工姓名</td>
				<td>员工邮箱</td>
				<td>入职时间</td>
				<td>职务</td>
				<td>工资</td>
				<td>部门</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="e">
			<tr class="tableinfo">
				<td>${e.empId}</td>
				<td>${e.ename}</td>
				<td>${e.email}</td>
				<td>${e.hiredate}</td>
				<td>${e.job.jobTitle}</td>
				<td>${e.sal}</td>
				<td>${e.dept.deptName}</td>
				<td><a href="<%=path %>/emp/emptoupdateservlet?EmpId=${e.empId}">修改</a> <a href="<%=path %>/emp/empdeleteservlet?EmpId=${e.empId}" onclick="return deleteconfirm();">删除</a> 照片</td>
			</tr>
			</c:forEach>
		</table>
		<table class="table2" border="0" align="center">
			<tr align="center">
				<td>共1页，当前是第一页</td>
			</tr>
			<tr align="center">
				<td>
					<a href="">首页</a>
				    <a href="">上页</a>
				    <a href="">下页</a>
				    <a href="">末页</a>
				</td>
			</tr>
			<tr align="center">
				<td><a href="<%=path %>/emp/emptoaddservlet" >增加员工</a></td>
			</tr>
		</table>
	</body>
</html>
