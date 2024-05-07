<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>


<div class="container">
    <form action="/member/login" method="post">
        <div class="form-group">
            <label for="loginId">id:</label>
            <input type="text" name="loginId" class="form-control" id="loginId" placeholder="Enter loginId">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="Enter password">
        </div>
        <button class="btn btn-primary">로그인</button>

    </form>

</div>

<%@ include file="../layout/footer.jsp" %>

