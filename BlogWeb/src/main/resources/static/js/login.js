let loginObject = {
	init : function() {
		let _this = this;
		
		$("#btn-login").on("click", () => {
			_this.login();
		});
	},
	
	login : function() {
		alert("로그인이 요청되었습니다.");
		
		let data = {
			username : $("#username").val(),
			password : $("password").val()
		}
		
		$.ajax({
			type : "POST",
			url : "/auth/login",
			data : JSON.stringify(data),
			ContentType : "application/json; charset=utf-8"
		}).done(function(response){
			let message = response["data"];
			alert(message);
		}).fail(function(error){
			let message = error["data"];
			alert(message);
		});
	}
}

loginObject.init();