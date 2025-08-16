package com.microservice.firebasemicroservice.services.impl;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.microservice.firebasemicroservice.models.Bid;
import com.microservice.firebasemicroservice.services.BidServices;
@Service
public class BidServicesImpl implements BidServices {
    private final Firestore firestore;
    public BidServicesImpl(Firestore firestore){
        this.firestore = firestore;
    }


    @Override
    public Bid save(Bid bid) throws ExecutionException, InterruptedException {
       Instant now = Instant.now();
       if(bid.getCreatedAt() == null){
        bid.setCreatedAt(now);
       }
       bid.setUpdatedAt(now);

       String docId = firestore.collection("bids").document().getId();
       bid.setId(docId);
       ApiFuture<WriteResult> write = firestore.collection("bids").document(docId).set(bid);
       write.get();
       return bid;

    }


    @Override
    public List<Bid> findAll() throws ExecutionException, InterruptedException {
        QuerySnapshot snap = firestore.collection("bids").get().get();
        return snap.getDocuments()
                    .stream()
                    .map(d-> d.toObject(Bid.class))
                    .collect(Collectors.toList());
    }
    
}
