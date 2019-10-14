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
    
    <title>My JSP 'news_findAll.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>

.zz{
  	font-family: "幼圆";
  	color:black;
  	font-size: 24px;
  	text-shadow: 4px 3px 2px 	#FFF8DC;
  }
.k{
   
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
.errorMessage li {  
            list-style-type: none;  
        }  
        .errorMessage {  
            padding:0;  
        } 
        a{
        	color:white;
        	text-decoration: none;
        }
</style>
<style> 
.ani
{float:left;

	width:17px;
	height:17px;
	background:#3CB371;
	animation:myfirst 2s;
	-webkit-animation:myfirst 5s; /* Safari and Chrome */
	border-radius: 50%;
}




@keyframes myfirst
{
	0%   {background:#3CB371;}
	15%   {background:#CD5C5C;}
	30%   {background:#D2691E;}
	45%   {background:#DC143C;}
	60%  {background:#6495ED;}
	75%  {background:#FFD700;}
	100% {background:green;}
}
.zz:HOVER {
	font-size: 1.2em;
	text-decoration: none;
	left:200px;
	text-shadow:5px 5px 2px #DEB887;
}

</style>
  </head>
  
  <body>
  <div style="height:5%;width:100%"><jsp:include page="bbbbanner.jsp"></jsp:include></div>
  <div style="height:5%;">
    		<center>
    		gin:<br/><br/><h2>浏览资讯</h2>
  		<form action="news_yfindAllBy.action" method="post">  
    <table style="width: 572px; height: 94px;" width="572" height="94">
    	<tr><td><div class="ani"></div>&nbsp;<font size="4">资讯标题&nbsp;</font></td><td><font size="4">
    	<input class="k" name="n.head"></font></td><td>&nbsp;<input class="zhubu" type="submit" value="筛选"/></td></tr>
    	<tr><td><div class="ani"></div>&nbsp;<font size="4">资讯类型&nbsp;</font></td>
    	<td>
    	<s:iterator value="ntlist" var="ttt">
			<input type="radio" name="t.id" value="${ttt.id}">${ttt.style}&nbsp; &nbsp;
		</s:iterator>
        </td></tr>
    </table><a class="aa" href="news_yfindAllBy.action?t.id=&n.head="><span>查看全部</span></a>
    </form><hr/>

<div style="width:1000px;text-algin:left;">
	    	<s:iterator value="tlist" var="ttll">
	 <div >   	 <h3> 
	 <a class="zz" href="news_llook.action?n.id=${ttll.id}" >
	 <p align="left">
	 ${ttll.head}:.............&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;访问量: ${ttll.count}
	 </p>
	 </a>
	 
	 </h3><br/>
	 </div>
		</s:iterator>
	  </div></center>
   </div>
  </body>
</html>
