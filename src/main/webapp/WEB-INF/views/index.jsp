<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="layout/header.jsp" %>

<div class="container">
    <div class="row"> <!-- 한 행에 모든 원소를 배치 -->

        <div class="col-md-4 border rounded p-3"> <!-- 게시판 -->
            게시판
        </div>

        <div class="col-md-4 border rounded p-3"> <!-- 매칭하기 -->
            매칭하기
        </div>

        <div class="col-md-4 border rounded p-3"> <!-- 폼의 너비 조정, 테두리 추가, padding 추가 -->
            <button id="btn-login" class="btn btn-primary" href="">로그인</button>
        </div>


    </div>
</div>

<%@ include file="layout/footer.jsp" %>
