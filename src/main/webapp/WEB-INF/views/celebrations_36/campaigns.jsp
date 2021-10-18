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
<title>Campaigns</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <style>
        .wrap{
            width: 500px;
            height: 400px;
            background-color: black;
            margin:0 auto;
            position: relative;
            overflow: hidden;
        }
        .slide-img{
            margin: 0;
            padding: 0;
            list-style: none;
            position: absolute;
            width: 4000px;
            /* border: olive 2px solid; */
            display: flex;
            left: 0;
            transition: 0.6s;
        }
        .slide-img li{
            width: 500px;
            height: 400px;
            /* 伸展比例 壓縮比例 額外剩餘比例 */
            /* flex:1 0 0; */
        }
        .slide-img li img{
            height: 100%;
            width: 100%;
            /* 元素內容調整大小比例 */
            object-fit: cover;
        }
        .pages{
            list-style: none;
            position: absolute;
            margin:0;
            padding: 0;
            bottom:10px;
            display: flex;
            left:0;
            width: 100%;
            justify-content: center;
        }
        .pages li{
            border:1px solid #fff;
            margin: 0 5px;
            width: 20px;
            height:20px;
            border-radius: 50%;
        }
        .slide-arrow{
            position: absolute;
            /* background-color: red; */
            width: 40px;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            z-index:1;
            font-size: 36px;
            cursor: pointer;
            color: white;
            opacity: .6;
        }
        .slide-arrow:hover{
            opacity: 1;
        }
        .slide-arrow.right{
            right:0;
        }
    </style>
</head> 
<body>
    <section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>活動清單</h1>
            </div>
        </div>
        
    </section>
	<div align='center'>
        <a href="<c:url value='/' />">回首頁</a>&nbsp;&nbsp;
        
    </div> 
    <hr style="height:1px;border:none;color:#333;background-color:#333;">
<!--     <section class="container"> -->
<!--         <div class="row"> -->
<%--         	<c:forEach items='${campaigns}' var='campaign'> --%>
        	
       <div class="container">
        <div class="wrap">
            <a class="slide-arrow" id="slidePrev"><i class="fas fa-arrow-left"></i></a>
            <a class="slide-arrow right" id="slideNext"><i class="fas fa-arrow-right"></i></a>
            <ul class="slide-img" id="slide-img">
                <c:forEach items='${campaigns}' var='campaign'>
                <li>
                <a href="<c:url value='${campaign.url}'  /> " target="_blank">
                <img src="<c:url value='/getCampaignPicture/${campaign.id}' />" alt="">
                </a>
                </li>
          </c:forEach>
            </ul>
            <ul class="pages" id="pages">
                <c:forEach var="i" begin="0" end="${campaignsize-1}">
                <li></li>
                </c:forEach>
            </ul>
        </div>
    </div>	
        	
        	
          
<!--             <div class="col-sm-6 col-md-3" style="width: 360px; height: 360px"> -->
<!--                 <div class="thumbnail" style="width: 320px; height: 340px"> -->
<%--                 	  <a href="<c:url value='${campaign.url}' />"> --%>
<!--                 	<img style="margin-left:30px;padding:10px;margin-bottom:20px" width='250' height='200'  -->
<%--                 		src="<c:url value='/getCampaignPicture/${campaign.id}' />" /> --%>
<!--                 		</a> -->
<!--                     <div class="caption"> -->
<!--                         <p style='margin-bottom:30px;margin-left:10px'> -->
<%--                            <b style='font-size: 20px;'>${campaign.name}</b> --%>
<!--                         </p> -->
<!--                         <p style='margin-left:10px'> -->
<%--                            <b style='font-size: 16px;color:grey;margin-right:28px'>有效期限至${campaign.date1}</b> --%>
<%--                        	<a href="<spring:url value='/campaign?id=${campaign.id}' />" --%>
<!--    							 class="btn btn-primary"> -->
<!--     						<span class="glyphicon-info-sigh glyphicon"style=''></span>詳細資料 -->
<!-- 						</a> -->
                       
<!--                         </p> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<%--           </c:forEach> --%>
<!--         </div> -->
<!--     </section> -->
     <div align='center'>
        <a href="<c:url value='/' />">回首頁</a>
    </div> 
    
     <script>
        $(function(){
            let index=0;
            let slideMove=0;
            $('#pages li').eq(0).css('background-color','white')
            $('#pages li').on('mouseenter',function(){
                // console.log('123')
                //移動第一張圖
                // $('#slide-img').css('left','-800px')
                //移動n張圖 index() 讀取索引值
                // let index=$(this).index()
                //區域變數變全域變數
                index=$(this).index()
                console.log(index)
                slideMove=-500*index;
                $('#slide-img').css('left',slideMove)
                $(this).css('background-color','white')
                .siblings().css('background-color','transparent')
            })
            let slideCount=$('#slide-img li').length
            console.log('123')
            $('#slideNext').on('click',function(){
                index++;
                if(index>=slideCount){
                    index=0;
                }
                // slideMove=-800*index;
                // $('#slide-img').css('left',slideMove)
                // $('#pages li').eq(index).css('background-color','white')
                // .siblings().css('background-color','transparent')
                moveImg()
            })
            $('#slidePrev').on('click',function(){
                index--;
                if(index<0){
                    index=slideCount-1;
                }
                // slideMove=-800*index;
                // $('#slide-img').css('left',slideMove)
                // $('#pages li').eq(index).css('background-color','white')
                // .siblings().css('background-color','transparent')
                moveImg()
            })
            function moveImg(){
                slideMove=-500*index;
                $('#slide-img').css('left',slideMove)
                $('#pages li').eq(index).css('background-color','white')
                .siblings().css('background-color','transparent')
            }
            setInterval(autoImg,2000)
            function autoImg(){
                index++;
                if(index>=slideCount){
                    index=0;
                }
                moveImg()
            }
        })
    </script>
</body>
</html>
    