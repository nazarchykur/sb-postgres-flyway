CREATE TABLE accounts_authorities
(
    account_id   BIGINT NOT NULL,
    authority_id BIGINT NOT NULL,
    CONSTRAINT pk_accounts_authorities PRIMARY KEY (account_id, authority_id)
);

ALTER TABLE accounts_authorities
    ADD CONSTRAINT fk_accounts_authorities_on_account FOREIGN KEY (account_id) REFERENCES accounts (id);

ALTER TABLE accounts_authorities
    ADD CONSTRAINT fk_accounts_authorities_on_authority FOREIGN KEY (authority_id) REFERENCES authorities (id);