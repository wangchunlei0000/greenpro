<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>浏览资讯类型</title>
    <link rel="stylesheet" type="text/css" href="css/admin.css">
     <style>

 </style>
  </head>
  
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

  
  <body style="text-align:center">
  
  <center>
  	<form action="newstype_add.action" method="post">
	  <br/><br/><br/><br/>
	  	<h2><font color="#3CB371">新增资讯类型</font></h2>
	  	<br/>
	    <input class="so" type="text" name="o.style">&nbsp;&nbsp;
	    <input class="go" type="submit" value=" 提交 "><br><br>
	  </form>
 
  <hr/>
  	<div align="center">
	    <h2><font color="#3CB371">资讯类型</font></h2>
	    <table  id="customers" width="40%" width="40%" border="1" style="text-align:center">
	    	<tr>
	    		<th>编号</th>
	    		<th>类型号</th>
	    		<th>是否可用</th>
	    		<th colspan="2">操作</th>
	    	</tr>
	    	<s:iterator value="list" var="o1">
	   		<tr>
	   			<td class="alt"><s:property value="#o1.id"/></td>
	   			<td><s:property value="#o1.style"/></td>
	   			<td class="alt"><s:property value="#o1.enable"/></td>
	   			<td><a href="newstype_toupdate.action?o.id=${o1.id}">修改</a></td>
	   			<td class="alt"><a href="newstype_todelete.action?o.id=${o1.id}" onclick="return confirm('确定删除?');">删除</a></td>
	   		</tr>
	    	</s:iterator>
	    </table>
    </div>
    </center>
  </body>
</html>
