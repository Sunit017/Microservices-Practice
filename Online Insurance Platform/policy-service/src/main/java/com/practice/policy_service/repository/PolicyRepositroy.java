package com.practice.policy_service.repository;

import com.practice.policy_service.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepositroy extends JpaRepository<Policy,Long> {

}
