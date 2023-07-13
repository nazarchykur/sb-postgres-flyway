CREATE SEQUENCE IF NOT EXISTS authorities_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE authorities
(
    id   BIGINT      NOT NULL,
    name VARCHAR(25) NOT NULL,
    CONSTRAINT pk_authorities PRIMARY KEY (id)
);

ALTER TABLE authorities
    ADD CONSTRAINT uc_authorities_name UNIQUE (name);