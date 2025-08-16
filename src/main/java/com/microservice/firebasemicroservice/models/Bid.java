// ...existing code...
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

    @JsonProperty("client_id")
    private Long clientId;

    @JsonProperty("auction_id")
    private Long auctionId;

    @JsonProperty("developer_id")
    private Long developerId;

    private BigDecimal amount;

    @JsonProperty("createdAt")
    private Instant createdAt;

    @JsonProperty("updatedAt")
    private Instant updatedAt;

    public Bid(){}

    public Bid(String id, Long clientId, Long auctionId, Long developerId, BigDecimal amount,
               Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.clientId = clientId;
        this.auctionId = auctionId;
        this.developerId = developerId;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @PropertyName("client_id")
    public Long getClientId() { return clientId; }
    @PropertyName("client_id")
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public Long getAuctionId() { return auctionId; }
    public void setAuctionId(Long auctionId) { this.auctionId = auctionId; }

    public Long getDeveloperId() { return developerId; }
    public void setDeveloperId(Long developerId) { this.developerId = developerId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}