package br.ufrn.modelo.dominio;

import javax.servlet.http.HttpSession;
import java.io.Serializable;

public abstract class Sessao implements Serializable {

    protected HttpSession httpSession;

    public Sessao(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public Sessao() {
        this((HttpSession)null);
    }

    public abstract String getIdentificadorUsuario();

    public void destruir() {
        this.httpSession.invalidate();
    }

}
