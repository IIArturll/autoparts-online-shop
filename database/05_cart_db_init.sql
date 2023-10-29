CREATE SCHEMA IF NOT EXISTS  autoparts_shop;

CREATE TABLE IF NOT EXISTS autoparts_shop.cart
(
	id UUID NOT NULL,
	user_id UUID NOT NULL,
	CONSTRAINT cart_pkey PRIMARY KEY (id),
	CONSTRAINT user_id_fk FOREIGN KEY (user_id)
		REFERENCES autoparts_shop.user (id)
);

CREATE TABLE IF NOT EXISTS autoparts_shop.cart_item
(
    id UUID NOT NULL,
	product_id UUID NOT NULL,
	amount INT,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id)
		REFERENCES autoparts_shop.product (id)
);

CREATE TABLE IF NOT EXISTS autoparts_shop.cart_product
(
    cart_id UUID NOT NULL,
    cart_item_id UUID NOT NULL,
    CONSTRAINT cart_id FOREIGN KEY (cart_id)
        REFERENCES autoparts_shop.cart (id),
    CONSTRAINT cart_item_id_pk FOREIGN KEY (cart_item_id)
        REFERENCES autoparts_shop.cart_item (id)
)