<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%String path = request.getContextPath();%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<td>职位编号</td>
				<td>职位名称</td>
				<td>最低工资</td>
				<td>最高工资</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list }" var="j">
			<tr class="tableinfo">
				<td>${j.jobId }</td>
				<td>${j.jobTitle }</td>
				<td>${j.minSal }</td>
				<td>${j.maxSal }</td>
				<td><a href="<%=path%>/job/jobtoupdateservlet?jobid=${j.jobId }">修改</a> <a href="<%=path %>/job/jobdelservlet?jobid=${j.jobId}"/>删除</td>
			</tr>
			</c:forEach>

		</table>
		<table class="table2" border="0" align="center">
			<tr align="center">
				<td><a href="<%=path %>/job/jobadd.jsp">增加职位</a></td>
			</tr>
		</table>
	</body>
</html>
