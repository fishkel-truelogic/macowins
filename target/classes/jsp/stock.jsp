<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<c:forEach var="item" items="${items}">
		<img style="float:left;" alt="${item.name}" src="/images/${item.image}"><p style="float:left;width: 550px;">${item.name} ${item.price}</p>
	</c:forEach>
</body>
</html>
