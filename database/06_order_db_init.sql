CREATE SCHEMA IF NOT EXISTS autoparts_shop;

CREATE TABLE autoparts_shop.order
(
    id            UUID                     NOT NULL,
    user_id       UUID                     NOT NULL,
    order_time    TIMESTAMP WITH TIME ZONE NOT NULL,
    ready BOOLEAN NOT NULL default FALSE,
    issuance_time TIMESTAMP WITH TIME ZONE,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES autoparts_shop.user
);

CREATE TABLE autoparts_shop.order_product
(
    order_id     UUID NOT NULL,
    cart_item_id UUID NOT NULL,
    FOREIGN KEY (cart_item_id)
        REFERENCES autoparts_shop.cart_order_item (id)
);

CREATE TABLE IF NOT EXISTS autoparts_shop.cart_order_item
(
    id UUID NOT NULL,
    product_id UUID NOT NULL,
    amount INT,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id)
        REFERENCES autoparts_shop.product (id)
);