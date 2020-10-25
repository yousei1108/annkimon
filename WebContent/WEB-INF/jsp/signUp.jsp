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

    <title>アカウント登録</title>
</head>
<body>

    <div class="wrapper" class="item">

        <h1>新規登録</h1>

        <form class="form-wrapper" action="/annkimon/UserRegisterServlet" method="POST">
            <input class="form-box" class="item" type="text" name="userName" placeholder="ユーザー名( 半角英数字 )">
            <c:if test="${ not empty error.nameError }"><p class="message">${ error.nameError }</p></c:if>
            <input class="form-box" class="item" type="password" name="password" placeholder="パスワード( 半角英数字８文字以上 )">
            <c:if test="${ not empty error.passwordError }"><p class="message">${ error.passwordError }</p></c:if>
            <input class="button" class="item" type="submit" value="アカウント登録">
        </form>

    </div>

</body>
</html>