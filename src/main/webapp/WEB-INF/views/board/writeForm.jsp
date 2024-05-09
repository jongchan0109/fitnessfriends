<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form action="${pageContext.request.contextPath}/board/write" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" placeholder="Enter id" name="title">
        </div>

        <spring:hasBindErrors name="writeDto">
            <c:if test="${errors.hasFieldErrors('title') }">
                <strong class="error-message">${errors.getFieldError( 'title' ).defaultMessage }</strong>
            </c:if>
        </spring:hasBindErrors>

        <div class="form-group">
            <label for="content">Content</label>
            <textarea class="form-control summernote" rows="5" id="content" name="content"></textarea>
        </div>

        <spring:hasBindErrors name="writeDto">
            <c:if test="${errors.hasFieldErrors('content') }">
                <strong class="error-message">${errors.getFieldError( 'content' ).defaultMessage }</strong>
                <br/>
            </c:if>
        </spring:hasBindErrors>


        <button id="btn-save" class="btn btn-primary">글쓰기</button>
    </form>

</div>

<script>
    $('.summernote').summernote({
        tabsize: 2,
        height: 300
    });
</script>

<%@ include file="../layout/footer.jsp" %>

