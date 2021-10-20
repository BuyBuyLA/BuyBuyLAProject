<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>會員系統</title>
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<style>
	  body {
      font-family: "微軟正黑體";
      background-color: rgb(203, 218, 218);
      align-items: center;
      justify-content: center;
      position: relative;
    }
	 h1 {
      background-color: #f7f7f7;
      /* 告訴電腦背景顏色 */
      padding: 18px 0 16px 22px;
      /* 告訴電腦內距要多大 */
      border-left: 8px solid #33779e;
      /* 告訴電腦左邊框要多寬、跟顏色 */
      color: #333 !important;
      /* 告訴電腦文字顏色 */
      width: 300px;
    }
     form {
      background-color: rgb(255, 255, 255, 0.8);
      margin: 20px auto;
      max-width: 600px;
      padding: 80px;
      /* border-radius: 20px; */
      box-shadow: 0 10px 10px 0 rgba(177, 175, 175, 0.2);
    }
      table {
      border: 1px solid rgba(147, 156, 165, 0.2);
      border-radius: 20px;
      border-collapse: collapse;
      margin: auto;
      width: 600px;
      height: 400px;
      text-align: center;
    }
       input,
    textarea,
    select {
      border: 1px solid rgb(155, 153, 153, 0.4);
      background-color: rgb(203, 218, 218, 0.2);
      font-size: 21px;
    }
    .leftSide{
      float: left;
    }


</style>
</head>
<body>
  
<!-- 
<div style="background-color: rgb(114, 13, 69);">
  <img src="/project2/image/trademark.png" style="width: 170px; padding-bottom: 0px; margin-bottom: -55px;" alt="tradeMaark">
  <center>
    <Input type="text" style="margin-top: -10px; background-color: white; font-size: 33px; width: 780px;"> <input type="submit" style="font-size: 28px;" value="搜尋"></Input> 
  </center>
  
  <hr>
</div> -->


 <div class="leftSide">
 <h1 class="p">我的帳戶</h1>
 <a style="color: red; font-size: 21px;"  href="<c:url value='/try/delete' />">刪除會員</a><BR>
  <a style="color: red; font-size: 21px;" href="./user.jsp">購買紀錄管理</a>
 
</div>






 <div>
    
    <form:form method='POST' modelAttribute="memberUiDefault"
    class='form-horizontal' enctype="multipart/form-data">
    <!-- 檔案上傳的標籤一定要有enctype="multipart/form-data -->

<table>
 <h2 style="text-align: center;">個人資料</h1><br>
 <span > - 您可以在這邊做新增、修改、刪除</span><br><br><br>
 <tr>
 	<td>帳號</td>
 	<td> 
    <!--放從DB取出的資料-->         
    Hi!!! &nbsp;&nbsp;  ${memberUiDefault.userEmail} 
   <br> pwd----> ${memberUiDefault.userPwd} 
   

	</td> 
 </tr>
 
 
 <tr>
 <td>頭像</td>
 <td>
 						<!-- 上傳圖片 -->
			
						更換${memberUiDefault.id}頭像<form:input id="productImage" path="productImage" type='file'  cssClass="size:20%;"  />
							&nbsp;&nbsp;
				<!-- 讀取圖片 -->
			<img width='150'
				src="<c:url value='/getPicturefromMember/${memberUiDefault.id}'/>" />

 </td>
 </tr>
 
 
 
 
 
  <tr>
 	<td>姓名</td>
 	<td> 
 	<label for="proName"></label>
   <!--放從DB取出的資料-->         
  	 ${memberUiDefault.userName} 
   &nbsp;&nbsp;/&nbsp;&nbsp;
   <form:input id="userName" path="userName" type='text'  style="width: 250px; height: 30px;" />
   
 	</td> 
 </tr>
   
   
   <tr>
   <td>手機號碼</td>
   <td>
    <!--放從DB取出的資料-->         
     ${memberUiDefault.userPhone} 
    &nbsp;&nbsp;/&nbsp;&nbsp;  
    <form:input id="userPhone" path="userPhone" type='text'  style="width: 250px; height: 30px;" />
    
   </td>
   </tr>

   <tr>
    <td>性別</td>
     <td>
       <!--放從DB取出的資料-->
        ${memberUiDefault.userGender} 
            &nbsp;&nbsp;/&nbsp;&nbsp; 
       <label>  <form:radiobutton path="userGender" value="男性" label="男性" /> 
       	</label> 
    <label>     <form:radiobutton path="userGender" value="女性" label="女性" /> 
    	</label>  
     </td>
     </tr>
     
     
     
     <tr>
 	<td>地址</td>
 	<td> 
 	<label for="address"></label>
   <!--放從DB取出的資料-->         
  	 ${memberUiDefault.address} 
   &nbsp;&nbsp;/&nbsp;&nbsp;
   <form:input id="address" path="address" type='text'  style="width: 250px; height: 30px;" />
   
 	</td> 
 </tr>
   
   
 </table>
 
 <p>&nbsp;</p>
 <a href="<c:url value='/try/index' />?userEmail= ${memberUiDefault.userEmail} ">
 <input type="submit" id="submitRewrite" class="submitBtn" name="submitRewrite" style="text-align: center; font-size: 18x;"  value="儲存修改"/>
  </a>



</form:form>

  </div>
  

 </body>
 </html>
