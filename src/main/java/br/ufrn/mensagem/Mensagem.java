package br.ufrn.mensagem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public abstract  class Mensagem implements Serializable {

    protected String chave;
    protected List<String> notificacoes;
    private Object objeto;

    public Mensagem() {
        notificacoes = new ArrayList<>();
        setChave();
    }

    protected abstract void setChave();

    public String getChave() {
        return chave;
    }

    public static String i18n(String chaveMensagem) {
        return ResourceBundle.getBundle("messages").getString(chaveMensagem);
    }

    public void addNotificacao(String chaveMensagem) {
        notificacoes.add(i18n(chaveMensagem));
    }

    public void addNotificacoes(List<String> chavesMensagens) {
        for (String chave : chavesMensagens) {
            addNotificacao(chave);
        }
    }

    public List<String> getNotificacoes() {
        return notificacoes;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public Object getObjeto() {
        return objeto;
    }
}
