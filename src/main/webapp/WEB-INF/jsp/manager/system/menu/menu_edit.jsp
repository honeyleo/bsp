<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="funcs" uri="funcs" %>
<script type="text/javascript">
function selectSystemMenuItem(id, parentIdPath, name){
    var parent=$("#menuEditor");
    if(id==$("#menuId", parent).val()){
        alertMsg.error("父节点不能为自己!");
        return ;
    }
    $("#parentId", parent).val(id);
    $("#parentIdPath", parent).val(parentIdPath + id + "$");
    $("#parentName", parent).val(name);
}
</script>
<div class="pageContent" id="menuEditor">
  <form method="post" action="system/menu/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
    <input id="menuId" name="id" type="hidden" size="30" value="${requestScope.menu.id}" />
    <input name="type" type="hidden" size="30" value="${param.type}" />
    <div class="pageFormContent" layoutH="60">
      <div class="unit">
        <label>名  称：</label>
        <input name="name" type="text" size="40" value="${requestScope.menu.name}" class="required"/>
      </div>
      <div class="unit">
        <label>父节点：</label>
        <input id="parentId" name="parentId" type="hidden" value="${requestScope.menu.parentId}" />
        <input id="parentIdPath" name="parentIdPath" type="hidden" value="${requestScope.menu.parentIdPath}" />
        <input id="parentName" type="text" size="40" value="${funcs:getMenuName(requestScope.menu.parentId)}" class="required" readonly="true"/>
        <a class="btnLook" href="system/menu/goselect?type=${param.type}" target="dialog" mask="true" minable="false" width="300" height="600">选择菜单</a>
      </div>
      <div class="unit">
        <label>排  序：</label>
        <input name="orderNo" type="text" size="40" class="digits required" value="${requestScope.menu.orderNo}"/>
      </div>
      <div class="unit">
        <label>链接地址：</label>
        <input name="url" type="text" size="40" value="${requestScope.menu.url}"/>       
      </div>
      <div class="unit">
        <label>链接说明：</label>
        <input name="remark" type="text" size="40" value="${requestScope.menu.remark}"/>       
      </div>
      <div class="unit">
        <label>是否显示为菜单：</label>
      	<select name="onMenu" class="required combox">
           <option value="1" ${requestScope.menu.onMenu == 1 ? "selected" : ""}>是</option>
           <option value="0" ${requestScope.menu.onMenu == 0 ? "selected" : ""}>否</option>
      </select>       
      </div>
    </div>
    <div class="formBar">
      <ul>
        <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
        <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
      </ul>
    </div>
  </form>
</div>