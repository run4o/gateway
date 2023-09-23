package com.example.gateway.dtos.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
public class Currency {
	
	private String value;
}
