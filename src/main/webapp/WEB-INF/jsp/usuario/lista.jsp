<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tags" uri="http://www.ufrn.br/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<tags:layout>
	<jsp:body>
		<ul id="tabs" class="nav nav-tabs">
			<li class="active"><a href="#">Pesquisa</a></li>
			<li><a href="${linkTo[UsuarioController].form}">Cadastro</a></li>
		</ul>
		
		<br />

		<tags:btNovoCadastro link="${linkTo[UsuarioController].form}" />

		<tags:tabelaDinamica id="tabela" cabecalho="Nome, Login">
			<c:forEach items="${usuarioList}" var="usuario">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.login}</td>
					<td>
						<a href="${linkTo[UsuarioController].editar}?id=${usuario.id}"> <span class="glyphicon glyphicon-edit"></span> Editar </a>
						<a href="${linkTo[UsuarioController].deletar}?id=${usuario.id}"> <span class="glyphicon glyphicon-trash"></span> Deletar </a>
					</td>
				</tr>
			</c:forEach>
		</tags:tabelaDinamica>
	</jsp:body>
</tags:layout>