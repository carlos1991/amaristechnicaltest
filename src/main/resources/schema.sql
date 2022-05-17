CREATE TABLE prices (
	id int8 NOT NULL DEFAULT nextval ('price_id_seq'),
	brand_id int8 NOT NULL,
	start_date TIMESTAMP NOT NULL,
	end_date TIMESTAMP NOT NULL,
	fare int8 NOT NULL,
	product_id int8 NOT NULL,
	priority int4 NOT NULL,
	price numeric(19,2) NOT NULL,
	currency varchar(3) NOT NULL,
	CONSTRAINT price_pkey PRIMARY KEY (id)
);