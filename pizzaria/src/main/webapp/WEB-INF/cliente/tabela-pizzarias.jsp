<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<table
	class="table table-hover table-condensed table-striped table-border">
	<thead>
		<tr>
			<td style="width: 10%">Id</td>
			
		</tr>
	</thead>
	<tbody>
		<fmt:setLocale value="pt_BR"/>
		<c:forEach items="${pizzarias}" var="pizzaria">
			<tr data-id="${pizzaria.id}">
				<td>${pizzaria.id}</td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">
				Pizzarias encontradas: <span id="quantidade-pizzas">${pizzarias.size()}</span>
			</td>
		</tr>
		<tr>
			<td colspan="7">
				<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#modal-pizza">
					<spring:message code="views.table.colunas.cadastrar"/>
				</button>
			</td>
		</tr>
	</tfoot>
</table>