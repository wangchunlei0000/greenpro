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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
body{background:#F5F5DC;
font-size:1.2em;}
.yy td {font-size:1.2em;border-bottom:1px solid #e0e0e0}
.zhubu{
	background: #4CAF50;
	color: white;
    padding: 5px 15px;
    margin: 8px 0;
    border: none;
    text-decoration: none;
 
}
 .errorMessage li {  
            list-style-type: none;  
        }  
        .errorMessage {  
            padding:0;  
        } 
</style>
  </head>
  
  <body><div style="height:5%"><jsp:include page="/banner.jsp"></jsp:include>
  </div><div style="height=95%">
    <center><br/><br/>
    <h3>项目详情</h3>
     <%  
		String i=request.getAttribute("p.money").toString();
		java.text.DecimalFormat df=new java.text.DecimalFormat("#0.00");   
		Double d=Double.parseDouble(i);  
		java.math.BigDecimal big = new java.math.BigDecimal(df.format(d));
		String ii="0";
			Double dd=Double.parseDouble(ii);  
		    java.math.BigDecimal bigg = new java.math.BigDecimal(df.format(dd));
		if(request.getAttribute("p.nowmoney")!=null&!"".equals(request.getAttribute("p.nowmoney"))){
			ii=request.getAttribute("p.nowmoney").toString();
		    dd=Double.parseDouble(ii);  
		    bigg = new java.math.BigDecimal(df.format(dd));
		}
	%>
    <table class="yy" width="427" height="365">
    	<tr><td width="43%">项目号:</td><td>${p.pojid}</td></tr>
    	<tr><td>项目名:</td><td>${p.name}</td></tr>
    	<tr><td>发起人:</td><td>${p.users.userid}</td></tr>
    	<tr><td>项目简介:</td><td>${p.introduce}</td></tr>
    	<tr><td>投资类型:</td><td>${p.touziType.style}</td></tr>
    	<tr><td>投资状态:</td><td>${p.touziState.style}</td></tr>
    	<tr><td>目标资金:</td><td><%=big %></td></tr>
    	<tr><td>现投资金额:</td><td><%=bigg %></td></tr>
    	<tr><td>所属区域:</td><td>${p.area}</td></tr>
    	<tr><td>开始时间</td><td>${p.starttime}</td></tr>
    	<tr><td>项目图片:</td><td height="170px"><img src="${p.icon}" width="140" height="109"></td></tr>
    	<tr><td height="10%">项目文件:</td><td height="10%"><a href="${p.by1}">${p.by1}</a></td></tr>
 
    </table>
    <form action="up_Tnowmoney.action?p.pojid=${p.pojid}&u.userid=${session.userid}" method="post"> 
    	投资金额：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="tzmoney" onkeyup="clearNoNum(this)"/>
    		   <input class="zhubu" type="submit" value="确定"/>
    		   <s:fielderror theme="simple"  fieldName="tzmoney"></s:fielderror>
    		   <br/><br/>
    		   <a href="y_ytfindByTitle.action?p.name=&r1.id=&r2.id" class="zhubu"><span>返回</span></a>
    </form>
    
    </center>
      <script language="JavaScript" type="text/javascript"> 
function clearNoNum(obj){ 
    obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符  
    obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的  
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数  
    if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额 
        obj.value= parseFloat(obj.value); 
        //onkeyup="clearNoNum(this)"
    } 
} 
</script></div>
  </body>
</html>
