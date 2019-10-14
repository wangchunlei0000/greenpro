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
    
    <title>My JSP 'info_news.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style>
  .zhu{
  	text-decoration: none;
  	  background: #4CAF50;
	color: white;
    padding: 5px 16px;
    margin: 7px 0;
    border: none;
    width:70px;
    height:38px;
    border: none;
    font-size:16px;
  }
  
  </style>
  <body>
    		<br/><br/>
    		<center>
    		<div style="width:50%;height:auto;rgba(138,197,0,0.6); border:2px solid black;padding:10px;">
    	<center>	<h1>${n.head }</h1> <br/>
    		资讯类型：${n.newsType.style }<br/>
    		<br/>发布时间：${n.starttime }</center>
    			<p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${n.text }</p><br/>
    		
    		 <s:if test="(#ttll.icon)==null"></s:if>
						<s:else>
							<br />
						<center>	<img width="440px" height="300px" alt="暂无图片" src="${n.icon}"></center>
						</s:else>
    		<br/><br/>
    	
    		</div><br/><br/><center>	<a href="javascript:history.go(-1)" class="zhu">返回</a></center></center>
  </body>
</html>
