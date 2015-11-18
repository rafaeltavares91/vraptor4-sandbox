<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tags" uri="http://www.ufrn.br/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<tags:layout>
	<jsp:body>
		<ul id="tabs" class="nav nav-tabs" >
			<li class="active"><a href="#">Pesquisa</a></li>
			<li><a href="${linkTo[ProdutoController].form}">Cadastro</a></li>
		</ul>

		<br />

		<a href="${linkTo[ProdutoController].form}" class="btn btn-primary">
			<span class="glyphicon glyphicon-plus"></span>Novo Produto
		</a>
		
		<div class="adv-table">
			<table id="dataTable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Categoria</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${produtoList}" var="produto">
						<tr>
							<td>${produto.nome}</td>
							<td>${produto.categoria.nome}</td>
							<td>
								<a href="${linkTo[ProdutoController].editar}?id=${produto.id}"> <span class="glyphicon glyphicon-edit"></span> Editar </a>  
								<a href="${linkTo[ProdutoController].deletar}?id=${produto.id}"> <span class="glyphicon glyphicon-trash"></span> Deletar </a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</jsp:body>
</tags:layout>