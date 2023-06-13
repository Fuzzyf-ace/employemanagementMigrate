DROP TABLE IF EXISTS employers_employees;
DROP TABLE IF EXISTS work_records;
DROP TABLE IF EXISTS shifts;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS employers;


CREATE TABLE employers
(
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email      VARCHAR(45) UNIQUE NOT NULL,
    password   TEXT NOT NULL,
    first_name VARCHAR(45),
    last_name  VARCHAR(45)
--     user_role  INT
);

INSERT INTO employers (email, password, first_name, last_name)
VALUES ('init1@example.com', 'password', 'david', 'a'),
       ('init2@example.com', 'password','daiming', 'yang');



CREATE TABLE employees
(
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email      VARCHAR(45) UNIQUE NOT NULL,
    password   TEXT NOT NULL,
    first_name VARCHAR(45),
    last_name  VARCHAR(45),
    active     BOOLEAN,
    pay_rate   DECIMAL(10),
--     user_role  INT,
    employer_id   UUID,
    CONSTRAINT fk_employees_employer FOREIGN KEY (employer_id) REFERENCES employers (id)
);




CREATE TABLE shifts
(
    id            UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    employer_id      UUID,
    employee_id      UUID,
    description   TEXT NOT NULL,
    start_time    TIMESTAMP NOT NULL,
    end_time      TIMESTAMP NOT NULL,
    CONSTRAINT fk_shifts_employee FOREIGN KEY (employee_id) REFERENCES employees (id),
    CONSTRAINT fk_shifts_employer FOREIGN KEY (employer_id) REFERENCES employers (id)
);

CREATE TABLE work_records
(
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    employee_id   UUID,
    shift_id      UUID,
    start_time TIMESTAMP,
    end_time   TIMESTAMP,
    CONSTRAINT fk_work_records_employee FOREIGN KEY (employee_id) REFERENCES employees (id),
    CONSTRAINT fk_work_records_shift FOREIGN KEY (shift_id) REFERENCES shifts (id)
);