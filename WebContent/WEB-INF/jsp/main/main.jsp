<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <link href="destyle.css" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css2?family=M+PLUS+1p:wght@300;700&display=swap" rel="stylesheet">
    <link href="css/stylesheet.css" rel="stylesheet">

    <title>暗記門</title>
</head>
<body>

    <div class="wrapper" class="item">

        <img src="picture/logo.png" width="120px" height="45px" >

        <button onclick="location.href='/annkimon/main/question'" class="button">問題を作る</button>
        <button onclick="location.href='/annkimon/main/answer'" class="button">問題に挑戦する</button>
        <button onclick="location.href='/annkimon/logout'" class="button color-gray">ログアウト</button>

    </div>

</body>
</html>