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
	<style type="text/css">
	input[type=text], input[type=password] {
   
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    width:100%;
    box-sizing: border-box;
    border-radius:4px;
}
	 .qu{
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
        }  .zhubu{
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
}.errorMessage li {  
            list-style-type: none;  
        }  
        .errorMessage {  
            padding:0;  
        } </style>
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
        document.form1.action="rongzipoj_zancun.action";      
        document.form1.submit();      
  }      
  
  </script>
  <style>.yy td{font-size:1.2em;border-bottom:1px solid #e0e0e0}</style>
  <body>
<br/><br/>
    <form name="form1" id="form1" action="rongzipoj_save.action?u.userid=${session.userid}" enctype="multipart/form-data" method="post"><center>
    <table class="yy" width="431" height="646">
    	<tr><td colspan="2"><center>发起项目</center></td></tr>
    	<tr><td>项目名称</td><td><input type="text" name="p.name" value="${p.name}"/>
    	<input type="hidden" name="u.userid" value="${session.userid}"/>
    	</td></tr>
     	<tr><td>项目图片</td>
      	<td><s:file name="mypic" id="doc" onchange="javascript:setImagePreview();"  accept="image/bmp,image/png,image/gif,image/jpeg"></s:file> 
    	</td></tr> 
    	<tr><td></td>
    	<td><img src="${p.icon}" style="diplay:none" id="preview" class="avatar" 
     		alt="上传" class="avatar" width="114" height="114"></td>
     	</tr>
    	<tr><td>融资类型</td>
    	<td>
    	<s:iterator value="typeListke" var="ty">
			<input type="radio" name="r2.id" value="${ty.id}">${ty.style}&nbsp;
		</s:iterator>
    	</td></tr> 
    	<tr><td>目标金额</td><td><input type="text" name="p.money" value="${p.money}" onkeyup="clearNoNum(this)"/></td></tr>
    	<tr><td>所在地区</td><td><input type="text" name="p.area" value="${p.area}"/></td></tr>
    	<tr><td>融资期限</td><td><input type="text" name="p.period" value="${p.period}" onkeyup="clearNoNumm(this)"/></td></tr>
    	<tr><td>项目简介</td><td><input type="text" name="p.introduce" value="${p.introduce}"/></td></tr>
        <tr><td>证明文件</td>
        <td><s:file name="myfile" id="doc" accept="doc/docx"></s:file></td></tr>
    	<tr><td colspan="2"><center><input type="submit" class="zhubu" value="提交"/>&nbsp;
    	<input type="submit" class="zhubu" value="暂存" onclick="action1()"/>
    	&nbsp;
    	<a href="javascript:history.go(-1)" class="qu">取消</a>
    	</center></td></tr>
    </table></center>
  <center> <s:fielderror theme="simple" fieldName="p.name"></s:fielderror>
  
  </center> 
    </form>
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
