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
    "auction_id":13,
    "user_id":90,
    "amount":700
}
```
### Create response when it is success

```json
{
    "success": true,
    "message": "Bid saved succesfully",
    "data": {
        "amount": 700,
        "id": "Zuhp2YwVHSrmwf33o2d8",
        "auction_id": 13,
        "user_id": 90,
        "createdAt": "2025-08-19T14:42:31.155322600Z",
        "updatedAt": "2025-08-19T14:42:31.155322600Z"
    },
    "timestamp": "2025-08-19T14:42:35.011375900Z"
}


```

```bash
const BASE = process.env.BIDS_API_BASE;
const API_KEY = process.env.BIDS_API_KEY;

async function createBid(bid) {
  const res = await fetch(`${BASE}/api/bids`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "X-API-KEY": API_KEY
    },
    body: JSON.stringify(bid)
  });
  const json = await res.json();
  if (!res.ok || !json.success) throw new Error(json.message || `HTTP ${res.status}`);
  return json.data;
}

async function listBids() {
  const res = await fetch(`${BASE}/api/bids`, {
    headers: { "X-API-KEY": API_KEY }
  });
  const json = await res.json();
  if (!res.ok || !json.success) throw new Error(json.message || `HTTP ${res.status}`);
  return json.data;
}

```
