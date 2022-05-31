<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>식몰</title>
		<style>
			#top {
				background:#4c9900;
			}
			#logo {
				display: table;
				margin-left:auto;
				margin-right:auto;
				list-style:none;
				background:#4c9900;			
			}
			#logo a{
				text-decoration:none;
				color:white;
			}
			
			#info {
				display:inline-block;
				float: right;
			}
			#info a {
				padding: 5px 10px;
				text-decoration:none;
				color:white;
			}
			#nav {
				list-style:none;
				height:40px;
				padding:5px 1px;
				margin:0;
				background:#4c9900;
				display: table;
				margin-left:auto;
				margin-right:auto;
			}
			
			#nav li{
				float:left;
				position:relative;
				margin:5px 30px;
				padding:0;
				color:white;
				font-weight:bold;
			}
			
			#nav li a{
				display:block;
				color:white;
				margin:0;
				text-decoration:none;
			}
			
			#nav ul li{
				float:none;
				margin:0;
				padding:0;
			}
			
			#nav ul a{
				font-weight:normal;
				color:white;
			}
			
			#nav ul li:hover a{
				background:#ccff99;
				font-weight:bold;
			}
			
			#nav ul{
				list-style:none;
				margin:0;
				padding:0;
				position:absolute;
				left:0;
				top:40px;
				width:105px;
				background:#66cc00;
				text-align:center;
				opacity:0;
			}
			
			#nav li:hover ul{
				opacity:1;
			}
			
			#nav li:hover ul li{
				height:35px;
				overflow:visible;
				padding:0;
			}
		</style>
	</head>
	<body>
	<div id="top">
		<ul>
			<li id="logo"><a href="<c:url value="/plantmall/index.do"/>"><img src="logoTemp.svg">식몰</a></li>
			<li id="info"><a href="<c:url value="/plantmall/login.do"/>">로그인</a></li>
			<li id="info"><a href="<c:url value="/plantmall/signUP.do"/>">회원가입</a></li>
		</ul>
		<ul id="nav">
			<li><a href="best.jsp">BEST</a>
			<li>CATEGORY
				<ul>
					<li><a href="productList.jsp">전체</a></li>
					<li><a href="#">꽃</a></li>
					<li><a href="#">야생화</a></li>
					<li><a href="#">허브</a></li>
					<li><a href="#">다육</a></li>
					<li><a href="#">나무</a></li>
					<li><a href="#">해조</a></li>
				</ul>
			</li>
			<li><a href="Cart.jsp">CART</a></li>
			<li><a href="OrderList.jsp">ORDER</a></li>
			<li><a href="funding.jsp">FUNDING</a></li>
			<li><a href="search.jsp">SEARCH</a></li>
		</ul>	
	</div>