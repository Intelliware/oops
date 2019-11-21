package com.intelliware.oops.server.adapter;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@FeignClient(name = "overnight", url = "http://localhost:8081")
public interface OvernightClient {
    @RequestMapping("/overnight/{accountId}/balance")
    BigDecimal getBalance(@PathVariable("accountId") String accountId);
}
