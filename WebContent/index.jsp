<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="destyle.css" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css2?family=M+PLUS+1p:wght@300;700&display=swap" rel="stylesheet">
    <link href="css/stylesheet.css" rel="stylesheet">

    <title>暗記門</title>
</head>
<body>

    <div class="wrapper" class="item">

        <img src="picture/logo.png" width="120px" height="45px" >

        <form class="form-wrapper" action="/annkimon/login" method="POST">
            <input class="form-box" class="item" type="text" name="userName" placeholder="ユーザー名">
            <input class="form-box" class="item" type="password" name="password" placeholder="パスワード">
            <input class="button" class="item" type="submit" value="ログイン">
            <c:if test="${ error.hasError() }"><p class="message">${ error.loginError }</p></c:if>
        </form>

        <button onclick="location.href='/annkimon/signup'" class="button" style="background-color: #d4ffd8; color: #707070;">新規登録はこちら</button>

    </div>

</body>
</html>