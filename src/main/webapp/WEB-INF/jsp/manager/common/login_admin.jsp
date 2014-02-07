<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <link href="<%= basePath%>static/manager/themes/css/login.css" rel="stylesheet" type="text/css" />
  <head>    
    <title>应用推广管理后台</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="">
    <meta http-equiv="description" content="应用推广管理后台">
    <script src="<%= basePath%>static/manager/js/jquery-1.4.4.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	<!--
	$(document).ready(function(){
	  var pageContent=$("#login");
	  $("#username", pageContent).focus();
	})
	//-->
	</script>
  </head>
  
  <body>
  <div id="login">
    <div id="login_header">
      <h1 class="login_logo">
<!--         <img src="themes/default/images/logo.png" alt="LOGO" /> -->
      </h1>
      <div class="login_headerContent">
        
        <h1 style="font-size:250%" class="login_title">应用推广</h1>
      </div>
    </div>
    <div id="login_content">
      <div class="loginForm">
        <form action="dologin" method="post">
          <p>
            <label>用户名：</label>
            <input type="text" id="username" name="username" size="20" class="required" />
          </p>
          <p>
            <label>密  码：</label>
            <input type="password" name="password" size="20" class="required" />
          </p>
          <p>
            <label style="color:red;">${model.loginErrInfo}</label><br/>
          </p>
          <div class="login_bar">
            <input class="sub" type="submit" value=" " />
          </div>
        </form>
      </div>
      <div class="login_banner">
        <img src="<%= basePath%>static/manager/themes/default/images/adm_login_banner.jpg" />
      </div>
      <div class="login_main">
        
        <div class="login_inner">
          
        </div>
      </div>
    </div>
    <div id="login_footer">
      Copyright &copy; 2013 www.ihuizhi.com Inc. All Rights Reserved.
    </div>
  </div>
</body>
</html>
