package com.microservice.firebasemicroservice.config;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Configuration
public class FirebaseConfig {
    @Bean
    public Firestore firestore() throws IOException{
        if(FirebaseApp.getApps().isEmpty()){
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("admin-sdk.json");
            if(serviceAccount == null){
                throw new IllegalStateException("Field admin-sdk not found");
            }
            FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
            FirebaseApp.initializeApp(options);
        }
        return FirestoreClient.getFirestore();
    }
}
