package com.practice.claim_service.dto;

import com.practice.claim_service.entity.ClaimStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClaimStatusRequest {

    @NotNull(message = "Status must not be null")
    private ClaimStatus status;
}
