<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    div{
        display: flex;
        width:360px;
        border: lightblue 3px solid;
        margin:0  auto;
    }

</style>
</head>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<body>
    <h1 ALIGN="center">購物記錄管理</h1>
    <div>
     <a href="<c:url value='/select' />">
            <button class='btn btn-default' type='submit' value='submit' style="width:120px;height:50px;font-size:30px;">
                <i class="fas fa-search"></i>查詢
            </button>

    </a> 
 


     <a href="<c:url value='/update' />">

            <button class='btn btn-default' type='submit' value='submit' style="width:120px;height:50px;font-size:30px;">
                <i class="fas fa-pencil-alt"></i>修改
            </button>

    </a>
    <a href="<c:url value='/delete' />">

            <button class='btn btn-default' type='submit' value='submit' style="width:120px;height:50px;font-size:30px;">
                <i class="fas fa-trash-alt"></i>刪除
            </button>

     </a>
    </div>

</body>
</html>