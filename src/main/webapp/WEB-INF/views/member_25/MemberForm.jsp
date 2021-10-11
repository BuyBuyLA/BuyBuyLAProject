<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/member_25/css/style.css' />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">

<title>新增會員資料</title>
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>


	<p>&nbsp;</p>
	<hr>
	<div class='center'>
		<H1>新增會員資料</H1>




		<form:form method='POST' modelAttribute="membershipInformationBean"
			class='form-horizontal' enctype="multipart/form-data">
			<!-- 檔案上傳的標籤一定要有enctype="multipart/form-data -->
			<fieldset>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for='userEmail'>
						帳號(請輸入e-mail) </label>
					<div class="col-lg-10">
						<form:input id="userEmail" path="userEmail" type='text'
							class='form:input-large' />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for='userPwd'>

						密碼 </label>
					<div class="col-lg-10">
						<form:input id="userPwd" path="userPwd" type='text'
							class='form:input-large' />
					</div>
				</div>



				<div class="form-group">
					<label class='control-label col-lg-2 col-lg-2' for="userPhone">
						手機 </label>
					<div class='col-lg-10'>
						<form:input id="userPhone" path="userPhone" type='text'
							class='form:input-large' />
					</div>
				</div>



				<div class="btn-group">
					<button type="button" class="btn btn-danger dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false">身分別</button>
					<ul class="dropdown-menu">
						<form:select path="house">
           				 <form:option value="Gryffindor"/>
         				   <form:option value="Hufflepuff"/>
         				   <form:option value="Ravenclaw"/>
         				   <form:option value="Slytherin"/>
       						 </form:select>
						<li><a class="dropdown-item" href="#">一般會員</a></li>
						<li><a class="dropdown-item" href="#">一般會員(同時開通賣家)</a></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#"> link</a></li>
						
					</ul>
				</div>



				<div class="form-group">
					<div class='col-lg-offset-2 col-lg-10'>
						<input id="btnAdd" type='submit' class='btn btn-primary'
							value="送出" />
						<!--  
							<input id="submit" type='submit' class='btn btn-primary'
							value="送出" />  -->
					</div>
				</div>
			</fieldset>
		</form:form>


		<a
			href='${pageContext.request.contextPath}/WEB-INF/views/member_25/index.jsp'>回到會員管理</a>

	</div>
</body>
</html>