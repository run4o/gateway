package com.example.gateway.processors;

import com.example.gateway.dtos.json.CurrentRequest;
import com.example.gateway.dtos.json.CurrentResponse;
import com.example.gateway.dtos.json.HistoryRequest;
import com.example.gateway.dtos.json.HistoryResponse;
import com.example.gateway.dtos.xml.CommandRequest;
import com.example.gateway.dtos.xml.CommandResponse;
import com.example.gateway.entities.CurrencyData;
import com.example.gateway.mappers.ResponseMapper;
import com.example.gateway.services.CurrencyDataService;
import com.example.gateway.validators.exceptions.RequestValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class RequestProccessor {
	
	private final CurrencyDataService currencyDataService;
	
	public CurrentResponse processCurrentRequest(CurrentRequest cr) {
		return ResponseMapper.currencyDataToCurrentResponse(currencyDataService.getLatestCurrencyData(cr.getCurrency()));
	}
	
	public HistoryResponse processHistoryRequest(HistoryRequest hr) {
		return ResponseMapper.currencyDataToHistoryResponse(
				currencyDataService.getCurrencyDataForPeriod(hr.getCurrency(), Long.valueOf(hr.getPeriod())));
	}
	
	public CommandResponse processCommandRequest(CommandRequest cr) {
		if (cr.getHistory() != null) {
			return ResponseMapper.currencyDataToCommandResponse(currencyDataService.getCurrencyDataForPeriod(cr.getHistory().getCurrency(),
																											 Long.parseLong(cr.getHistory()
																															  .getPeriod())));
		} else if (cr.getGet() != null) {
			List<CurrencyData> currencyDataList = new ArrayList<>();
			currencyDataList.add(currencyDataService.getLatestCurrencyData(cr.getGet().getCurrency().getValue()));
			return ResponseMapper.currencyDataToCommandResponse(currencyDataList);
		} else {
			throw new RequestValidationException("get/history", "Request needs either get or history");
		}
	}
}
