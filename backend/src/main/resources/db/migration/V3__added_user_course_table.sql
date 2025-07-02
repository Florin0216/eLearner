CREATE TABLE user_course
(
    course_id BIGINT NOT NULL,
    user_id   BIGINT NOT NULL,
    CONSTRAINT pk_user_course PRIMARY KEY (course_id, user_id)
);

ALTER TABLE course
    RENAME COLUMN creation_time TO creation_date;

ALTER TABLE user_course
    ADD CONSTRAINT fk_usecou_on_course FOREIGN KEY (course_id) REFERENCES course (id);

ALTER TABLE user_course
    ADD CONSTRAINT fk_usecou_on_user FOREIGN KEY (user_id) REFERENCES users (id);