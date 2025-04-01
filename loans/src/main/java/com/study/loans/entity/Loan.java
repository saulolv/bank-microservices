package com.study.loans.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "loans")
@Entity
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Loan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String mobileNumber;

    @Column(nullable = false, length = 100)
    private String loanNumber;

    @Column(nullable = false, length = 100)
    private String loanType;

    @Column(nullable = false)
    private Integer totalLoan;

    @Column(nullable = false)
    private Integer amountPaid;

    @Column(nullable = false)
    private Integer outstandingAmount;
}
