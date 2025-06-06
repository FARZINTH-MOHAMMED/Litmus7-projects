CREATE TABLE student(
    student_id INT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    email_address VARCHAR(40) UNIQUE,
    DOB DATE
);

CREATE TABLE course(
    course_code VARCHAR(20) PRIMARY KEY,
    title VARCHAR(40) NOT NULL,
    description VARCHAR(60),
    instructor VARCHAR(40)
);

CREATE TABLE advisor(
    advisor_id INT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    email_address VARCHAR(40) UNIQUE,
    specialization VARCHAR(40)
);

CREATE TABLE student_course_map(
    student_id INT NOT NULL,
    course_code VARCHAR(20) NOT NULL,
    course_name VARCHAR(40),
    status VARCHAR(20)
);

ALTER TABLE student ADD advisor_id INT;
ALTER TABLE student ADD FOREIGN KEY (advisor_id) REFERENCES advisor(advisor_id) ON DELETE SET NULL;
