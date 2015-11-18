package br.ufrn.mensagem;

public enum ChaveMensagem {

    SUCESSO("sucesso"), ERRO("erro"), ATENCAO("atencao"), INFORMACAO("informacao");

    private String chave;

    private ChaveMensagem(String chave) {
        this.chave = chave;
    }

    protected String getChave() {
        return chave;
    }
}