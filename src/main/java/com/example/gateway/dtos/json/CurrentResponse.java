package com.example.gateway.dtos.json;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
public class CurrentResponse {
	
	@NotEmpty
	private Map<String, Double> rates;
}
