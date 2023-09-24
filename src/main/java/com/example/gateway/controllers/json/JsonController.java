package com.example.gateway.controllers.json;


import com.example.gateway.dtos.json.CurrentRequest;
import com.example.gateway.dtos.json.CurrentResponse;
import com.example.gateway.dtos.json.HistoryRequest;
import com.example.gateway.dtos.json.HistoryResponse;
import com.example.gateway.entities.Request;
import com.example.gateway.mappers.RequestMapper;
import com.example.gateway.processors.RequestProccessor;
import com.example.gateway.services.RequestService;
import com.example.gateway.validators.RequestValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/json_api", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class JsonController {
	
	private final RequestProccessor requestProccessor;
	private final RequestService requestService;
	private final RequestValidator requestValidator;
	
	@PostMapping(value = "/current")
	public ResponseEntity<CurrentResponse> current(@Validated @RequestBody CurrentRequest crDto) {
		log.info(crDto.toString());
		Request request = RequestMapper.currentRequestDtoToRequest(crDto);
		requestValidator.validate(request);
		requestService.saveRequest(request);
		return ResponseEntity.ok(requestProccessor.processCurrentRequest(crDto));
	}
	
	@PostMapping(value = "/history")
	public ResponseEntity<HistoryResponse> history(@Validated @RequestBody HistoryRequest hrDto) {
		log.info(hrDto.toString());
		Request request = RequestMapper.historyRequestDtoToRequest(hrDto);
		requestValidator.validate(request);
		requestService.saveRequest(request);
		return ResponseEntity.ok(requestProccessor.processHistoryRequest(hrDto));
	}
	
}
