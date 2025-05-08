package com.practice.claim_service.service;

import com.practice.claim_service.dto.ClaimRequestDTO;
import com.practice.claim_service.dto.ClaimResponseDTO;
import com.practice.claim_service.entity.Claim;
import com.practice.claim_service.entity.ClaimStatus;
import com.practice.claim_service.exception.ResourceNotFoundException;
import com.practice.claim_service.external.client.PolicyClient;
import com.practice.claim_service.external.client.UserClient;
import com.practice.claim_service.repository.ClaimRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserClient userClient;

    @Autowired
    private PolicyClient policyClient;

    public ClaimResponseDTO createClaim(ClaimRequestDTO claimRequestDTO) {
        try {
            userClient.getUserById(claimRequestDTO.getUserId());
        } catch (Exception e) {
            throw new ResourceNotFoundException("User ID with " + claimRequestDTO.getUserId() + " Not Found");
        }
        try {
            policyClient.getUserById(claimRequestDTO.getPolicyId());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Policy Id with " + claimRequestDTO.getPolicyId() + " Not Found");
        }
        Claim claim=modelMapper.map(claimRequestDTO,Claim.class);
        claim.setStatus(claimRequestDTO.getStatus()!=null ? claimRequestDTO.getStatus(): ClaimStatus.PENDING);
        claim.setCreatedAt(new Date());
        claim.setUpdatedAt(new Date());

        return modelMapper.map(claimRepository.save(claim),ClaimResponseDTO.class);

        }

        public List<ClaimResponseDTO> getAllClaims()
        {
            return claimRepository.findAll().stream()
                    .map(claim -> modelMapper.map(claim,ClaimResponseDTO.class)).toList();
        }

        public ClaimResponseDTO getClaimById(Long id)
        {
            Claim claim = claimRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("Claim Not Found with Id " +id));
            return modelMapper.map(claim,ClaimResponseDTO.class);
        }
    }

