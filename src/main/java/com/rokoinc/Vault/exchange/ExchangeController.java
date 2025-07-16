package com.rokoinc.Vault.exchange;

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
}
