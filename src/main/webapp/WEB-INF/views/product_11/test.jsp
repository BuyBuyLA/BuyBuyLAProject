<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form:form method='POST' modelAttribute="productBean"  class='form-horizontal'
        	enctype="multipart/form-data">
            <fieldset >
             
                    <div class='col-lg-10'>
                        <form:input id="productName" path="productName" type='text'
                            class='form:input-large' />
                    </div>
                    <div class='col-lg-offset-2 col-lg-10'>
                        <input id="btnAdd" type='submit' class='btn btn-primary'
                            value="送出" />
                    </div>
                
            </fieldset>
        </form:form>
</body>
</html>