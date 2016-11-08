package com.tangyu.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class CommonConfig {
	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		simpleClientHttpRequestFactory.setConnectTimeout(5000);
		simpleClientHttpRequestFactory.setReadTimeout(10000);
		return new RestTemplate(simpleClientHttpRequestFactory);
	}

	@Bean
	public ExecutorService executorService() {
		return Executors.newSingleThreadExecutor();
	}
}
