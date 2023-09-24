package com.example.gateway.processors;

import com.example.gateway.dtos.json.CurrentRequest;
import com.example.gateway.dtos.json.CurrentResponse;
import com.example.gateway.dtos.json.HistoryRequest;
import com.example.gateway.dtos.json.HistoryResponse;
import com.example.gateway.mappers.ResponseMapper;
import com.example.gateway.services.CurrencyDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class RequestProccessor {
	
	private final CurrencyDataService currencyDataService;
	
	public CurrentResponse processCurrentRequest(CurrentRequest crDto) {
		return ResponseMapper.currencyDataToCurrentResponse(currencyDataService.getLatestCurrencyData(crDto.getCurrency()));
	}
	
	public HistoryResponse processHistoryRequest(HistoryRequest crDto) {
		return ResponseMapper.currencyDataToHistoryResponse(
				currencyDataService.getCurrencyDataForPeriod(crDto.getCurrency(), Long.valueOf(crDto.getPeriod())));
	}
}
