<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tags" uri="http://www.ufrn.br/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<tags:layout>
	<jsp:body>
		<tags:tabs link="${linkTo[ProdutoController].lista}" isForm="${true}" />
		<tags:formulario id="form" action="${linkTo[ProdutoController].salvar}" titulo="Cadastrar Produto">
			<input type="hidden" name="produto.id" value="${produto.id}" />

			<div class="form-group">
				<label> Nome: </label> <input type="text" class="form-control"
					placeholder="Nome" name="produto.nome" value="${produto.nome}" />
			</div>

			<div class="form-group">
				<label> Categoria: </label> <select id="select1" class="form-control" name="produto.categoria.id">
					<c:forEach items="${categoriaList}" var="categoria">
						<option value="${categoria.id}">${categoria.nome}</option>
					</c:forEach>
				</select>
			</div>
		</tags:formulario>
	</jsp:body>
</tags:layout>