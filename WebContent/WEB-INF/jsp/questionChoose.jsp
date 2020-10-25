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

    <title>問題を登録しました</title>
</head>
<body>

    <div class="wrapper" class="item">

        <h1>どの問題を編集する？</h1>

        <table class="question-table">

        <tr>
            <th>作成日</th>
            <th>カテゴリー</th>
            <th>答え</th>
            <th>編集</th>
        </tr>

        <tr>
            <td>2020.7.16</td>
            <td>歴史問題</td>
            <td>中臣鎌足</td>
            <td><button class="color-gray">編集</button></td>
        </tr>

        <tr>
            <td>2020.7.16</td>
            <td>歴史問題aaaaaaaaaaaaaa</td>
            <td>豊臣秀吉aaaaaaaaaa</td>
            <td><button class="color-gray">編集</button></td>
        </tr>

        </table>

    </div>

</body>
</html>