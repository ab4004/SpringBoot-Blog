<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>

<br>

<div class="container mt-3">
  <h3>회원가입</h3>
    
  <form action="/action_page.php" class="was-validated">
    <div class="mb-3 mt-3">
      <label for="uname" class="form-label">Username:</label>
      <input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname" required>
      <div class="valid-feedback">사용 가능합니다.</div>
      <div class="invalid-feedback">사용자 이름을 입력해주세요</div>
    </div>
    <div class="mb-3">
      <label for="pwd" class="form-label">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd" required>
      <div class="valid-feedback">사용 가능합니다.</div>
      <div class="invalid-feedback">비밀번호</div>
    </div>
    <div class="mb-3">
      <label for="email" class="form-label">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
      <div class="valid-feedback">사용 가능합니다.</div>
      <div class="invalid-feedback">이메일을 입력해주세요.</div>
    </div>
  <button type="submit" class="btn btn-primary">회원가입</button>
  </form>
</div>

<br>

<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>