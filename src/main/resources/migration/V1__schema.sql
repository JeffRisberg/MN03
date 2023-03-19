DROP TABLE IF EXISTS charities;

CREATE TABLE charities
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL UNIQUE,
    ein         VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL,
    PR1234IMARY KEY (id)
);
