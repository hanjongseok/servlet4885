<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<style>
.divider-text {
	position: relative;
	text-align: center;
	margin-top: 15px;
	margin-bottom: 15px;
}

.divider-text span {
	padding: 7px;
	font-size: 12px;
	position: relative;
	z-index: 2;
}

.divider-text:after {
	content: "";
	position: absolute;
	width: 100%;
	border-bottom: 1px solid #ddd;
	top: 55%;
	left: 0;
	z-index: 1;
}

.btn-facebook {
	background-color: #405D9D;
	color: #fff;
}

.btn-twitter {
	background-color: #42AEEC;
	color: #fff;
}
</style>

</head>
<body>
	<%@ include file="top.jsp"%>
	<div class="container">



		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center">회원가입</h4>
				<form action="join_ok.nhn" method="post">
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-user"></i>
							</span>
						</div>
						<input name="name" class="form-control" placeholder="name"
							type="text">
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-envelope"></i>
							</span>
						</div>
						<input name="email" id="email" class="form-control"
							placeholder="Email address" type="email">

					</div>
					<div class="form-group input-group">

						<div class="alert alert-success" id="email-success">사용가능한 이메일입니다</div>
						<div class="alert alert-danger" id="email-danger">사용할수없는 이메일입니다</div>
					</div>

					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-phone"></i>
							</span>
						</div>
						<select id="mobile1"  name="mobile1" class="custom-select"
							style="max-width: 120px;">
							<option value="010" selected="">010</option>
							<option value="011">011</option>
							<option value="017">017</option>
							<option value="018">018</option>
						</select> <input id="mobile2" name="mobile2" name="mobile" class="form-control"
							placeholder="Phone number" type="text">
					</div>

					<!-- form-group end.// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input name="pw" id="pw" class="form-control"
							placeholder="Create password" type="password">
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input id="repw" name="pw" class="form-control"
							placeholder="Repeat password" type="password">
					</div>

					<div class="form-group input-group">

						<div class="alert alert-success" id="alert-success">비밀번호가
							일치합니다.</div>
						<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지
							않습니다.</div>
					</div>
					<!-- form-group// -->

					<!-- form-group// -->
					<div class="form-group">
						<button type="submit" id="submit"
							class="btn btn-primary btn-block">회원가입</button>
					</div>
					<!-- form-group// -->
					<p class="text-center">
						Have an account? <a href="login.nhn">Log In</a>
					</p>
				</form>
			</article>
		</div>
		<!-- card.// -->

	</div>
<script type="text/javascript">
    $(function(){
        $("#alert-success").hide();
        $("#alert-danger").hide();
        $("#repw").keyup(function(){
//         	console.log("눌렀다");
            var pwd1=$("#pw").val();
            var pwd2=$("#repw").val();
            console.log("pw: " + pwd1);
            console.log("repw: "+ pwd2);
            
            if(pwd1 != "" || pwd2 != ""){
                if(pwd1 == pwd2){
                    $("#alert-success").show();
                    $("#alert-danger").hide();
                    $("#submit").removeAttr("disabled");
                }else{
                    $("#alert-success").hide();
                    $("#alert-danger").show();
                    $("#submit").attr("disabled", "disabled");
                }    
            } 
        });
    });
$(document).ready(function(){    
    $("#email-success").hide();
    $("#email-danger").hide();
    $("#email").blur(function(){
        var email = $("#email").val();
        console.log(email + ' 이메일 체크!!');
        $.post("emailck.nhn",
        	    {
        	      email: email
        	    },
        	    function(data,status){
        	    	if (data.trim() == "ok") {
        	    		$("#email-success").hide();
        	    		$("#email-danger").show();
//         	    		alert("이메일이 있습니다");	
        	    	} else {
        	    		 $("#email-danger").hide();
        	    		 $("#email-success").show();
//         	    		alert("가입이 가능한 메일입니다.");	
        	    	}
        	      
       	});
    });
    $("#mobile1").blur(function(){
        $("#email-success").hide();
        $("#email-danger").hide();
    });
    $("#mobile2").blur(function(){
        $("#email-success").hide();
        $("#email-danger").hide();
    });
});
</script>

</body>
</html>