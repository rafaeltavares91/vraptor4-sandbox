<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tags" uri="http://www.ufrn.br/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<tags:layout>
	<jsp:body>
		<tags:tabs link="${linkTo[CategoriaController].lista}" isForm="${true}" />
		<tags:formulario id="form" action="${linkTo[CategoriaController].salvar}" titulo="Cadastrar Categoria">
			<input type="hidden" name="categoria.id" value="${categoria.id}" />

			<div class="form-group">
				<label> Nome: </label> <input type="text" name="categoria.nome"
					class="form-control" value="${categoria.nome}" />
			</div>
		</tags:formulario>
	</jsp:body>
</tags:layout>