package com.example.gateway.dtos.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CommandResponse {
	
	@XmlAttribute(name = "rates")
	private List<Map<String, Double>> rates;
}
