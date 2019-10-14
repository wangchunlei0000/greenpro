<%@ page language="java" import="java.util.*,java.math.BigDecimal;" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/button.css">
	<link rel="stylesheet" type="text/css" href="css/users.css"> 
	<style>.yy td{font-size:1.2em;}
	.errorMessage li {  
            list-style-type: none;  
        }  
        .errorMessage {  
            padding:0;  
        } </style>
  </head> 
  <script language="javascript">
	
	function setImagePreview() {
var docObj=document.getElementById("doc");
var imgObjPreview=document.getElementById("preview");
if(docObj.files && docObj.files[0]){
//火狐下，直接设img属性
imgObjPreview.style.display = 'block';
imgObjPreview.style.width = '114px';
imgObjPreview.style.height = '114px';
//imgObjPreview.src = docObj.files[0].getAsDataURL();
//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
}else{
//IE下，使用滤镜
docObj.select();
var imgSrc = document.selection.createRange().text;
var localImagId = document.getElementById("localImag");
//必须设置初始大小
localImagId.style.width = "114px";
localImagId.style.height = "114px";
//图片异常的捕捉，防止用户修改后缀来伪造图片
try{
localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
}catch(e){
alert("您上传的图片格式不正确，请重新选择!");
return false;
}
imgObjPreview.style.display = 'none';
document.selection.empty();
}
return true;
}
	</script>
  <body>
  <script language="JavaScript" type="text/javascript"> 
function clearNoNum(obj){ 
    obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符  
    obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的  
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数  
    if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额 
        obj.value= parseFloat(obj.value); 
    } 
} 
</script>
  <center>
    <form action="users_update.action?o.userid=${session.userid}&o.head=${o.head}" method="post" enctype="multipart/form-data">
    <br/><br/><br/>
<table width="628" height="178">
    <tr><td>
     	<div id="localImag"> 
     		<center><img src="${o.head}" id="preview" class="avatar" 
     		alt="上传头像" class="avatar" width="145" height="114"></center>
     	</div></td>
     </tr>
</table>
<table class="yy" width="400" height="287">
<tr><td colspan="2"><s:file cssClass="color:red;" name="mypic" id="doc" onchange="javascript:setImagePreview();" accept="image/bmp,image/png,image/gif,image/jpeg"></s:file></td></tr>
	<tr>
   	 		<td><strong>账&nbsp;&nbsp; 号:</strong></td>
   	 		<td>${session.userid}</td>
   	</tr> 
   	<tr>
   	 		<td><strong>真实姓名:</strong></td>
   	 		<td><input type="text" name="o.name" value="${o.name}"/></td>
   	</tr>
   	<tr>
   	
   	 		<td><strong>性&nbsp;&nbsp;&nbsp;别:</strong></td>
   	 		<td>
   	 			<s:if test='o.sex=="女"'><input name="o.sex" type="radio" checked="checked" value="女" /><label>女&nbsp; &nbsp;</label></s:if>
   	 			<s:else><input name="o.sex" type="radio" value="女" /><label>女</label> &nbsp; &nbsp; </s:else>
   	 			<s:if test='o.sex=="男"'><input name="o.sex" type="radio" checked="checked" value="男" /><label>男&nbsp; &nbsp;</label></s:if>
   	 			<s:else><input name="o.sex" type="radio" value="男" /><label>男</label> &nbsp; &nbsp; </s:else>
   	 			<s:if test='o.sex=="保密"'><input name="o.sex" type="radio" checked="checked" value="保密" /><label>保密&nbsp; &nbsp;</label></s:if>
   	 			<s:else><input name="o.sex" type="radio" value="保密" /><label>保密</label> &nbsp; &nbsp; </s:else>
   	 			
   	 			
			</td>
	</tr>
	<tr>
	 		<td><strong>昵&nbsp;&nbsp;&nbsp;称:</strong></td>
	 		<td><input type="text" name="o.username" value="${o.username}"/></td>
	</tr>
	<tr>
	 		<td><strong>手机号码:</strong></td>
	 		<td><input type="text" name="o.phone" value="${o.phone}"/></td>
	</tr>
	<tr>
	 		<td><strong>邮&nbsp;&nbsp;&nbsp;箱:</strong></td>
	 		<td><input type="text" name="o.email" value="${o.email}"/></td>
	</tr>
	<tr>
	 		<td><strong>传&nbsp;&nbsp;&nbsp;真:</strong></td>
	 		<td><input type="text" name="o.fax" value="${o.fax}"/></td>
	</tr> 
	<tr>
	<%  
	
		java.text.DecimalFormat df=new java.text.DecimalFormat("#0.00");   
		BigDecimal big=new BigDecimal(df.format(0.0));
		try{
		String i=request.getAttribute("o.money").toString();
		Double d=Double.parseDouble(i);  
 		
		big = new BigDecimal(df.format(d));}
		catch(Exception e){
			big=new BigDecimal(df.format(0.0));
		}
		%>
	 		<td><strong>余&nbsp;&nbsp;&nbsp;额:</strong></td>
	 		<td><input type="text" name="o.money" value="<%=big %>" onkeyup="clearNoNum(this)"/></td><!-- onkeyup="value=value.replace(/[^\d\.]/g,'')" -->
	</tr> 
	
	<tr>	
  	 		<td colspan="2">
   		<center>
   		  <input class="button" type="submit" value="确定"/>
  	   </center></td>
 	</tr>
</table><s:fielderror theme="simple" fieldName="o.email"></s:fielderror>
<s:fielderror theme="simple" fieldName="o.phone"></s:fielderror>
<s:fielderror theme="simple" fieldName="o.money"></s:fielderror>
<s:fielderror theme="simple" fieldName="repwd"></s:fielderror>
</form>

 </center>
  </body>
</html>
