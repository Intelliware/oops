package com.intelliware.oops.core.overnightService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class OvernightController {
    @RequestMapping("/overnight/{accountId}/balance")
    public BigDecimal getOvernightBalance(@PathVariable String accountId) {
        return new BigDecimal("2400.00");
    }
}
