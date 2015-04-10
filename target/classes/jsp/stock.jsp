<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#calculate").bind('click', function() {
			var total = 0;
			$('.amount').each(function(i, obj) {
				var json = $(this).attr('title');
				console.log(json);
				var obj = jQuery.parseJSON(json);
				var price = (obj.price + 30) * (obj.imported ? 1.3 : 1);
				console.log(price);
				total = total + price * $(this).val();
				console.log(total);
			});
			$("#totalhtml").html(total);
			$("#totalbill").val(total);
		});
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
	<form method="POST" action="/macowins/stock/purcharse">
		<ul>
			<c:forEach var="item" items="${items}" varStatus="loop">
				<input type="hidden" name="billItems[${loop.index}].item.id"
					value="${item.id}" />
				<input type="hidden" name="billItems[${loop.index}].item.name"
					value="${item.name}" />
				<input type="hidden" name="billItems[${loop.index}].item.price"
					value="${item.price}" />
				<input type="hidden" name="billItems[${loop.index}].item.imported"
					value="${item.imported}" />
				<li><span><input
						title='{"price":${item.price}, "imported":${item.imported}}'
						class="amount" name="billItems[${loop.index}].amount"
						type="number" /></span> <span>${item.name}</span> <span>$
						${item.price}</span> <c:if test="${item.imported}">
						<span>Importado</span>
					</c:if> <c:if test="${!item.imported}">
						<span>No Importado</span>
					</c:if></li>
			</c:forEach>
		</ul>
		<p>
			<span id="calculate">Calcular</span>
		</p>
		<span>Total:</span><span id="totalhtml"></span> <input type="hidden"
			id="totalbill" name="total" value="0" />
		<button style="margin-top: 2em;" onclick="alert('Comprado con exito')">Comprar</button>
	</form>

	<form style="display: block;margin-top: 5em; margin-left: 19em" 
		  method="GET" 
		  action="/macowins/stock/history">
		  
		<input name="date" type="date" />

		<button>Consultar</button>
	</form>

</body>
</html>
