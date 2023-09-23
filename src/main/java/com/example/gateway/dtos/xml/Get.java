package com.example.gateway.dtos.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Get {
	
	@XmlAttribute(name = "consumer")
	private String consumer;
	@XmlElement(name = "currency")
	private Currency currency;
	
}
