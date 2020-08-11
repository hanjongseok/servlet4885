<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.naver.dto.* "%>
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
		<h3>영화 랭킹 출력</h3>
		<div id="result"></div>
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">후기작성</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form action="/action_page.php">

							<div class="form-group">
								<label for="email">영화제목:</label> <input type="email"
									class="form-control" id="m_tit" placeholder="영화제목" name="m_tit"
									disabled="disabled"> 
									<input type="hidden" id="mv_num"value="">

							</div>


							<div class="form-group">
								<label for="email">작성자:</label> <input type="email"
									class="form-control" id="name" placeholder="작성자" name="name"
									disabled="disabled">
									<input type="hidden" id="mb_num" value="">
							</div>

							<div class="form-group">
								<label for="h_tit">후기제목:</label> <input type="h_tit"
									class="form-control" id="h_tit" placeholder="후기제목" name="h_tit">
							</div>

							<div class="form-group">
								<label for="comment">Comment:</label>
								<textarea class="form-control" rows="5" id="hugi" name="hugi"></textarea>
						</form>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="submit" id="okBtn" class="btn btn-primary">후기작성</button>
						<button type="button" class="btn btn-danger" id="close_modal">Close</button>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script>
function modal_show(num){
             $("#myModal").modal("show");
             //사용자에게 보여주는 값 세팅
             var je = $("#mv" + num).val();
             $("#m_tit").val(je);// 영화제목
			$("#name").val('<%=dto.getName()%>');
             
             //데이터 넘김
             $("#mv_num").val(num);
             $("#mb_num").val(<%= dto.getNum() %>);
             

		};
		$("#close_modal").click(function() {
			$("#myModal").modal("hide");
		});

		$("#okBtn").click(function() {
			alert("저장합니다")
			var m_tit = $("#mv_num").val();
			var name = $("#mb_num").val();
			var h_tit = $("#h_tit").val();
			var hugi = $("#hugi").val();
// 			console.log(m_tit);
// 			console.log(name);
// 			console.log(h_tit);
// 			console.log(hugi);
			$.post("hugi_ok.nhn",
			{
				mv_num : m_tit,
				mb_num : name,
				h_tit : h_tit,
				hugi : hugi
			}, function(data, status) {
				console.log(data);
				
			});
		});

		$.get(
				"movie_ok.nhn",
				function(data, status) {
					var html = "";
					
					
					console.log(data);
					//     	console.log(data.items);
					$.each(data,function(key, field) {
												//     		html += "<a href='" + field.link + "' target='_blank'>"
												html += "<img src='" + field.img + "'><br>";
												html += field.je + "<br>";
												html += field.gam + "<br>";
												html += field.bae + "<br>";
												html += "<input type='hidden' id = 'mv"+ field.num +"' value='" + field.je + "'>";
												html += '<button type="button" class="btn btn-danger" onclick="modal_show('
														+ field.num
														+ ')" >후기 입력 </button><br><br>';
												//     		html += '<button type="button" class="btn btn-danger" onclick="modal_show(\''+ field.je +'\')" >후기 입력 </button><br><br>>';
												//     		html += '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal" >후기 입력 </button>'+"<br><br>";
											});
							$("#result").html(html);
						});
	</script>
</body>
</html>