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
			<td style="width: 50%">Nome</td>
			<td style="width: 20%">Categoria</td>
			<td style="width: 10%">Deletar</td>
			<td style="width: 10%">Editar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ingredientes}" var="ingrediente">
			<tr data-id="${ingrediente.id}">
				<td>${ingrediente.id}</td>
				<td>${ingrediente.nome}</td>
				<td>${ingrediente.categoria}</td>
				<td><button id="btn-deletar" type="button" class="btn btn-danger btn-deletar" >Deletar</button></td>
				<td><button id="btn-editar" type="button" class="btn btn-warning btn-editar" >Editar</button></td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">Ingredientes cadastrados <span id="quantidade-ingredientes">${ingredientes.size()}</span></td>
		</tr>
		<tr>
			<td colspan="5">
				<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#modal-ingrediente">
					Cadastrar Ingrediente</button>
			</td>
		</tr>
	</tfoot>
</table>