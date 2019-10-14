<%@ page language="java" import="java.util.*,java.math.BigDecimal;" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/button.css">
	<link rel="stylesheet" type="text/css" href="css/users.css"> 
	<style>.yy td{font-size:1.2em;}
	.errorMessage li {  
            list-style-type: none;  
        }  
        .errorMessage {  
            padding:0;  
        }
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
 
  <body>
 
  <center>
    <form action="logins_pwd.action?o.userid=${session.userid}" target="_blank" method="post" >
    <br/><br/><br/>
<table class="yy" width="400" height="287">
<tr>
   	 		<td><strong>旧密码:</strong></td>
   	 		<td><input type="password" name="o.pwd"/></td>
   	</tr> 
   	<tr>
   	 		<td><strong>新密码:</strong></td>
   	 		<td><input type="password" name="newpwd" /></td>
   	</tr>
   	
	<tr>
	 		<td><strong>确认密码:</strong></td>
	 		<td><input type="password" name="rnewpwd"/></td>
	</tr>
	
	
	<tr>	
  	 		<td colspan="2">
   		<center>
   		  <input class="button" type="submit" value="确定"/>&nbsp;

  	   </center></td>
 	</tr>
</table>
<s:fielderror theme="simple" fieldName="o.userid"/>
<s:fielderror theme="simple" fieldName="u.email"/>
<s:fielderror theme="simple" fieldName="rnewpwd"/>
<s:fielderror theme="simple" fieldName="newpwd"/>
<s:actionmessage/>
		
</form>

 </center>
  </body>
</html>
