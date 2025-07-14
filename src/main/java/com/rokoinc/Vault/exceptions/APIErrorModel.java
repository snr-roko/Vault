package com.rokoinc.Vault.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public record APIErrorModel(
        String path,
        String message,
        LocalDateTime timestamp,
        List<String> errors
) {
}
