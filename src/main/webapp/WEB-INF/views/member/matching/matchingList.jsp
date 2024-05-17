<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../../layout/header.jsp" %>

<div class="container">
    <h4>매칭된 사람들</h4>

    <c:choose>
        <c:when test="${empty matchingList}">
            <div class="col-12">
                <p class="text-center">매칭된 사용자가 없습니다.</p>
            </div>
        </c:when>
        <c:otherwise>
            <c:forEach var="member" items="${matchingList}">
                <div class="card m-2" style="height: auto;">
                    <div class="card-body d-flex justify-content-between">
                        <div>
                            <h5 class="card-title h6 mb-0">별명: ${member.nickname}</h5>
                            <p class="mb-0">운동 능력: ${member.matchingInfo.ability.description}</p>
                            <p class="mb-0">성별: ${member.matchingInfo.gender.description}</p>
                            <p class="mb-0">선호 시간: ${member.matchingInfo.preferredTime.description}</p>
                        </div>
                        <div>
                            <a href="#" class="btn btn-sm btn-primary">메세지 보내기</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>

<%@ include file="../../layout/footer.jsp" %>
