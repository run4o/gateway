package com.example.gateway.mappers;

import com.example.gateway.dtos.json.CurrentRequest;
import com.example.gateway.dtos.json.HistoryRequest;
import com.example.gateway.dtos.xml.CommandRequest;
import com.example.gateway.entities.Request;

public class RequestMapper {
	private RequestMapper() {
		//Sonar
	}
	
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
	
	public static Request commandToRequest(CommandRequest commandRequest) {
		if (commandRequest == null) {
			return null;
		}
		
		Request.RequestBuilder request = Request.builder();
		request.requestId(commandRequest.getId());
		request.timestamp(String.valueOf(System.currentTimeMillis() / 1000L));
		request.type("Command");
		request.client(commandRequest.getGet() != null ? commandRequest.getGet().getConsumer() :
							   commandRequest.getHistory().getConsumer());
		
		return request.build();
	}
}
