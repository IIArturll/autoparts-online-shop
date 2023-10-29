CREATE SCHEMA IF NOT EXISTS autoparts_shop;

CREATE TABLE IF NOT EXISTS autoparts_shop.user_status
(
    id SMALLSERIAL NOT NULL,
    status TEXT NOT NULL UNIQUE,
    CONSTRAINT user_status_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS autoparts_shop.user_role
(
    id SMALLSERIAL NOT NULL,
    role TEXT NOT NULL UNIQUE,
    CONSTRAINT user_role_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS autoparts_shop.user
(
    id UUID NOT NULL,
    email TEXT NOT NULL UNIQUE,
    first_name TEXT NOT NULL,
    second_name TEXT NOT NULL,
    role SMALLINT NOT NULL,
    status SMALLINT NOT NULL,
    phone_number TEXT NOT NULL,
    password TEXT NOT NULL,
    CONSTRAINT uuid_user PRIMARY KEY (id),
    FOREIGN KEY (role)
        REFERENCES autoparts_shop.user_role (id),
    FOREIGN KEY (status)
        REFERENCES autoparts_shop.user_status (id)
);