package com.example.gateway.validators.json;

import com.example.gateway.entities.Request;
import com.example.gateway.services.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Slf4j
@RequiredArgsConstructor
@Component
public class RequestValidator implements Validator {
	private final RequestService requestService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Request.class.equals(clazz);
	}
	
	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "requestId", "requestId.empty");
		Request req = (Request) obj;
		if (requestService.isRequestIdDuplicate(req.getRequestId())) {
			e.rejectValue("requestId", "requestId.duplicate");
		}
	}
}
