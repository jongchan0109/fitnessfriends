<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <div class="button-group">
    <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
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

</div>


<%@ include file="../layout/footer.jsp" %>

