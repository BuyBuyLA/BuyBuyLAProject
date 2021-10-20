<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章討論區</title>
<!-- Jquery JS -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Summernote CSS JS -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<style>
.tab {
	display: block;
	margin: 50px;
}

.tab :hover {
	background-color: rgb(194, 203, 186);
}

.tab li {
	display: inline;
	border: 1px solid rgb(166, 184, 184);
	margin: 10px;
	padding: 10px 0px;
}

.tab li a {
	margin: 0 auto;
	color: black;
	text-decoration: none;
	padding: 10px 50px;
}

nav {
	text-align: center;
}

h1 {
	display: inline;
}

.newContent {
	width: 1000px;
	margin: 0 auto;
	margin-bottom: 50px;
}

.card {
	overflow: hidden;
}

.productImg img {
	transform: scale(1, 1);
	transition: all 1s ease-out;
}

.productImg img:hover {
	transform: scale(1.05, 1.05);
}
#edit{transform: scale(1, 1);}
#edit:hover{transform: scale(1.1, 1.1);}
</style>
</head>
<body>
	<nav>
		<br>
		<br>
		<br>
		<h1>動態貼文</h1>
		<input type="hidden" id="hidden" value="" />
		<br>
<!-- 		<div style="margin: 0px 50px; width: 390px; float: right;"> -->
<!-- 			<input class="form-control me-2 mb-0 search" name="search" -->
<!-- 				type="search" placeholder="請輸入關鍵字" aria-label="Search" -->
<!-- 				style="width: 200px; display: inline"> -->
<!-- 			<button class="btn btn-outline-success searchbtn me-5" -->
<!-- 				name="searchbtn" type="submit">Search</button> -->
<!-- 		</div> -->
		<br>
		<br>
		<ul class="tab">
			<li><a href="<c:url value="forum"/>">所有文章</a></li>
			<li><a href="<c:url value="chat"/>">忙裡偷閒聊</a></li>
			<li><a href="<c:url value="box"/>">開箱文</a></li>
			<li><a href="<c:url value="other"/>">其他</a></li>
		</ul>
	</nav>
	<div class="幻燈片"></div>
	<div class="newContent">
		<button type="button" class="btn btn-outline-secondary"
			data-bs-toggle="modal" data-bs-target="#Modal">新增貼文</button>
	</div>
	<div class="row">
		<div class="col-12 col-md-9 mx-auto"
			style="width: 55%; border: 1px solid black; padding: 50px;">

			<c:forEach var='content' items='${content}'>
			<div class="card mx-auto" style="width: 34rem; padding: 10px;">
				<div>
					<img style="width: 50px; height: 50px; border-radius: 50%;"
						src="data:image/jpeg;base64,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"
						alt=""> 
						<span>${content.userName}</span>
                            <img id="edit" data-bs-toggle="dropdown" aria-expanded="false" class="dropdown-toggle" style="cursor:pointer;float:right;width: 30px; height: 30px;" src="https://cdn-icons-png.flaticon.com/128/1827/1827933.png">
                            <ul class="dropdown-menu">
                              <li><a id="update" target="_blank" class="dropdown-item" href="<c:url value='/update32/${content.id}'/>">編輯</a></li>
                              <li style="cursor:pointer" class="dropdown-item" onclick="if(window.confirm('確定要刪除？')) location.href =' <c:url value='/delete32?id=${content.id}'/>'">刪除</li>
                              <li><a class="dropdown-item" href="#">隱藏此用戶貼文</a></li>
                            </ul>
				</div>
				<br>
				<div class="productImg">
					<a href="#"> 
					<img style="width:522px;height:347px" class="card-img-top" src="<c:url value='/getPicture32/${content.id}' />" />
					</a>
				</div>
				<div class="card-body">
					<div>
						<div>
							<a href="#" class="btn"
								style="background-color: rgb(171, 131, 102); color: cornsilk;">${content.tag}</a>
							<span style="position: absolute; left: 140px;"> <img
								style="width: 30px;"
								src="https://cdn-icons-png.flaticon.com/512/1077/1077035.png">
								<label>0</label>
							</span> <span style="position: absolute; left: 220px;"> <img
								style="width: 30px;"
								src="https://cdn-icons-png.flaticon.com/128/739/739286.png">
								<label>0</label>
							</span> <span style="position: absolute; left: 300px;"> <img
								style="width: 30px;"
								src="https://cdn-icons-png.flaticon.com/128/709/709612.png">
								<label>0</label>
							</span>
						</div>
						<br>
						<p class="card-text">${content.content}</p>
					</div>
				</div>
				<span>${content.date}
				<button style="float:right;padding:1px 2px" type="button" class="btn btn-success">引言回覆</button>
				</span>
				<div><textarea rows="3" style="width:100%"></textarea></div>
			</div>
			<br>
			</c:forEach>
			
			
			
			</div>
			</div>
			
			
			<div class="modal fade" id="Modal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<form:form method='POST' modelAttribute="forumBean"
				class='form-horizontal' enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<h3 style="margin-left:auto;" class="modal-title" id="exampleModalLabel">建立貼文</h3>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body contentBody">
						<form:input path="userName" type="text" value="廖總"
							style="display:none" />
						<div class="mb-3">
							<label>分類標籤</label> <select id="select">
								<option>忙裡偷閒聊</option>
								<option>開箱文</option>
								<option>其他</option>
							</select><br>
							<br>
							<form:input type="text" path="date" id="dt" style="display:none" />
							<form:input path="tag" type="text" id="select2"
								style="display:none" />
							<img id=fileshow class="img-thumbnail"
									src=""
									style=" width: 100%; height: 200px;"><br><br>
							<div class="mb-3">
