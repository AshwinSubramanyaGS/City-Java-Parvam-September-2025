# **Gaming Club App**

## **Abstract**

This project develops a **Membership and Game Management System** using **Spring Boot and MongoDB** for managing the operations of a gaming center. The system enables administrators to manage **memberships, games, recharges, transactions, and daily collections** via secure REST APIs. Members are registered with an initial joining fee that updates their balance. Recharges and game plays are recorded as separate documents, and balances are automatically adjusted. The system maintains **daily collections** and provides detailed **member histories**. Authentication ensures only authorized administrators can access the system. With MongoDB’s flexible schema and scalability, the solution eliminates manual tracking, improves accuracy, and offers a reliable digital platform for efficient gaming center management.

---

## **Collections/Document Overview**

| **Collection Name** | **Fields (with notes)**                                                                                                                                  |
| ------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **members**         | `_id ObjectId PK`, `name String NOT NULL`, `balance Double DEFAULT 0`, `phone String UNIQUE`                                                             |
| **games**           | `_id ObjectId PK`, `name String NOT NULL`, `price Double NOT NULL`, `description String`                                                                 |
| **recharges**       | `_id ObjectId PK`, `memberId ObjectId (ref → members._id)`, `amount Double NOT NULL`, `dateTime Date DEFAULT now()`                                      |
| **transactions**    | `_id ObjectId PK`, `memberId ObjectId (ref → members._id)`, `gameId ObjectId (ref → games._id)`, `amount Double NOT NULL`, `dateTime Date DEFAULT now()` |
| **collections**     | `_id ObjectId PK`, `date Date NOT NULL`, `amount Double NOT NULL`                                                                                        |
| **admin\_users**    | `_id ObjectId PK`, `username String UNIQUE NOT NULL`, `password String NOT NULL`                                                                         |

---

## **MongoDB Collection Creation (Migration from SQL DDL)**

In MongoDB you don’t create schemas strictly (it’s schema-less), but you can enforce structure with **JSON schema validation** at collection level. Below is the **equivalent of your SQL DDL** using `db.createCollection` with validators.

---

### 1. **members**

```js
db.createCollection("members", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["name", "phone"],
      properties: {
        name: { bsonType: "string" },
        balance: { bsonType: "double" },
        phone: { bsonType: "string" }
      }
    }
  }
});
```

---

### 2. **games**

```js
db.createCollection("games", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["name", "price"],
      properties: {
        name: { bsonType: "string" },
        price: { bsonType: "double" },
        description: { bsonType: "string" }
      }
    }
  }
});
```

---

### 3. **recharges**

```js
db.createCollection("recharges", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["memberId", "amount"],
      properties: {
        memberId: { bsonType: "objectId" },
        amount: { bsonType: "double" },
        dateTime: { bsonType: "date" }
      }
    }
  }
});
```

---

### 4. **transactions**

```js
db.createCollection("transactions", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["memberId", "gameId", "amount"],
      properties: {
        memberId: { bsonType: "objectId" },
        gameId: { bsonType: "objectId" },
        amount: { bsonType: "double" },
        dateTime: { bsonType: "date" }
      }
    }
  }
});
```

---

### 5. **collections**

```js
db.createCollection("collections", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["date", "amount"],
      properties: {
        date: { bsonType: "date" },
        amount: { bsonType: "double" }
      }
    }
  }
});
```

---

### 6. **admin\_users**

```js
db.createCollection("admin_users", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["username", "password"],
      properties: {
        username: { bsonType: "string" },
        password: { bsonType: "string" }
      }
    }
  }
});
```
