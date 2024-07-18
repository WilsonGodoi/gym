CREATE TABLE exercise_type
(
    type VARCHAR(15) PRIMARY KEY,
    groupType VARCHAR(15) NOT NULL,
    FOREIGN KEY (groupType) REFERENCES exercise_group_type (type)
);

INSERT INTO exercise_type (type, groupType)
VALUES ('TREADMILL', 'CARDIO');