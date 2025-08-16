package com.microservice.firebasemicroservice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.microservice.firebasemicroservice.models.ApiResponse;
import com.microservice.firebasemicroservice.models.Bid;

import com.microservice.firebasemicroservice.services.BidServices;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/bids")
public class TestController {
    private final BidServices bidServices;

    public TestController(BidServices bidService) {
        this.bidServices = bidService;
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Bid>> create(@RequestBody Bid bid) {
        try {
            Bid saved = bidServices.save(bid);
            return ResponseEntity.ok(ApiResponse.success("Bid saved succesfully", saved));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ApiResponse.error("Error found " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Bid>>> listAll() {
        try {
            List<Bid> bids = bidServices.findAll();
            return ResponseEntity.ok(ApiResponse.success("Lista de bids", bids));
        } catch (ExecutionException | InterruptedException e) {
            Thread.currentThread().interrupt();
            return ResponseEntity.status(500).body(ApiResponse.error("Error obteniendo bids: " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ApiResponse.error("Error inesperado: " + e.getMessage()));
        }
    }

}
