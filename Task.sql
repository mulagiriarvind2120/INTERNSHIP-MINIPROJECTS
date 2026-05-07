CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    marks INT,
    attendance INT
);

INSERT INTO students (student_id, name, department, marks, attendance) VALUES
(1, 'Arjun', 'CSE', 85, 90),
(2, 'Meera', 'ECE', 78, 88),
(3, 'Rahul', 'ME', 92, 95),
(4, 'Sneha', 'CSE', 70, 80),
(5, 'Vikram', 'EEE', 81, 86),
(6, 'Priya', 'IT', 60, 75),
(7, 'Kiran', 'CIVIL', 83, 89),
(8, 'Anita', 'CSE', 79, 84),
(9, 'Ravi', 'ECE', 90, 87),
(10, 'Divya', 'ME', 82, 92);

CREATE VIEW eligible_scholarship_students AS
SELECT student_id, name, department, marks, attendance
FROM students
WHERE marks > 80 AND attendance > 85;

SELECT * FROM eligible_scholarship_students;

INSERT INTO eligible_scholarship_students (student_id, name, department, marks, attendance)
VALUES (11, 'Suresh', 'CSE', 75, 90);

CREATE VIEW eligible_scholarship_students AS
SELECT student_id, name, department, marks, attendance
FROM students
WHERE marks > 80 AND attendance > 85
WITH CHECK OPTION;
