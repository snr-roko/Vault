package com.rokoinc.Vault.exchange;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class ExchangeService {

    private final RestClient restClient;

    public ExchangeService() {
        this.restClient = RestClient.create("https://open.er-api.com/v6/latest");
    }

    public ExchangeRate retrieveExchangeRate (Currency fromCurrency, Currency ToCurrency) {
        Map<String, Object> response = restClient.get()
                .uri("/" + fromCurrency.toString())
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {});

        assert response != null;
        @SuppressWarnings("unchecked")
        Map<String, Object> rates = (Map<String, Object>) response.get("rates");

        Double exchangeRate = (Double) rates.get(ToCurrency.toString());

        String lastUpdated = (String) response.get("time_last_update_utc");

        return new ExchangeRate(
                fromCurrency,
                fromCurrency.getDisplayName(),
                ToCurrency,
                ToCurrency.getDisplayName(),
                exchangeRate,
                lastUpdated
        );

    }
}
