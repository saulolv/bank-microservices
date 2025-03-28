package com.study.accounts.Domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Account extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Id
    @Column(nullable = false, name = "account_number")
    private Long accountNumber;

    @Column(nullable = false, name = "account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String BranchAddress;

}
