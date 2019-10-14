<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
.bef{position:absolute;
 background:rgba(225,225,225,0);
}	
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

body {
    font-family: "Lato", sans-serif;
    
   
}

.sidenav {
    height: 100%;
    width: 180px;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color:#3CB371;
    overflow-x: hidden;
    padding-top: 20px;
}

.sidenav a {
    padding: 6px 8px 6px 16px;
    text-decoration: none;
    font-size: 25px;
    color: black;
    display: block;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.main {
    margin-left: 180px; /* 与sidenav的宽度相同 */
    font-size: 28px; /* 字体放大，让页面可滚动 */
    padding: 0px 0px;
    
}

@media screen and (max-height: 450px) {
    .sidenav {padding-top: 0px;}
    .sidenav a {font-size: 0px;}
}
	</style>
  </head>
  
  <body>
  <div class="sidenav">
  <br/><br/><br/><center><font size="6" color="#ffffff"><span>管理员登录</span></font></center><br/>&nbsp;&nbsp;&nbsp;&nbsp;
  <SCRIPT>setInterval("clock.innerHTML=new Date().toLocaleString()+'&nbsp;&nbsp;'+''.charAt(new Date().getDay());",1000)</SCRIPT>
  <SPAN id=clock></SPAN>&nbsp;&nbsp;<br/><br/><br/><br/>
  	<center>
  		<a href="newstype_findAll.action" target="mainly">资讯管理功能</a>
  		<a href="rongzitype_findAll.action" target="mainly">融资类型管理</a>
  		<a href="rongzistate_findAll.action" target="mainly">融资状态管理</a>
  		<a href="touzitype_findAll.action" target="mainly">投资类型管理</a>
  		<a href="touzistate_findAll.action" target="mainly">投资状态管理</a>
  		<a href="users_findAll.action?o.userid=" target="mainly">用户管理功能 </a>
  		<a href="rongzipoj_adminfindall.action?p.name=&r1.id=&r2.id=" target="mainly">融资管理功能 </a>
  		<a href="touzipoj_adminfindall.action?p.name=&r1.id=&r2.id=" target="mainly">投资管理功能 </a>
  		<a href="tuichu.action">用户退出登录</a>
  	</center>
  </div>
  
	<div class="main">
	
		<iframe src ="wel.jsp"  frameborder="0"  marginwidth="0" 
		marginheight="0"name="mainly" height="100%" width="100%"></iframe><!-- scrolling="no" -->
     </div>
  

  </body>
</html>
