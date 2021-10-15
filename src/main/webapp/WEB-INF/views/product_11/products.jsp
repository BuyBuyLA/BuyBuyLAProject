<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
                <h1>BuyBuyLa</h1>
            </div>
        </div>
    </section>
    
    
    
    
    
    <nav>
		<ul class="dropdown">
		<li> Hello!!!!!!!<a href="<c:url value='/try/member_Ui' />"> ${loginSession.userEmail}</a></li>
			<li><a href="<c:url value='/cart' />"> 我的購物車 (<i id="ccount">0</i>)
			</a></li>
			<li><a href="<c:url value='/user' />">購物記錄管理</a></li>
			<li><a href="main.html">活動專區</a></li>
			<li><a href="Intelligence32.jsp">團購專區</a></li>
			<li><a href="<c:url value='/try/login' />">會員登入</a></li>
			<li><a href="<c:url value='/try/add' />">會員註冊</a></li>			
			<li> <a href="<c:url value='/try/logout' />">登出會員</a></li>
		</ul>
	</nav>
    
    
    
    
    
    
    
    
    
    
    
	<div align='center'>
       <!--   <a href="<c:url value='/' />">回首頁</a>&nbsp;&nbsp;-->
    </div> 
       <c:forEach var='category' items='${categoryList}' >
	<a href="<c:url value='/products/${category}' />">${category}</a><br>
	</c:forEach>
    <hr style="height:1px;border:none;color:#333;background-color:#333;">
 
 <form:form method='POST' action="./query" class='form-horizontal'>
            <fieldset >
                    <div>
                        <input name="productName" id="productName"  type='text'
                            class='form:input-large' />
                    </div>
                    <div >
                        <input id="btnAdd" type='submit' class='btn btn-primary'
                            value="送出" />
                    </div>
            </fieldset>
        </form:form>
        
    <section class="container">
        <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-3" style="width: 360px; height: 360px">
                <div class="thumbnail" style="width: 320px; height: 340px">
                <img width='100' height='200' 
  				   src="<c:url value='/getPicture/${product.productId}' />" />	
        	
                    <div class="caption">
                        <p>
                            <b style='font-size: 12px;'>${product.productName}</b>
                        </p>
                        <p>${product.price}</p>
                        <p>目前在庫數量: ${product.stock}</p>
                        <p>
                    <a href="<spring:url value='/product?id=${product.productId}' />"
   						 class="btn btn-primary">
    					<span class="glyphicon-info-sigh glyphicon"></span>詳細資料
						</a>
                        </p>
                        
                    </div>
                </div>
            </div>
         </c:forEach>
        </div>
    </section>
    

        
     <div align='center'>
        <a href="<c:url value='/' />">回首頁</a>
    </div> 
    
    <script>
var count=0;
$('.count').each(function(){
	$(this).html;
	var a = parseInt($(this).html());
	count=count+a

	})

$('#ccount').html(count)
</script>
</body>
</html>
    