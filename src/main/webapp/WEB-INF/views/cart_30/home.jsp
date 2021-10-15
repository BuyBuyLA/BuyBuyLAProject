<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
		<meta charset="utf-8" />
		<title>商品列表</title>
		<!--商品列表样式表-->
		<link rel="stylesheet" type="text/css" href="test.css" />
	</head>
	<style>
	* {
	margin: 0;
	padding: 0;
}

.container {
	width: 1303px;
	margin: 0 auto;
}

a {
	text-decoration: none;
	color: #808080;
}

h1 {
	text-align: center;
}

i {
	font-style: normal;
}

.list {
	width: 1303px;
	margin: 0 auto;
	overflow: hidden;
	margin-top: 20px;
}

.list dl {
	float: left;
	width: 300px;
	border: 1px solid #ccc;
	padding: 10px;
}

.list dl:hover {
	border-color: red;
}

.list dl+dl {
	margin-left: 5px;
}

.list dl img {
	width: 100%;
	text-align: center;
}

.list dl dd {
	text-align: center;
}

.list dl dd span {
	font: bold 22px/22px "微软雅黑";
	color: red;
}

.list dl dd button {
	height: 30px;
	width: 100px;
	font: 400 18px/30px "微软雅黑";
	background-color: darkred;
	color: #fff;
	border: none;
}

.list dl dd button:hover {
	background-color: red;
}

.mycar {
	width: 200px;
	font: bold 16px/30px "微软雅黑";
	text-align: center;
	margin: 30px 200px;
	border: 1px solid #CCCCCC;
	cursor: pointer;
	position: relative;
	overflow: hidden;
}

.mycar a {
	display: block;
	width: 100%;
	font: bold 16px/30px "微软雅黑";
}

.mycar:hover {
	background-color: gold
}

.mycar i {
	font: bold 22px/30px "微软雅黑";
	color: red;
	position: absolute;
	right: 10px;
	top: 0;
}
.mycar2 {
	
	width: 200px;
	font: bold 16px/30px "微软雅黑";
	text-align: center;
	margin: 30px 200px;
	border: 1px solid #CCCCCC;
	cursor: pointer;
	position: relative;
	overflow: hidden;
}

.mycar2 a {
	display: block;
	width: 100%;
	font: bold 16px/30px "微软雅黑";
}

.mycar2:hover {
	background-color: gold
}

.mycar2 i {
	font: bold 22px/30px "微软雅黑";
	color: red;
	position: absolute;
	right: 10px;
	top: 0;
}
</style>
<body>
 
<sql:setDataSource var="snapshot" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
     url="jdbc:sqlserver://localhost:1433;databaseName=shopping"
     user="sa"  password="zxcv265358"/>

<sql:query dataSource="${snapshot}" var="result">
SELECT * from goods;
</sql:query>
 <div class="container">
			<h1>商品列表</h1>
			<div class="mycar">
				<a href="<c:url value='/cart' />">我的購物車</a><i id="ccount">0</i>
			</div><br><br>
		<div class="mycar2">
				<a href="<c:url value='/user' />">管理購物紀錄</a>
		</div>	

<div class="list">
<c:forEach var="row" items="${result.rows}">

				<dl pid="${row.PID}">
					<dt>
						<img src="${row.P_img}" />
					</dt>
					<dd>商品名稱:<span>${row.P_name}</span></dd>
					
					<dd>NT<span>${row.P_price}</span></dd>
					<dd>
						<a href="<c:url value='/additem' />?id=${row.PID}" ><button>加入購物車</button></a>
					</dd>
				</dl>
			
</c:forEach>


<sql:query dataSource="${snapshot}" var="rs">
SELECT * from Cart;
</sql:query>
<c:forEach var="row" items="${rs.rows}">
<span class="count"  style="display:none"> ${row.count}</span>

</c:forEach>
 <div class="container">

</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
<script>
var count=0;
$('.count').each(function(){
	$(this).html;
	var a = parseInt($(this).html());
	count=count+a

	})

$('#ccount').html(count)
</script>


</script>
</body>


</html>