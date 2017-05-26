$(document).ready(function(){
	$("#signuptab").click(function(){
		$("#welcomepage").hide();
		$("#submitBtn").val("signup")
		$("#signup").show();
	});
	$("#logintab").click(function(){
		$("#welcomepage").hide();
		$("#submitBtn").val("login")
		$("#signup").show();
	});
	
	$("#submitBtn").click(function(e){
		e.preventDefault();
		$("#signup").hide();
		
		var userName = $("[name=username]").val();
		var password = $("[name=password]").val();
		
		var user = {"userName":userName, "password":password};
		var url;
		var op;
		if($("#submitBtn").val() === "login")
		{
			op="login";
			url = '/CMAD1/rest/login';
		}
		else
		{
			op="signup";
			url = '/CMAD1/rest/user';
		}
		$.ajax({
		url:url,
		type:'POST',
		dataType:'json',
		contentType: "application/json; charset=utf-8",
		success : function(data) {
			console.log("success of data submit");
			if($("#submitBtn").val() === "login")
			$("#welcome").show();
			else
			{
				alert("Signup success!!");
				$("#name").html("Welcom ", userName)
				$("#welcomepage").show();
			}
		},
		error : function(data) {
			console.log("Failure of data submit");
			alert("Login/Signup failed");
			$("#welcomepage").show();
			
		},
		data:JSON.stringify(user)
		});
	});
	
	$("#logout").click(function(){
		$("#welcome").hide();
		$.ajax({
			url:'/CMAD1/rest/logout',
			type:'POST',
			dataType:'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				console.log("successfully logged out");
				$("#welcomepage").show();
			},
			error : function(data) {
				console.log("Failure of data submit");
				$("#welcomepage").show();
			}
			});
	});
});