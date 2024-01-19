<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>상세 게시글</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<br>

	<div class="container mt-3">
		<div>
			<h3>제목 : ${ }</h3>

			<div class="mb-3 mt-3">
				<textarea id="content" name="content"></textarea>
				<script>
					$(document).ready(function() {
						$("#content").summernote({
							height : 300
						});
					});
				</script>
			</div>
			
			<button class="btn btn-secondary" id="btn-write">글작성</button>
			<script src="/js/post.js"></script>
		</div>
	</div>

	<br>

	<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>