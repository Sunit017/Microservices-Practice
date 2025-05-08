package com.practice.claim_service.repository;

import com.practice.claim_service.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim,Long> {

}
