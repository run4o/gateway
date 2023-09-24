package com.example.gateway.mappers;

import com.example.gateway.dtos.json.CurrentResponse;
import com.example.gateway.dtos.json.HistoryResponse;
import com.example.gateway.entities.CurrencyData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseMapper {
	
	public static CurrentResponse currencyDataToCurrentResponse(CurrencyData currencyData) {
		return CurrentResponse.builder().rates(convertRatesToMap(currencyData)).build();
	}
	
	public static HistoryResponse currencyDataToHistoryResponse(List<CurrencyData> currencyDataList) {
		List<Map<String, Double>> ratesList = currencyDataList.stream().map(ResponseMapper::convertRatesToMap).toList();
		return HistoryResponse.builder().rates(ratesList).build();
	}
	
	public static Map<String, Double> convertRatesToMap(CurrencyData currencyData) {
		Map<String, Double> rates = new HashMap<>();
		String[] data = currencyData.getRates().replace("{", "").replace("}", "").split(", ");
		Arrays.stream(data).forEach(line -> {
			String[] parts = line.split("=");
			if (parts.length == 2) {
				rates.put(parts[0], Double.parseDouble(parts[1]));
			}
		});
		return rates;
	}
}
