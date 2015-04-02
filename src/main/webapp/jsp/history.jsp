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
