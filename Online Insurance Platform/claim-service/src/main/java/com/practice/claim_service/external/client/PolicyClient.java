package com.practice.claim_service.external.client;

import com.practice.claim_service.dto.PolicyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name = "policy-service")
public interface PolicyClient {

    @GetMapping("/api/policies/{id}")
    public ResponseEntity<PolicyDto> getUserById(@PathVariable Long id);

}
