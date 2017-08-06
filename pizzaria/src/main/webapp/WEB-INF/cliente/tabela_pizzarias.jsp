<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<table
	class="table table-hover table-condensed table-striped table-border">
	<thead>
		<tr>
			<td style="width: 30%">Nome</td>
			<td style="width: 40%">Endereço</td>
			<td style="width: 20%">Atendendo desde</td>
			<td style="width: 10%">Entre em contato</td>
		</tr>
	</thead>
	<tbody>
		<fmt:setLocale value="pt_BR"/>
		<c:forEach items="${pizzarias}" var="pizzaria">
			<tr data-id="${pizzaria.id}">
				<td>${pizzaria.nome}</td>
				<td>${pizzaria.endereco}</td>
				<td><fmt:formatDate value="${pizzaria.dataCadastro.time}" pattern="dd/MM/yyyy"/></td>
				<td><a href="#">Contatos</a></td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">
				Pizzarias encontradas: <span id="quantidade-pizzas">${pizzarias.size()}</span>
			</td>
		</tr>
	</tfoot>
</table>