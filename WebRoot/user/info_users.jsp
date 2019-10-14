<%@ page language="java" import="java.util.*,java.math.BigDecimal,java.text.DecimalFormat" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>info_user</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/users.css"> 
	<style>.yy td{font-size:1.2em;border-bottom:1px solid #e0e0e0}</style>
  </head> 
  <body>
  <center>
    <form action="" method="post" enctype="multipart/form-data">
     <br/><br/><br/>
   
		<%  
		String i=request.getAttribute("o.money").toString();
		DecimalFormat df=new DecimalFormat("#0.00");
		Double d=Double.parseDouble(i);  
 		
		BigDecimal big = new BigDecimal(df.format(d));
		
		
		%>
		
	<table width="603" height="158">
   		 <tr><td> <center><img src="${o.head}" alt="上传头像" class="avatar" width="131" height="109"></center></td></tr>
	</table>
	
	<table class="yy" width="337" height="237">
	<tr>
   	 		<td><strong>账 &nbsp;&nbsp; 号:</strong></td>
   	 		<td>${session.userid}</td>
   	</tr>
   	<tr>
   	 		<td><strong>真实姓名:</strong></td>
   	 		<td>${o.name}</td>
   	</tr>
   	<tr>
   	 		<td><strong>性&nbsp; &nbsp; 别:</strong></td>
   	 		<td>${o.sex}</td>
	</tr>
	<tr>
	 		<td><strong>昵&nbsp;&nbsp;&nbsp; 称:</strong></td>
	 		<td>${o.username}</td>
	</tr>
	<tr>
	 		<td><strong>手机号码:</strong></td>
	 		<td>${o.phone}</td>
	</tr>
	<tr>
	 		<td><strong>邮 &nbsp;&nbsp; 箱:</strong></td>
	 		<td>${o.email}</td>
	</tr>
	<tr>
	 		<td><strong>传&nbsp; &nbsp; 真:</strong></td>
	 		<td>${o.fax}</td>
	</tr> 
	<tr>
	 		<td><strong>余&nbsp; &nbsp; 额:</strong></td>
	 		<td><%=big %></td>
	</tr> 
	</table>
    </form>
 	</center>
  </body>
</html>
