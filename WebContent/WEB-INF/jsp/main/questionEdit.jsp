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
    <link href="destyle.css" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css2?family=M+PLUS+1p:wght@300;700&display=swap" rel="stylesheet">
    <link href="/annkimon/css/stylesheet.css" rel="stylesheet">

    <title>アカウント登録</title>
</head>
<body>

    <div class="wrapper" class="item">

        <h1>問題</h1>

        <form class="form-wrapper" action="/annkimon/main/question/edit" method="POST">
            <input class="form-box" class="item" type="text" name="category" list="category" placeholder="カテゴリーを選択、もしくは入力"
            value=<c:out value="${ selectQuestion.category }"></c:out>>
            	 <c:if test="${ not empty error.categoryError }"><p class="message">${ error.categoryError }</p></c:if>
            <datalist id="category">

				<c:if test="${ not empty categoryList }">
					<c:forEach var="category" items="${ categoryList }">
						<option value= <c:out value="${ category }" />>
					</c:forEach>
				</c:if>

            </datalist>
            <input class="form-box" class="item" type="text" name="correctAnswer" placeholder="答えを入れてね"
            value=<c:out value="${ selectQuestion.correctAnswer }"></c:out> >
            	 <c:if test="${ not empty error.correctAnswerError }"><p class="message">${ error.correctAnswerError }</p></c:if>
            <h1 style="margin-bottom: 10px;">最低一つヒントを入れてね</h1>
            <textarea class="form-box" name="hint_1" rows="5" placeholder="一つ目のヒント"><c:out value="${ selectQuestion.hint_1 }"></c:out></textarea>
            	<c:if test="${ not empty error.hintError }"><p class="message">${ error.hintError }</p></c:if>
            <textarea class="form-box" name="hint_2" rows="5" placeholder="二つ目のヒント"><c:out value="${ selectQuestion.hint_2 }"></c:out></textarea>
            <textarea class="form-box" name="hint_3" rows="5" placeholder="三つ目のヒント"><c:out value="${ selectQuestion.hint_3 }"></c:out></textarea>
			<input type="hidden" name="id" value="${ selectQuestion.id }">

            <input class="button" class="item" type="submit" value="問題を更新する">
        </form>

    </div>

</body>
</html>