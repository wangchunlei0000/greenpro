<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
<title>注册用户</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css" tppabs="css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
.a{color:white;}
.errorMessage li {  
            list-style-type: none;  
        }  
        .errorMessage {  
            padding:0;  
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


</script>
</head>
<body>

<form class="admin_login" action="logins_reg.action" method="post">
 <dt><strong><font color="white">注册</font></strong></dt>
 
 <dd class="user_icon">
  <input type="text" name="o.userid" id="o.userid" placeholder="账号" class="login_txtbx"/>
 </dd>
 <dd class="user_icon">
  <input type="text" name="email" id="email" placeholder="邮箱" class="login_txtbx"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" name="o.pwd" id="o.pwd" placeholder="密码" class="login_txtbx"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" name="repwd" placeholder="再次输入密码" class="login_txtbx"/>
 </dd>
 
 <dd>
  <input type="submit" value="立即注册" class="submit_btn" />
  
 </dd>
 <dd>
  <a href="logins.jsp" class="a" >返回登录</a>
  <a href="Myindex.jsp" class="a" >返回首页</a>
  
 </dd>
<s:fielderror theme="simple" fieldName="o.userid"></s:fielderror>
<s:fielderror theme="simple" fieldName="o.pwd"></s:fielderror>
<s:fielderror theme="simple" fieldName="repwd"></s:fielderror>
</form>
<center>

</center>

</body>
</html>
