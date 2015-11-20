<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tags" uri="http://www.ufrn.br/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<tags:layout>
	<jsp:body>
		<tags:tabs link="${linkTo[UsuarioController].lista}" isForm="${true}" />
		<tags:formulario id="form" action="${linkTo[UsuarioController].salvar}" titulo="Cadastrar Usuário">
			<input type="hidden" name="usuario.id" value="${usuario.id}" />

			<div class="form-group">
				<label> Nome: </label> <input type="text" name="usuario.nome"
					class="form-control" value="${usuario.nome}" />
			</div>

			<div class="form-group">
				<label> Login: </label> <input type="text" name="usuario.login"
					class="form-control" value="${usuario.login}" />
			</div>

			<div class="form-group">
				<label> Senha: </label> <input type="text" name="usuario.senha"
					class="form-control" value="${usuario.senha}" />
			</div>
		</tags:formulario>
	</jsp:body>
</tags:layout>