<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="funcs" uri="funcs" %>
<form id="pagerForm" method="post" action="system/admin/list">
    <input type="hidden" name="pageNum" value="${requestScope.result.nowPage}" />
    <input type="hidden" name="numPerPage" value="${requestScope.reslut.pageSize}" />
    <input type="hidden" name="realname" value="${param.realname}" />
    <input type="hidden" name="username" value="${param.email}" />
</form>

<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="system/admin/list" method="post" class="pageForm required-validate">
      <div class="searchBar">
      <table class="searchContent">
        <tr>
            <td>
                        用户名：<input type="text" name="username" value="${param.username}"/> 
                        真实姓名：<input type="text" name="realName" value="${param.realName}"/>
            </td>
        </tr>
      </table>
      <div class="subBar">
          <ul>
              <li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
          </ul>
      </div>
    </div>
    </form>
</div>

<div class="pageContent">
        <div class="panelBar">
            <ul class="toolBar">
                <li><a class="add" href="system/admin/goadd" rel="lookup2organization" target="dialog" width="500" height="370" mask="true" close="closedialog"><span>添加</span></a></li>
                <li><a class="delete" href="system/admin/del?id={sid_user}" target="ajaxTodo" title="确定删除该员工吗?"><span>删除</span></a></li>
                <li><a class="edit" href="system/admin/detail?id={sid_user}" rel="lookup2organization" target="dialog" width="500" height="370" mask="true" close="closedialog"><span>修改</span></a></li>         
            </ul>
        </div>
        
        <table class="table" width="100%" layoutH="138">
            <thead>
            <tr>
                <th width="80">ID</th>
                <th width="120">用户名</th>
                <th width="120">实名</th>
                <th width="120">邮箱</th>
                <th width="100">用户角色</th>
                <th width="100">状态</th>
                <th width="100">权限菜单</th>
            </tr>
        </thead>
        <tbody>
        
        <c:forEach items="${requestScope.result.data}" var="admin" varStatus="var">
            <tr target="sid_user" rel="${admin.id}">
                <td>${admin.id}</td>
                <td>${admin.username}</td>
                <td>${admin.realName}</td>
                <td>${admin.email}</td>
                <td>${funcs:getRoleName(admin.roleId)} </td>
                <td>${admin.state == 1 ? "有效" : "无效"} </td>
                <td>
                    <a href="system/admin_menu/list?adminId=${admin.id}" target="dialog" mask="true" target="dialog" minable="false" width="300" height="600"><span style="color:blue">查看</span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
        <div class="panelBar">
          <div class="pages">
            <span>共${requestScope.result.total}条</span>
          </div>
        <div class="pagination" targetType="navTab" totalCount="${requestScope.result.total}" numPerPage="${requestScope.result.pageSize}" currentPage="${requestScope.result.nowPage}"></div>

    </div>
</div>

