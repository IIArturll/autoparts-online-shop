CREATE SCHEMA IF NOT EXISTS autoparts_shop;

CREATE TABLE IF NOT EXISTS autoparts_shop.verification
(
    email text NOT NULL,
    code  text NOT NULL,
    CONSTRAINT verification_pkey PRIMARY KEY (email)
);