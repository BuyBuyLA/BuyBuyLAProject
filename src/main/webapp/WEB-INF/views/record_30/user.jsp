<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-family: "微軟正黑體";
	background-color: rgb(203, 218, 218);
	align-items: center;
	justify-content: center;
	position: relative;
}

div {
	display: flex;
	width: 360px;
	border: lightblue 3px solid;
	margin: 0 auto;
}
</style>
</head>
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<body>
	<h1 ALIGN="center">購物記錄管理</h1>
	<div>
		<form action=".\UserServlet" method="post">

			<button class='btn btn-default' name="select" type='submit'
				value='submit' style="width: 120px; height: 50px; font-size: 30px;">
				<i class="fas fa-search"></i>查詢
			</button>

		</form>



		<form action=".\update.jsp" method="post">

			<button class='btn btn-default' type='submit' value='submit'
				style="width: 120px; height: 50px; font-size: 30px;">
				<i class="fas fa-pencil-alt"></i>修改
			</button>

		</form>
		<form action=".\delete.jsp" method="post">

			<button class='btn btn-default' type='submit' value='submit'
				style="width: 120px; height: 50px; font-size: 30px;">
				<i class="fas fa-trash-alt"></i>刪除
			</button>

		</form>
	</div>

</body>
</html>