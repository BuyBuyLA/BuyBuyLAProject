<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet"
    href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
<style type="text/css">
fieldset {
    border: 1px solid rgb(255, 232, 57);
    width: 400px;
    margin: auto;
}
</style>
<title>Campaign</title>
</head>
<body>
    <section>
        <div class="container">
            <h1 style="text-align: center">
            </h1>
        </div>
    </section>
    <div align='center'>
        <a href="<c:url value='/' />">
			首頁
        </a>
    </div> 
    <hr style="height: 1px; border: none; color: #333; background-color: #333;">
    <section class="container">
        <!--       三個地方要完全一樣 -->
        <form:form method='POST' modelAttribute="Campaign" class='form-horizontal'
        		   enctype='multipart/form-data'
        >
            <fieldset >
            
            	   <div class="form-group">
					<label class='control-label col-lg-2 col-lg-2' for="productImage">
						照片
					</label>
					<div class='col-lg-10'>
						<form:input id="productImage" path="productImage" type='file'
							class='form:input-large' />
					</div>
				</div>
				             
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for='name'>
						活動名稱:         
					</label>
                    <div class="col-lg-10">
                         <form:input id="name" path="name" type='text'
                            class='form:input-large' />
                    </div>
                </div>
				 <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for='date'>
						活動名稱:         
					</label>
                    <div class="col-lg-10">
                         <form:input id="date" path="date" type='date'
                            class='form:input-large' />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2"  for='url'>
                         活動網址:
                     </label>
                    <div class="col-lg-10">
                        <form:input id="url" path="url" type='text'
                            class='form:input-large' />
                    </div>
                </div>


                <div class="form-group">
                    <label class='control-label col-lg-2 col-lg-2' for="description">
                     	活動描述:
                    </label>
                    <div class='col-lg-10'>
                        <form:input id="description" path="description" type='text'
                            class='form:input-large' />
                    </div>
                </div>
                <div class="form-group">
                    <label class='control-label col-lg-2 col-lg-2' for="note">
                        備註:
                     </label>
                    <div class='col-lg-10'>
                        <form:input id="note" path="note" type='text'
                            class='form:input-large' />
                    </div>
                </div>

                
                <div class="form-group">
                    <div class='col-lg-offset-2 col-lg-10'>
                        <input id="btnAdd" type='submit' class='btn btn-primary'
                            value="送出" />
                    </div>
                </div>
            </fieldset>
        </form:form>
    </section>
</body>
</html>
