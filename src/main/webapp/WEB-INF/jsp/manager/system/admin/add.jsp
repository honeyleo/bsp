<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="pageContent">
    <form method="post" action="system/admin/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>用 户 名：</label>
                <input name="username" type="text" size="30" class="required"/>
            </p>
            <p>
                <label>密    码：</label>
                <input name="passward" type="password" size="30" class="required alphanumeric" minlength="6" maxlength="20" alt="字母、数字、下划线 6-20位"/>
            </p>
            <p>
                <label>真实姓名：</label>
                <input name="realName" type="text" size="30" class=""/>
            </p>
            <p> 
                <label>邮    箱：</label>
                <input name="email" type="text" size="30" class="email"/>
            </p>
            <p>
                <label>联系电话：</label>
                <input name="phone" type="text" size="30" class=""/>
            </p>
            <p>
                <label>联系地址：</label>
                <input name="address" type="text" size="30" class=""/>
            </p>
            <p>
                <label>用户角色：</label>
                <select name="roleId" class="required combox">
                    <c:forEach items="${requestScope.roles}" var="role">
                        <option value="${role.id}">${role.name}</option>
                    </c:forEach>
                </select>
            </p>
        </div>
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