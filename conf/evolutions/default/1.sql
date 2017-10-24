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

# --- !Downs

DROP TABLE basket;
DROP SEQUENCE basket_id_seq;

