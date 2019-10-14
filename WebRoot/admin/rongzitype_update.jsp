 <style type="text/css"> .zhubu{
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
} </style><%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改融资类型</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/admin.css">	
  </head>
    <body>
  
    <div>
    <center>
	    <form action="rongzitype_update.action" method="post"> <br/>
	    <h3><font>更改融资类型</font></h3><hr/><br/>
	    <table width="351" height="190">
	    <tr>
	    <td>编  号：</td>
	    <td><input  name=" o.id" value="${o.id}"></td></tr><!-- readonly="readonly" -->
	    <tr>
	    	<td>类 型：</td>
	    	<td><input name="o.style" value="${o.style}"><br></td>
	    </tr>
	    <tr>
	    	<td>是否可用：</td>
	    	<td><input name="o.enable" value="${o.enable}"></td>
	    </tr>
	    </table><br/>
	     <input class="zhubu" type="submit" value="  修改  ">
	     
	    </form>
	</center>
    </div>
    
  </body>
</html>
