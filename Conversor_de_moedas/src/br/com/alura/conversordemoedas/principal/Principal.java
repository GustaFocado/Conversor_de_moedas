package br.com.alura.conversordemoedas.principal;

import br.com.alura.conversordemoedas.configuracoes.Conversor;
import br.com.alura.conversordemoedas.configuracoes.ConversorCalculos;

import java.util.Scanner;
import java.util.Set;

public class Principal {
    public static void main(String[] args) {
        Conversor conversor = new Conversor();
        ConversorCalculos conversorCalculos = new ConversorCalculos(conversor);


        Set<String> currencies = Set.of(
                "BRL",
                "USD",
                "EUR",
                "JPY",
                "GBP",
                "AUD",
                "CAD",
                "CHF",
                "CNY",
                "SEK"
        );

        Scanner leitura = new Scanner(System.in);
        while (true) {
            System.out.println("Menu de Conversão de Moedas:");
            System.out.println("1. Converter moedas");
            System.out.println("2. Sair");
            System.out.print("Selecione uma opção: ");
            int opcao = leitura.nextInt();

            if (opcao == 1) {
                leitura.nextLine(); // Limpar o buffer do scanner
                System.out.print("Digite uma moeda (ex: USD): ");
                String baseCurrency = leitura.nextLine().toUpperCase();

                System.out.print("Digite para qual moeda deseja converter (ex: BRL): ");
                String targetCurrency = leitura.nextLine().toUpperCase();

                System.out.print("Digite o valor a ser convertido: ");
                double amount = leitura.nextDouble();

                try {
                    double convertedAmount = conversorCalculos.converte(baseCurrency, targetCurrency, amount);
                    System.out.printf("Valor convertido: %.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
                } catch (RuntimeException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } else if (opcao == 2) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        leitura.close();
    }
}
