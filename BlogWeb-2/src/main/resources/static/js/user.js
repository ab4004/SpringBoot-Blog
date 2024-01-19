let userObject = {
	init : function() {
		let _this = this;
		
		$("#reg-btn").on("click", () => {
			_this.register();
		});
		
		$("#login-btn").on("click", () => {
			_this.login();
		})
	},
	
	register : function() {
		let regInfo = {
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val()
		}
		
		$.ajax({
			type : "POST",
			url : "/auth/register",
			data : JSON.stringify(regInfo),
			contentType : "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response["data"]);
			location.href = "/";
		}).fail(function(error) {
			alert(error["data"]);
		})
	},
	
	login : function() {
		let loginInfo = {
			username : $("#username").val(),
			password : $("#password").val()
		}
		
		$.ajax({
			type : "POST",
			url : "/auth/login",
			data : JSON.stringify(loginInfo),
			contentType : "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response["data"]);
			location.href = "/";
		}).fail(function(error) {
			alert(error["data"]);
		})
	}
}

userObject.init();