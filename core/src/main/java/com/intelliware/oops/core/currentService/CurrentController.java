package com.intelliware.oops.core.currentService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrentController {
    @RequestMapping("/current/{accountId}/balance")
    public BigDecimal getCurrentBalance(@PathVariable String accountId) {
        return new BigDecimal("99.00");
    }
}
