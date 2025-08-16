package com.microservice.firebasemicroservice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.microservice.firebasemicroservice.models.ApiResponse;
import com.microservice.firebasemicroservice.models.Bid;

import com.microservice.firebasemicroservice.services.BidServices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/bids")
public class TestController {
    private final BidServices bidServices;
    public TestController(BidServices bidService){
        this.bidServices = bidService;
    }
    @PostMapping()
    public ResponseEntity<ApiResponse<Bid>>create(@RequestBody Bid bid) {
        try {
            Bid saved = bidServices.save(bid);
            return ResponseEntity.ok(ApiResponse.success("Bid saved succesfully", saved));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ApiResponse.error("Error found " +e.getMessage()));
        }
    }
    
    
}
