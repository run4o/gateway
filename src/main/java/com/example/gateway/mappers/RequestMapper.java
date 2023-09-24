package com.example.gateway.mappers;

import com.example.gateway.dtos.json.CurrentRequest;
import com.example.gateway.dtos.json.HistoryRequest;
import com.example.gateway.dtos.xml.Command;
import com.example.gateway.entities.Request;

public class RequestMapper {
	
	public static Request currentRequestDtoToRequest(CurrentRequest crDto) {
		if (crDto == null) {
			return null;
		}
		
		Request.RequestBuilder request = Request.builder();
		request.requestId(crDto.getRequestId());
		request.timestamp(crDto.getTimestamp());
		request.type("CurrentRequest");
		request.client(crDto.getClient());
		
		return request.build();
	}
	
	public static Request historyRequestDtoToRequest(HistoryRequest hrDto) {
		if (hrDto == null) {
			return null;
		}
		
		Request.RequestBuilder request = Request.builder();
		request.requestId(hrDto.getRequestId());
		request.timestamp(hrDto.getTimestamp());
		request.type("HistoryRequest");
		request.client(hrDto.getClient());
		
		return request.build();
	}
	
	public static Request commandToRequest(Command command) {
		if (command == null) {
			return null;
		}
		
		Request.RequestBuilder request = Request.builder();
		request.requestId(command.getId());
		request.timestamp(String.valueOf(System.currentTimeMillis() / 1000L));
		request.type("Command");
		request.client(command.getGet() != null ? command.getGet().getConsumer() : command.getHistory().getConsumer());
		
		return request.build();
	}
}
