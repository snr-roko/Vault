package com.rokoinc.Vault.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("{fromCurrency}/{toCurrency}")
    public ExchangeRate exchangeRate (@PathVariable Currency fromCurrency, @PathVariable Currency toCurrency) {
        return exchangeService.retrieveExchangeRate(fromCurrency, toCurrency);
    }

    @GetMapping("{fromCurrency}/{toCurrency}/{amount}")
    public ExchangeConversion convertAmount (
            @PathVariable Currency fromCurrency,
            @PathVariable Currency toCurrency,
            @Valid @Positive @PathVariable Double amount
    ) {
        return exchangeService.convertAmount(fromCurrency, toCurrency, amount);
    }
}
