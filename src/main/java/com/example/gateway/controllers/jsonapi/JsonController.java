package com.example.gateway.controllers.jsonapi;

import com.example.gateway.dtos.json.CurrentRequestDto;
import com.example.gateway.dtos.json.HistoryRequestDto;
import com.example.gateway.entities.Request;
import com.example.gateway.mappers.RequestMapper;
import com.example.gateway.services.RequestService;
import com.example.gateway.validators.json.RequestValidator;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/json_api", consumes = "application/json")
public class JsonController {
	
	private final RequestService requestService;
	private final RequestValidator requestValidator;
	
	@PostMapping(value = "/current")
	public ResponseEntity<Request> current(@Validated @RequestBody CurrentRequestDto crDto) {
		log.info(crDto.toString());
		Request request = RequestMapper.currentRequestDtoToRequest(crDto);
		Errors errors = new BeanPropertyBindingResult(request, "Request");
		requestValidator.validate(request, errors);
		if (errors.hasErrors()) {
			throw new ValidationException("Duplicated requestId");
		}
		requestService.saveRequest(RequestMapper.currentRequestDtoToRequest(crDto));
		return ResponseEntity.ok(requestService.getRequestById(crDto.getRequestId()));
	}
	
	@PostMapping(value = "/history")
	public ResponseEntity<Request> history(@Validated @RequestBody HistoryRequestDto hrDto) {
		log.info(hrDto.toString());
		Request request = RequestMapper.historyRequestDtoToRequest(hrDto);
		Errors errors = new BeanPropertyBindingResult(request, "Request");
		requestValidator.validate(request, errors);
		if (errors.hasErrors()) {
			throw new ValidationException("Duplicated requestId");
		}
		requestService.saveRequest(request);
		return ResponseEntity.ok(requestService.getRequestById(hrDto.getRequestId()));
	}
	
}
