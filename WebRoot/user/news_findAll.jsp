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
}.errorMessage li {  
            list-style-type: none;  
        }  
        .errorMessage {  
            padding:0;  
        } .zhubu{
	background: #4CAF50;
	color: white;
    padding: 5px 15px;
    margin: 8px 0;
    border: none;
    /**cursor: pointer;*/
}
</style>
  </head>
  
  <body>
  		<center><br/><br/><h2>我的资讯</h2>
  		<form action="news_findAllByTitle.action?u.userid=${session.userid}" method="post">
    <table>
    	<tr><td><font size="4">资讯标题</font></td><td><font size="4">
    	<input class="k" name="n.head"></font></td><td><input class="zhubu" type="submit" value="筛选"/></td></tr>
    	<tr><td><font size="4">资讯类型</font></td>
    	<td>
    	<s:iterator value="ntlist" var="ttt">
			<input type="radio" name="t.id" value="${ttt.id}">${ttt.style}&nbsp; &nbsp;
		</s:iterator>
        </td></tr>
    		
    </table><a class="aa" href="news_findAllByTitle.action?u.userid=${session.userid}&t.id=&n.head="><span>查看全部</span></a>
    	&nbsp;&nbsp;&nbsp;	<a href="news_jubao.action?u.userid=${session.userid }">查看被举报内容</a>&nbsp;&nbsp;&nbsp;	<a href="tiao.action">发布资讯</a>
    </form><br/>
  		
		<div>
    	 <table  id="customers" width="40%" width="40%" border="1" style="text-align:center">
	    	<tr>
	    		<th>资讯编号</th>
	    		<th>资讯标题</th>
	    		<th>资讯类型</th>
	    		<th>资讯状态</th>
	    		<th colspan="2">操作</th>
	    	</tr>
	    	<s:iterator value="tlist" var="ttll">
	   		<tr>
	   			<td class="alt">${ttll.id}</td>
	   			<td>${ttll.head}</td>
	   			<td class="alt">${ttll.starttime}</td>
	   			<td>${ttll.newsType.style}</td>
	   			<td class="alt"><a href="news_look.action?n.id=${ttll.id}">查看详情</a>
	   			
	   			</td><td><a class="two" href="news_delete.action?n.id=${ttll.id}" onclick="return confirm('确定删除?');">
	   				<img alt="" src="img/shanchu.gif" width="20" height="20"></a>
	   			
	   			</td>
	   		</tr>
	    	</s:iterator>
	    </table>
    
    	</div>
	
  		<br/>
  		 <form method="post" action="news_test.action?u.userid=${session.userid}">
	    	<s:if test="p.currentPage==1">上一页</s:if>
	    	<s:else><a href="news_test.action?p.currentPage=${p.currentPage-1}&u.userid=${session.userid}&p.pageCount=${p.pageCount}">上一页</a></s:else>
	    	&nbsp;&nbsp;
	    	<s:if test="p.currentPage==p.pageCount">下一页</s:if>
	    	<s:else><a href="news_test.action?p.currentPage=${p.currentPage+1}&u.userid=${session.userid}&p.pageCount=${p.pageCount}">下一页</a></s:else>
	    	&nbsp;&nbsp;
	    	共${p.pageCount}页&nbsp;第&nbsp;
	    	<input class="ye" type="text" name="p.currentPage" value="${p.currentPage}" 
	    	style="width:40px; text-align:center;"/>&nbsp;页&nbsp;
	    	<input type="submit" class="zhubu" value="确定"/>
	    	<br/> <h3><s:actionmessage cssClass="width:50px;"/></h3>
	    </form>
	    
  		</center>
  </body>
</html>
