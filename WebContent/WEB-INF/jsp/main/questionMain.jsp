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
    <link href="/annkimon/css/stylesheet.css" rel="stylesheet">

    <title>暗記門</title>
</head>
<body>

    <div class="wrapper" class="item">

        <h1>問題を作る</h1>

        <button onclick="location.href='/annkimon/main/question/register'" class="button">新しく問題を作る</button>
        <button onclick="location.href='/annkimon/main/question/select'" class="button">問題を編集する</button>
        <button onclick="location.href='/annkimon/main'" class="button color-gray">メイン画面に戻る</button>

    </div>

</body>
</html>