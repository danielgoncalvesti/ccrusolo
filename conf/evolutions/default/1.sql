# Users schema

# --- !Ups

CREATE TABLE basket(
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  urlfriendly varchar(255) NOT NULL,
  description varchar(255), 
  price decimal(18,2),
  PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE basket;
