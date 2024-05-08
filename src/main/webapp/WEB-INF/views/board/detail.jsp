<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">

    <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
    <c:if test="${board.member.id == loginMember.id}">
        <a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
        <button id="btn-delete" class="btn btn-danger">삭제</button>
    </c:if>
    <br/><br/>

    <div>
        글번호: <span id="id"><i>${board.id} </i></span>
        작성자: <span><i>${board.member.nickname} </i></span>
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

