package com.example.gateway.dtos.json;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class HistoryResponse {
	
	@NotEmpty
	private List<Map<String, Double>> rates;
}
