DROP TABLE customers IF EXISTS

CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255));

INSERT INTO customers (id, first_name, last_name) VALUES
  (1, 'Bruno', 'NaoGiannotti');