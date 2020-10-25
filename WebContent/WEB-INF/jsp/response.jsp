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

    <title>問題</title>
</head>
<body>

    <div class="wrapper" class="item">

        <h1>カテゴリー</h1>

        <form class="form-wrapper" action="" method="POST">
            <input class="form-box" class="item" type="text" name="answer" placeholder="答えを入れてね">
            <textarea class="form-box" name="hint_1" rows="5" placeholder="一つ目のヒント"></textarea>
            <button class="button color-gray" type="button" onclick="hintOpen('hint_2')" id="hint_2_button">二つ目のヒントを見る</button>
            <textarea class="form-box" name="hint_2" rows="5" id="hint_2" placeholder="二つ目のヒント"></textarea>
            <button class="button color-gray" type="button" onclick="hintOpen( 'hint_3' )" id="hint_3_button">三つ目のヒントを見る</button>
            <textarea class="form-box" name="hint_3" rows="5" id="hint_3" placeholder="三つ目のヒント"></textarea>
            <input type="hidden" name="hint_2_open" id="hint_2_open" value="false">
            <input type="hidden" name="hint_3_open" id="hint_3_open" value="false">
            <input class="button" class="item" type="submit" value="答え合わせ">
        </form>

    </div>
    <script>
        function hintOpen( hint ){
            let hint_area = document.getElementById( hint );
            hint_area.style.display = "block";
            document.getElementById( hint + '_button' ).style.display = "none";
            document.getElementById( hint + '_open' ).value = "true";
            //alert( document.getElementById( 'hint_2_open' ).value );
            //alert( document.getElementById( 'hint_3_open' ).value );
        }
    </script>

</body>
</html>