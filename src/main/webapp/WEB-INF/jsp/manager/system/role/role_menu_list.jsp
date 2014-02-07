<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="funcs" uri="funcs" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
$(document).ready(function(){
  roleMenu = new dTree('roleMenu', '<%= basePath%>', 'select');
  roleMenu.clearCookie();
  <c:forEach var="menu" items="${requestScope.menus}">
  roleMenu.add(${menu.id}, ${menu.parentId}, '${menu.name}', '',  '${menu.name}', "", '', '', '', '${funcs:isContains( menu.id, requestScope.roleMenuIds)}', "");
  </c:forEach>
  $('#roleMenuList').html(roleMenu.toString());
})

function saveUserTreeNode(form){
    var tmpForm=$(form);
    var checkedBox=$(":checkbox:checked", tmpForm);
    if(checkedBox.size()==0){
        return false;
    }
    alertMsg.confirm("确定要提交吗？", {
        okCall: function(){
          validateCallback(form, dialogAjaxDone);;
        }
    });
    return false;
}
</script>
<form onsubmit="return saveUserTreeNode(this)" action="system/role_menu/save" method="post">
  <input type="hidden" name="roleId" value="${param.roleId}">
  <input type="hidden" name="mtype" value="${param.mtype}">
  <div class="pageContent">
    <div id="roleMenuList" layoutH="50">
    </div>
    <div class="formBar">
      <ul>
        <li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
        <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
      </ul>
    </div>
  </div>
</form>