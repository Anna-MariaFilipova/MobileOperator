DROP database IF EXISTS mobileOperator;
CREATE DATABASE mobileOperator;
USE mobileOperator;

CREATE TABLE admins(
id       INT AUTO_INCREMENT   NOT NULL PRIMARY KEY,
name     VARCHAR(255)         NOT NULL,
email    VARCHAR(255)         NOT NULL UNIQUE,
password VARCHAR(255)         NOT NULL,
datecreated timestamp default now()
);

CREATE TABLE users(
id       INT AUTO_INCREMENT   NOT NULL PRIMARY KEY,
name     VARCHAR(255)         NOT NULL,
email    VARCHAR(255)         NOT NULL UNIQUE,
password VARCHAR(255)         NOT NULL,
date_created timestamp default now()
);

CREATE TABLE services (
    id              INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    typeService     VARCHAR(255)       NOT NULL,
    price           DOUBLE             NOT NULL,
    startService    DATE               NOT NULL,
    endService      DATE               NOT NULL,
    lastPaymentDate DATE               NOT NULL,
    countMinutes    INT                NOT NULL,
    countSMS        INT                NOT NULL,
    countMegabytes  INT                NOT NULL,
    user_id         INT                NOT NULL,
    isActivated     BOOLEAN            NOT NULL,
    CONSTRAINT FOREIGN KEY (user_id)
        REFERENCES users (id)
);

