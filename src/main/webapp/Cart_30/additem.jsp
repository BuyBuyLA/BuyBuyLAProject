<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<sql:setDataSource var="snapshot"
	driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
	url="jdbc:sqlserver://localhost:1433;databaseName=shopping" user="sa"
	password="zxcv265358" />

<% String id=request.getParameter("id"); 
	request.getSession(true).setAttribute("PID", id);
%>success
<sql:query sql="select * from PRODUCT where PID ='${PID}'" var="rs"
	dataSource="${snapshot}" />

<c:forEach var="row" items="${rs.rows}">

	<sql:update
		sql="if not exists(select pid from Cart where pid='${row.PID}')
INSERT INTO  Cart VALUES('${row.PID}','${row.P_img}','${row.P_name}','${row.P_price}','1')
else
update Cart set count=count+1 where pid='${row.PID}' "
		var="count" dataSource="${snapshot}" />

</c:forEach>
<%
request.getSession(true).removeAttribute("PID");
request.getRequestDispatcher("/TotalHome.jsp").forward(request, response);
%>

