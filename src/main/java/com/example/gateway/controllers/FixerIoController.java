package com.example.gateway.controllers;

import org.springframework.web.client.RestTemplate;

public class FixerIoController {
	
	private static final String url = "http://data.fixer.io/api/";
	private static final String key = "cb6456b7cb1f9e9c68d61a926ae940a4";
	
	public static void getData() {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(restTemplate.getForObject(url, String.class));
	}
}
