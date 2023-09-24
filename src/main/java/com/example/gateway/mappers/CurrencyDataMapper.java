package com.example.gateway.mappers;

import com.example.gateway.dtos.external.FixerIoResponse;
import com.example.gateway.entities.CurrencyData;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CurrencyDataMapper {
	public static CurrencyData fixerIoResponseToCurrencyData(FixerIoResponse fixerIoResponse) {
		if (fixerIoResponse == null) {
			return null;
		}
		
		CurrencyData.CurrencyDataBuilder currencyData = CurrencyData.builder();
		currencyData.currency(fixerIoResponse.getBase());
		if (fixerIoResponse.getDate() != null) {
			currencyData.date(LocalDate.parse(fixerIoResponse.getDate()));
		}
		currencyData.timestamp(fixerIoResponse.getTimestamp());
		currencyData.rates(fixerIoResponse.getRates().toString());
		
		return currencyData.build();
	}
}

