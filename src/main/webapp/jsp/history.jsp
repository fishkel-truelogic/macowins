<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
<style type="text/css">
span {
	margin: 10px;
	background-color: red;
	display: block;
	width: 170px;
	float: left;
}

ul {
display: block;
float: left;
}

li {
display: block;
float: left;
}

#calculate {
	display: block;
	width: 66px;
	height: 20px;
	background-color: grey;
	color: black;
	font-size: 15px;
	font: -webkit-small-control;
	border: solid;
}

body {
	background-image: url("http://www.dw.de/image/0,,16990990_303,00.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	color: #1111FF;
}
</style>
</head>
<body>
<ul>
<c:forEach var="bill" items="${bills}" varStatus="loop">
	<li> <span>date: </span><span>${bill.date}</span>
		<c:forEach var="billItem" items="${bill.billItems}" varStatus="loop">
		<p>
			<span>${billItem.item.name}</span>
			<span>${billItem.item.price}</span>
			<span>${billItem.amount}</span>
		</p>	
		</c:forEach>		
	</li>
</c:forEach>
</ul>


</body>
</html>
