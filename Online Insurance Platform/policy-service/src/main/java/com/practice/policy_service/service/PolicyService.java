package com.practice.policy_service.service;

import com.practice.policy_service.dto.PolicyDTO;
import com.practice.policy_service.entity.Policy;
import com.practice.policy_service.exception.ResourceNotFoundException;
import com.practice.policy_service.repository.PolicyRepositroy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepositroy policyRepositroy;

    @Autowired
    private ModelMapper modelMapper;


    public List<PolicyDTO> getAllPolicies()
    {
        return policyRepositroy.findAll().stream().map(policy->modelMapper.map(policy, PolicyDTO.class))
                .collect(Collectors.toList());
    }

    public PolicyDTO getPolicyById(Long id)
    {
        Policy policy =policyRepositroy.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Policy Not Found with id" + id));
        return modelMapper.map(policy, PolicyDTO.class);
    }

    public PolicyDTO savePolicy(PolicyDTO policyDTO)
    {
        Policy policy= modelMapper.map(policyDTO,Policy.class);
        return modelMapper.map(policyRepositroy.save(policy), PolicyDTO.class);
    }

}
