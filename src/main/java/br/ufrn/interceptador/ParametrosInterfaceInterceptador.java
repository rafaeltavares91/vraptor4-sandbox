package br.ufrn.interceptador;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.http.MutableRequest;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.ufrn.controlador.LoginController;
import br.ufrn.modelo.dominio.DadosSessao;
import br.ufrn.util.IdentificadorRequisicao;

import javax.inject.Inject;

@Intercepts
public class ParametrosInterfaceInterceptador {

    private final Result result;
    private final MutableRequest request;
    private final DadosSessao dadosSessao;

    /**
     * @deprecated Usado pelo CDI
     */
    @Deprecated
    public ParametrosInterfaceInterceptador() {
        this(null, null, null);
    }

    @Inject
    public ParametrosInterfaceInterceptador(Result result, MutableRequest request, DadosSessao dadosSessao) {
        this.result = result;
        this.request = request;
        this.dadosSessao = dadosSessao;
    }

    @Accepts
    public boolean interceptar (ControllerMethod method) {
        return !IdentificadorRequisicao.isRequisicaoJson(request)
                && !LoginController.class.isAssignableFrom(method.getController().getType());
    }

    @AroundCall
    public void inserirParametros (SimpleInterceptorStack stack) {
        result.include("usuarioLogado", dadosSessao.getUsuarioLogado());
        stack.next();
    }
}
