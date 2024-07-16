CREATE TABLE exercise_type
(
    type VARCHAR(15) PRIMARY KEY,
    group_type VARCHAR(15) NOT NULL,
    FOREIGN KEY (group_type) REFERENCES exercise_group_type (type)
);

INSERT INTO exercise_type (type, group_type)
VALUES ('TREADMILL', 'CARDIO');