package com.rokoinc.Vault.exchange;

public record ExchangeRate(
        Currency fromCurrency,
        String fromCurrencyName,
        Currency toCurrency,
        String toCurrencyName,
        Double rate,
        String lastUpdated
) {
}
