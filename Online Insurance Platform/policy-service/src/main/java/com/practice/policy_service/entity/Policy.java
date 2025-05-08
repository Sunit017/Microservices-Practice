package com.practice.policy_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="policy")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String policyName;

    @Column(nullable = false)
    private String policyType;

    @Column(nullable = false)
    private double coverageAmount;

    @Column(nullable = false)
    private double premium;

}
