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
    
    <title>My JSP 'findAllPoj.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
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
.kk{
   
    padding: 4px 10px;
    margin: 5px 0;
    display: inline-block;
    border: 1px solid #ccc;
    width:100%;
    height:36px;
    box-sizing: border-box;
    border-radius:4px;
}
a{text-decoration: none}
body{background:;
font-size:1.2em;}
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
}
</style>
  <body>
 
   <div style="height:5%;width:100%"><jsp:include page="bbbanner.jsp"></jsp:include></div>
	
  <div style="width:100%">
 		<center><br/><br/>
              <h2>投资项目</h2><br>
    <form action="y_ytfindByTitle.action" method="post">
    <table width="505" height="150">
    	<tr><td><div class="ani"></div>&nbsp;<font size="4">项目名称</font></td><td><input class="kk" name="p.name"/></td></tr>
    	<tr><td><div class="ani"></div>&nbsp;<font size="4">项目类型</font></td>
    	<td height="30px">
		<s:iterator value="typeList" var="ty">
		<input type="radio" name="r2.id" value="${ty.id}">${ty.style}&nbsp; &nbsp;   &nbsp; 
		</s:iterator>
        </td></tr>
    	<tr><td height="40px"><div class="ani"></div>&nbsp;<font size="4">项目进程</font></td>
    	<td>
    	<input type="radio" name="r1.id" value="2">投资中 &nbsp; &nbsp;
    	<input type="radio" name="r1.id" value="4">投资结束
    	</td>
    	</tr> 
    	<tr><td style="text-align: center"colspan="2"><input class="zhubu" type="submit" value="筛选"/>&nbsp;&nbsp;
    	 <a class="zhubu" href="y_ytfindByTitle.action">查看全部</a></td></tr>
    </table>
    </form><hr/>
    <div style="width:18%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
    <div style="padding-left:10px;padding-right:0px;margin:25px;float:left;width:65%;height:35%;height:50%">
    	<s:iterator value="poj" var="lpp">
       <div style="padding-left:20px;padding-right:30px;margin:25px;float:left;width:550px;">
    	<div style="height:80%">
    			<img src="${lpp.icon}" alt="项目图片" class="avatar" width="500" height="274"></div><br/><div style="height:20%">
    			<a href="cytpoj_uusers?po.pojid=${lpp.pojid}">${lpp.name}</a>&nbsp;&nbsp;
    			<a href="y_ytjubao.action?p.pojid=${lpp.pojid}" onclick="return confirm('确定举报这个项目?');">举报</a>&nbsp;&nbsp;
    			<s:if test="(#session.role)==null"></s:if>
    			<s:else>
    				<s:if test="(#lpp.touziState.id)==2">
    						<a href="touzipoj_money.action?p.pojid=${lpp.pojid}">参加投资</a>
    				</s:if>
    			</s:else></div>
    	</div>
    </s:iterator>
    </div>
     <div  style="width:17%;float:left;"></div>
    <div  style="width:100%;float:left;">
     <form method="post" action="touzipoj_test1.action?">
	    	<s:if test="pp.currentPage==1">上一页</s:if>
	    	<s:else><a href="touzipoj_test1.action?pp.currentPage=${pp.currentPage-1}">上一页</a></s:else>
	    	&nbsp;&nbsp;
	    	<s:if test="pp.currentPage==pp.pageCount">下一页</s:if>
	    	<s:else><a href="touzipoj_test1.action?pp.currentPage=${pp.currentPage+1}">下一页</a></s:else>
	    	&nbsp;&nbsp;
	    	共${pp.pageCount}页&nbsp;第&nbsp;
	    	<input class="ye" type="text" name="pp.currentPage" value="${pp.currentPage}" 
	    	style="width:40px; text-align:center;"/>&nbsp;页&nbsp;
	    	<input type="submit" class="zhubu" value="确定"/>
	    	<br/> <h3><s:actionmessage cssClass="width:50px;"/></h3>
	    </form>
    </div>
    </center>
   </div>	
  </body>
</html>
