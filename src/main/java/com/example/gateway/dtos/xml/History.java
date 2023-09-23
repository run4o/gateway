package com.example.gateway.dtos.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class History {
	
	@XmlAttribute(name = "consumer")
	private String consumer;
	@XmlAttribute(name = "currency")
	private String currency;
	@XmlAttribute(name = "period")
	private String period;
	
}
