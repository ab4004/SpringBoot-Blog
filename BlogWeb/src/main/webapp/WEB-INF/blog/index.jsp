<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
<jsp:include page="./layout/header.jsp"></jsp:include>

<br>

<div class="container mt-3">
  <div class="card">
    <div class="card-body">
      <h4 class="card-title">게시판</h4>
      <p class="card-text">게시판 제목</p>
      <a href="#" class="btn btn-secondary">상세보기</a>
    </div>
  </div>
</div>

<br>

<jsp:include page="./layout/footer.jsp"></jsp:include>
</body>
</html>