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
	cart_id UUID NOT NULL,
	product_id UUID NOT NULL,
	amount INT,
	FOREIGN KEY (cart_id)
		REFERENCES autoparts_shop.cart (id),
	FOREIGN KEY (product_id)
		REFERENCES autoparts_shop.product (id)
);