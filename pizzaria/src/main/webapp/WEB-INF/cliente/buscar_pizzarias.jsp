<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
		<c:set var="path" value="${pageContext.request.contextPath}" scope="request"></c:set>
		
		
		<style type="text/css">
			@import url("${path}/static/bootstrap/css/bootstrap.min.css");
			@import url("${path}/static/bootstrap/css/bootstrap-theme.min.css");
		</style>
		
		<script type="text/javascript" src="${path}/static/js/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${path}/static/js/pizzas.js"></script>
	</head>
	<body>
		<div class="container">
			<jsp:include page="../menu-cliente.jsp"></jsp:include>
		
		<section>
			<div id="consulta-pizzarias" class="well">
				<label for="pizza_pesquisa">Que pizza você quer comer hoje?</label>
				<select id="pizza-pesquisa" class="form-control">
					<c:forEach items="${nomesPizzas}" var="nomePizza">
						<option value="${nomePizza}">${nomePizza}</option>
					</c:forEach>		
				</select>
			</div>
			
			<div id="secao-pizzarias"></div>
		</section>	
		</div>
	
	</body>
</html>