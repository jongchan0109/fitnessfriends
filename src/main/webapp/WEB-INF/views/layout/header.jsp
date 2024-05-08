<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="find.fitnessfriends.com.entity.member.Member" %>
<%
    // 세션에서 로그인 정보 가져오기
    Member loginMember = (Member) session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Find-Fitness-Friends</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">홈</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <%-- 세션이 없거나 로그인 정보가 없는 경우 --%>
            <% if (loginMember == null) { %>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/member/loginForm">로그인</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/member/joinForm">회원가입</a>
            </li>
            <% } else { %>
            <%-- 세션이 있고 로그인 정보가 있는 경우 --%>
            <li class="nav-item">
                <a class="nav-link" href="#">게시판</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">매칭하기</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">채팅방</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
            </li>
            <% } %>
        </ul>
    </div>
</nav>
<br/>
