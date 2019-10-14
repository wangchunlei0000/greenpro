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
    
    <title>My JSP 'info_poject.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script>
		// 获取模型
			var modal = document.getElementById('id01');
			var modal1 =document.getElementById('id02');
		// 鼠标点击模型外区域关闭登录框
			window.onclick = function(event) {
    		if (event.target == modal) {
        		modal.style.display = "none";
   			 }
			}
			window.onclick = function(event) {
    		if (event.target == modal1) {
        		modal1.style.display = "none";
   		 }
		}
	</script>
	<style>

.modal {
    display: none; /* Hidden by default */
    top: 0px;
    left: 0px;
    right: 0px;
    bottom: 0px;
    margin: auto;
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    width: 60%; /* Full width */
    height: 80%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}


body{text-align:center;}

/* Modal Content/Box */
.modal-content {
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border:none;
    width: 80%; /* Could be more or less, depending on screen size */
    padding:20px;
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
   
}

		</style>
  
<style>
.yy td{font-size:1.2em;border-bottom:1px solid #e0e0e0}
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
}</style>
  </head>
  
  <body>
  <div style="height:5%;width:100%">
  <jsp:include page="banner.jsp"></jsp:include>
  </div><div style="width:100%;height:95%">
    <center><br/><br/>
    <h3>项目详情</h3>
    <%  
		String i="0";
    	java.text.DecimalFormat df=new java.text.DecimalFormat("#0.00");   
		Double d=Double.parseDouble(i);  
		java.math.BigDecimal big = new java.math.BigDecimal(df.format(d));
    	if(request.getAttribute("p.money")!=null&!"".equals(request.getAttribute("p.money"))){
			i=request.getAttribute("p.money").toString();
		    d=Double.parseDouble(i);  
		    big = new java.math.BigDecimal(df.format(d));
		}
		String ii="0";
			Double dd=Double.parseDouble(ii);  
		    java.math.BigDecimal bigg = new java.math.BigDecimal(df.format(dd));   
		if(request.getAttribute("p.nowmoney")!=null&!"".equals(request.getAttribute("p.nowmoney"))){
			ii=request.getAttribute("p.nowmoney").toString();
		    dd=Double.parseDouble(ii);  
		    bigg = new java.math.BigDecimal(df.format(dd));
		}
	%>
    <table class="yy" width="35%" height="60%">
    	<tr><td width="43%">项目号:</td><td>${p.pojid}</td></tr>
    	<tr><td>项目名:</td><td>${p.name}</td></tr>
    	<tr><td>发起人:</td><td>${p.users.userid}</td></tr>
    	<tr><td>项目简介:</td><td>${p.introduce}</td></tr>
    	<tr><td>融资类型:</td><td>${p.rongziType.style}</td></tr>
    	<tr><td>融资状态:</td><td>${p.rongziState.style}</td></tr>
    	<tr><td>目标资金:</td><td><%=big %></td></tr>
    	<tr><td>现融资金额:</td><td><%=bigg %></td></tr>
    	<tr><td>所属区域:</td><td>${p.area}</td></tr>
    	<tr><td>开始时间</td><td>${p.starttime}</td></tr>
    	<tr><td>项目图片:</td><td height="170px"><img src="${p.icon}" alt="暂无图片" width="140px" height="80px"></td></tr>
    	<tr><td height="10%">项目文件:</td><td height="10%"><a href="${p.by1}">${p.by1}</a></td></tr>
 		
    </table><br/>
 
    <a class="zhubu" href="javascript:history.go(-1)">确定</a>&nbsp;&nbsp;
  	<!-- <a class="zhubu" href="cypoj_users.action?po.pojid=${p.pojid}">查看融资状况</a> -->
  
       	<s:if test="(p.rongziState.id)==2">
       	   	<s:if test="%{p.users.userid.equals(#session.userid)}">
<button  class="zhubu" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">查看融资状态</button>
       	</s:if>	<s:elseif test='%{"1".equals(#session.role)}'>
<button  class="zhubu" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">查看融资状态</button>
       	</s:elseif>
       	</s:if>
 
<div id="id01" class="modal">
    <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
  <div style="width:100%">
  
    <h2 style="color:white">参与项目-${p.name}融资的用户</h2><br/>
      <table style="border: 1px solid rgb(224, 224, 224); background: black none repeat scroll 0% 0%; font-size: 1.2em; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;" width="828" >
    	<tr>
    		<th style="border:1px solid #e0e0e0; color:white">用户账号</th>
    		<th style="border:1px solid #e0e0e0; color:white">融资金额</th>
    		<th style="border:1px solid #e0e0e0; color:white">用户邮箱</th>
    	</tr>
   
    <s:iterator value="cyp" var="cy">
    	
    	<tr style="color:white">
    		<td  style="text-align:center;font-size:1.2em;border:1px solid #e0e0e0">${cy.users.userid }</td>
    		<td style="text-align:center;font-size:1.2em;border:1px solid #e0e0e0">${cy.money}</td>
    		<td style="text-align:center;font-size:1.2em;border:1px solid #e0e0e0">${cy.users.email}</td>	
    	</tr>
    	</s:iterator>
     </table>
   </div><br/><br/><div style="width:100%">
 <center>  <span onclick="document.getElementById('id01').style.display='none'" class="zhubu" title="Close Modal">确定</span>
 </center> </div>	
 </div>

    </center></div>
  </body>
</html>
