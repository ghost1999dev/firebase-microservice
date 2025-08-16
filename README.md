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
