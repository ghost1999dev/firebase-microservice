package com.microservice.firebasemicroservice.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.microservice.firebasemicroservice.models.Bid;
@Service
public interface BidServices {
    Bid save(Bid bid) throws ExecutionException,InterruptedException;
    List<Bid> findAll() throws ExecutionException, InterruptedException;
}
