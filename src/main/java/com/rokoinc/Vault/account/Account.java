package com.rokoinc.Vault.account;

import com.rokoinc.Vault.customer.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Account {

    @GeneratedValue(strategy = GenerationType.UUID)
    @NotNull
    @Id
    private UUID id;

    @NotNull
    @Column(unique = true, nullable = false)
    private long accountNumber;

    @NotNull
    @Column(nullable = false)
    private double balance=0.00;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "account_customer_fkey"))
    private Customer customer;

    @NotNull
    @Column(nullable = false)
    private String accountType;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Account() {
    }

    public Account(UUID id, long accountNumber, double balance, Customer customer, String accountType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
        this.accountType = accountType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
