package com.example.gateway.dtos.external;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Map;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FixerIoResponse {
	@NotEmpty
	private boolean success;
	
	@NotEmpty
	@Pattern(regexp = "^\\d+$")
	private String timestamp;
	
	@NotEmpty
	private String base;
	
	@NotEmpty
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private String Date;
	
	@NotEmpty
	private Map<String, Double> rates;
	
	private Map<String, String> error;
	
}