<!-- 								<img id=fileshow class="img-thumbnail" -->
<!-- 									src="https://cdn-icons-png.flaticon.com/128/568/568717.png" -->
<!-- 									style="position: absolute; right: 20px; top: 10px; width: 300px; height: 230px;"> -->
								<form:input class="form-control" path="image" id="filebtn" type="file"/>
							</div>
							<form:textarea path="content" class="form-control" placeholder="在想什麼呢？" rows="7" id="recipient-name" />
						</div>
					</div>
					<div class="modal-footer">
						<button id="submit" type="submit" class="btn btn-primary">送出</button>
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">取消</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>


<!-- 		<div class="modal fade" id="UpdateModal" tabindex="-1" -->
<!-- 		aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
<!-- 		<div class="modal-dialog"> -->
<%--  			<form:form method='POST' modelAttribute="updateForumBean" class='form-horizontal' enctype="multipart/form-data">  --%>
<!-- 				<div class="modal-content"> -->
<!-- 					<div class="modal-header"> -->
<!-- 						<h3 style="margin-left:auto;" class="modal-title" id="exampleModalLabel">編輯貼文</h3> -->
<!-- 						<button type="button" class="btn-close" data-bs-dismiss="modal" -->
<!-- 							aria-label="Close"></button> -->
<!-- 					</div> -->
<!-- 					<div class="modal-body contentBody"> -->
<%-- 						<form:input path="userName" type="text" value="asd123" style="display:none" /> --%>
<!-- 						<div class="mb-3"> -->
<!-- 							<label>分類標籤</label> <select id="select"> -->
<!-- 								<option>忙裡偷閒聊</option> -->
<!-- 								<option>開箱文</option> -->
<!-- 								<option>其他</option> -->
<!-- 							</select><br> -->
<!-- 							<br> -->
<%-- 							<form:input type="text" path="date" id="dt" style="display:none" /> --%>
<%-- 							<form:input path="tag" type="text" id="select2" style="display:none" /> --%>
<!-- 							<img id=fileshow class="img-thumbnail" src="" style=" width: 100%; height: 200px;"><br><br> -->
<!-- 							<div class="mb-3"> -->
<%-- 								<form:input class="form-control" path="image" id="filebtn" type="file"/> --%>
<!-- 							</div> -->
<%-- 							<form:textarea path="content" class="form-control" placeholder="在想什麼呢？" rows="7" id="recipient-name" /> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="modal-footer"> -->
<!-- 						<button id="submit" type="submit" class="btn btn-primary">送出</button> -->
<!-- 						<button type="button" class="btn btn-secondary" -->
<!-- 							data-bs-dismiss="modal">取消</button> -->
<!-- 					</div> -->
<!-- 				</div> -->
<%-- 			</form:form> --%>
<!-- 		</div> -->
<!-- 	</div> -->


	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"> </script>
	<script>
		$(function() {
			$("#filebtn").change(function() {
				var readFile = new FileReader();
				var mfile = $("#filebtn")[0].files[0];  //注意這裡必須時$("#myfile")[0]，document.getElementById('file')等價與$("#myfile")[0]
				readFile.readAsDataURL(mfile);
				readFile.onload = function() {
					var img = $("#fileshow");
					img.attr("src", this.result);
				}
			})
// 		    $('#summernote').summernote({
// 		          tabsize: 2,
// 		          height: 200,
// 		          width:766,
// 		          toolbar: [
// 		            ['style', ['style']],
// 		            ['font', ['bold', 'underline', 'clear']],
// 		            ['color', ['color']],
// 		            ['view', ['codeview']]
// 		          ]
// 		     });
		     $('.contentBody').on('mouseover',function(){
		        $('#select2').val($('#select option:selected').text())
		     })
			 })
			 var date = new Date();
		     const formatDate = (date)=>{
		     let formatted_date = date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate() + " " + date.getHours()+":"+date.getMinutes()
		     return formatted_date;
		     }
		     $('#dt').val(formatDate(date))
		     
    </script>
</body>
</html>