package com.practice.claim_service.controller;

import com.practice.claim_service.dto.ClaimRequestDTO;
import com.practice.claim_service.dto.ClaimResponseDTO;
import com.practice.claim_service.dto.UpdateClaimStatusRequest;
import com.practice.claim_service.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claim")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping("/create")
    public ResponseEntity<ClaimResponseDTO> createClaim(@RequestBody ClaimRequestDTO claimRequestDTO)
    {
        return new ResponseEntity<>(claimService.createClaim(claimRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClaimResponseDTO>> getAllClaims()
    {
        return ResponseEntity.ok(claimService.getAllClaims());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaimResponseDTO> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(claimService.getClaimById(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ClaimResponseDTO> updateStatus(@PathVariable Long id,
                                                         @RequestBody @Valid UpdateClaimStatusRequest claimStatusRequest)
    {
        ClaimResponseDTO claimResponseDTO= claimService.updateClaimStatus(id,claimStatusRequest);
        return ResponseEntity.ok(claimResponseDTO);

    }

}
