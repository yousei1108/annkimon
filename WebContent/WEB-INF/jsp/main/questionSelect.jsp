<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="destyle.css" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css2?family=M+PLUS+1p:wght@300;700&display=swap" rel="stylesheet">
    <link href="/annkimon/css/stylesheet.css" rel="stylesheet">

    <title>問題を登録しました</title>
</head>
<body>

    <div class="wrapper" class="item">

        <h1>どの問題を編集する？</h1>

		<form action="/annkimon/main/question/select" method="post" name="mainForm">
        	<table class="question-table">

        	<tr>
        	    <th>作成日</th>
        	    <th>カテゴリー</th>
            	<th>答え</th>
            	<th>編集</th>
        	</tr>

			<c:forEach var="question" items="${questionList}">
        	<tr>
           	 	<td>
           	 	<fmt:formatDate value="${ question.created_at }" pattern="yyyy.MM.dd"/><br>
           	 	<fmt:formatDate value="${ question.created_at }" pattern="kk:mm"/>
           	 	</td>
            	<td><c:out value="${ question.category }"></c:out></td>
            	<td><c:out value="${ question.correctAnswer }"></c:out></td>
            	<td><button class="color-gray" type="button" onclick="selectNumber( ${ question.id } )">編集</button></td>
        	</tr>
        	</c:forEach>

       		</table>

			<input type="hidden" name="questionId" id="questionId">
       </form>

    </div>

<script>

	function selectNumber( id ){

		document.getElementById( "questionId" ).value = id;
		document.mainForm.submit();

	}


</script>

</body>
</html>