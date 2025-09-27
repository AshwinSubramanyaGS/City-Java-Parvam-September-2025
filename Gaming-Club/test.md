## **Postman Collection JSON** (Import directly into Postman)

```json
{
  "info": {
    "name": "Gaming Club API",
    "description": "Complete API testing for Gaming Club Management System",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Authentication",
      "item": [
        {
          "name": "Login - Admin",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"username\": \"admin\",\n  \"password\": \"admin\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/auth",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["auth"]
            }
          },
          "response": []
        },
        {
          "name": "Login - Invalid Credentials",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"username\": \"wrong\",\n  \"password\": \"wrong\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/auth",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["auth"]
            }
          },
          "response": []
        }
      ]
    },
    {
      "name": "Members Management",
      "item": [
        {
          "name": "Create New Member",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"name\": \"John Doe\",\n  \"phone\": \"9876543210\",\n  \"fee\": 1000\n}"
            },
            "url": {
              "raw": "http://localhost:8080/members",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["members"]
            }
          },
          "response": []
        },
        {
          "name": "Create Another Member",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"name\": \"Alice Smith\",\n  \"phone\": \"9123456780\",\n  \"fee\": 1500\n}"
            },
            "url": {
              "raw": "http://localhost:8080/members",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["members"]
            }
          },
          "response": []
        },
        {
          "name": "Search Member by Phone",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"phone\": \"9876543210\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/members/search",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["members", "search"]
            }
          },
          "response": []
        },
        {
          "name": "Search Non-Existent Member",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"phone\": \"0000000000\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/members/search",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["members", "search"]
            }
          },
          "response": []
        }
      ]
    },
    {
      "name": "Games Management",
      "item": [
        {
          "name": "Add New Game - FIFA",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"name\": \"FIFA 2024\",\n  \"price\": 50,\n  \"description\": \"Football simulation game\",\n  \"category\": \"SPORTS\",\n  \"difficultyLevel\": \"MEDIUM\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/game",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["game"]
            }
          },
          "response": []
        },
        {
          "name": "Add New Game - Call of Duty",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"name\": \"Call of Duty\",\n  \"price\": 75,\n  \"description\": \"First-person shooter game\",\n  \"category\": \"ACTION\",\n  \"difficultyLevel\": \"HARD\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/game",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["game"]
            }
          },
          "response": []
        },
        {
          "name": "Add New Game - Chess",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"name\": \"Chess Master\",\n  \"price\": 25,\n  \"description\": \"Strategic board game\",\n  \"category\": \"STRATEGY\",\n  \"difficultyLevel\": \"HARD\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/game",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["game"]
            }
          },
          "response": []
        },
        {
          "name": "Add New Game - Mario Kart",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"name\": \"Mario Kart\",\n  \"price\": 40,\n  \"description\": \"Fun racing game\",\n  \"category\": \"RACING\",\n  \"difficultyLevel\": \"EASY\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/game",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["game"]
            }
          },
          "response": []
        }
      ]
    },
    {
      "name": "Game Play",
      "item": [
        {
          "name": "Play Game - Success",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"member_id\": 1,\n  \"game_id\": 1\n}"
            },
            "url": {
              "raw": "http://localhost:8080/play",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["play"]
            }
          },
          "response": []
        },
        {
          "name": "Play Game - Insufficient Balance",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"member_id\": 1,\n  \"game_id\": 2\n}"
            },
            "url": {
              "raw": "http://localhost:8080/play",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["play"]
            }
          },
          "response": []
        },
        {
          "name": "Play Game - Invalid Member",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"member_id\": 999,\n  \"game_id\": 1\n}"
            },
            "url": {
              "raw": "http://localhost:8080/play",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["play"]
            }
          },
          "response": []
        },
        {
          "name": "Play Game - Invalid Game",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"member_id\": 1,\n  \"game_id\": 999\n}"
            },
            "url": {
              "raw": "http://localhost:8080/play",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["play"]
            }
          },
          "response": []
        }
      ]
    },
    {
      "name": "Collections & Reports",
      "item": [
        {
          "name": "Get Daily Collection - Today",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/collection/2024-01-15",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["collection", "2024-01-15"]
            }
          },
          "response": []
        },
        {
          "name": "Get Daily Collection - Specific Date",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/collection/2024-01-01",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["collection", "2024-01-01"]
            }
          },
          "response": []
        }
      ]
    }
  ]
}
```

