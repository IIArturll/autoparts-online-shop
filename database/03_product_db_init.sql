CREATE SCHEMA IF NOT EXISTS autoparts_shop;

CREATE TABLE IF NOT EXISTS autoparts_shop.product_category
(
    id       SMALLSERIAL NOT NULL,
    category TEXT        NOT NULL UNIQUE,
    CONSTRAINT product_category_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS autoparts_shop.car_brand
(
    id    SMALLSERIAL NOT NULL,
    brand TEXT        NOT NULL UNIQUE,
    CONSTRAINT car_brand_pkey PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS autoparts_shop.product_manufacturer
(
    id           SMALLSERIAL NOT NULL,
    manufacturer TEXT        NOT NULL UNIQUE,
    CONSTRAINT manufacturer_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS autoparts_shop.product
(
    id           UUID     NOT NULL,
    title        TEXT     NOT NULL,
    category     SMALLINT NOT NULL,
    car_brand    SMALLINT NOT NULL,
    description  TEXT     NOT NULL,
    manufacturer SMALLINT NOT NULL,
    img_url      Text,
    price        DECIMAL  NOT NULL,
    amount       INT      NOT NULL,
    CONSTRAINT uuid_product PRIMARY KEY (id),
    FOREIGN KEY (category)
        REFERENCES autoparts_shop.product_category (id),
    FOREIGN KEY (car_brand)
        REFERENCES autoparts_shop.car_brand (id),
    FOREIGN KEY (manufacturer)
        REFERENCES autoparts_shop.product_manufacturer (id)
);