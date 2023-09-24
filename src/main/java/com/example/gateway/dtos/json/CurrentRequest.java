package com.example.gateway.dtos.json;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CurrentRequest {
	
	@NotEmpty
	@Size(max = 36, message = "Size of requestId must be max 36")
	private String requestId;
	
	@NotEmpty
	@Pattern(regexp = "^\\d+$")
	private String timestamp;
	
	@NotEmpty
	private String client;
	
	@NotEmpty
	private String currency;
}
