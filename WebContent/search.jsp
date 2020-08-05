<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.naver.dto.DTO"%>
<%
	String email = (String) request.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
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
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-envelope"></i>
						</span>
					</div>
					<input id="search" name="search" class="form-control"
						placeholder="검색" type="search" value="">
				</div>

				<!-- form-group// -->
				<div class="form-group">
					<button id="searchbt" type="submit"
						class="btn btn-primary btn-block">검색</button>
				</div>
			</article>
			<!-- 			검색결과 출력 -->

		</div>
		<h3>검색결과 출력</h3>
		<div id="result"></div>
		<!-- card.// -->

	</div>
	<script>
		$(document).ready(function() {
			$("#searchbt").click(function() {
				var search = $("#search").val();
				$("#result").html("여기에 출력" + search);
				console.log(search);
				$.post("search_ok.nhn", {
					search : search
				}, function(data, status) {
					var html = "";
					console.log(data['total']);
					console.log(data.items);
					$.each(data.items, function(key, field) {
						html += "<a href='" + field.link + "' target='_blank'>"
						html += field.title + "</a><br>";
						//			             $("div").append(field + " ");
						//			     		console.log("Data: " + field.title);  // field['title']
					});
					$("#result").html(html);
				});
			});
		});
	</script>

</body>
</html>