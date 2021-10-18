<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
    href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel='stylesheet' href="<c:url value='/css/products.css' />"  type="text/css" />
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<title>Products</title>
</head> 
<body>
    <div class="menu-btn">
    <i class="fas fa-bars fa-2x"></i>
  </div>

  <div class="container">
    <!-- Nav -->
    <nav class="main-nav">
      <img src="image/BuyBuyLaLogo.png" alt="Microsoft" class="logo">

      <ul class="main-menu">
        <li><a href="<c:url value='/try/login' />">會員登入</a></li>
        <li><a href="<c:url value='/try/add' />">會員註冊</a></li>
        <li><a href="forum">討論區</a></li>
        <li><a href="campaigns">活動專區</a></li>
        <li><a href="<c:url value='/cart' />"><i class="fas fa-shopping-cart"></i><i id="ccount"></i>
			</a></li>
			<li><a href="<c:url value='/try/member_Ui' />">${loginSession.userEmail}</a></li>
<!--  <li><a href="#">待更新</a></li> -->
      </ul>
 
      <ul class="right-menu">
        <li>
      <form:form method='POST' action="./queryproduct" class='form-horizontal'>
            <fieldset >
                        <input name="productName" id="productName"  type='text'
                            class='form:input-large' />
                        <input id="btnAdd" type='submit' class='btn btn-primary'
                            value="送出" />
            </fieldset>
        </form:form>
        </li>
      </ul>
    </nav>

    <!-- Showcase -->
    <header class="showcase">
      <h2>Surface Deals</h2>
      <p>
        Select Surfaces are on sale now - save while supplies last
      </p>
      <a href="#" class="btn">
        Shop Now <i class="fas fa-chevron-right"></i>
      </a>
    </header>

    <!-- Home cards 1 -->
    <section class="home-cards">
      <c:forEach var='category' items='${categoryList}' >
    <div>
      <img src="https://i.ibb.co/LZPVKq9/card1.png" alt="">
       <h3>${category}</h3>
        	<a href="<c:url value='/products/${category}' />">${category} <i class="fas fa-chevron-right"></i></a>
       </div>
		</c:forEach>
 
    </section>

    <!-- Xbox -->
    <section class="xbox">
      <div class="content">
        <h2>Xbox Game Pass Ultimate</h2>
        <p>Xbox Game Pass Ultimate Xbox Live Gold and over 100 high-quality
          console and PC games. Play together with friends and discover your
          next favorite game.</p>
          <a href="#" class="btn">
            Join Now <i class="fas fa-chevron-right"></i>
          </a>
      </div>
    </section>

    <!-- Home cards 2 -->
			<section class="home-cards">
				<div>
					<img src="https://i.ibb.co/zVqhWn2/card5.png" alt="" />
					<h3>Microsoft Teams</h3>
					<p>
						Unleash the power of your team.
					</p>
					<a href="#">Shop Now <i class="fas fa-chevron-right"></i></a>
				</div>
				<div>
					<img src="https://i.ibb.co/mGZcxcn/card6.jpg" alt="" />
					<h3>Unlock the power of learning</h3>
					<p>
						Get students future-ready with Windows 10 devices. Starting at $219.
					</p>
					<a href="#">Shop Now <i class="fas fa-chevron-right"></i></a>
				</div>
				<div>
					<img src="https://i.ibb.co/NpPvVHj/card7.png" alt="" />
					<h3>Windows 10 Enterprise</h3>
					<p>
						Download the free 90-day evaluation for IT professionals.
					</p>
					<a href="#">Download Now <i class="fas fa-chevron-right"></i></a>
				</div>
				<div>
					<img src="https://i.ibb.co/LkP4L5T/card8.png" alt="" />
					<h3>Explore Kubernetes</h3>
					<p>
						Learn how Kubernetes works and get started with cloud native app
						development today.
					</p>
					<a href="#">Get Started <i class="fas fa-chevron-right"></i></a>
				</div>
      </section>
        
     
      <!-- Carbon
      <section class="carbon dark">
        <div class="content">
          <h2>Commiting To Carbon Negative</h2>
          <p>Microsoft will be carbon negative by 2030 and by 2050 we will remove
            all carbon the company has emitted since it was founded in 1975</p>
            <a href="#" class="btn">
              Learn More <i class="fas fa-chevron-right"></i>
            </a>
        </div>
      </section> -->
      
      <!-- produts -->
      <div class="pcontainer">
    <div class="well well-sm">
        <div id="view" class="btn-group">
            <a href="#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list">
            </span>List</a> <a href="#" id="grid" class="btn btn-default btn-sm"><span
                class="glyphicon glyphicon-th"></span>Grid</a>
        </div>
	
    <div id="products" class="row list-group">
    	<c:forEach items="${products}" var="product">
       	 <div class="item  col-xs-4 col-md-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="<c:url value='/getPicture/${product.productId}' />" alt="" />
              <div class="category">
                <h5 class="category-name">Tables</h5>
              </div>
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        Pearl Galaxy</h4>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                $2,100</p>
                        </div>
		<div class="btn-group">
            <a class="btn btn-details" href="<spring:url value='/product?id=${product.productId}' />">Details</a>
 			<a class="btn btn-success" href="<c:url value='/additem' />?id=${product.productId}">Add to cart</a>
 		 </div>
                 </div>
              </div>
              </div>
            </div>
            </c:forEach>
    </div>
