package com.example.gateway.repositories;

import com.example.gateway.entities.CurrencyData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyDataRepository extends JpaRepository<CurrencyData, Long> {
	
	CurrencyData findTopByCurrencyOrderByTimestampDesc(String currency);
	
	List<CurrencyData> findByCurrencyAndTimestampBetween(String currency, String from, String to);
}
