<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">

    <div class="text-right mb-3">
        <a href="/board/writeForm" class="btn btn-success">글쓰기</a>
    </div>

    <c:forEach var="board" items="${boards.content}">
        <div class="card m-2">
            <div class="card-body">
                <div class="d-flex justify-content-between">
                    <h4 class="card-title">제목: ${board.title}</h4>
                    <h5 class="card-title">작성자: ${board.member.nickname}</h5>
                </div>
                <a href="/board/detail/${board.id}" class="btn btn-primary">상세보기</a>
            </div>
        </div>
    </c:forEach>

    <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${boards.first}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
            </c:otherwise>
        </c:choose>

        <c:set var="begin" value="${boards.number - 2}"/>
        <c:if test="${begin < 1}">
            <c:set var="begin" value="1"/>
        </c:if>

        <c:set var="end" value="${begin + 4}"/>
        <c:if test="${end > boards.totalPages}">
            <c:set var="end" value="${boards.totalPages}"/>
        </c:if>

        <c:forEach var="i" begin="${begin}" end="${end}" step="1">
            <c:choose>
                <c:when test="${i == boards.number + 1}">
                    <li class="page-item disabled"><a class="page-link" href="#">${i}</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="?page=${i - 1}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>


        <c:choose>
            <c:when test="${boards.last}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
            </c:otherwise>
        </c:choose>
    </ul>

</div>

<%@ include file="../layout/footer.jsp" %>

