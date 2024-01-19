let postObject = {
	init : function() {
		let _this = this;
		
		$("#btn-write").on("click", () => {
			_this.write();
		});
	},
	
	write : function() {
		let postInfo = {
			title : $("#title").val(),
			content : $("#content").val()
		}
		
		$.ajax({
			type : "POST",
			url : "/post/write",
			data : JSON.stringify(postInfo),
			contentType : "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response["data"]);
			location.href = "/";
		}).fail(function(error) {
			alert(error["data"]);
		});
	}
	
}

postObject.init();