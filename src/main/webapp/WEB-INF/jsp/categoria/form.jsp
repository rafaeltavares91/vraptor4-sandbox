<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tags" uri="http://www.ufrn.br/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<tags:layout>
	<jsp:body>
		<ul class="nav nav-tabs">
			<li><a href="${linkTo[CategoriaController].lista}">Pesquisa</a></li>
			<li class="active"><a href="#">Cadastro</a></li>
		</ul>

		<br />

		<form role="form" action="${linkTo[CategoriaController].salvar}" method="post">
			<fieldset>
				<legend>Cadastrar Categoria</legend>
				<input type="hidden" name="categoria.id" value="${categoria.id}" />

				<div class="form-group">
					<label> Nome: </label> <input type="text" name="categoria.nome"
						class="form-control" value="${categoria.nome}" />
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-primary"> <i class="fa fa-check"> </i> <span>Salvar</span> </button>
					<a href="${linkTo[CategoriaController].lista}" class="btn btn-default" role="button"> <i class="fa fa-reply"> </i> <span>Voltar</span> </a>
				</div>
			</fieldset>
		</form>
	</jsp:body>
</tags:layout>