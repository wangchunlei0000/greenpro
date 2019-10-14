<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_look.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center><br/><br/>
    <h3>项目详情</h3>
    <table class="yy" width="35%" height="60%">
    	<tr><td width="43%">项目号:</td><td>${p.pojid}</td></tr>
    	<tr><td>项目名:</td><td>${p.name}</td></tr>
    	<tr><td>发起人:</td><td>${p.users.userid}</td></tr>
    	<tr><td>项目简介:</td><td>${p.introduce}</td></tr>
    	<tr><td>投资类型:</td><td>${p.touziType.style}</td></tr>
    	<tr><td>投资状态:</td><td>${p.touziState.style}</td></tr>
    	<tr><td>目标资金:</td><td>${p.money}</td></tr>
    	<tr><td>现投资金额:</td><td>${p.nowmoney}</td></tr>
    	<tr><td>所属区域:</td><td>${p.area}</td></tr>
    	<tr><td>开始时间</td><td>${p.starttime}</td></tr>
    	<tr><td>项目图片:</td><td><img src="${p.icon}" width="140" height="109"></td></tr>
    	<tr><td height="10%">项目文件:</td><td height="10%"><a href="${p.by1}">${p.by1}</a></td></tr>
 		
    </table>
    
    </center>
  </body>
</html>
