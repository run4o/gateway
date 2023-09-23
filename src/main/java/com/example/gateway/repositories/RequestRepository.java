package com.example.gateway.repositories;

import com.example.gateway.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {
	
	Optional<Request> findByRequestId(String requestId);
}
