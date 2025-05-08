package com.practice.policy_service.controller;

import com.practice.policy_service.dto.PolicyDTO;
import com.practice.policy_service.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("/all")
    public ResponseEntity<List<PolicyDTO>> getAllPolicies()
    {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyDTO> getPolicy(@PathVariable Long id)
    {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<PolicyDTO> createPolicy(@Valid @RequestBody PolicyDTO policyDTO)
    {
        return  new ResponseEntity<>(policyService.savePolicy(policyDTO), HttpStatus.CREATED);
    }

}
