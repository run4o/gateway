package com.example.gateway.scheduled;

import com.example.gateway.controllers.external.FixerIoController;
import com.example.gateway.dtos.external.FixerIoResponse;
import com.example.gateway.entities.CurrencyData;
import com.example.gateway.mappers.CurrencyDataMapper;
import com.example.gateway.services.CurrencyDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduleImportCurrencyTask {
	
	private final CurrencyDataService currencyDataService;
	private final FixerIoController fixerIoController;
	
	@Scheduled(fixedRateString = "${gateway.data.update.interval}", initialDelay = 1L, timeUnit = TimeUnit.HOURS)
	public void runScheduledTask() {
		log.info("Gathering Data from fixer.io");
		FixerIoResponse response = fixerIoController.getData();
		CurrencyData currencyData = CurrencyDataMapper.fixerIoResponseToCurrencyData(response);
		currencyDataService.addData(currencyData);
	}
}
