package com.example.gateway.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REQUEST")
public class Request {
	
	@Id
	@Column(name = "requestId", nullable = false, unique = true)
	@Size(max = 36)
	private String requestId;
	
	@Column(name = "TIMESTAMP", nullable = false, length = 25)
	private String timestamp;
	
	@Column(name = "SERVICE", nullable = false, length = 25)
	private String type;
	
	@Column(name = "CLIENT", nullable = false, length = 25)
	private String client;
}
