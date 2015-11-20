package br.ufrn.interceptador;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.ufrn.controlador.LoginController;
import br.ufrn.mensagem.Mensagem;
import br.ufrn.mensagem.MensagemAtencao;
import br.ufrn.mensagem.MensagemErro;
import br.ufrn.modelo.dominio.DadosSessao;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Intercepts(after = ParametrosInterfaceInterceptador.class)
public class AutenticacaoInterceptador {

    private final Result result;
    private final DadosSessao dadosSessao;
    private final HttpServletRequest httpServletRequest;

    /**
     * @deprecated Usado pelo CDI
     */
    @Deprecated
    public AutenticacaoInterceptador() {
        this(null, null, null);
    }

    @Inject
    public AutenticacaoInterceptador(Result result, DadosSessao dadosSessao, HttpServletRequest httpServletRequest) {
        this.result = result;
        this.dadosSessao = dadosSessao;
        this.httpServletRequest = httpServletRequest;
    }

    @Accepts
    public boolean interceptar (ControllerMethod method) {
        return !LoginController.class.isAssignableFrom(method.getController().getType());
    }

    @AroundCall
    public void checarAutenticacao(SimpleInterceptorStack stack) {
        if (dadosSessao.isLogado()) {
            stack.next();
        } else {
            if (isSessaoExpirada(httpServletRequest)) {
                Mensagem mensagem = new MensagemAtencao("mensagem.timeout");
                result.include(mensagem);
            } else {
                Mensagem mensagem = new MensagemErro("mensagem.usuarioNaoLogado");
                result.include(mensagem);
            }
            result.redirectTo(LoginController.class).login();
        }
    }

    private boolean isSessaoExpirada(HttpServletRequest httpServletRequest) {
        boolean sessaoExpirou = true;
        if (httpServletRequest.getRequestedSessionId() == null || httpServletRequest.isRequestedSessionIdValid()) {
            sessaoExpirou = false;
        }
        return sessaoExpirou;
    }

}
