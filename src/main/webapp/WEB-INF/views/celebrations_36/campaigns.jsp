<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
    href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />   
<title>Products</title>
</head> 
<body>
    <section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>產品清單</h1>
            </div>
        </div>
    </section>
	<div align='center'>
        <a href="<c:url value='/' />">回首頁</a>&nbsp;&nbsp;
          <a href="<c:url value='/queryByCategory' />">再查一次</a>
    </div> 
    <hr style="height:1px;border:none;color:#333;background-color:#333;">
    <section class="container">
        <div class="row">
        	<c:forEach items='${campaigns}' var='campaign'>
            <div class="col-sm-6 col-md-3" style="width: 360px; height: 360px">
                <div class="thumbnail" style="width: 320px; height: 340px">
                	  <a href="<c:url value='${campaign.url}' />">
                	<img style="padding:10px" width='310' height='200' 
                		src="<c:url value='/getPicture/${campaign.id}' />" />
                		</a>
                    <div class="caption">
                        <p>
                           <b style='font-size: 16px;'>${campaign.description}</b>
                        </p>
                        <p><a href="<spring:url value='/campaign?id=${campaign.id}' />"
   							 class="btn btn-primary">
    						<span class="glyphicon-info-sigh glyphicon"></span>詳細資料
						</a></p>
                    </div>
                </div>
            </div>
           </c:forEach>
        </div>
    </section>
     <div align='center'>
        <a href="<c:url value='/' />">回首頁</a>
    </div> 
</body>
</html>
    