<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>


<div class="container">
    <form action="/member/join" method="post">
        <div class="form-group">
            <label for="loginId">Id:</label>
            <input type="text" class="form-control" id="loginId" placeholder="Enter id" name="loginId">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <div class="form-group">
            <label for="nickname">Nickname:</label>
            <input type="text" class="form-control" id="nickname" placeholder="Enter nickname" name="nickname">
        </div>
        <button class="btn btn-primary">회원가입완료</button>

    </form>

</div>

<%@ include file="../layout/footer.jsp" %>

