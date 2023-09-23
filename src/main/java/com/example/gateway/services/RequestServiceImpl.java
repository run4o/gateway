package com.example.gateway.services;

import com.example.gateway.entities.Request;
import com.example.gateway.repositories.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
	
	private final RequestRepository requestRepository;
	
	@Override
	public Request getRequestById(String requestId) {
		return requestRepository.findByRequestId(requestId).orElse(null);
	}
	
	@Override
	public boolean isRequestIdDuplicate(String requestId) {
		Optional<Request> request = requestRepository.findByRequestId(requestId);
		return request.isPresent();
	}
	
	@Override
	public void saveRequest(Request request) {
		requestRepository.save(request);
	}
}
