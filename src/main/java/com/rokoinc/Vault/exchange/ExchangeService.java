package com.rokoinc.Vault.exchange;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
public class ExchangeService {

    private final RestClient restClient;

    public ExchangeService() {
        this.restClient = RestClient.create("https://open.er-api.com/v6/latest");
    }

    public Map<String, Object> callExternalAPI (Currency fromCurrency) {
        return restClient.get()
                .uri("/" + fromCurrency.toString())
                .retrieve()
                .onStatus(HttpStatusCode::isError, ((request, response) -> {
                    throw new ResponseStatusException(response.getStatusCode());
                }))
                .body(new ParameterizedTypeReference<Map<String, Object>>() {});
    }

    public ExchangeRate retrieveExchangeRate (Currency fromCurrency, Currency toCurrency) {
        Map<String, Object> response = callExternalAPI(fromCurrency);

        assert response != null;
        @SuppressWarnings("unchecked")
        Map<String, Object> rates = (Map<String, Object>) response.get("rates");

        Double exchangeRate = (Double) rates.get(toCurrency.toString());

        String lastUpdated = (String) response.get("time_last_update_utc");

        return new ExchangeRate(
                fromCurrency,
                fromCurrency.getDisplayName(),
                toCurrency,
                toCurrency.getDisplayName(),
                exchangeRate,
                lastUpdated
        );

    }

    public ExchangeConversion convertAmount (Currency fromCurrency, Currency toCurrency, Double originalAmount) {
        Map<String, Object> response = callExternalAPI(fromCurrency);

        assert response != null;
        @SuppressWarnings("unchecked")
        Map<String, Object> rates = (Map<String, Object>) response.get("rates");

        Double exchangeRate = (Double) rates.get(toCurrency.toString());
        Double convertedAmount = (Double) (originalAmount * exchangeRate);

        String lastUpdated = (String) response.get("time_last_update_utc");

        return new ExchangeConversion(
                originalAmount,
                fromCurrency,
                fromCurrency.getDisplayName(),
                toCurrency,
                toCurrency.getDisplayName(),
                convertedAmount,
                exchangeRate,
                lastUpdated
        );

    }
}
