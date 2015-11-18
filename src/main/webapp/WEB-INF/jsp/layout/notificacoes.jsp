<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${not empty errors}">
    <div class="alert alert-block alert-danger fade in">
        <button data-dismiss="alert" class="close close-sm" type="button">
            <i class="fa fa-times"></i>
        </button>
        <h4>
            <i class="icon-ok-sign"></i>
            <strong><fmt:message key="mensagem.erro.titulo"/></strong>
        </h4>
        <c:forEach items="${errors}" var="error">
            <p><c:out value="${error.message}"></c:out></p>
        </c:forEach>
    </div>
</c:if>

<div id="notificacaoErro" <c:out value="${empty mensagemErro ? 'class=invisivel' : '' }"></c:out>>
    <div class="alert alert-block alert-danger fade in">
        <button data-dismiss="alert" class="close close-sm" type="button">
            <i class="fa fa-times"></i>
        </button>
        <h4>
            <i class="icon-ok-sign"></i>
            <strong><fmt:message key="mensagem.erro.titulo"/></strong>
        </h4>
        <div class="notificacoes">
            <c:forEach items="${mensagemErro.notificacoes}" var="notificacao">
                <p>${notificacao}</p>
            </c:forEach>
        </div>
    </div>
</div>


<div id="notificacaoSucesso" <c:out value="${empty mensagemSucesso ? 'class=invisivel' : '' }"></c:out>>
    <div class="alert alert-block alert-success fade in">
        <button data-dismiss="alert" class="close close-sm" type="button">
            <i class="fa fa-times"></i>
        </button>
        <h4>
            <i class="icon-ok-sign"></i>
            <strong><fmt:message key="mensagem.sucesso.titulo"/></strong>
        </h4>

        <div class="notificacoes">
            <c:forEach items="${mensagemSucesso.notificacoes}" var="notificacao">
                <p>${notificacao}</p>
            </c:forEach>
        </div>
    </div>
</div>

<div id="notificacaoAtencao" <c:out value="${empty mensagemAtencao ? 'class=invisivel' : '' }"></c:out>>
    <div class="alert alert-block alert-warning fade in">
        <button data-dismiss="alert" class="close close-sm" type="button">
            <i class="fa fa-times"></i>
        </button>
        <h4>
            <i class="icon-ok-sign"></i>
            <strong><fmt:message key="mensagem.atencao.titulo"/></strong>
        </h4>
        <div class="notificacoes">
            <c:forEach items="${mensagemAtencao.notificacoes}" var="notificacao">
                <p>${notificacao}</p>
            </c:forEach>
        </div>
    </div>
</div>

<div id="notificacaoInformacao" <c:out value="${empty mensagemInformacao ? 'class=invisivel' : '' }"></c:out>>
    <div class="alert alert-block alert-info fade in">
        <button data-dismiss="alert" class="close close-sm" type="button">
            <i class="fa fa-times"></i>
        </button>
        <h4>
            <i class="icon-ok-sign"></i>
            <strong><fmt:message key="mensagem.informacao.titulo"/></strong>
        </h4>
        <div class="notificacoes">
            <c:forEach items="${mensagemInformacao.notificacoes}" var="notificacao">
                <p>${notificacao}</p>
            </c:forEach>
        </div>
    </div>
</div>