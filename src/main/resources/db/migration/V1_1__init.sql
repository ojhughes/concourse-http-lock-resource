CREATE TABLE pools
(
  id   SERIAL  NOT NULL,
  name VARCHAR NOT NULL,

  CONSTRAINT pools_pkey
  PRIMARY KEY (id)
);

CREATE UNIQUE INDEX pools_id_uindex
  ON pools (id);

CREATE UNIQUE INDEX pools_name_uindex
  ON pools (name);

COMMENT ON TABLE pools IS 'A pool is a logical grouping of environments eg all environments having version 1.12';

CREATE TABLE environments
(
  id       SERIAL  NOT NULL,
  name     VARCHAR NOT NULL,
  metadata JSON    NOT NULL,
  lock_id  INTEGER,
  pool_id  INTEGER NOT NULL,

  CONSTRAINT environments_pkey
  PRIMARY KEY (id),

  CONSTRAINT environments_pools_id_fk
  FOREIGN KEY (pool_id) REFERENCES pools
  ON DELETE SET NULL
);

CREATE UNIQUE INDEX environments_id_uindex
  ON environments (id);

CREATE UNIQUE INDEX environments_name_uindex
  ON environments (name);

CREATE UNIQUE INDEX environments_lock_id_uindex
  ON environments (lock_id);

COMMENT ON TABLE environments IS 'Each environment represents a managed test PCF environment';

CREATE TABLE locks
(
  id             SERIAL                                       NOT NULL,
  claimed_time   TIMESTAMP DEFAULT (now() AT TIME ZONE 'utc') NOT NULL,
  claimed_by     VARCHAR                                      NOT NULL,
  environment_id INTEGER                                      NOT NULL,

  CONSTRAINT locks_pkey
  PRIMARY KEY (id),

  CONSTRAINT locks_environments_lock_id_fk
  FOREIGN KEY (environment_id) REFERENCES environments (lock_id)
  ON DELETE SET NULL
);

CREATE UNIQUE INDEX locks_id_uindex
  ON locks (id);

CREATE UNIQUE INDEX locks_environment_id_uindex
  ON locks (environment_id);

COMMENT ON TABLE locks IS 'A single lock exists when an environment is claimed by a job or person. When the lock is released, the lock is deleted';

CREATE TABLE environment_meta_schema
(
  schema JSON              NOT NULL,
  id     INTEGER DEFAULT 1 NOT NULL,

  CONSTRAINT environment_meta_schema_id_pk
  PRIMARY KEY (id),

  CHECK (id = 1)
);

COMMENT ON TABLE environment_meta_schema IS 'This table has a single row describing the schema that decribes an environments metadata';