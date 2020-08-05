<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String email = (String) request.getAttribute("email");
%>
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
<%@ include file="top.jsp"%>
<body>
	<div class="container">



		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center">로그인</h4>
				
				
				<form action="login_ok.nhn" method="post">
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-envelope"></i>
							</span>
						</div>
						<input name="email" class="form-control" placeholder="Email address"
							type="email" value="">
					</div>
					<!-- form-group// -->


					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input name="pw" class="form-control" placeholder="password"
							type="password">
					</div>
					<!-- form-group// -->
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							login</button>
					</div>
					<!-- form-group// -->
					<p class="text-center">
						<a href="join.nhn">sing up</a>
					</p>
				</form>
			</article>
		</div>
		<!-- card.// -->

	</div>

</body>
</html>