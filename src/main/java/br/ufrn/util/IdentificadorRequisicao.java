package br.ufrn.util;

import br.com.caelum.vraptor.http.MutableRequest;

public final class IdentificadorRequisicao {

    private IdentificadorRequisicao() {}

    public static boolean isRequisicaoJson(MutableRequest request) {
        String accept = request.getHeader("accept");
        return accept != null && accept.contains("application/json");
    }
}
