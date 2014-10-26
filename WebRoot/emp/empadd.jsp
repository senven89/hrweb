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
<script src="../js/emp.js" language="javascript" type="text/javascript"></script>
<script src="../js/My97DatePicker/WdatePicker.js" language="javascript" type="text/javascript"></script>
</head>
<body id="bd">
<form action="<%=path %>/emp/empaddservlet" method="post">
<table align="center" width="500px" border="0" cellspacing="1" cellpadding="5px" class="datatable">
		<tr class="tabletitle">
			<td colspan="2">请输入员工信息</td>
		</tr>
		<tr>
			<td class="tablelable">员工姓名</td>
			<td class="tableinfo"><input type="text" id="ename" name="ename" maxlength="20" />*</td>
		</tr>
		<tr>
			<td class="tablelable">员工邮箱</td>
			<td class="tableinfo"><input type="text" id="email" name="email" maxlength="20" />*</td>
		</tr>
		<tr>
			<td class="tablelable">入职时间</td>
			<td class="tableinfo"><input type="text" id="hiredate" name="hiredate" maxlength="10" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>*</td>
		</tr>
		<tr>
			<td class="tablelable">职位</td>
			<td class="tableinfo">
				<select name="jobid">
					<c:forEach items="${jobList}" var="j">
					<option value="${j.jobId }">${j.jobTitle}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td class="tablelable">工资</td>
			<td class="tableinfo"><input type="text" id="sal" name="sal" maxlength="9" />*</td>
		</tr>
		<tr>
			<td class="tablelable">部门</td>
			<td class="tableinfo">
				<select name="deptid">
					<c:forEach items="${deptList}" var="d">
					<option value="${d.deptId}">${d.deptName}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td class="tablelable" colspan="2">
				<input type="submit" value="增加" onclick="return checkform();"/>
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
