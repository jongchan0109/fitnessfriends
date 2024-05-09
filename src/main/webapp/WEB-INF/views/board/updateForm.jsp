<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form action="/board/update/${board.id}" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" placeholder="Enter id" name="title" value="${board.title}">
        </div>

        <spring:hasBindErrors name="updateDto">
            <c:if test="${errors.hasFieldErrors('title') }">
                <strong class="error-message">${errors.getFieldError( 'title' ).defaultMessage }</strong>
            </c:if>
        </spring:hasBindErrors>


        <div class="form-group">
            <label for="content">Content</label>
            <textarea class="form-control summernote" rows="5" id="content" name="content">
                ${board.content}
            </textarea>

            <spring:hasBindErrors name="updateDto">
                <c:if test="${errors.hasFieldErrors('title') }">
                    <strong class="error-message">${errors.getFieldError( 'title' ).defaultMessage }</strong>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <button id="btn-save" class="btn btn-primary">수정하기</button>
    </form>

</div>

<script>
    $('.summernote').summernote({
        tabsize: 2,
        height: 300
    });
</script>

<%@ include file="../layout/footer.jsp" %>

