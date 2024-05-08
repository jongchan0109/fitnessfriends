<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>


<div class="container">
    <form action="/member/login" method="post">
        <div class="form-group">
            <label for="loginId">id:</label>
            <input type="text" name="loginId" class="form-control" id="loginId" placeholder="Enter loginId">
            <spring:hasBindErrors name="loginDto">
                <c:if test="${errors.hasFieldErrors('loginId') }">
                    <strong class="error-message">${errors.getFieldError( 'loginId' ).defaultMessage }</strong>
                </c:if>
            </spring:hasBindErrors>

        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="Enter password">
            <spring:hasBindErrors name="loginDto">
                <c:if test="${errors.hasFieldErrors('password') }">
                    <strong class="error-message">${errors.getFieldError( 'password' ).defaultMessage }</strong>
                </c:if>
            </spring:hasBindErrors>
        </div>

        <spring:hasBindErrors name="loginDto">
            <c:if test="${errors.hasGlobalErrors()}">
                <c:forEach var="error" items="${errors.globalErrors}">
                    <strong class="error-message">${error.defaultMessage}</strong>
                </c:forEach>
            </c:if>
        </spring:hasBindErrors>
        <br/>


        <button class="btn btn-primary">로그인</button>

    </form>

</div>

<%@ include file="../layout/footer.jsp" %>

