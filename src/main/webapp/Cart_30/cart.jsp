<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>購物車</title>

<link rel="stylesheet" type="text/css" href="cart.css" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">


<meta charset="UTF-8">
<title>購物車</title>

<link rel="stylesheet" type="text/css" href="cart.css" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<script type="text/javascript" src="cookie.js"></script>
<style>
body {
	font-family: "微軟正黑體";
	background-color: rgb(203, 218, 218);
	align-items: center;
	justify-content: center;
	position: relative;
}

td {
	background-color: white;
}

th {
	background-color: rgb(126, 199, 199);
}

.wrap {
	text-align: center;
	margin-top: 50px;
}

.submit {
	width: 200px;
	height: 60px;
	font-family: 'Roboto', sans-serif;
	font-size: 20px;
	text-transform: uppercase;
	letter-spacing: 2.5px;
	font-weight: 500;
	color: #000;
	background-color: #fff;
	border: none;
	border-radius: 45px;
	box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
	transition: all 0.3s ease 0s;
	cursor: pointer;
	outline: none;
}

.submit:hover {
	background-color: #33779e;
	color: #fff;
	transform: translateY(-7px);
}
</style>
</head>

<body>
	<sql:setDataSource var="snapshot"
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost:1433;databaseName=shopping" user="sa"
		password="zxcv265358" />

	<sql:query sql="select * from Cart" var="rs" dataSource="${snapshot}" />


	<div class="container">
		<div id="title" class="title">
			<h1>購物車</h1>
			<div class="search">
				<button class="icon">
					<i class="fa fa-search"></i>
				</button>
				<input type="search" id="search" placeholder="Search..." />
			</div>
		</div>

		<h3>
			<a href="TotalHome.jsp">返回商品頁面</a>
		</h3>
		<table>
			<thead>
				<tr>
					<th>圖片</th>
					<th>商品名稱</th>
					<th>數量</th>
					<th>單價</th>
					<th>合計</th>
					<th>刪除</th>
				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach var="row" items="${rs.rows}">
					<tr>
						<td><img src="${row.P_img}" /></td>
						<td>${row.P_name}</td>
						<td><a href="sub.jsp?id=${row.PID}"><button class="down">-</button></a><input
							type="text" value="${row.count}" readonly="readonly" /><a
							href="add.jsp?id=${row.PID}"><button class="up">+</button></a></td>
						<td>NT<span>${row.P_price}</span></td>
						<td>NT<span class="total">${row.count*row.P_price}</span></td>
						<td><a href="deletecart.jsp?id=${row.PID}"><button>刪除</button></a>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

		<h2 id="h2" class="">
			總價：$<span id="totalPrice">0</span>
		</h2>
		<br> <br> <br> <br> <br> <br>
		<center>

			<a href="check.jsp"><input type="submit" name="confirm"
				value="我要結帳" class="submit"></a>
		</center>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	
	var total=0;
	$('.total').each(function(){
		$(this).html;
		var a = parseInt($(this).html());
		total=total+a

		})
	
	$('#totalPrice').html(total)
	</script>

</body>



</html>