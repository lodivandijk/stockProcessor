package com.example.stockProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RestService {

	@Autowired
	private WebClient myWebClient;

	public String retrieveData(String urlAddress) {
		return myWebClient
				.get().uri(urlAddress)
				.retrieve().bodyToMono(String.class).block();
	}


}