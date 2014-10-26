<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%String path = request.getContextPath();%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改职位</title>
<link href="../css/stylesheet.css" rel="stylesheet" type="text/css"/>
<script src="../js/job.js" language="javascript" type="text/javascript"></script>
</head>
<body id="bd">
<form action="<%=path %>/job/jobupdateservlet" method="post">
<table align="center" width="500px" border="0" cellspacing="1" cellpadding="5px" class="datatable">
		<tr class="tabletitle">
			<td colspan="2">请输入职位信息</td>
		</tr>
		<tr>
			<td class="tablelable">职位编号</td>
			<td class="tableinfo"><input type="text" id="jobid" name="jobid" readonly="readonly" maxlength="20" value="${job.jobId }"/>*</td>
		</tr>
		<tr>
			<td class="tablelable">职位名称</td>
			<td class="tableinfo"><input type="text" id="jobname" name="jobname" maxlength="20" value="${job.jobTitle }"/>*</td>
		</tr>
		<tr>
			<td class="tablelable">最低工资</td>
			<td class="tableinfo"><input type="text" id="minsalary" name="minsalary" maxlength="10" value="${job.minSal }"/>*</td>
		</tr>
		<tr>
			<td class="tablelable">最高工资</td>
			<td class="tableinfo"><input type="text" id="maxsalary" name="maxsalary" maxlength="10" value="${job.maxSal }"/>*</td>
		</tr>
		<tr>
			<td class="tablelable" colspan="2">
				<input type="submit" value="确定" />
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
