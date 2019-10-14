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
	<style type="text/css"> .zhubu{
	background: #4CAF50;
	color: white;
    padding: 5px 15px;
    margin: 8px 0;
    border: none;
    width:70px;
    height:33px;
    border: none;
    text-decoration: none;
    /**cursor: pointer;*/
}.in{
   
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    width:100%;
    box-sizing: border-box;
    border-radius:4px;
}.errorMessage li {  
            list-style-type: none;  
        }  
        .errorMessage {  
            padding:0;  
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
	</script><script   language="javascript">      
    
  
  </script>
  </head>
 
 
  <style>.yy td{font-size:1.2em;border-bottom:1px solid #e0e0e0}</style>
  <body>
<br/><br/>
    <form name="form1" id="form1" action="news_add.action" enctype="multipart/form-data" method="post"><center>
    <table class="yy" width="603" height="529">
    	<tr><td colspan="2"><center>创建资讯</center></td></tr>
    	<tr><td width="20%">资讯标题</td><td><input class="in" name="n.head" value="${n.head}"/>
    	<input type="hidden" name="u.userid" value="${session.userid}"/>
    	</td></tr>
     	<tr><td>资讯图片</td>
      	<td><s:file name="mypic" id="doc" onchange="javascript:setImagePreview();"  accept="image/bmp,image/png,image/gif,image/jpeg"></s:file> 
    	</td></tr> 
    	<tr><td></td>
    	<td><img src="${n.icon}" style="diplay:none" id="preview" class="avatar" 
     		alt="上传" class="avatar" width="114" height="114"></td>
     	</tr>
    	<tr><td>资讯类型</td>
    	<td>
    	<s:iterator value="ntlistke" var="ntk">
			<input type="radio" name="t.id" value="${ntk.id}">${ntk.style}&nbsp;
		</s:iterator>
    	</td></tr> 
    
    	<tr><td>资讯内容</td><td><textarea class="in" name="n.text" cols="30" rows="10" ></textarea>（限制4000字）</td></tr>
    	<tr><td colspan="2"><center><input type="submit" class="zhubu" value="提交"/>&nbsp;
    	<a href="javascript:history.go(-1)" class="qu">取消</a>
    	</center></td></tr>
    </table></center>
  <center> <s:fielderror theme="simple" fieldName="p.name"></s:fielderror>
  
  </center> 
    </form>
   
  </body>
</html>
