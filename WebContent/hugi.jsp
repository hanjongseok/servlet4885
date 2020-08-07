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
	<div class="row">							
		<table class="table table-striped"						
			style="text-align: center; border: 1px solid #dddddd">					
			<thead>					
				<tr>				
					<th style="background-color: #eeeeee; text-align: center;">글번호</th>					
					<th style="background-color: #eeeeee; text-align: center;">영화제목</th>			
					<th style="background-color: #eeeeee; text-align: center;">평점</th>			
					<th style="background-color: #eeeeee; text-align: center;">작성자</th>			
<!-- 					<th style="background-color: #eeeeee; text-align: center;">내용</th>			 -->
				</tr>				
			</thead>					
			<tbody>					
				<tr>				
					<td>1</td>			
					<td>반도</td>			
					<td>0.1</td>			
					<td>홍길동</td>			
<!-- 					<td>잼</td>			 -->
				</tr>				
			</tbody>					
		</table>						
		<a href="" class="btn btn-primary pull-right">글쓰기</a>						
	</div>							
</div>								


<!-- 	<div class="container"> -->
<!-- 		<h3>영화 랭킹 출력</h3> -->
<!-- <div id="result"></div> -->

<!-- </div>  -->
<!-- <script> -->
<!--  $(document).ready(function(){ -->
<!--  	var search = $("#search").val(); -->
<!--  	$("#result").html("여기에 출력: " + search); -->
<!--  	console.log(search); -->
<!--      $.get("movie_ok.nhn", -->
<!--      function(data, status){ -->
<!--      	var html = ""; -->
<!--      	console.log(data); -->
<!--  //     	console.log(data.items); -->
<!--      	$.each(data, function(key, field){ -->
<!--  //     		html += "<a href='" + field.link + "' target='_blank'>" -->
<!--      		html += "<img src='" + field.img + "'></a><br>"; -->
<!--      		html += field.je + "<br>"; -->
<!--      		html += field.gam + "<br>"; -->
<!--      		html += field.bae + "<br>"; -->
<!--            }); -->
<!--  		$("#result").html(html); -->
<!--      }); -->
<!--  }); -->
<!-- </script> -->

</body>
</html>