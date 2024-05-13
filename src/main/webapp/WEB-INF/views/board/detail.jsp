<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <div class="button-group">
        <c:if test="${board.member.id == loginMember.id}">
            <a href="/board/updateForm/${board.id}" class="btn btn-warning">수정</a>
            <form id="deleteForm" action="/board/delete/${board.id}" method="post">
                <input type="hidden" name="_method" value="DELETE">
                <button type="submit" class="btn btn-danger">삭제</button>
            </form>
        </c:if>
    </div>

    <br/><br/>

    <div>
        글번호: <span>${board.id} </span>
        작성자: <span>${board.member.nickname} </span>
        조회수: <span>${board.view} </span>
        <br/>
        작성날짜: <span>${formattedCreateDate} </span>
        수정날짜: <span>${formattedUpdateDate} </span>
    </div>
    <br/>

    <div>
        <h3>${board.title}</h3>
    </div>
    <hr>
    <div>
        <div>
            ${board.content}
        </div>
    </div>
    <hr>
    <div class="card">
        <div class="card-header">댓글 리스트</div>
        <ul id="reply--box" class="list-group">
            <c:forEach var="reply" items="${board.replies}">
                <li id="reply--1" class="list-group-item d-flex justify-content-between">
                    <div>${reply.content}</div>
                    <div class="d-flex">
                        <div>작성날짜: <script>document.write(new Date('${reply.createDate}').toLocaleString())</script></div>
                        <div class="mx-2 font-italic">작성자: ${reply.member.nickname}</div>
                        <button class="badge btn btn-danger">삭제</button>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>

    <form action="/board/${board.id}/reply" method="post">
        <div class="card-body d-flex align-items-center">
            <div class="flex-grow-1">
                <textarea class="form-control" rows="1" name="content"></textarea>
            </div>
            <button type="submit" class="btn btn-primary ml-2">등록</button>
        </div>
    </form>
</div>

<%@ include file="../layout/footer.jsp" %>

