CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE tbl_payment (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
     client_id UUID NOT NULL,
     amount NUMERIC NOT NULL,
     method VARCHAR(50) NOT NULL,
     status VARCHAR(50) NOT NULL,
     date TIMESTAMP NOT NULL,
     CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES tbl_account(id)
);
