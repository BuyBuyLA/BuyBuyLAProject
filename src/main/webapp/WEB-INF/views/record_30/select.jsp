<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   fieldset {
            width: 420px;
            margin: auto;
            border: 3px solid red;
            border-radius: 20px;
            text-align: center;
        }

        legend {
            color: black;
            font-size: 200%;
            text-align: center;

        }
        button{
        border:border: 10px solid red;
        font-size: 100%;
        }

</style>
</head>
<body>
	<form:form method='POST' modelAttribute="RecordBean" class='form-horizontal'>
 <fieldset>
        <legend><em>購物紀錄查詢</em></legend>
<h3>請輸入要查詢的帳號:<form:input id="buyer" path="buyer" type='text'/></h3>
<a href="<c:url value='/select2' />"><input type="submit" value="確認送出"></a>
</fieldset>
</form:form>
</body>
</html>