</div>
 </div> 
      

      <!-- Follow -->
      <section class="follow">
        <p>Follow Microsoft</p>
        <a href="https://facebook.com">
          <img src="https://i.ibb.co/LrVMXNR/social-fb.png" alt="Facebook">
        </a>
        <a href="https://twitter.com">
          <img src="https://i.ibb.co/vJvbLwm/social-twitter.png" alt="Twitter">
        </a>
        <a href="https://linkedin.com">
          <img src="https://i.ibb.co/b30HMhR/social-linkedin.png" alt="Linkedin">
        </a>
      </section>
    </div>
      <!-- Links -->
      <section class="links">
        <div class="links-inner">
          <ul>
            <li><h3>What's New</h3></li>
            <li><a href="#">Surface Pro X</a></li>
            <li><a href="#">Surface Laptop 3</a></li>
            <li><a href="#">Surface Pro 7</a></li>
            <li><a href="#">Windows 10 apps</a></li>
            <li><a href="#">Office apps</a></li>
          </ul>
          <ul>
            <li><h3>Microsoft Store</h3></li>
            <li><a href="#">Account Profile</a></li>
            <li><a href="#">Download Center</a></li>
            <li><a href="#">Microsoft Store support</a></li>
            <li><a href="#">Returns</a></li>
            <li><a href="#">Older tracking</a></li>
          </ul>
          <ul>
            <li><h3>Education</h3></li>
            <li><a href="#">Microsfot in education</a></li>
            <li><a href="#">Office for students</a></li>
            <li><a href="#">Office 365 for schools</a></li>
            <li><a href="#">Deals for studentss</a></li>
            <li><a href="#">Microsfot Azure</a></li>
          </ul>
          <ul>
            <li><h3>Enterprise</h3></li>
            <li><a href="#">Azure</a></li>
            <li><a href="#">AppSource</a></li>
            <li><a href="#">Automotive</a></li>
            <li><a href="#">Government</a></li>
            <li><a href="#">Healthcare</a></li>
          </ul>
          <ul>
            <li><h3>Developer</h3></li>
            <li><a href="#">Visual Studio</a></li>
            <li><a href="#">Windowszs Dev Center</a></li>
            <li><a href="#">Developer Network</a></li>
            <li><a href="#">TechNet</a></li>
            <li><a href="#">Microsoft Developer</a></li>
          </ul>
          <ul>
            <li><h3>Company</h3></li>
            <li><a href="#">Careers</a></li>
            <li><a href="#">About Microsoft</a></li>
            <li><a href="#">Company news</a></li>
            <li><a href="#">Privacy at Microsoft</a></li>
            <li><a href="#">Inverstors</a></li>
          </ul>
        </div>
      </section>

      <!-- Footer -->
      <footer class="footer">
        <div class="footer-inner">
          <div><i class="fas fa-globe fa-2x"></i> English (United States)</div>
          <ul>
            <li><a href="#">Sitemap</a></li>
					<li><a href="#">Contact Microsoft</a></li>
					<li><a href="#">Privacy & cookies</a></li>
					<li><a href="#">Terms of use</a></li>
					<li><a href="#">Trademarks</a></li>
					<li><a href="#">Safety & eco</a></li>
					<li><a href="#">About our ads</a></li>
					<li><a href="#">&copy; Microsoft 2020</a></li>
          </ul>
        </div>
      </footer>
      
      
      
      
      <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
      <script>
      document.querySelector('.menu-btn').addEventListener('click', () => document.querySelector('.main-menu').classList.toggle('show'));
     
      $(document).ready(function() {
    	    $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
    	    $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
    	});
      
      </script>
      
</body>
</html>
    