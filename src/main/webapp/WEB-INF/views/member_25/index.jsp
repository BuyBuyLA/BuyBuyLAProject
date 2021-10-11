<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link rel='stylesheet' href='${pageContext.request.contextPath}/member_25/css/style.css' />
<meta charset="UTF-8">
<title>會員資料管理</title>
</head>  
<body>
<p>&nbsp;</p>
<hr>
<div class='center' >
<h2>會員管理</h2>
<hr>
<a href='MemberForm.jsp' >會員資料新增</a><br>
<a href='queryMember.do' >會員資料查詢</a><br>
<a href="<c:url value='/member/add' />">新增會員資料</a><BR>
<br>

<a href='..'>回前頁</a>

</div>
</body>
</html>