<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
<title>找回密码</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/users.css" />
<link rel="stylesheet" type="text/css" href="css/loader.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
.a{color:white;}#snackbar {
    visibility: hidden;
    min-width: 250px;
    margin-left: -125px;
    background-color: #333;
    color: #fff;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1;
    left: 50%;
    bottom: 30px;
    font-size: 17px;
}

#snackbar.show {
    visibility: visible;
    -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
    animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@-webkit-keyframes fadein {
    from {bottom: 0; opacity: 0;} 
    to {bottom: 30px; opacity: 1;}
}

@keyframes fadein {
    from {bottom: 0; opacity: 0;}
    to {bottom: 30px; opacity: 1;}
}

@-webkit-keyframes fadeout {
    from {bottom: 30px; opacity: 1;} 
    to {bottom: 0; opacity: 0;}
}

@keyframes fadeout {
    from {bottom: 30px; opacity: 1;}
    to {bottom: 0; opacity: 0;}
}
	/* Full-width input fields */
input[type=text], input[type=password] {
   
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    width:20%;
    box-sizing: border-box;
    border-radius:4px;
} .zhubu{
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
}
</style>
<script src="js/jquery.js"></script>
<script src="js/verificationNumbers.js" tppabs="js/verificationNumbers.js"></script>
<script src="js/Particleground.js" tppabs="js/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
  createCode();
  //测试提交，对接程序删除即可
  $(".submit_btn").click(function(){
	  location.href="javascrpt:;"/*tpa=http://***index.html*/;
	  });
});



function myFunction() {
    var x = document.getElementById("snackbar")
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
}
</script>
</head>
<body>
<center><br/><br/><br/>
<form action="forget.action" method="post">
 <h1><font color="white">找回密码</font></h1><br/>

  <input type="text" name="o.userid" value="${o.userid}" placeholder="账号" /><br/>
  <input type="text" name="u.email" value="${u.email}" placeholder="邮箱" /><br/>
  <input type="password" name="newpwd" placeholder="新密码" /><br/>
  <input type="password" name="rnewpwd" placeholder="确认密码" /><br/>
  <input type="submit" value="确定" class="zhubu" /><br/>

  <a href="regist.jsp" class="a" >立即注册 &nbsp;</a>
  <a href="Myindex.jsp" class="a" >返回首页</a> &nbsp;&nbsp;

 <br/><h1>
 <s:actionmessage/>
	<s:fielderror theme="simple" fieldName="o.userid"></s:fielderror>
<s:fielderror theme="simple" fieldName="u.email"></s:fielderror>
<s:fielderror theme="simple" fieldName="newpwd"></s:fielderror>	
<s:fielderror theme="simple" fieldName="rnewpwd"></s:fielderror>			</h1>
</form>

</center>

</body>
</html>
