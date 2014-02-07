<!-- 可选，配置tag文件字符编码 -->
<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="name" required="true" rtexprvalue="true" description="bean对象中对应的属性名称" %>
<%@ attribute name="label" required="true" rtexprvalue="true" description="输入框标签。如果输入的内容提交后被判定无效，这个标记会以红色显示" %>
<%@ attribute name="maxlength" required="false" rtexprvalue="true" description="最大长度，可选" %>
<%@ attribute name="readonly" required="false" rtexprvalue="true" description="只读，可选" %>
<%@ attribute name="type" required="false" rtexprvalue="true" description="类型，可选" %>
<%@ attribute name="desc" required="false" rtexprvalue="true" description="描述，显示在输入框中" %>
<%@ attribute name="css" required="false" rtexprvalue="true" description="css" %>
<%@ attribute name="display" required="false" rtexprvalue="true" description="css" %>


<spring:bind path="${name}">
	<c:set var="cssGroup" value="control-group ${status.error ? 'error' : ''} "></c:set>
	<div class="${cssGroup} ${display}">
		<label class="control-label">${label}</label>
		
		<div class="controls">
			<c:choose>
				<c:when test="${type == 'password'}">
					<form:password path="${name}" cssClass="input-xlarge ${css} " readonly="${readonly}" maxlength="${maxlength}" placeholder="${desc}"/>
				</c:when>
				<c:when test="${type == 'textarea'}">
					<form:textarea path="${name}" cssClass="input-xlarge ${css} " readonly="${readonly}" maxlength="${maxlength}"  placeholder="${desc}"/>
				</c:when>
				<c:otherwise>
					<form:input path="${name}" cssClass="input-xlarge ${css} " readonly="${readonly}" maxlength="${maxlength}" placeholder="${desc}"/>
				</c:otherwise>
			</c:choose>
			<span class="help-inline">${status.errorMessage}</span>
		</div>
	</div>
</spring:bind>