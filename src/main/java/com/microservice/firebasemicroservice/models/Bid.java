package com.microservice.firebasemicroservice.models;

import java.math.BigDecimal;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bid {
    private Long id;
    @JsonProperty("auction_id")
    private Long auctionId;
    @JsonProperty("developer_id")
    private Long developerId;

    private BigDecimal amount;
    @JsonProperty("createdAt")
    private Instant createdAt;
    @JsonProperty("updateAt")
    private Instant updateAt;
    public Bid() {
    }
    public Bid(Long id, Long auctionId, Long developerId, BigDecimal amount, Instant createdAt, Instant updateAt) {
        this.id = id;
        this.auctionId = auctionId;
        this.developerId = developerId;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getAuctionId() {
        return auctionId;
    }
    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }
    public Long getDeveloperId() {
        return developerId;
    }
    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public Instant getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
