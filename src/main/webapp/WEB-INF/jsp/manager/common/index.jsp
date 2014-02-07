<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="funcs" uri="funcs" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>应用推广管理后台</title>

<link href="<%= basePath%>static/manager/themes/default/style.css" rel="stylesheet" type="text/css" />
<link href="<%= basePath%>static/manager/themes/css/core.css" rel="stylesheet" type="text/css" />
<link href="<%= basePath%>static/manager/js/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" />
<![endif]-->
<link href="<%= basePath%>static/manager/css/common.css" rel="stylesheet" type="text/css" />
<link href="<%= basePath%>static/manager/css/acc.css" rel="stylesheet" type="text/css" />
<link href="<%= basePath%>static/manager/css/tree_table.css" rel="stylesheet" />

<script src="<%= basePath%>static/manager/js/speedup.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/xheditor/xheditor-1.1.14-zh-cn.min.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/jquery.treeTable.js" type="text/javascript"></script>

<script src="<%= basePath%>static/manager/js/uploadify/swfobject.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/uploadify/jquery.uploadify.v2.1.0.js" type="text/javascript"></script>

<link rel="StyleSheet" href="<%= basePath%>static/manager/js/dtree/dtree.css" type="text/css" />
<script type="text/javascript" src="<%= basePath%>static/manager/js/dtree/dtree.js"></script>

<script src="<%= basePath%>static/manager/js/dwz.core.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.util.date.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.drag.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.tree.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.accordion.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.ui.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.theme.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.navTab.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.tab.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.resize.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.dialog.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.stable.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.ajax.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.pagination.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.database.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.effects.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.panel.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.history.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/dwz.combox.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="<%= basePath%>static/manager/js/chart/raphael.js"></script>
<script type="text/javascript" src="<%= basePath%>static/manager/js/chart/g.raphael.js"></script>
<script type="text/javascript" src="<%= basePath%>static/manager/js/chart/g.bar.js"></script>
<script type="text/javascript" src="<%= basePath%>static/manager/js/chart/g.line.js"></script>
<script type="text/javascript" src="<%= basePath%>static/manager/js/chart/g.pie.js"></script>
<script type="text/javascript" src="<%= basePath%>static/manager/js/chart/g.dot.js"></script>


<script src="<%= basePath%>static/manager/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="<%= basePath%>static/manager/js/common.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
  DWZ.init("<%= basePath%>static/manager/dwz.frag.xml", {
    loginUrl:"login_dialog", loginTitle:"登录",  // 弹出登录对话框
    statusCode:{ok:200, error:300, timeout:301}, //【可选】
    pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
    debug:false,  // 调试模式 【true|false】
    callback:function(){
      initEnv();
      $("#themeList").theme({themeBase:"<%= basePath%>static/manager/themes"}); // themeBase 相对于index页面的主题base路径
    }
  });
});
</script>
</head>

<body scroll="no">
  <div id="layout">
    <div id="header">
      <div class="headerNav">
        <span class="logo" href="http://www.ihuizhi.com">LOGO</span>
        <ul class="nav">
          <li><a href="#">(${funcs:getSessionLoginUser(pageContext.session).realName})</a></li>
          <li><a href="logout">退出</a></li>
        </ul>
        <ul class="themeList" id="themeList">
          <li theme="default"><div>蓝色</div></li>
          <li theme="green"><div>绿色</div></li>
          <li theme="purple"><div class="selected">紫色</div></li>
          <li theme="silver"><div>银色</div></li>
          <li theme="azure"><div>天蓝</div></li>
        </ul>
      </div>
      <!-- navMenu -->
    </div>

    <div id="leftside">
      <div id="sidebar_s"><div class="collapse"><div class="toggleCollapse"><div></div></div>
        </div>
      </div>
      <div id="sidebar">
        <div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
        <div class="accordion" fillSpace="sidebar">
          <div class="accordionContent">
          <script type="text/javascript">
	        var leftMenu = new dTree('leftMenu', ' <%= basePath%>'); //, "select"
	        // id, pid, name, url, title, target, icon, iconOpen, open, isChecked, rel
	        <c:forEach var="menu" items="${requestScope.menus}" varStatus="rowstat">
	        	<c:if test="${menu.onMenu == 1}">
	          		leftMenu.add(${menu.id},${menu.parentId},'${menu.name}','${menu.url}', '${menu.name}', "navTab",'','','',false,"navtab_menu_${menu.id}");
	          	</c:if>
	        </c:forEach>
	        document.write(leftMenu);
          </script>
          </div>
      </div>
    </div>
  </div>
  <div id="container">
      <div id="navTab" class="tabsPage">
        <div class="tabsPageHeader">
          <div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
            <ul class="navTab-tab">
              <li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">首页</span></span></a></li>
            </ul>
          </div>
          <div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
          <div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
          <div class="tabsMore">more</div>
        </div>
        <ul class="tabsMoreList">
          <li><a href="javascript:;">首页</a></li>
        </ul>
        <div class="navTab-panel tabsPageContent layoutBox">
          <div class="page unitBox">            
            <div class="pageFormContent" layoutH="80" style="margin-right:230px">
            		<c:if test="${requestScope.params.sysCount > 0 }">
	            		<div>
	            			<div style="font-weight:bold;color:red;">系统消息：</div>
	           				 <c:forEach items="${requestScope.announcementListSys}" var="announcement">
								<br />
								<div><span>${announcement.title }</span>：${announcement.content}</div>
							 </c:forEach>
	            		</div>
            		</c:if>
            		<br />
            		<c:if test="${requestScope.params.perCount > 0 }">
            		<div>
            			 <div style="font-weight:bold;color:red;">个人消息：</div>
           				 <c:forEach items="${requestScope.announcementListPer}" var="announcementP">
							<br />
							<div><span>${announcementP.title }</span>：${announcementP.content}</div>
						 </c:forEach>
            		</div>
            		</c:if>
            </div>
          </div>          
        </div>
      </div>
    </div>
  </div>
  <div id="footer">Copyright &copy; 2013&nbsp;&nbsp;汇智游戏推广平台</div>
  <input id="dmbi" type="hidden" value="<c:out value="${sessionScope.SESSION_DMBI}" />"/>
</body>
</html>
