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

    <title>問題に挑戦する</title>
</head>
<body>

    <div class="wrapper" class="item">

		<h1 style="margin-bottom:-25px;">【カテゴリー】</h1>
        <h1 style="word-wrap: break-word; width: 100%; color:#0090FF"><c:out value="${ answerQuestion.category }"></c:out></h1>

        <form class="form-wrapper" action="/annkimon/main/answer/question" method="POST">
        	<p class="tag">答え</p>
            <input class="form-box" class="item" type="text" name="answer" placeholder="答えを入れてね" oninput="answerEmptyCheck( this.value );">

            <p class="tag">問題</p>
            <textarea class="form-box" name="hint_1" rows="5" placeholder="一つ目のヒント" readonly><c:out value="${answerQuestion.hint_1 }"></c:out></textarea>

            <c:if test="${not empty answerQuestion.hint_2 }">
            <button class="button color-steelblue" type="button" onclick="hintOpen('hint_2')" id="hint_2_button" >１つ目のヒントを見る</button>
            <textarea class="form-box" name="hint_2" rows="5" id="hint_2" readonly><c:out value="${answerQuestion.hint_2 }"></c:out></textarea>
            </c:if>

            <c:if test="${ not empty answerQuestion.hint_3 }">
            <button class="button color-steelblue" type="button" onclick="hintOpen( 'hint_3' )" id="hint_3_button">２つ目のヒントを見る</button>
            <textarea class="form-box" name="hint_3" rows="5" id="hint_3" readonly><c:out value="${answerQuestion.hint_3 }"></c:out></textarea>
            </c:if>

            <input type="hidden" name="hintOpenCount" id="hintOpenCount" value="1">
            <input class="button" class="item" type="submit" value="次の問題へ進む" id="answerCheck">
        </form>
        <button onclick="location.href='/annkimon/main'"  class="button color-gray">メイン画面に戻る</button>

    </div>
    <script>
        function hintOpen( hint ){
            let hint_area = document.getElementById( hint );
            hint_area.style.display = "block";
            document.getElementById( hint + '_button' ).style.display = "none";
            document.getElementById( "hintOpenCount" ).value++;
        }

        function answerEmptyCheck( answer ){

    		let answerCheck = document.getElementById( "answerCheck" );

        	if( answer ){
        		answerCheck.value = "答え合わせ";
        		answerCheck.style = "background-color: #FF8282";
        	}else{
        		answerCheck.value = "次の問題へ進む";
        		answerCheck.style = "background-color: #a29cdc";
        	}

        }
    </script>

</body>
</html>