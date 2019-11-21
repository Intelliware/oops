package com.intelliware.oops.server.adapter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@FeignClient(name = "current", url = "http://localhost:8081")
public interface CurrentClient {
    @RequestMapping("/current/{accountId}/balance")
    BigDecimal getBalance(@PathVariable("accountId") String accountId);
}