## **2. Individual API Testing Examples**

### **Authentication API**
```http
POST http://localhost:8080/auth
Content-Type: application/json

{
  "username": "admin",
  "password": "admin"
}
```

### **Create Member API**
```http
POST http://localhost:8080/members
Content-Type: application/json

{
  "name": "Raj Sharma",
  "phone": "9876543210",
  "fee": 1000
}
```

### **Search Member API**
```http
POST http://localhost:8080/members/search
Content-Type: application/json

{
  "phone": "9876543210"
}
```

### **Add Game API**
```http
POST http://localhost:8080/game
Content-Type: application/json

{
  "name": "FIFA 2024",
  "price": 50,
  "description": "Football simulation game",
  "category": "SPORTS",
  "difficultyLevel": "MEDIUM"
}
```

### **Play Game API**
```http
POST http://localhost:8080/play
Content-Type: application/json

{
  "member_id": 1,
  "game_id": 1
}
```

### **Get Collection API**
```http
GET http://localhost:8080/collection/2024-01-15
```

## **3. Testing Sequence Guide**

### **Step-by-Step Testing Flow:**

1. **Start with Authentication**
   ```http
   POST /auth → Expect: "fake-jwt-token"
   ```

2. **Create Members** (Run these first)
   ```http
   POST /members → Create John Doe (phone: 9876543210)
   POST /members → Create Alice Smith (phone: 9123456780)
   ```

3. **Add Games** 
   ```http
   POST /game → Add FIFA 2024 (ID: 1)
   POST /game → Add Call of Duty (ID: 2)
   POST /game → Add Chess Master (ID: 3)
   ```

4. **Test Member Search**
   ```http
   POST /members/search → Search by phone 9876543210
   ```

5. **Test Game Play**
   ```http
   POST /play → Member 1 plays Game 1 (should succeed)
   POST /play → Member 1 plays Game 2 (might fail if balance low)
   ```

6. **Check Collections**
   ```http
   GET /collection/2024-01-15 → View today's transactions
   ```

## **4. Expected Responses**

### **Success Responses:**
```json
// Login Success
"fake-jwt-token"

// Create Member Success
{
  "id": 1,
  "name": "John Doe",
  "phone": "9876543210",
  "balance": 1000.0,
  "membershipType": "REGULAR",
  "totalGamesPlayed": 0
}

// Play Game Success
"Game 'FIFA 2024' played successfully! Balance deducted: $50.00"
```

### **Error Responses:**
```json
// Insufficient Balance
"Insufficient balance!"

// Member Not Found
"Member not found"

// Game Not Found  
"Game not found"
```

## **5. Postman Environment Variables**

Create a Postman environment with these variables:
```json
{
  "id": "gaming-club-env",
  "name": "Gaming Club API",
  "values": [
    {
      "key": "baseUrl",
      "value": "http://localhost:8080",
      "type": "default"
    },
    {
      "key": "memberId",
      "value": "1",
      "type": "default"
    },
    {
      "key": "gameId",
      "value": "1", 
      "type": "default"
    }
  ]
}
```

## **6. Quick Test Commands (curl)**

```bash
# Test login
curl -X POST http://localhost:8080/auth \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"admin"}'

# Test create member
curl -X POST http://localhost:8080/members \
  -H "Content-Type: application/json" \
  -d '{"name":"Test User","phone":"1234567890","fee":500}'

# Test play game
curl -X POST http://localhost:8080/play \
  -H "Content-Type: application/json" \
  -d '{"member_id":1,"game_id":1}'
```

