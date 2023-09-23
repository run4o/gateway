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
public class Command {
	
	@XmlAttribute(name = "id")
	private String id;
	@XmlElement(name = "get", required = false)
	private Get get;
	@XmlElement(name = "history", required = false)
	private History history;
	
}
