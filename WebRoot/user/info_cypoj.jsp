<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'info_cypoj.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/button.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>.yy td{font-size:1.2em;border-bottom:1px solid #e0e0e0}
 .zhubu{
	background: #4CAF50;
	color: white;
    padding: 5px 15px;
    margin: 8px 0;
    border: none;
    width:94px;
    height:30px;
    font-size: 14px;
    
    /**cursor: pointer;*/
}
</style>
  </head>
  
  <body>
  <center><br/><br/>
   <%  
		String i="0";
    	java.text.DecimalFormat df=new java.text.DecimalFormat("#0.00");   
		Double d=Double.parseDouble(i);  
		java.math.BigDecimal big = new java.math.BigDecimal(df.format(d));
    	if(request.getAttribute("c.money")!=null&!"".equals(request.getAttribute("c.money"))){
			i=request.getAttribute("c.money").toString();
		
		    d=Double.parseDouble(i);  
		    big = new java.math.BigDecimal(df.format(d));
		   // out.println("c.money"+big);
		}
			String ii="0";
			Double dd=Double.parseDouble(ii);  
		    java.math.BigDecimal bigg = new java.math.BigDecimal(df.format(dd));   
		if(request.getAttribute("c.rongziPoj.money")!=null&!"".equals(request.getAttribute("c.rongziPoj.money"))){
			ii=request.getAttribute("c.rongziPoj.money").toString();
		    dd=Double.parseDouble(ii);  
		    bigg = new java.math.BigDecimal(df.format(dd));
		   // out.println("money"+bigg);
		}
			String iii="0";
			Double ddd=Double.parseDouble(iii);  
		    java.math.BigDecimal biggg = new java.math.BigDecimal(df.format(ddd));   
		if(request.getAttribute("c.rongziPoj.nowmoney")!=null&!"".equals(request.getAttribute("c.rongziPoj.nowmoney"))){
			iii=request.getAttribute("c.rongziPoj.nowmoney").toString();
		    ddd=Double.parseDouble(iii);  
		    biggg = new java.math.BigDecimal(df.format(ddd));//out.println(biggg);
		}
	%>
  <h3>${c.rongziPoj.name}</h3>
     <table class="yy" width="433" height="395">
    	<tr><td width="43%">项目号:</td><td>${c.rongziPoj.pojid}</td></tr>
    	<tr><td>项目名:</td><td>${c.rongziPoj.name}</td></tr>
    	<tr><td>发起人:</td><td>${c.users.userid}</td></tr>
    	<tr><td>参与金额:</td><td><%=big %></td></tr>
    	<tr><td>融资状态:</td><td>${c.rongziPoj.rongziState.style}</td></tr>
    	<tr><td>目标资金:</td><td><%=bigg %></td></tr>
    	<tr><td>现融资金额:</td><td><%=biggg %></td></tr>
    	<tr><td>所属区域:</td><td>${c.rongziPoj.area}</td></tr>
    	<tr><td>开始时间</td><td>${c.rongziPoj.starttime}</td></tr>
    	<tr><td>项目图片:</td><td><img src="${c.rongziPoj.icon}" width="140" height="109"></td></tr>
    	<tr><td height="10%">项目文件:</td><td height="10%"><a href="${c.rongziPoj.by1}">${c.rongziPoj.by1}</a></td></tr>
 
    </table><br/>
    <a class="zhubu" href="javascript:history.go(-1)">确定</a>
    </center>
  </body>
</html>
