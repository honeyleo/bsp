<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="funcs" uri="funcs" %>
<form id="pagerForm" method="post" action="system/role/list">
    <input type="hidden" name="pageNum" value="${requestScope.result.nowPage}" />
    <input type="hidden" name="numPerPage" value="${requestScope.reslut.pageSize}" />
    <input type="hidden" name="type" value="${requestScope.type}" />
</form>

<div class="pageHeader"> 
</div>

<div class="pageContent">
  <div class="panelBar">
    <ul class="toolBar">
      <li><a class="add" href="system/role/goadd" target="dialog" width="500" height="370" mask="true" close="closedialog"><span>添加</span></a></li>
      <li><a class="delete" href="system/role/del?id={sid_role}" target="ajaxTodo" title="确定删除该角色吗?"><span>删除</span></a></li>
      <li><a class="edit" href="system/role/detail?id={sid_role}" target="dialog" width="500" height="370" mask="true" close="closedialog"><span>修改</span></a></li>         
    </ul>
  </div>
  <table class="table" width="100%" layoutH="138">
    <thead>
      <tr >
        <th width="80">角色ID</th>
        <th width="120">角色名称</th>
        <th width="120">角色说明</th>
        <th width="100">数据状态</th>
        <th width="200">默认权限菜单</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${requestScope.result.data}" var="r" varStatus="var">
        <tr target="sid_role" rel="${r.id}">
          <td>${r.id}</td>
          <td>${r.name}</td>
          <td>${r.desc}</td>
          <td>${r.state == 1 ? "有效" : "失效"}</td>
          <td>
            <a href="system/role_menu/list?roleId=${r.id}&mtype=${requestScope.type}" target="dialog" mask="true" target="dialog" minable="false" width="300" height="600"><span style="color:blue">查看</span></a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

