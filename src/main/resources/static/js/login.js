/**
 * 
 */

function visiblePassword(){
	var password = document.getElementById("pass");
	if(password.type === "password"){
		password.type = "text";
		
	}else{
		password.type="password";
		
	}
}
function visiblePassword2(){
	var password = document.getElementById("pass2");
	if(password.type === "password"){
		password.type = "text";
		
	}else{
		password.type="password";
		
	}
}

function resetAll(){
	$("#cuser").val('');
	$("#cpass").val('');
	$("#email").val('');
	$("#address").val('');
	
}


function validateCreate(){
	if($("#answer").val()==""||$("#email").val()==""||$("#cuser").val()==""||$("#cpass").val()==""||$("#address").val()==""){
		return false;
	}
	else if($("#mail").text()!=""){
		$("#email").notify( 
				  "Email is already registerd", 
				  { position:"right" }
				);
		
	}
	else{
		return true;
	}
}
function validateLogin(){
	if($("#user").val()==""||$("#pass").val()==""){
		return false;
	}
	else{
		return true;
	}
}
$(document).ready(function(){
	  /* 	sad */
		$('.signup-link').click(function(){
        //	 	   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
        			 $(".container-reg").slideToggle("slow");

        			 $(".container").slideToggle("slow");
        		});
        		$('.forgot-link').click(function(){
        				 $(".container-forgot").slideToggle("slow");

        				 $(".container").slideToggle("slow");
        		});
        		$('.go-back').click(function(){
        			 $(".container-forgot").slideToggle("slow");

        			 $(".container").slideToggle("slow");

        		});





		
		$('.resetPass').submit(function(){

        			  $.post("/resetPassword",$(this).serialize(),
        					  function(response){
        						  if(response == ""){
        							  $(".container-password").slideToggle("slow");
        							  $(".container").slideToggle("slow");
        							  $.notify("Password Changed Successfully","success");
        						  }
        						  else{
        							  $(".resetPass #rpass").notify( response , { position:"right" }	);
        						  }

        					  });

        		});
		$('#secureQus').submit(function(){
			
			
			  $.post("/checkEmail",$(this).serialize(),
					  function(response){
						  if(response=="done"){
							  $("#rQues").val( $("#secureQus #combo option").filter(":selected").val() );
							  $("#rAns").val( $("#secureQus #sAnswer").val() );
							  $("#rEmail").val( $("#mainEmail").val() );
							  $(".container-question").slideToggle("slow");
							  $(".container-password").slideToggle("slow");
							  
						  }
						  else{
							  $.notify(response,"warn");
						  }
						  
					  });
			 
		});

		
		$('#recoverEmail').submit(function(){
			 
			  $.post("/checkEmail",$(this).serialize(),
					 
					  function(response){
						  var b=response.split(',');
						  if(b[0]==""){
							  $(".container-question").slideToggle("slow");
							  $(".container-forgot").slideToggle("slow");
							  $("#mainEmail").val(b[1]);
						  }
						  else{
							 
							  if(response=="Banned"){
//								  ALERT('HI2');
								  window.location = "/login";
							  }
							  else{
								  $("#mailMsg").text(response);
							  }
							 
						  }
						  
					  });
			 
		});
		$("#loginForm").submit(function() {
			
			if(validateLogin()){ 
				$("#msg").text('')
				$.post("/login",
	                    $(this).serialize(),
	                    function (response) {
							if(response!="index")
//								$("#msg").text('Wrong Username Or Password')
								$.notify("Wrong Username Or Password","error")
							else
								window.location = '/'
				});
			}
		
		});
		$("#regForm").submit(function() {
			if(validateCreate()){
				$.post("/signUp", 
						$(this).serialize(),
						function(response){
							if(response == "done"){
//								resetAll();
								 $(".container-reg").slideToggle("slow");
								 $(".container").slideToggle("slow");
								$.notify("Account Created", "success");
								resetAll();
							}
							else{
								$.notify(response);
							}
					});
			}
		});
		
				
	});
		