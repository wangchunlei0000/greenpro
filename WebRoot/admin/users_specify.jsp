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
    <title>My JSP 'users_specify.jsp' starting page</title>  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>  td{font-size:1.2em;border-bottom:1px solid #e0e0e0}
	*{font-family:"幼圆";font-weight: bold;}
	</style>
	<style>
  .zhubu{
	background: #4CAF50;
	color: white;
    padding: 5px 15px;
    margin: 8px 0;
    border: none;
    width:70px;
    height:35px;
    border: none;
    text-decoration: none;
    /**cursor: pointer;*/
}
  </style>
  </head>
  
  <body>
  <center><br/><br/><br/><h2>用户信息</h2><br/>
    		<table width="392" height="294">
    			<tr>
    				<td>账号</td>
    				<td>${o.userid}</td>
    			</tr>
    			<tr>
    				<td>密码</td>
    				<td>${o.pwd}</td>
    			</tr>
    			<tr>
    				<td>角色</td>
    				<td>
    				<s:if test='"0".equals(o.role)'>普通用户</s:if>
					<s:elseif test='"0".equals(o.role)'>管理员</s:elseif>
    				</td>
    			</tr>
    			<tr>
    				<td>是否可用</td>
    				<td>
					<s:if test='"0".equals(o.enable)'>可用</s:if>
					<s:elseif test='"1".equals(o.enable)'>不可用</s:elseif>
					</td>
    			</tr>
    			<tr>
    				<td>注册时间</td>
    				<td>${o.regtime}</td>
    			</tr>
    		</table><br/><br/>
    		<a href="javascript:history.go(-1)" class="zhubu">返回</a>
  </center>
  </body>
</html>
