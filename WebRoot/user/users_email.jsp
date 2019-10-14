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
    
    <title>My JSP 'users_email.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
#customers
{
	font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
	width:60%;
	border-collapse:collapse;
	text-align:center
}
#customers td, #customers th 
{
	width:50px;
	height:25px;
	font-size:1em;
	border:1px solid #98bf21;
	padding:3px 7px 2px 7px;
	text-align:center;
	background-color:#F0F8FF;
}
#customers th 
{
	font-size:1.1em;
	text-align:center;
	padding-top:5px;
	padding-bottom:4px;
	background-color:#6495ED;
	color：;
}

.two{text-decoration: none;}
a.two:link {color:	#9370DB;}
a.two:visited {color:#9370DB;}
a.two:hover {font-size:120%;}
.z {text-decoration:line-through;}
</style>

  </head>
  
  <body>
    	<center><br/>
       <h3>我的消息</h3><br>
    	
    	<div>
    	 <table  id="customers" width="40%" width="40%" border="1" style="text-align:center">
	    	<tr>
	    		<th>通知编号</th>
	    		<th>标题</th>
	    		<th>时间</th>
	    		<th>操作</th>
	    	</tr>
	    	<s:iterator value="elist" var="li">
	   		<tr>
	   		<s:if test="(#li.n)!=0">
	   			<td class="z"><label class="z">${li.id}</label></td>
	   			<td class="z"><label class="z">${li.head}</label></td>
	   			<td class="z"><label class="z">${li.by1}</label></td>
	   			<td class="z"><a style="text-decoration:line-through;" class="two" href="email_findById.action?e.id=${li.id}">查看详情</a>
	   			&nbsp;
	   			<a style="text-decoration:line-through;" class="two" href="email_delete.action?e.id=${li.id}"  onclick="return confirm('确定删除?');">
	   			<img alt="" src="img/shanchu.gif" width="20" height="20"></a>
	   		</td>
	   		
	   		</s:if>
	   		<s:else>
	   			<td><font size="4">${li.id}</font></td>
	   			<td><font size="4">${li.by1}</font></td>
	   			<td><font size="4"><a class="two" href="email_findById.action?e.id=${li.id}">查看详情</a> 
	   			&nbsp; 
	   				<a class="two" href="email_delete.action?e.id=${li.id}" onclick="return confirm('确定删除?');">
	   				<img alt="" src="img/shanchu.gif" width="20" height="20"></a></font>
	   				</td></s:else>
	   				
	   		</tr>
	    	</s:iterator>
	    </table>
    	</div>
    </center>
  </body>
</html>
