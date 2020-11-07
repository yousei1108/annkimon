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

        <h1 id="response_result"><c:choose><c:when test="${ answer.correctCheck }">正解です！</c:when><c:otherwise>不正解です…</c:otherwise></c:choose></h1>
        <p class="text-left">正解は</p>
        <div class="form-box"><c:out value="${ answerQuestion.correctAnswer }"></c:out></div>
        <p class="text-left">あなたの解答</p>
        <div class="form-box"><c:out value="${ answer.answerString }"></c:out></div>
        <c:choose>
        <c:when test="${ hasQuestion }">
        <button onclick="location.href='/annkimon/main/answer/question'"  class="button">次の問題へ行く</button>
        <button onclick="location.href='/annkimon/main'"  class="button color-gray">あきらめる・・・</button>
        </c:when>
        <c:otherwise><button onclick="location.href='/annkimon/main/answer/result'"  class="button">結果発表！</button></c:otherwise>
        </c:choose>

    </div>

    <script>
        function resultCheck(){
            let result = document.getElementById( 'response_result' );
            if( result.innerHTML == '正解です！' ){
                result.style.color = "#FF8282";
            }else{
                result.style.color = "#0090FF";
            }
        }

        resultCheck();

    </script>
</body>
</html>