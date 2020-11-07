<%@page import="dao.QuestionDAOService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

	QuestionDAOService service = new QuestionDAOService();
	List<String> categoryList = service.selectCategoryByUser( (String)request.getSession().getAttribute("userName") );
	pageContext.setAttribute( "categoryList" , categoryList );

%>
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
<body onpageshow="fnc();">

    <div class="wrapper" class="item">

        <h1>どの問題に挑戦する？</h1>

        <form class="form-wrapper" action="/annkimon/main/answer" method="post">
            <select class="form-box" name="category" oninput="outputVal.value = questionRate.value;">
                <c:if test="${ not empty categoryList }">
					<c:forEach var="category" items="${ categoryList }">
						<option value= <c:out value="${ category }" /> ><c:out value="${ category }" /></option>
					</c:forEach>
				</c:if>
            </select>

            <h1 style="margin-bottom: 0;">出題率を設定しよう</h1>
            <input type="range" name="questionRate" value="100" min="1" max="100" step="1" width="50%" oninput="outputVal.value = this.value;" id="questionRate">
            <h1 style="display: inline-block;"><output style="margin-left: 30px;" name="outputVal" id="outputVal">100</output>％</h1>
            <input class="button" class="item" type="submit" value="問題に挑戦する" oninput="alert( questionRate.value );">

        </form>
        <button onclick="location.href='/annkimon/main'" class="button color-gray">メイン画面に戻る</button>

    </div>



</body>

<script>

	let fnc = function(){
        let questionRate = document.getElementById( 'questionRate' );
        let outputVal    = document.getElementById( 'outputVal' );
 		outputVal.value = questionRate.value;
	}

</script>

</html>