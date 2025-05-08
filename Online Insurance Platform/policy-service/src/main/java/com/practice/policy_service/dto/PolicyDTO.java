package com.practice.policy_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDTO {

    private Long id;

    @NotBlank(message = "Policy name is mandatory")
    private String policyName;

    @NotBlank(message = "Policy type is mandatory")
    private String policyType;

    @Min(value = 1, message = "Coverage amount must be greater than zero")
    private double coverageAmount;

    @Min(value = 1, message = "Premium must be greater than zero")
    private double premium;
}
