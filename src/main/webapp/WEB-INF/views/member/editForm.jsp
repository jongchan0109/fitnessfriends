<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>


<div class="container">
    <form action="${pageContext.request.contextPath}/member/join" method="post">
        <div class="form-group">
            <label for="loginId">Id:</label>
            <input type="text" class="form-control" id="loginId" placeholder="Enter id" name="loginId" value="${member.loginId}">
            <spring:hasBindErrors name="editDto">
                <c:if test="${errors.hasFieldErrors('loginId') }">
                    <strong class="error-message">${errors.getFieldError( 'loginId' ).defaultMessage }</strong>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" value="${member.password}">
            <spring:hasBindErrors name="editDto">
                <c:if test="${errors.hasFieldErrors('password') }">
                    <strong class="error-message">${errors.getFieldError( 'password' ).defaultMessage }</strong>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <div class="form-group">
            <label for="nickname">Nickname:</label>
            <input type="text" class="form-control" id="nickname" placeholder="Enter nickname" name="nickname" value="${member.nickname}">
            <spring:hasBindErrors name="joinDto">
                <c:if test="${errors.hasFieldErrors('nickname') }">
                    <strong class="error-message">${errors.getFieldError( 'nickname' ).defaultMessage }</strong>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <button class="btn btn-primary">정보 수정 완료</button>
    </form>
</div>

<%@ include file="../layout/footer.jsp" %>

