CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE public.shoestore_user
(
    user_id bigint NOT NULL,
    firstname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    lastname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_group character varying(255) COLLATE pg_catalog."default" NOT NULL,
    username character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT shoestore_user_pkey PRIMARY KEY (user_id),
    CONSTRAINT uk_8rh1g9t7ml05jh7jaicunkr5n UNIQUE (username)
);

CREATE SEQUENCE user_sequence OWNED BY public.shoestore_user.user_id;

CREATE TABLE public.price
(
    price_id bigint NOT NULL,
    price real NOT NULL,
    CONSTRAINT price_pkey PRIMARY KEY (price_id)
);

CREATE SEQUENCE price_sequence OWNED BY public.price.price_id;

CREATE TABLE public.shoe
(
    shoe_id bigint NOT NULL,
    inventory integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    realse_date timestamp without time zone NOT NULL,
    size character varying(255) COLLATE pg_catalog."default" NOT NULL,
    price_price_id bigint,
    CONSTRAINT shoe_pkey PRIMARY KEY (shoe_id),
    CONSTRAINT fkpjb9k5vpukl9kobfqbff5yghe FOREIGN KEY (price_price_id)
        REFERENCES public.price (price_id) MATCH SIMPLE
);

CREATE SEQUENCE shoe_sequence OWNED BY public.shoe.shoe_id;

CREATE TABLE public.purchase
(
    purchase_id bigint NOT NULL,
    shoe_shoe_id bigint,
    user_user_id bigint,
    CONSTRAINT purchase_pkey PRIMARY KEY (purchase_id),
    CONSTRAINT fk3og42a2r6t5qwcvttyoui6m2w FOREIGN KEY (user_user_id)
        REFERENCES public.shoestore_user (user_id) MATCH SIMPLE,
    CONSTRAINT fk8mm9akgcvl7itkgjt0oc99stq FOREIGN KEY (shoe_shoe_id)
        REFERENCES public.shoe (shoe_id) MATCH SIMPLE
);

CREATE SEQUENCE purchase_sequence OWNED BY public.purchase.purchase_id;


INSERT INTO public.shoestore_user (user_id, username, password, user_group, firstname, lastname)
VALUES (1, 'NickD', crypt('test', gen_salt('bf', 8)), 'ADMIN', 'Nick', 'Durrer');
