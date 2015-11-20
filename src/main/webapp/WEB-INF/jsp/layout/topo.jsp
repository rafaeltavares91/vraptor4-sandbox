<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="http://www.ufrn.br">
                <img src="${ctx}/resources/imagens/logo.png" alt="UFRN"/>
            </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${linkTo[InicioController].index}">Inicio</a></li>
                <li><a href="${linkTo[ProdutoController].lista}">Produto</a></li>
                <li><a href="${linkTo[CategoriaController].lista}">Categoria</a></li>
                <li><a href="${linkTo[UsuarioController].lista}">Usuário</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="fa fa-user"><c:out value=""/></span> ${usuarioLogado.nome} </a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="fa fa-cog"><c:out value=""/></span>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Profile</a></li>
                        <li><a href="#">Akun</a></li>
                        <li><a href="#">About</a></li>
                        <li class="divider"></li>
                        <li><a href="${linkTo[LoginController].logout}">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<br/><br/><br/><br/>