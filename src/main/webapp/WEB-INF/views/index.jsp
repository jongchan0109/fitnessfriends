<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="layout/header.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<style>
    .full-height {
        height: 100%;
    }
    .full-height a {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 100%;
        font-size: 1.5rem; /* 버튼 텍스트 크기 조정 */
    }
</style>

<div class="container">
    <div class="row"> <!-- 한 행에 모든 원소를 배치 -->

        <div class="col-md-4 border rounded p-3"> <!-- 게시판 -->
            <h4>인기 게시글 </h4>
            <c:forEach var="board" items="${boards}">
                <div class="card m-2" style="height: 80px;">
                    <div class="card-body d-flex justify-content-between">
                        <div>
                            <h5 class="card-title h6 mb-0">제목: ${board.title}</h5>
                            <br/>
                            <h6 class="card-subtitle mb-2 text-muted small">작성자: ${board.member.nickname}</h6>
                        </div>
                        <div>
                            <h6 class="card-subtitle mb-2 text-muted small">조회수: ${board.view}</h6>
                            <a href="/board/detail/${board.id}" class="btn btn-sm btn-primary">상세보기</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="col-md-4 border rounded p-3 full-height" style="height: 500px;"> <!-- 높이는 필요에 따라 조정 -->
            <a href="/member/matching/matching/${loginMember.id}" class="btn btn-primary">
                <i class="fas fa-handshake"></i> 매칭하기
            </a>
        </div>

        <div class="col-md-4 border rounded p-3"> <!-- 폼의 너비 조정, 테두리 추가, padding 추가 -->
            <% if (loginMember == null) { %>
            <a href="member/loginForm" class="btn btn-success">로그인</a>
            <% } else { %>
            <%-- 세션이 있고 로그인 정보가 있는 경우 --%>
            <strong><%= loginMember.getNickname() %>님 환영합니다.</strong>
            <br/>
            <a href="${pageContext.request.contextPath}/member/editForm/${loginMember.id}" class="btn btn-secondary">개인정보 수정</a>
            <a href="${pageContext.request.contextPath}/member/matching/matchingInfoForm/${loginMember.id}" class="btn btn-secondary">매칭정보 수정</a>
            <% } %>
        </div>

    </div>
</div>

<%@ include file="layout/footer.jsp" %>
