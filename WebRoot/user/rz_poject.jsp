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
  </head>
  
  <body><center><br/> 
              <font size="5">我的融资项目</font><br>
    <form action="rongzipoj_findAllByTitle.action?u.userid=${session.userid}" method="post">
    <table>
    	<tr><td><font size="4">项目名称</font></td><td><font size="4">
    	<input class="k" name="p.name"></font></td><td><input class="button" type="submit" value="筛选"/></td></tr>
    	<tr><td><font size="4">项目类型</font></td>
    	<td>
    		<s:iterator value="typeList" var="ty">
		<input type="radio" name="r2.id" value="${ty.id}">${ty.style}&nbsp; &nbsp;   &nbsp; 
		</s:iterator>
        </td></tr>
    	<tr><td><font size="4">项目进程</font></td>
       	<td>
    	<s:iterator value="stateList" var="st">
		<input type="radio" name="r1.id" value="${st.id}">${st.style}&nbsp; &nbsp;   &nbsp; 
		</s:iterator>
    	</td>
    	
    	</tr>
    	
    </table><a class="aa" href="rongzipoj_findAllByTitle.action?u.userid=${session.userid}&r1.id=&r2.id=&p.name="><span>查看全部</span></a>
    	&nbsp;&nbsp;&nbsp;<a class="aa" href="create.action"><span>新建项目</span></a>
    </form><hr/><br/>
    <div>
    <div style="width:18%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
    <div style="padding-left:10px;padding-right:0px;margin:25px;float:left;width:65%">
   
    <s:iterator value="poj" var="lpp">
   
    	<div class="polaroid" style="padding-left:20px;padding-right:30px;margin:25px;float:left;width:500px;">
    	 <div class="polaroid">
    	<img src="${lpp.icon}" alt="项目图片" class="avatar" width="500" height="320">
    	</div>
    	<div class="container">
  			  <p><a href="cypoj_users?po.pojid=${lpp.pojid}">${lpp.name}</a>&nbsp;&nbsp;<!-- rongzipoj_look -->
    	<s:if test="(#lpp.rongziState.id)==1">已提交</s:if>
		<s:elseif test="(#lpp.rongziState.id)==2">正在融资</s:elseif>
		<s:elseif test="(#lpp.rongziState.id)==4">融资结束</s:elseif>
		<s:elseif test="(#lpp.rongziState.id)==5">已拒绝&nbsp;&nbsp;
		<a href="rongzipoj_toupdate.action?p.pojid=${lpp.pojid}">重新提交<img alt="" src="img/bianxie.gif" width="20" height="20"></a></s:elseif>
		<s:elseif test="(#lpp.rongziState.id)==8">&nbsp;&nbsp;被举报</s:elseif>
		<s:elseif test="(#lpp.rongziState.id)==10">&nbsp;&nbsp;
		<a href="rongzipoj_toupdate.action?p.pojid=${lpp.pojid}">继续编辑<img alt="" src="img/bianxie.gif" width="20" height="20"></a></s:elseif>
		&nbsp;&nbsp;<a href="rongzipoj_udelete.action?p.pojid=${lpp.pojid}&u.userid=${session.userid}" onclick="return confirm('确定删除?');">
		<img alt="" src="img/shanchu.gif" width="20" height="20"></a></p>
  		</div>
    	
    	</div>
    </s:iterator>
    </div>
    <div  style="width:17%;float:left;"></div><br/>
    </div>
    <div  style="width:100%;float:left;">
     <form method="post" action="rongzipoj_test.action?u.userid=${session.userid}">
	    	<s:if test="pp.currentPage==1">上一页</s:if>
	    	<s:else><a href="rongzipoj_test.action?pp.currentPage=${pp.currentPage-1}&u.userid=${session.userid}&pp.pageCount=${pp.pageCount}">上一页</a></s:else>
	    	&nbsp;&nbsp;
	    	<s:if test="pp.currentPage==pp.pageCount">下一页</s:if>
	    	<s:else><a href="rongzipoj_test.action?pp.currentPage=${pp.currentPage+1}&u.userid=${session.userid}&pp.pageCount=${pp.pageCount}">下一页</a></s:else>
	    	&nbsp;&nbsp;
	    	共${pp.pageCount}页&nbsp;第&nbsp;
	    	<input class="ye" type="text" name="pp.currentPage" value="${pp.currentPage}" 
	    	style="width:40px; text-align:center;"/>&nbsp;页&nbsp;
	    	<input type="submit" class="button" value="确定"/>
	    	<br/> <h3><s:actionmessage cssClass="width:50px;"/></h3>
	    </form>
    </div>
    </center>
  </body>
</html>
