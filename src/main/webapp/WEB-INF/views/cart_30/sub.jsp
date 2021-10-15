<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<sql:setDataSource var="snapshot"
	driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
	url="jdbc:sqlserver://localhost:1433;databaseName=shopping" user="sa"
	password="zxcv265358" />

<% String id=request.getParameter("id"); 
	request.getSession(true).setAttribute("PID", id);
%>

<sql:update
	sql="if not exists(select * from Cart where count=1 AND PID=${PID})
update Cart set count=count-1 where pid='${PID}'"
	var="count" dataSource="${snapshot}" />
<%
request.getSession(true).removeAttribute("PID");
%>
 <script>
                
                setTimeout("location.href='cart'",0)

    </script>