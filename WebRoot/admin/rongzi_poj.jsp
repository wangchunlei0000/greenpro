<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>admin/项目管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/fycss.css">
  </head> <style>
 	.errorMessage li {  
            list-style-type: none;  
        }  
        .errorMessage {  
            padding:0;  
        } 
        
 </style>
  <style>.k{
   
    padding: 4px 10px;
    margin: 3px 0;
    display: inline-block;
    border: 1px solid #ccc;
    width:80%;
    box-sizing: border-box;
    border-radius:4px;
} .zhubu{background: #4CAF50;
	color: white;
    padding: 5px 15px;
    margin: 8px 0;
    border: none;
    width:94px;
    height:30px;
    font-size: 14px;
    text-decoration: none;
}div.polaroid {
  width: 500px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  text-align: center;
}

div.container {
  padding: 10px;
}
</style>
  <body>
  
  	<center><br/>项目管理<br/>
          
     <form action="rongzipoj_adminfindall.action" method="post">
    <table>
    	<tr><td>项目名称</td><td><input class="k" name="p.name"/></td></tr>
    	<tr><td>项目类型</td>
    	<td>
    	<s:iterator value="typeList" var="ty">
    	
		<input type="radio" name="r2.id" value="${ty.id}">${ty.style}&nbsp; &nbsp;   &nbsp; 
		</s:iterator>
        </td></tr>
    	<tr><td>项目进程</td>
       	<td>
    	<s:iterator value="stateList" var="st">
    	<s:if test="(#st.id)==10"></s:if>
    	<s:else>
		<input type="radio" name="r1.id" value="${st.id}">${st.style}&nbsp; &nbsp;</s:else>
		</s:iterator>
    	</td>
    	</tr>
    	<tr><td style="text-align: center"colspan="2"></td></tr>
    </table><input class="zhubu" type="submit" value="筛选"/>&nbsp;&nbsp;
    <a href="rongzipoj_adminfindall.action?r1.id=&r2.id=&p.name=" class="zhubu">查看全部</a>
    	
    </form><hr/><br/>
    </center>	
    <div style="padding-left:220px;">
    <s:iterator value="poj" var="lpp">
    	<div class="polaroid" style="padding-left:20px;padding-right:30px;margin:30px;float:left;width:500px;">
    	 <div class="polaroid">
  		<img src="${lpp.icon}" alt="image" class="avatar" width="490" height="300"><br/> </div>
    	<center>
    	<a href="cypoj_users?po.pojid=${lpp.pojid}">${lpp.name}</a>&nbsp;&nbsp;
    		<s:if test="(#lpp.rongziState.id)==1">
    		<a href="rongzipoj_tong.action?p.pojid=${lpp.pojid}">通过</a>&nbsp;&nbsp;
				<a href="rongzipoj_jujue.action?p.pojid=${lpp.pojid}">拒绝</a>
				
			</s:if>
		<s:elseif test="(#lpp.rongziState.id)==8">
	 &nbsp;&nbsp;<a href="rongzipoj_tong.action?p.pojid=${lpp.pojid}">去除举报</a>
		&nbsp;&nbsp;<a href="rongzipoj_delete.action?p.pojid=${lpp.pojid}" onclick="return confirm('确定删除?');">删除</a></s:elseif>
         </center>
    	</div>
    </s:iterator></div>
    <div  style="width:100%;float:left;"><center>
     <form method="post" action="rongzipoj_test0.action">
       	

     
	    	<s:if test="pp.currentPage==1">上一页</s:if>
	    	<s:else><a href="rongzipoj_test0.action?pp.currentPage=${pp.currentPage-1}&pp.pageCount=${pp.pageCount}">上一页</a></s:else>
	    	&nbsp;&nbsp;
	    	<s:if test="pp.currentPage==pp.pageCount">下一页</s:if>
	    	<s:else><a href="rongzipoj_test0.action?pp.currentPage=${pp.currentPage+1}&pp.pageCount=${pp.pageCount}">下一页</a></s:else>
	    	&nbsp;&nbsp;
	    	共${pp.pageCount}页&nbsp;第&nbsp;
	    	<input class="ye" type="text" name="pp.currentPage" value="${pp.currentPage}" 
	    	style="width:40px; text-align:center;"/>&nbsp;页&nbsp;
	    	<input type="submit" class="zhubu" value="确定"/>
	    	<br/> 
	    	
	  
	    </form>
	    <s:actionmessage cssStyle="list-style-type: none;"/></center>
    </div>
   
   
  </body>
</html>
