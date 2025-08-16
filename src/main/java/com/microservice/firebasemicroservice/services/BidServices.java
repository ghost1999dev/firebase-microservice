package com.microservice.firebasemicroservice.services;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.microservice.firebasemicroservice.models.Bid;
@Service
public interface BidServices {
    Bid save(Bid bid) throws ExecutionException,InterruptedException;
}
