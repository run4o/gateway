package com.example.gateway.services;

import com.example.gateway.entities.Request;

public interface RequestService {
	Request getRequestById(String requestId);
	
	boolean isRequestIdDuplicate(String requestId);
	
	void saveRequest(Request request);
	
}
