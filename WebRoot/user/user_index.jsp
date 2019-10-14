<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户个人中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
	
	#main,.main {
 position:absolute;
 background:rgba(225,225,225,0);

	}
	
 body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover, .offcanvas a:focus{
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

#main {
    transition: margin-left .5s;
    padding: 0px 0px;
    margin:0px 0px;
}
.if{
	padding: 0px 0px;
    margin:0px 0px;
    width:100%;
    height:100%;
     background-position: 100% 100%;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
	</style>

<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
}
</script>
   
  </head>
  
<body style="background:#20B2AA;">
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="users_look.action?o.userid=${session.userid}" target="mainly">信息卡片<img alt="" src="img/xinxi.gif" width="20" height="20"></a>
  <a href="users_toup.action?o.userid=${session.userid}" target="mainly">完善信息<img alt="" src="img/ws.gif" width="20" height="20"></a>
  <a href="news_findAllByTitle.action?u.userid=${session.userid}&t.id=&n.head=" target="mainly">
  我的资讯<img alt="" src="img/11.gif" width="20" height="20"></a>
  <a href="rongzipoj_findAllByTitle.action?u.userid=${session.userid}&r1.id=&r2.id=&p.name=" target="mainly">
  融资项目<img alt="" src="img/shezhi.gif" width="20" height="20"></a>
  
  <a href="touzipoj_findAllByTitle.action?u.userid=${session.userid}&r1.id=&r2.id=&p.name=" target="mainly">
  投资项目<img alt="" src="img/22.gif" width="20" height="20"></a>
  <a href="cypoj_findAll.action?u.userid=${session.userid}&r1.id=&r2.id=&po.name=" target="mainly">
  融资参与<img alt="" src="img/cy.gif" width="20" height="20"></a>
  <a href="cytpoj_findAll.action?u.userid=${session.userid}&r1.id=&r2.id=&po.name=" target="mainly">
  投资参与<img alt="" src="img/33.gif" width="20" height="20"></a>
  <!-- &r1.id=&r2.id=&p.name= -->
  <a href="email_look.action?u.userid=${session.userid}" target="mainly">
  我的消息<img alt="" src="img/you.gif" width="20" height="20"></a>
  <a href="logins_topwd.action?o.userid=${session.userid}" target="mainly">修改密码<img alt="" src="img/44.gif" width="20" height="20"></a>
  <a href="Myindex.jsp">返回首页<img alt="" src="img/shouye.gif" width="20" height="20"></a>
  <a href="tuichu.action">退出登录<img alt="" src="img/tuichu.gif" width="20" height="20"></a>
</div>

<div id="main" style="top: 17px;">
  <span style="font-size:30px;cursor:pointer" onclick="openNav()"> >>>用户中心</span>
</div>
<div class="if">
<center>
<div class="main" style="top: -1px; left: 546px; height: 70px;">
		
		</div></center>
        <iframe src =""  frameborder="0"  marginwidth="0"
		marginheight="0"name="mainly" height="100%" width="100%"></iframe><!-- scrolling="no" -->
		
</div>
</body>
</html>


