package br.com.alura.conversordemoedas.configuracoes;

public class ErrosDeConversao extends RuntimeException {
    public ErrosDeConversao(String message) {
        super(message);
    }
}

