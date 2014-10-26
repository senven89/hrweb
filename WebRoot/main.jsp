<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>人力资源管理系统</title>
	</head>
	<!--frameset frameborder:框架边框 framespacing：框架之间的边距-->
	<frameset rows="20%,*,10%" frameborder="no" border="0" framespacing="0">
	<!--frame scrolling:设置滚动条 noresize：不可调大小-->
	  <frame src="<%=path%>/top.jsp" name="topFrame" scrolling="no" noresize="noresize" />
	  <frameset cols="20%,*">
	  		<frame src="<%=path%>/left.jsp" scrolling="no" name="leftFrame" noresize="noresize"/>
			<frame src="<%=path%>/default.html" name="default" noresize="noresize"/>
	  </frameset>
	  <frame src="<%=path%>/bottom.html" scrolling="no" name="bottomFrame" noresize="noresize"/>
	</frameset>
</html>
