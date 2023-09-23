package com.example.gateway.controllers.xmlapi;

import com.example.gateway.dtos.xml.Command;
import com.example.gateway.mappers.RequestMapper;
import com.example.gateway.services.RequestService;
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
	
	@PostMapping(value = "/command", produces = APPLICATION_XML_VALUE, consumes = APPLICATION_XML_VALUE)
	public ResponseEntity command(@RequestBody Command command) {
		System.out.println(command.toString());
		log.info("In ExtService1 controller");
		requestService.saveRequest(RequestMapper.commandToRequest(command));
		return ResponseEntity.ok().body(requestService.getRequestById(command.getId()));
	}
}
