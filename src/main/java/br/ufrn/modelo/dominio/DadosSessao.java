package br.ufrn.modelo.dominio;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@SessionScoped
public class DadosSessao extends Sessao {

    private Usuario usuario;

    /**
     * @deprecated Usado pelo CDI
     */
    @Deprecated
    public DadosSessao() {
        this(null);
    }

    @Inject
    public DadosSessao(HttpSession httpSession) {
        super(httpSession);
    }

    public Usuario getUsuarioLogado() {
        return usuario;
    }

    public void setUsuarioLogado(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isLogado() {
        boolean isLogado;
        if (getUsuarioLogado() == null) {
            isLogado = false;
        } else {
            isLogado = true;
        }

        return isLogado;
    }

    @Override
    public String getIdentificadorUsuario() {
        String identificador = "";
        if (usuario != null) {
            identificador = usuario.getLogin();
        }

        return identificador;
    }

    public void setTempoSessao(Integer tempoSegundos) {
        httpSession.setMaxInactiveInterval(tempoSegundos);
    }
}
