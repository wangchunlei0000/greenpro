<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'y_poj.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  <style>
  		body{background:#F5F5DC;}
  </style>
  
  <body>
    
   		<s:iterator value="poj" var="lpp">
    	
    	<div style="padding-left:20px;padding-right:30px;margin:25px;float:left;width:500px;height:315px;">
    	<center>
    	<img src="${lpp.icon}" alt="项目图片" class="avatar" width="500" height="320" ><br/>
    	<a href="rongzipoj_look?p.pojid=${lpp.pojid}" target="mainly" >${lpp.name}</a>
    	</center>
    	</div>
    </s:iterator>
   	
  </body>
</html>
