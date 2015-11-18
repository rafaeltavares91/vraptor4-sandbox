package br.ufrn.mensagem;

public class MensagemAtencao extends Mensagem {

    public MensagemAtencao() {
        super();
    }

    public MensagemAtencao(String chaveMensagem) {
        super();
        addNotificacao(chaveMensagem);
    }

    @Override
    public void setChave() {
        this.chave = ChaveMensagem.ATENCAO.getChave();
    }

}
