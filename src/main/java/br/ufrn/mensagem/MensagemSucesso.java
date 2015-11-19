package br.ufrn.mensagem;

public class MensagemSucesso extends Mensagem{

    public MensagemSucesso() {
        super();
    }

    public MensagemSucesso(String notificacao) {
        super();
        addNotificacao(notificacao);
    }

    @Override
    public void setChave() {
        this.chave = ChaveMensagem.SUCESSO.getChave();
    }
}
