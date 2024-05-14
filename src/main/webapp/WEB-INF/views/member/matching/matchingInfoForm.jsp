<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../../layout/header.jsp" %>

<div class="container">
    <form action="/member/matching/matchingInfo/${member.id}" method="POST">
        <div class="row">
            <div class="col">
                <h2>당신의 매핑 정보</h2>
                <label>운동 능력:</label><br>
                <c:forEach items="${abilities}" var="ability">
                    <input type="radio" name="ability" value="${ability}" id="${ability}" ${ability eq matchingInfo.ability ? 'checked' : ''}>
                    <label for="${ability}">${ability.description}</label><br> <!-- 수정 -->
                </c:forEach>

                <br>

                <label>성별:</label><br>
                <c:forEach items="${genders}" var="gender">
                    <input type="radio" name="gender" value="${gender}" id="${gender}" ${gender eq matchingInfo.gender ? 'checked' : ''}>
                    <label for="${gender}">${gender.description}</label><br>
                </c:forEach>

                <br>

                <label>선호 시간:</label><br>
                <c:forEach items="${preferredTimes}" var="time">
                    <input type="radio" name="preferredTime" value="${time}" id="${time}" ${time eq matchingInfo.preferredTime ? 'checked' : ''}>
                    <label for="${time}">${time.description}</label><br>
                </c:forEach>
            </div>
            <div class="col">
                <h2>상대의 매핑 정보</h2>
                <label>운동 능력:</label><br>
                <c:forEach items="${abilities}" var="ability">
                    <input type="radio" name="oppAbility" value="${ability}" id="opp_${ability}" ${ability eq oppMatchingInfo.ability ? 'checked' : ''}>
                    <label for="opp_${ability}">${ability.description}</label><br> <!-- 수정 -->
                </c:forEach>

                <br>

                <label>성별:</label><br>
                <c:forEach items="${genders}" var="gender">
                    <input type="radio" name="oppGender" value="${gender}" id="opp_${gender}" ${gender eq oppMatchingInfo.gender ? 'checked' : ''}>
                    <label for="opp_${gender}">${gender.description}</label><br>
                </c:forEach>

                <br>

                <label>선호 시간:</label><br>
                <c:forEach items="${preferredTimes}" var="time">
                    <input type="radio" name="oppPreferredTime" value="${time}" id="opp_${time}" ${time eq oppMatchingInfo.preferredTime ? 'checked' : ''}>
                    <label for="opp_${time}">${time.description}</label><br>
                </c:forEach>
            </div>
        </div>

        <br>

        <button type="submit">Submit</button>
    </form>
</div>

<%@ include file="../../layout/footer.jsp" %>
