# Firebase Microservice (BIDS)

## Node.js Usage
Base URL: https://firebase-microservice.onrender.com  
API Key header: X-API-KEY

### Environment Variables

BIDS_API_BASE=https://firebase-microservice.onrender.com 
BIDS_API_KEY=YOUR_API_KEY_HERE 

### Create (POST /api/bids) Payload
```json
{
  "client_id": 123,
  "auction_id": 45,
  "developer_id": 67,
  "amount": "500.00"
}

import axios from "axios";

const api = axios.create({
  baseURL: process.env.BIDS_API_BASE,
  headers: {
    "X-API-KEY": process.env.BIDS_API_KEY,
    "Content-Type": "application/json"
  },
  timeout: parseInt(process.env.REQUEST_TIMEOUT_MS || "5000", 10)
});

export async function createBid(bid) {
  const { data } = await api.post("/api/bids", bid);
  if (!data.success) throw new Error(data.message);
  return data.data;
}

export async function listBids() {
  const { data } = await api.get("/api/bids");
  if (!data.success) throw new Error(data.message);
  return data.data;
}