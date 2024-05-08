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

            <% if (loginMember == null) { %>
            <button id="btn-login" class="btn btn-primary" href="member/loginForm">로그인</button>
            <% } else { %>
            <%-- 세션이 있고 로그인 정보가 있는 경우 --%>
            <strong><%= loginMember.getNickname() %>님 환영합니다.</strong>
            <br/>
            <a href="${pageContext.request.contextPath}/member/editForm/${loginMember.id}" class="btn btn-secondary">개인정보 수정</a>
            <a href="${pageContext.request.contextPath}/member/matching/editForm" class="btn btn-secondary">매칭정보 수정</a>

            <% } %>

        </div>


    </div>
</div>

<%@ include file="layout/footer.jsp" %>
