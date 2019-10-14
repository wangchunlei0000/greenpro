<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'info_email.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="css/button.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/button.css">
<style>h1
{
	text-shadow: 5px 5px 5px #6495ED;
}</style>
<style>.yy td{font-size:1.2em;border-bottom:1px solid #e0e0e0}
 .zhubu{
	background: #4CAF50;
	color: white;
    padding: 5px 15px;
    margin: 8px 0;
    border: none;
    width:94px;
    height:30px;
    font-size: 14px;
    text-decoration: none;
    /**cursor: pointer;*/
}</style>
  </head>
  
  <body><center><br/><br/><br/><br/>
    	
    			<h1>收到管理员的通知</h1><br/><p><font size="6" face="宋体">${e.text}</font></p>
    		<br/><br/><a href="email_look.action?u.userid=${session.userid}" class="zhubu">&nbsp;确定&nbsp;</a>
    	</center>
  </body>
</html>
