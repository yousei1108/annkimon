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
    <title>アカウント登録</title>
</head>
<body>

    <div class="wrapper" class="item">

        <h1>どの問題に挑戦する？</h1>

        <form class="form-wrapper" action="" method="POST">
            <select class="form-box" name="category" oninput="questionRate.value = 100;">
                <option value="カテゴリー①">カテゴリー①</option>
                <option value="カテゴリー②">カテゴリー②</option>
                <option value="カテゴリー③">カテゴリー③</option>
            </select>

            <h1 style="margin-bottom: 0;">出題率を設定しよう</h1>
            <input type="range" value="100" min="1" max="100" step="1" width="50%" oninput="questionRate.value = this.value;">
            <h1 style="display: inline-block;"><output style="margin-left: 30px;" name="questionRate"></output>％</h1>
            <input class="button" class="item" type="submit" value="問題に挑戦する">

        </form>

    </div>



</body>
</html>