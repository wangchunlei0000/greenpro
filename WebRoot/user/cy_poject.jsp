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
    <title>My JSP 'rz_poject.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/button.css">
<style>.k{
   
    padding: 4px 10px;
    margin: 3px 0;
    display: inline-block;
    border: 1px solid #ccc;
    width:100%;
    box-sizing: border-box;
    border-radius:4px;
} .zhubu{
	background: #4CAF50;
	color: white;
    padding: 5px 15px;
    margin: 8px 0;
    border: none;
    /**cursor: pointer;*/
}
#customers
{
	font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
	width:60%;
	border-collapse:collapse;
	text-align:center
}
#customers td, #customers th 
{
	
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
#customers td.alt 
{
	color:;
	background-color:#F0F8FF;
}
</style>
  </head>
  
  <body>
  <center><br/>
       <h3>  我参与的融资项目</h3><br>
    	
    	<div>
    	 <table  id="customers" width="40%" width="40%" border="1" style="text-align:center">
	    	<tr>
	    		<th>项目号</th>
	    		<th>项目名称</th>
	    		<th>项目状态</th>
	    		<th>参与融资金额</th>
	    		<th>操作</th>
	    	</tr>
	    	<s:iterator value="cyp" var="cp">
	   		<tr>
	   			<td class="alt">${cp.rongziPoj.pojid}</td>
	   			<td>${cp.rongziPoj.name}</td>
	   			<td class="alt">${cp.rongziPoj.rongziState.style}</td>
	   			<td>${cp.money}</td>
	   			<td class="alt"><a href="cypoj_look.action?c.id=${cp.id}">查看详情</a>
	   			
	   			</td>
	   		</tr>
	    	</s:iterator>
	    </table>
    
    	</div>
    	
    </center>
  </body>
</html>
