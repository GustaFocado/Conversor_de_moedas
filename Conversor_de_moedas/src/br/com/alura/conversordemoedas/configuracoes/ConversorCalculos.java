package br.com.alura.conversordemoedas.configuracoes;

import com.google.gson.Gson;

import java.util.Map;
import java.util.Set;

public class ConversorCalculos {

        private Conversor conversor;

        public ConversorCalculos(Conversor conversor) {
            this.conversor = conversor;
        }

        public double converte(String baseCurrency, String targetCurrency, double amount) {
            Set<String> currencies = Set.of(targetCurrency);
            String jsonResponse = conversor.getConversorRecordAsJson(baseCurrency, currencies);

            if (jsonResponse != null) {
                Gson gson = new Gson();Map<String, Object> responseMap = gson.fromJson(jsonResponse, Map.class);
                Map<String, Double> rates = (Map<String, Double>) responseMap.get("rates");

                if (rates.containsKey(targetCurrency)) {
                    double rate = rates.get(targetCurrency);
                    return amount * rate;
                } else {
                    throw new RuntimeException("Não encontrei esta taixa de cambio.");
                }
            } else {
                throw new RuntimeException("Falha ao obter os dados de conversão.");
            }
        }
    }


