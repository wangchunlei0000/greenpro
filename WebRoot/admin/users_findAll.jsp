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
    
    <title>My JSP 'users_gl.jsp' starting page</title>  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/userall.css">
  </head>
 <style> .zhubu{
	background: #4CAF50;
	color: white;
    padding: 5px 15px;
    margin: 8px 0;
    border: none;
    width:70px;
    height:35px;
    border: none;
    text-decoration: none;
    /**cursor: pointer;*/
}
 	.errorMessage li {  
            list-style-type: none;  
        }  
        .errorMessage {  
            padding:0;  
        } 
        
 </style>
  <body>
  <div align="center"><br/><br/>
       <form action="users_findAll.action">  
	    	<font size="5"><strong>用户账号&nbsp;</strong></font>&nbsp;&nbsp; 
	    	<input class="so" type="text" size=100 name="o.userid"/>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; 
	    	<input type="submit" class="go" value="搜索"/>
	    </form><br/><hr/><br/>
	
	<s:form theme="simple">
	    <table  id="customers" >
	    	<tr>
	    		<!-- --><th>
	    		<s:submit  theme="simple" action="logins_enableBatch" value="启用账户"></s:submit>
	    		<s:submit theme="simple" action="logins_disEnableBatch" value="禁用账户"></s:submit>
	    		</th> 
	    		<th>用户账号</th>
	    		<th>用户姓名</th>
	    		<th>电话</th>
	    		<th>电子邮件</th>
	    		<th>用户角色</th>
	    		<th>是否可用</th>
	    		<th colspan="3">操作</th>
	    	</tr>
	    	<s:iterator value="l" var="oo">
	   		<tr>
	   			<td><input type="checkbox" name="ids" value="${oo[2].userid}"/></td>
	   			<td class="alt">${oo[2].userid}</td>
	   			<td>${oo[2].name}</td>
	   			<td class="alt">${oo[2].phone}</td>
	   			<td class=>${oo[2].email}</td>
	   			<td class="alt">
	   				<s:if test='"0".equals(#oo[1])'>普通用户</s:if>
					<s:elseif test='"1".equals(#oo[1])'>管理员</s:elseif>
	   			</td>
	   			<td>
	   				<s:if test='"0".equals(#oo[0])'>可用</s:if>
					<s:elseif test='"1".equals(#oo[0])'>不可用</s:elseif>
	   			</td>
	   			<td>
	   				<a href="logins_findById.action?o.userid=${oo[2].userid}">查看详情</a>
					<s:if test='"0".equals(#oo[0])'>
					<a href="logins_disEnableBatch.action?ids=${oo[2].userid}" onclick="return confirm('确定禁用账户？');">禁用账户</a></s:if>
					<s:else>
					<a href="logins_enableBatch.action?ids=${oo[2].userid}" onclick="return confirm('确定启用账户？');">启用账户</a></s:else>
	   			</td>
	   		</tr>
	    	</s:iterator>
	    </table></s:form><br/>
	    <form method="post" action="users_test.action">
	    	<s:if test="p.currentPage==1">上一页</s:if>
	    	<s:else><a href="users_test.action?p.currentPage=${p.currentPage-1}">上一页</a></s:else>
	    	&nbsp;&nbsp;
	    	<s:if test="p.currentPage==p.pageCount">下一页</s:if>
	    	<s:else><a href="users_test.action?p.currentPage=${p.currentPage+1}">下一页</a></s:else>
	    	&nbsp;&nbsp;
	    	共${p.pageCount}页&nbsp;第&nbsp;
	    	<input class="ye" type="text" name="p.currentPage" value="${p.currentPage}" style="width:40px; text-align:center;"/>&nbsp;页&nbsp;
	    	<input type="submit" class="zhubu" value="确定"/>
	    	<br/> <h3><s:actionmessage cssStyle="list-style-type: none;"/>
	  
	    	</h3>
	    </form>
	   
    </div>
  </body>
</html>
