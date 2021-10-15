<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8" />
<title>BuyBuyLa購物商城</title>
<!--商品列表样式表-->
<link rel="stylesheet" type="text/css" href="TotalHome.css" />
<!--cookie操作的js库-->

<script src="cookie.js" type="text/javascript" charset="utf-8"></script>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Patrick+Hand&display=swap')
	;

/* HTML5 display-role reset for older browsers */
html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, center, dd, ol, ul, li, fieldset, form, label, legend, table,
	caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font: inherit;
	vertical-align: baseline;
}

ol, ul {
	list-style: none;
}

blockquote, q {
	quotes: none;
}

blockquote:before, blockquote:after, q:before, q:after {
	content: '';
	content: none;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

/* ---CSS reset is above--- */
* {
	box-sizing: border-box;
}

.header {
	width: 100%;
	height: 80px;
	background: rgb(203, 218, 218);
	color: white;
	font-size: 50px;
	padding-left: 30px;
	position: fixed;
	top: 0;
	z-index: 5000;
	font-family: 'Patrick Hand', cursive;
	font-weight: 600;
}

.box {
	border-radius: 10%;
	background: rgb(203, 218, 218);
	position: fixed;
	right: 50px;
	bottom: 30px;
	z-index: 2;
}

.box a {
	display: block;
	width: 70px;
	height: 70px;
	padding: 25px 15px;
	font-size: 20px;
	text-decoration: none;
	color: white;
}

.productList {
	width: 960px;
	margin: 120px auto;
	z-index: 1;
}

.productList img {
	width: 60%;
	margin-top: 30px;
	margin-left: 30px;
}

.productList li {
	position: relative;
	float: left;
	width: 220px;
	height: 310px;
	border: 1px dotted rgb(203, 218, 218);
	margin-left: 10px;
	margin-right: 10px;
	margin-bottom: 20px;
	padding-right: 5px;
	padding-left: 10px;
}

.productList .sale {
	position: absolute;
	top: 0;
	left: 0;
	background: rgb(203, 218, 218);
	color: rgb(203, 218, 218);
	padding: 8px;
}

.productList li h2 {
	font-weight: bold;
	color: #000000;
	margin-bottom: 10px;
	margin-top: 30px;
}

.productList li span {
	color: rgb(138, 221, 221);
	font-size: 20px;
}

button {
	background-color: white;
	display: block;
	margin: 0 auto;
	max-width: 130px;
	text-decoration: none;
	border-radius: 4px;
	padding: 10px 30px;
	font-size: small;
	border: 1px solid gainsboro;
}

button:hover {
	color: rgba(255, 255, 255, 0.85);
	border: none;
	background-color: #3498db;
	opacity: 0.5;
}

.demo-footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	padding: 15px;
	background-color: #212121;
	text-align: center;
	opacity: 0.1;
}

.demo-footer>a {
	text-decoration: none;
	font-weight: bold;
	font-size: 16px;
	color: #fff;
}

.modal-content {
	border-radius: 0;
	border: none;
}

.modal-header {
	border-bottom-color: #EEEEEE;
	background-color: #FAFAFA;
}

nav {
	float: right;
	position: fixed;
	top: 0;
	right: 0;
	z-index: 6000;
}

ul {
	margin: 10px 0;
	padding: 0px;
	list-style: none;
}

ul.dropdown {
	position: relative;
	width: 100%;
}

ul.dropdown li {
	font-weight: bold;
	float: left;
	width: 110px;
	position: relative;
	background: #ecf0f1;
	opacity: 0.6;
	margin-right: 5px;
}

ul.dropdown a:hover {
	color: #000;
}

ul.dropdown li a {
	display: block;
	padding: 20px 8px;
	color: rgb(3, 0, 0);
	position: relative;
	z-index: 2000;
	text-align: center;
	text-decoration: none;
	font-weight: 350;
	font-size: small;
}

ul.dropdown li a:hover, ul.dropdown li a.hover {
	background: #3498db;
	position: relative;
	color: #fff;
}

ul.dropdown ul {
	display: none;
	position: absolute;
	width: 180px;
	z-index: 1000;
}

