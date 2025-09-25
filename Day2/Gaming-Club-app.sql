create database gaming_club_app;

use gaming_club_app;

-- Table: members
CREATE TABLE members (
    _id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    balance DOUBLE DEFAULT 0,
    phone VARCHAR(20) UNIQUE
);

-- Table: games
CREATE TABLE games (
    _id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    description TEXT
);

-- Table: recharges
CREATE TABLE recharges (
    _id BIGINT AUTO_INCREMENT PRIMARY KEY,
    memberId BIGINT,
    amount DOUBLE NOT NULL,
    dateTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (memberId) REFERENCES members(_id)
);

-- Table: transactions
CREATE TABLE transactions (
    _id BIGINT AUTO_INCREMENT PRIMARY KEY,
    memberId BIGINT,
    gameId BIGINT,
    amount DOUBLE NOT NULL,
    dateTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (memberId) REFERENCES members(_id),
    FOREIGN KEY (gameId) REFERENCES games(_id)
);

-- Table: collections
CREATE TABLE collections (
    _id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    amount DOUBLE NOT NULL
);

-- Table: admin_users
CREATE TABLE admin_users (
    _id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
