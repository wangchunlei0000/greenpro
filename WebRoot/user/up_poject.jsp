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
    
    <title>My JSP 'up_poject.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<style>.yy td{font-size:1.2em;border-bottom:1px solid #e0e0e0}
	/* Full-width input fields */
input[type=text], input[type=password] {
   
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    width:100%;
    box-sizing: border-box;
    border-radius:4px;
}
 .zhubu{
	background: #4CAF50;
	color: white;
    padding: 5px 15px;
    margin: 8px 0;
    border: none;
    width:70px;
    height:34px;
    border: none;
    text-decoration: none;
 
} .qu{
        background: red;
	color: white;
    padding: 5px 16px;
    margin: 7px 0;
    border: none;
    width:70px;
    height:38px;
    border: none;
    font-size:16px;
    text-decoration: none;    
    /*
    &nbsp;
    	<a href="javascript:history.go(-1)" class="qu">取消</a>
    */
        }</style>
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
  </head>
   <script   language="javascript">      
  function   action1()      
  {      
        document.form1.action="rongzipoj_upzancun.action";      
        document.form1.submit();      
  }      
  
  </script>
  <body>
    <center><br/><br/>
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
    <form name="form1" id="form1" action="rongzipoj_update.action" enctype="multipart/form-data" method="post">
    <center>
     
    <table class="yy" width="474" height="578">
    	<tr><td colspan="2"><center>项目信息</center></td></tr>
     
    	<tr><td>项目名称</td><td><input type="text"  name="p.name" value="${p.name}"/>
    </td></tr>
     	<tr><td>项目图片</td>
      	<td><s:file name="mypic" id="doc" onchange="javascript:setImagePreview();"  accept="image/bmp,image/png,image/gif,image/jpeg"></s:file> 
    	</td></tr> 
    	<tr><td></td>
    	<td><img src="${p.icon}" style="diplay:none" id="preview" alt="上传" class="avatar" width="140" height="114"></td>
     	</tr>
    	<tr><td>融资类型</td>
    	<td>
    	<s:iterator value="typeList" var="ty">
    	<s:if test="(#ty.id)==p.rongziType.id"><input type="radio" name="r2.id" value="${ty.id}" checked="checked">${ty.style}&nbsp; &nbsp;   &nbsp;</s:if>
		<s:else><input type="radio" name="r2.id" value="${ty.id}">${ty.style}&nbsp; &nbsp;   &nbsp; 
		</s:else>
		</s:iterator>
    	</td></tr> 
    	<tr><td>目标金额</td>
    	<td><input type="text" name="p.money" value="<%=big %>" onkeyup="clearNoNum(this)"/>
    	<input type="hidden" name="p.pojid" value="${p.pojid}" />
    	<input type="hidden" name="p.requesttime" value="${p.requesttime}" />
    	<input type="hidden" name="u.userid" value="${session.userid}"/>
    	</td>
    	</tr>
    	<tr><td>所在地区</td><td><input type="text" name="p.area" value="${p.area}"/></td></tr>
    	<tr><td>融资期限</td><td><input type="text" name="p.period" value="${p.period}" onkeyup="clearNoNumm(this)"/></td></tr>
    	<tr><td>项目简介</td><td><input type="text" name="p.introduce" value="${p.introduce}"/></td></tr>
        <tr><td>证明文件</td>
        <td>${p.by1}</td></tr>
    	<tr>
        <td></td>
        <td><s:file name="myfile" id="doc" accept="doc/docx"></s:file>
        </td></tr>
    	<tr><td colspan="2"><center><input type="submit" class="zhubu" value="提交"/>&nbsp;
    	<input type="submit" class="zhubu" value="暂存" onclick="action1()"/>&nbsp; 
    	<a href="javascript:history.go(-1)" class="qu">取消</a>
    	</center></td></tr>
    </table><s:fielderror theme="simple" fieldName="p.name"></s:fielderror>
    
    <s:fielderror theme="simple" fieldName="p.period"></s:fielderror>
    </center>
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
function clearNoNumm(obj){ 
    obj.value = obj.value.replace(/[^\d]/g,"");  //清除“数字”和“.”以外的字符  
  
} 
</script>
  </body>
</html>
