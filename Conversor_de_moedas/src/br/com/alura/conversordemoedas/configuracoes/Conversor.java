package br.com.alura.conversordemoedas.configuracoes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Set;

public class Conversor {

    private static final String BASE_API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public String getConversorRecordAsJson(String baseCurrency, Set<String> currencies) {
        try {
            String apiUrl = buildApiUrl(baseCurrency, currencies);
            URI endereco = URI.create(apiUrl);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Falha no codigo HTTP : " + response.statusCode());
            }

            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String buildApiUrl(String baseCurrency, Set<String> currencies) {
        StringBuilder apiUrl = new StringBuilder(BASE_API_URL);
        apiUrl.append(baseCurrency);
        if (currencies != null && !currencies.isEmpty()) {
            apiUrl.append("?symbols=").append(String.join(",", currencies));
        }
        return apiUrl.toString();
    }
}



