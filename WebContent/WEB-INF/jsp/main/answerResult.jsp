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
    <link href="/annkimon/css/stylesheet.css" rel="stylesheet">

    <title>暗記門</title>
</head>
<body>

    <div class="wrapper" class="item">

        <h1 class="font-size-m">　今回の成績は・・・</h1>

        <div class="font-size-m">　出題率　<span class="accent"><c:out value="${ result.questionRate }"></c:out>%</span></div>
        <div class="font-size-m">　正解率　<span class="accent"><c:out value="${ result.correctRate  }"></c:out>％</span></div>
        <div class="font-size-m">　暗記度　<span class="accent"><c:out value="${ result.hintOpenRate }"></c:out>％</span></div>

        <span class="font-size-m" id="result-text">評価　　</span><img id="result-img" src="/annkimon/picture/${ result.evaluation }.png" height="194" width="148">
        <button onclick="location.href='/annkimon/main'" class="button">メイン画面に戻る</button>


    </div>

</body>
</html>