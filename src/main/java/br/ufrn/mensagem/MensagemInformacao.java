package br.ufrn.mensagem;

public class MensagemInformacao extends Mensagem {

    public MensagemInformacao() {
        super();
    }

    public MensagemInformacao(String chaveMensagem) {
        super();
        addNotificacao(chaveMensagem);
    }

    @Override
    public void setChave() {
        this.chave = ChaveMensagem.INFORMACAO.getChave();
    }
}
