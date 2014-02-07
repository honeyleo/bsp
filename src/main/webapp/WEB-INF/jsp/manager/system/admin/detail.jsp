<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="net.bsp.manager.model.type.StateType"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="system/admin/update" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p> 
                <label>用 户 名：</label>
                <input name="username" type="text" size="30" value="${requestScope.admin.username}" readonly />
            </p>
            <p>
                <label>密    码：</label>
                <input name="password" type="password" size="30" class="alphanumeric" minlength="6" maxlength="20" alt="字母、数字、下划线 6-20位"/>
            </p>
            <p>
                <label>真实姓名：</label>
                <input name="realName" type="text" size="30" value="${requestScope.admin.realName}" class=""/>
            </p>
            <p> 
                <label>邮    箱：</label>
                <input name="email" type="text" size="30" value="${requestScope.admin.email}" class="email"/>
            </p>
            <p>
                <label>联系电话：</label>
                <input name="phone" type="text" size="30" value="${requestScope.admin.phone}" class=""/>
            </p>
            <p>
                <label>联系地址：</label>
                <input name="address" type="text" size="30" value="${requestScope.admin.address}" class=""/>
            </p>
            <p>
                <label>用户角色：</label>
                <select name="roleId" class="required combox">
                    <c:forEach items="${requestScope.roles}" var="role">
                        <option value="${role.id}" ${requestScope.admin.roleId eq role.id ? "selected" : ""}>${role.name}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>账户状态：</label>
                <select name="state" class="required combox">
                    <c:set var="states" value="<%=StateType.values()%>"/>
                    <c:forEach items="${states}" var="s">
                        <option value="${s.id}" ${requestScope.admin.state == s.id ? "selected" : ""}>${s.name}</option>
                    </c:forEach>
                </select>
            </p>
        </div>
        <input name="id" type="hidden" value="${requestScope.admin.id}"/>
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>