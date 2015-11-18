package br.edu.unirn.mensagem;

public class MensagemSucesso extends Mensagem{

    public MensagemSucesso() {
        super();
    }

    public MensagemSucesso(String chaveMensagem) {
        super();
        addNotificacao(chaveMensagem);
    }

    @Override
    public void setChave() {
        this.chave = ChaveMensagem.SUCESSO.getChave();
    }
}
