package com.example.gateway.services;

import com.example.gateway.entities.CurrencyData;

import java.util.List;

public interface CurrencyDataService {
	CurrencyData getLatestCurrencyData(String currency);
	
	List<CurrencyData> getCurrencyDataForPeriod(String currency, long period);
	
	void addData(CurrencyData currencyData);
}
