package com.rokoinc.Vault.exchange;

public record ExchangeConversion(
        Double originalAmount,
        Currency fromCurrency,
        String fromCurrencyName,
        Currency toCurrency,
        String toCurrencyName,
        Double convertedAmount,
        Double exchangeRate,
        String lastUpdated
) {
}
