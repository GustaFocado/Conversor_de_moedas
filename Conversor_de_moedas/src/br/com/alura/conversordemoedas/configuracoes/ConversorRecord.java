package br.com.alura.conversordemoedas.configuracoes;


import java.util.Map;

public class ConversorRecord {

    private String base;
    private String date;
    private Map<String, Double> rates;


    @Override
    public String toString() {
        return "br.com.alura.conversordemoedas.configuraçoes.ConversorRecord{" + "base='" + base + '\'' + ", date='" + date + '\'' + ", rates=" + rates + '}';
    }
}
