<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tags" uri="http://www.ufrn.br/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<tags:layout>
	<jsp:body>
		<tags:tabs link="${linkTo[UsuarioController].form}" isForm="${false}" />

		<tags:btNovoCadastro link="${linkTo[UsuarioController].form}" />

		<tags:tabelaDinamica id="tabela" cabecalho="Nome, Login, Senha">
			<c:forEach items="${usuarioList}" var="usuario">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.login}</td>
					<td>${usuario.senha}</td>
					<td>
						<tags:btMinEditar link="${linkTo[UsuarioController].editar}?id=${usuario.id}" />
						<tags:btMinDeletar link="${linkTo[UsuarioController].deletar}?id=${usuario.id}" />
					</td>
				</tr>
			</c:forEach>
		</tags:tabelaDinamica>
	</jsp:body>
</tags:layout>