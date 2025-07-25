CREATE TABLE course
(
    id                BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name              VARCHAR(255)                            NOT NULL,
    description       VARCHAR(255),
    creation_time     TIMESTAMP WITHOUT TIME ZONE,
    domain            VARCHAR(255)                            NOT NULL,
    educational_stage VARCHAR(255)                            NOT NULL,
    grade             VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_course PRIMARY KEY (id)
);

CREATE TABLE material
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name       VARCHAR(255)                            NOT NULL,
    url        VARCHAR(255)                            NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    course_id  BIGINT,
    CONSTRAINT pk_material PRIMARY KEY (id)
);

ALTER TABLE course
    ADD CONSTRAINT uc_course_name UNIQUE (name);

ALTER TABLE material
    ADD CONSTRAINT FK_MATERIAL_ON_COURSE FOREIGN KEY (course_id) REFERENCES course (id);