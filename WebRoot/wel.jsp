<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'wel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
@keyframes animX{  
          0% {left: 0px;}  
        100% {left: 500px;}  
    }  
    @keyframes animY{  
          0% {top: 0px;}  
        100% {top: 500px;}  
    }  
      
    .ball {  
        width: 20px;  
        height: 20px;  
        border-radius: 50%;  
        position: absolute;  
            }  
    
    #lopp {  
        width: 498px;  
        height: 498px;  
        border: 2px solid #999;  
        border-radius: 50%;  
        position: absolute;  
        left: 9px;  
        top: 9px;  
    } 
    .ThreeDee {font-family: 'Microsoft YaHei';
line-height: 1em;
color: #ffffff;
font-weight:bold;
font-size: 80px;
text-shadow:0px 0px 0 rgb(231,231,231),1px 1px 0 rgb(216,216,216),2px 2px 0 rgb(202,202,202),3px 3px 0 rgb(187,187,187),4px 4px 0 rgb(173,173,173),5px 5px 0 rgb(158,158,158), 6px 6px 0 rgb(144,144,144),7px 7px 6px rgba(0,0,0,0.6),7px 7px 1px rgba(0,0,0,0.5),0px 0px 6px rgba(0,0,0,.2);}
</style>
  </head>
  
  <body>
  
    <div style="margin-left:550px;margin-top:180px;float:left;" id="lopp">
   
    </div>   <div style="text-decoration:blink;left;margin-left:550px;margin-top:300px;"><h1 class="ThreeDee">&nbsp;&nbsp;&nbsp;&nbsp;欢迎登录</h1></div>
    <div style="animation: animX 4s cubic-bezier(0.36,0,0.64,1) -2s infinite alternate, animY 4s cubic-bezier(0.36,0,0.64,1)  0s infinite alternate;  
    margin-left:550px;margin-top:180px;float:left;background-color:#2E8B57;" class="ball"></div> 
     <div style=" animation: animX 2s cubic-bezier(0.36,0,0.64,1) -1s infinite alternate, animY 2s cubic-bezier(0.36,0,0.64,1)  0s infinite alternate;  
     margin-left:550px;margin-top:180px;float:left;background-color:#4169E1;" class="ball"></div> 
      <div style="animation: animX 8s cubic-bezier(0.36,0,0.64,1) -4s infinite alternate, animY 8s cubic-bezier(0.36,0,0.64,1)  0s infinite alternate;  
 margin-left:550px;margin-top:180px;float:left;background-color:#A52A2A;" class="ball"></div> 
       <div style="animation: animX 5s cubic-bezier(0.36,0,0.64,1) -2.5s infinite alternate, animY 5s cubic-bezier(0.36,0,0.64,1)  0s infinite alternate;margin-left:550px;margin-top:180px;float:left;background-color:#D2691E;" class="ball"></div> 
       <div style="margin-left:550px;margin-top:180px;float:left;background-color:#E9967A;animation: animX 9s cubic-bezier(0.36,0,0.64,1) -4.5s infinite alternate, animY 9s cubic-bezier(0.36,0,0.64,1)  0s infinite alternate;" class="ball"></div>
<div style="animation: animX 6s cubic-bezier(0.36,0,0.64,1) -3s infinite alternate, animY 6s cubic-bezier(0.36,0,0.64,1)  0s infinite alternate;margin-left:550px;margin-top:180px;float:left;background-color:#FFA500;" class="ball"></div> 
<div style="animation: animX 7s cubic-bezier(0.36,0,0.64,1) -3.5s infinite alternate, animY 7s cubic-bezier(0.36,0,0.64,1)  0s infinite alternate;margin-left:550px;margin-top:180px;float:left;background-color:#BA55D3;" class="ball"></div> 
<div style="animation: animX 10s cubic-bezier(0.36,0,0.64,1) -5s infinite alternate, animY 10s cubic-bezier(0.36,0,0.64,1)  0s infinite alternate;margin-left:550px;margin-top:180px;float:left;background-color:#00FFFF" class="ball"></div> 
<div style="animation: animX 11s cubic-bezier(0.36,0,0.64,1) -5.5s infinite alternate, animY 11s cubic-bezier(0.36,0,0.64,1)  0s infinite alternate;margin-left:550px;margin-top:180px;float:left;background-color:#696969;" class="ball"></div> 
<div style="animation: animX 12s cubic-bezier(0.36,0,0.64,1) -6s infinite alternate, animY 12s cubic-bezier(0.36,0,0.64,1)  0s infinite alternate;margin-left:550px;margin-top:180px;float:left;background-color:#F08080;" class="ball"></div>   </body>
</html>
