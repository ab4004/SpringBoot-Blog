<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>

	<jsp:include page="./layout/header.jsp"></jsp:include>

	<br>

	<div class="container mt-3">
		<h2>메인 게시판 화면</h2>
		<p>게시판 글작성은 회원만 가능합니다.</p>
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th style="width: 10%">글번호</th>
					<th style="width: 60%">제목</th>
					<th style="width: 30%">작성자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="post" items="${postList}">
				<tr>
					<th>${post.id}</th>
					<th><a href="/post/show?id=${post.id}">${post.title}</a></th>
					<th>${post.user.username}</th>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<br>

	<jsp:include page="./layout/footer.jsp"></jsp:include>

</body>
</html>