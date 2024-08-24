SET search_path TO opendelivery;

CREATE TABLE source_app_data (
    id          UUID PRIMARY KEY,
    description VARCHAR(100) UNIQUE
);

CREATE TABLE order_data (
    id                  UUID PRIMARY KEY,
    source_app_id       UUID,
    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    merchant_id         UUID      NOT NULL UNIQUE,
    date                DATE      NOT NULL,
    order_external_code VARCHAR(255),

    CONSTRAINT fk_source_app FOREIGN KEY (source_app_id) REFERENCES source_app_data (id)
);

CREATE TABLE event_data (
    id                      UUID PRIMARY KEY,
    source_app_id           UUID,
    order_id                UUID         NOT NULL UNIQUE,
    created_at              TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date                    DATE         NOT NULL,
    accepted_at             DATE         NOT NULL,
    event_type              VARCHAR(255) NOT NULL,
    CONSTRAINT fk_source_app FOREIGN KEY (source_app_id) REFERENCES source_app_data (id)
);
