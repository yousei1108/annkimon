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
    <link href="stylesheet.css" rel="stylesheet">

    <title>暗記門</title>
</head>
<body>

    <div class="wrapper" class="item">

        <h1 id="response_result">正解です！</h1>
        <p class="text-left">正解は</p>
        <div class="form-box">正解</div>
        <button onclick="location.href='response.html'" class="button">次の問題へ行く</button>
        <button onclick="location.href='main.html'" class="button color-gray">あきらめる・・・</button>

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