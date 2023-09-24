package com.example.gateway.services;

import com.example.gateway.entities.CurrencyData;
import com.example.gateway.repositories.CurrencyDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Primary
@RequiredArgsConstructor
@Service
public class CurrencyDataServiceImpl implements CurrencyDataService {
	
	private final CurrencyDataRepository currencyDataRepository;
	
	@Override
	public CurrencyData getLatestCurrencyData(String currency) {
		return currencyDataRepository.findTopByCurrencyOrderByTimestampDesc(currency);
	}
	
	@Override
	public List<CurrencyData> getCurrencyDataForPeriod(String currency, long period) {
		long currentTimestamp = System.currentTimeMillis() / 1000L;
		long fromTimestamp = currentTimestamp - period * 60 * 60;
		return currencyDataRepository.findByCurrencyAndTimestampBetween(currency, String.valueOf(fromTimestamp),
																		String.valueOf(currentTimestamp));
	}
	
	@Override
	public void addData(CurrencyData currencyData) {
		currencyDataRepository.save(currencyData);
	}
}
