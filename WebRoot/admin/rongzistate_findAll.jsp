<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>浏览融资状态</title>
    <link rel="stylesheet" type="text/css" href="css/admin.css">
   <style type="text/css">
    
   .so{
   padding: 12px 20px;	margin: 8px 0;display: inline-block;border: 2px solid #ccc; width:50%; 
   box-sizing: border-box; border-radius:4px;
    	}
    	.go{background:#3CB371;border-radius:4px;
	color: white;
    padding: 12px 20px;
    margin: 8px 0;
    border: none;}
    </style>
  </head>
  
  <body style="text-align:center">
  
  <center>
  	<form action="rongzistate_add.action" method="post">
	  <br/><br/><br/><br/>
	  	<h2><font color="#3CB371">新增融资状态</font></h2>
	  	<br/>
	    <input class="so" type="text" name="o.style">&nbsp;&nbsp;
	    <input class="go" type="submit" value=" 提交 "><br><br>
	  </form>
  </center>
	  <hr/>
  	<div align="center">
	    <h2><font color="#3CB371">融资状态</font></h2>
	    <table  id="customers" width="40%" width="40%" border="1" style="text-align:center">
	    	<tr>
	    		<th>编号</th>
	    		<th>状态</th>
	    		<th>是否可用</th>
	    		<th colspan="2">操作</th>
	    	</tr>
	    	<s:iterator value="li" var="opp">
	   		<tr>
	   			<td class="alt"><s:property value="#opp.id"/></td>
	   			<td><s:property value="#opp.style"/></td>
	   			<td class="alt"><s:property value="#opp.enable"/></td>
	   			<td><a href="rongzistate_toupdate.action?o.id=${opp.id}">修改</a></td>
	   			<td class="alt"><a href="rongzistate_todelete.action?o.id=${opp.id}" onclick="return confirm('确定删除?');">删除</a></td>
	   		</tr>
	    	</s:iterator>
	    </table>
    </div>
  </body>
</html>
