let userObject = {
	init: function() {
		let _this = this;

		$("#btn-save").on("click", () => {
			_this.insertUser();
		});
	},

	insertUser: function() {
		alert("회원가입이 요청되었습니다.");

		let user = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}

		$.ajax({
			type: "POST",
			url: "/auth/insertUser",
			data: JSON.stringify(user),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(user.username + "님 로그인에 성공하였습니다.");
			location = "/"
		}).fail(function(error) {
			alert("로그인에 실패하였습니다.\ncode : " + error);
		});
	}
}

userObject.init();