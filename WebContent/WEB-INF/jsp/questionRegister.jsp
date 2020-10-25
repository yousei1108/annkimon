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

        <h1>問題</h1>

        <form class="form-wrapper" action="" method="POST">
            <input class="form-box" class="item" type="text" name="category" list="category" placeholder="カテゴリーを選択、もしくは入力">
            <datalist id="category">
                <option value="カテゴリー①">
                <option value="カテゴリー②">
                <option value="カテゴリー③">
            </datalist>
            <input class="form-box" class="item" type="text" name="answer" placeholder="答えを入れてね">

            <h1 style="margin-bottom: 10px;">最低一つヒントを入れてね</h1>
            <textarea class="form-box" name="hint_1" rows="5" placeholder="一つ目のヒント"></textarea>
            <textarea class="form-box" name="hint_2" rows="5" placeholder="二つ目のヒント"></textarea>
            <textarea class="form-box" name="hint_3" rows="5" placeholder="三つ目のヒント"></textarea>

            <input class="button" class="item" type="submit" value="問題を登録する">
        </form>

    </div>

</body>
</html>