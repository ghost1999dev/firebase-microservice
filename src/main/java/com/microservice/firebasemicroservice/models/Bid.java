package com.microservice.firebasemicroservice.models;

import java.math.BigDecimal;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.PropertyName;

public class Bid {
    @DocumentId
    @JsonProperty("id")
    private String id;

    @JsonProperty("auction_id")
    private Long auctionId;
    @JsonProperty("user_id")
    private Long userId;

    private BigDecimal amount;

    @JsonProperty("createdAt")
    private Instant createdAt;
    @JsonProperty("updatedAt")
    private Instant updatedAt;
    public Bid() {
    }
    public Bid(String id, Long auctionId, Long userId, BigDecimal amount, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.auctionId = auctionId;
        this.userId = userId;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Long getAuctionId() {
        return auctionId;
    }
    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }
    @PropertyName("user_id")
    public Long getUserId() {
        return userId;
    }
    @PropertyName("user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    public Instant getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
    

    
}