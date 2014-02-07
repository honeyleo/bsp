<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
<!--
$(document).ready(function(){
  var pageContent=$("#login_dialog");
  $("#username", pageContent).focus();
})
-->
</script>
<div class="pageContent" id="login_dialog">  
  <form method="post" action="dologin" class="pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
    <div class="pageFormContent" layoutH="58">
      <div class="unit">
        <label>用户名：</label>
        <input type="text" name="username" size="30" class="required" id="username"/>
      </div>
      <div class="unit">
        <label>密  码：</label>
        <input type="password" name="password" size="30" class="required"/>
      </div>
    </div>
    <div class="formBar">
      <ul>
        <li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
        <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
      </ul>
    </div>
  </form>  
</div>
