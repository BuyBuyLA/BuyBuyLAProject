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
%>
<sql:update sql="delete from Cart where pid='${PID}' " var="delete" dataSource="${snapshot}"/>
 <%
request.getSession(true).removeAttribute("PID");

%>
 <script>
                
                setTimeout("location.href='cart'",0)

    </script>