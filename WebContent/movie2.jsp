<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.naver.dto.MovieDTO"%>
<%@ include file="top.jsp"%>
<%
	ArrayList<MovieDTO> list = (ArrayList<MovieDTO>) request.getAttribute("movie");
if(dto == null){
	response.sendRedirect("login.nhn");
}
%>

<body>
	<div class="container">
		<h3>영화 랭킹 출력</h3>

		<%
			for (MovieDTO mv : list) {
		%>
		<img src="<%=mv.getImg()%>" >
		<button type="button" class="btn btn-danger" onclick="send('<%= mv.getJe() %>')" >후기 입력 </button><br><br>
		

		<%}%>
	</div>
	<script >
	
	function send(je) {
		alert(je);
		alert("<%= dto.getName() %>");
	}
	
	</script>
</body>
</html>