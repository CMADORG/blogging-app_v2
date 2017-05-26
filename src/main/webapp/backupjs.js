$(document).ready(function(){
	$("#signuplab").click(function(){
		$("#welcomepage").hide();
		$("#signup").show();
	});
	
	$("#subclick").click(function(){
		$("#welcomepage").hide();
		$.ajax({
			url:'/CMAD1/rest/sub',
			type:'POST',
			dataType:'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				console.log("successfully logged out");
			//$("#welcomepage").show();
			},
			error : function(data) {
				$("#welcomepage").html(data);		
				console.log("Failure of data submit");
				//$("#welcomepage").show();
			}
			});
		
	});
	
	$("#subclick1").click(function(){
		console.log("Clicked the subclick1");
		$("#welcomepage").hide();
		$.ajax({
			url:'/CMAD1/rest/sub1',
			type:'POST',
			dataType:'html',
			contentType: "application/json; charset=utf-8",
			success : function(html) {
				console.log("successfully logged out");
			//$("#welcomepage").show();
			},
			error: function(xhr, status, error) {
				console.log(error);
				//console.log(status);
				//var err = eval("(" + xhr.responseText + ")");
				  //alert(err.Message);
				  
				}//,
//				
//			error : function(data) {
//				//alert(data)
//				//$("#welcomepage").html(data);
//				console.log("Failure of data submit" +data);
//				//$("#welcomepage").show();
//			}
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
	
	$("#loginlab").click(function(){
		$("#welcomepage").hide();
		$("#login").show();
		
	});
	
	
	
	$("#signupsubmit").click(function(e){
		e.preventDefault();
		$("#signup").hide();
		var userName = $("[name=username1]").val();
		var password = $("[name=password1]").val();
		
		var user = {
				"userName":userName,
				"password":password
		};
		console.log(user);
		$.ajax({
		url:'/CMAD1/rest/user',
		type:'POST',
		dataType:'json',
		contentType: "application/json; charset=utf-8",
		success : function(data) {
			console.log("success of data submit");
			$("#welcome").show();
		},
		error : function(data) {
			console.log("Failure of data submit");
			$("#signupfailure").show();
		},
		data:JSON.stringify(user)
		});
	});
		
		
		$("#loginsubmit").click(function(e){
			e.preventDefault();
			$("#login").hide();
			var userName = $("[name=username]").val();
			var password = $("[name=password]").val();
			
			var user = {
					"userName":userName,
					"password":password
			};
			console.log(user);
			$.ajax({
			url:'/CMAD1/rest/login',
			type:'POST',
			dataType:'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				console.log("success login");
				
				$("#welcome").show();
			},
			error : function(data) {
				console.log("Failure of data submit");
				$("#signupfailure").show();
			},
			data:JSON.stringify(user)
			});
});
});