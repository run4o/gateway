package com.example.gateway.controllers.external;

import com.example.gateway.dtos.external.FixerIoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
public class FixerIoController {
	
	private final String accessToken = "?access_key=";
	private final String baseUrl = "http://data.fixer.io/api/latest";
	
	@Value("${gateway.data.update.key}")
	private String key;
	
	public FixerIoResponse getData() {
		RestTemplate restTemplate = new RestTemplate();
		FixerIoResponse result = restTemplate.getForObject(generateUrl(), FixerIoResponse.class);
		return result;
	}
	
	private String generateUrl() {
		return baseUrl + accessToken + key;
	}
}
