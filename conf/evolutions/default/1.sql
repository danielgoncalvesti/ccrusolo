# Users schema

# --- !Ups

CREATE SEQUENCE basket_id_seq;
CREATE TABLE basket(
  id BIGINT(20) NOT NULL DEFAULT nextval('basket_id_seq'),
  name varchar(255) NOT NULL,
  urlFriendly varchar(255) NOT NULL,
  description varchar(255),
  price decimal(18,2)
);

CREATE SEQUENCE order_id_seq;
CREATE TABLE order_basket(
  id BIGINT(20) NOT NULL DEFAULT nextval('order_id_seq'),
  place varchar(255) NOT NULL,
  urlFriendly varchar(255) NOT NULL,
  name varchar(255),
  email varchar(255)
);

# --- !Downs

DROP TABLE basket;
DROP SEQUENCE basket_id_seq;

DROP TABLE order_basket;
DROP SEQUENCE order_id_seq;
