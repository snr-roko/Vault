package com.rokoinc.Vault.exchange;

public record ExchangeConversion(
        Double originalAmount,
        String fromCurrency,
        String fromCurrencyName,
        String toCurrency,
        String toCurrencyName,
        Double convertedAmount,
        Double exchangeRate,
        String lastUpdated
) {
}