ul.dropdown ul li {
	font-weight: normal;
	background: #f6f6f6;
	color: #000;
	border-bottom: 1px solid #ccc;
}

ul.dropdown ul li a {
	display: block;
	color: #34495e !important;
	background: #eee !important;
}

ul.dropdown ul li a:hover {
	display: block;
	background: #3498db !important;
	color: #fff !important;
}

ul.dropdown ul li a i {
	color: red;
}

.drop>a {
	position: relative;
}

.drop>a:after {
	content: "";
	position: absolute;
	right: 10px;
	border-left: 5px solid transparent;
	border-top: 5px solid #333;
	border-right: 5px solid transparent;
	z-index: 999;
}

.drop>a:hover:after {
	content: "";
	border-left: 5px solid transparent;
	border-top: 5px solid #fff;
	border-right: 5px solid transparent;
}
h1 {
	text-align: center;
}

i {
	font-style: normal;
}

.list {
	width: 1303px;
	margin: auto;
	overflow: hidden;
	margin-top: 20px;
}

.list dl {
	margin-top: 80px;
	float: left;
	width: 300px;
	border: 2px solid rgb(203, 218, 218);
	padding: 10px;
}

.list dl+dl {
	margin-left: 5px;
}

.list dl img {
	width: 100%;
	text-align: center;
}

.list dl dd {
	margin: auto;
}

.list dl dd span {
	font: bold 20px/20px "微軟正黑體";
	color: black;
}

dt {
	width: "280px";
	height: "200px";
	margin: 0 0 10px 0;
}

.mycar {
	width: 200px;
	font: bold 16px/30px "微軟正黑體";
	text-align: center;
	margin: 30px 200px;
	cursor: pointer;
	position: relative;
	overflow: hidden;
}

.mycar a {
	display: block;
	width: 100%;
	font: bold 16px/30px "微軟正黑體";
}

.mycar i {
	font: bold 22px/30px "微軟正黑體";
	color: red;
	position: relative;
	right: 10px;
	top: 0;
}
</style>

</head>
<body>
Hi!!!&nbsp;&nbsp;${loginSession.userEmail}
	<nav>
		<ul class="dropdown">
			<li><a href="<c:url value='/cart' />"> 我的購物車 (<i id="ccount">0</i>)
			</a></li>
			<li><a href="main.html">活動專區</a></li>
			<li><a href="Intelligence32.jsp">團購專區</a></li>
			<li><a href="UserLogin.jsp">會員登入</a></li>
			<li><a href="Form.jsp">會員註冊</a></li>
		</ul>
	</nav>
	<sql:setDataSource var="snapshot"
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost:1433;databaseName=BuyBuyLa" user="sa"
		password="password" />

	<sql:query dataSource="${snapshot}" var="result">
SELECT * from PRODUCT;
</sql:query>

	<div class="header">
		BuyBuyLa <span style="font-size: 30; color: #fff; font-weight: 200;">×
			Make money what you like</span>
	</div>
	<div class="box">
		<a href="#">TOP</a>
	</div>
	<div class="mycar"></div>

	<div class="List">
		<c:forEach var="row" items="${result.rows}">

			<dl pid="${row.PID}">
				<dt>
					<img src="${row.P_img}" />
				</dt>
				<dd>
					商品名稱:<span>${row.P_name}</span>
					<hr><hr>
					
				</dd>

				<dd>
					NT<span>${row.P_price}</span>
				</dd>
				<dd>
					<a href="<c:url value='/additem' />?id=${row.PID}"><button>加入購物車</button></a>
				</dd>
			</dl>

		</c:forEach>
		<sql:query dataSource="${snapshot}" var="rs">
SELECT * from Cart;
</sql:query>
		<c:forEach var="row" items="${rs.rows}">
			<span class="count" style="display: none"> ${row.count}</span>

		</c:forEach>

	</div>
	<footer class="demo-footer">
		<a href="./AllProduct.jsp" target="_blank">商品管理</a>
	</footer>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
var count=0;
$('.count').each(function(){
	$(this).html;
	var a = parseInt($(this).html());
	count=count+a

	})

$('#ccount').html(count)
</script>
</body>


</html>