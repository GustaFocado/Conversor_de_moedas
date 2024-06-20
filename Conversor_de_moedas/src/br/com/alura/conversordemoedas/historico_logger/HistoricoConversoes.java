package br.com.alura.conversordemoedas.historico_logger;

import java.util.ArrayList;
import java.util.List;

public class HistoricoConversoes {
        private List<String> historico;

        public HistoricoConversoes() {
            historico = new ArrayList<>();
        }

        public void adicionarConversao(String conversao) {
            historico.add(conversao);
        }

        public List<String> obterHistorico() {
            return historico;
        }
    }


