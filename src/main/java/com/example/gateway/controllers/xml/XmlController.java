package com.example.gateway.controllers.xml;

import com.example.gateway.dtos.xml.CommandRequest;
import com.example.gateway.entities.Request;
import com.example.gateway.mappers.RequestMapper;
import com.example.gateway.processors.RequestProccessor;
import com.example.gateway.services.RequestService;
import com.example.gateway.validators.RequestValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/xml_api")
public class XmlController {
	
	private final RequestService requestService;
	private final RequestValidator requestValidator;
	private final RequestProccessor requestProccessor;
	
	@PostMapping(value = "/command", produces = APPLICATION_XML_VALUE, consumes = APPLICATION_XML_VALUE)
	public ResponseEntity command(@RequestBody CommandRequest commandRequest) {
		Request request = RequestMapper.commandToRequest(commandRequest);
		requestValidator.validate(request);
		requestService.saveRequest(request);
		return ResponseEntity.ok().body(requestProccessor.processCommandRequest(commandRequest));
	}
}
