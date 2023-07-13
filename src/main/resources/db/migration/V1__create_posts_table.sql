CREATE TABLE posts
(
    id      BIGINT NOT NULL,
    title   VARCHAR(255),
    content TEXT,
    CONSTRAINT pk_posts PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS posts_seq
    START WITH 1
    INCREMENT BY 50;