<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="layout/header.jsp" %>

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

        <div class="col-md-4 border rounded p-3"> <!-- 매칭하기 -->
            매칭하기
        </div>

        <div class="col-md-4 border rounded p-3"> <!-- 폼의 너비 조정, 테두리 추가, padding 추가 -->

            <% if (loginMember == null) { %>
            <a href="member/loginForm" class="btn btn-primary">로그인</a>
            <% } else { %>
            <%-- 세션이 있고 로그인 정보가 있는 경우 --%>
            <strong><%= loginMember.getNickname() %>님 환영합니다.</strong>
            <br/>
            <a href="${pageContext.request.contextPath}/member/editForm/${loginMember.id}" class="btn btn-secondary">개인정보
                수정</a>
            <a href="${pageContext.request.contextPath}/member/matching/editForm" class="btn btn-secondary">매칭정보 수정</a>

            <% } %>

        </div>


    </div>
</div>

<%@ include file="layout/footer.jsp" %>
