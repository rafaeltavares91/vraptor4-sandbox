package br.ufrn.mensagem;

import br.com.caelum.vraptor.validator.Message;
import java.util.List;

public class MensagemErro extends Mensagem {

    public MensagemErro() {
        super();
    }

    public MensagemErro(List<Message> erros) {
        super();

        for (Message mensagem : erros) {
            notificacoes.add(mensagem.getCategory().concat(" - ").concat(mensagem.getMessage()));
        }
    }

    public MensagemErro(String messagei18n) {
        super();
        notificacoes.add(super.i18n(messagei18n));
    }

    @Override
    public void setChave() {
        this.chave = ChaveMensagem.ERRO.getChave();
    }

}
