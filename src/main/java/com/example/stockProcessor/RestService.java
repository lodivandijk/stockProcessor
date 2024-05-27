package com.example.stockProcessor;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RestService {

	private final WebClient webClient;

	public RestService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.build();
	}

	public String someRestCall(String urlAddress) {

		return this.webClient.get().uri(urlAddress)
						.retrieve().bodyToMono(String.class).block();
	}

}