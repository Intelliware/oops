package com.intelliware.oops.server;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;


//@EnableHystrixDashboard
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class ServerApplication {
/*
	@Bean
	@Primary
	@Order(value= Ordered.HIGHEST_PRECEDENCE)
	public HystrixCommandAspect hystrixAspect() {
		return new HystrixCommandAspect();
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
