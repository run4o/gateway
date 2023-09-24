package com.example.gateway.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CURRENCY_DATA")
public class CurrencyData {
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@SequenceGenerator(name = "idGenerator", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
	private long id;
	
	@Column(name = "currency", nullable = false, length = 25)
	private String currency;
	
	@Column(name = "date", nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate date;
	
	@Column(name = "timestamp", nullable = false, length = 25)
	private String timestamp;
	
	@Column(name = "rates", nullable = false, length = 5000)
	private String rates;
	
}

