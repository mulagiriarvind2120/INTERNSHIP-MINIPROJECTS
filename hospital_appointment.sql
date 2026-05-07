CREATE TABLE Doctors (
    doctor_id INT PRIMARY KEY,
    doctor_name VARCHAR(50),
    specialization VARCHAR(50),
    max_patients_per_day INT,
    booked_patients INT DEFAULT 0
);

CREATE TABLE Patients (
    patient_id INT PRIMARY KEY,
    patient_name VARCHAR(50)
);

CREATE TABLE Appointments (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id)
);

-- Doctors
INSERT INTO Doctors VALUES
(1, 'Dr. Sharma', 'Cardiology', 3, 0),
(2, 'Dr. Mehta', 'Orthopedics', 2, 0),
(3, 'Dr. Reddy', 'Dermatology', 4, 0),
(4, 'Dr. Khan', 'Neurology', 2, 0),
(5, 'Dr. Patel', 'General', 5, 0);

-- Patients
INSERT INTO Patients VALUES
(1, 'Rahul'), (2, 'Sneha'), (3, 'Arjun'),
(4, 'Priya'), (5, 'Vikram'), (6, 'Anita'),
(7, 'Ravi'), (8, 'Kiran'), (9, 'Neha'), (10, 'Amit');

DELIMITER //

CREATE PROCEDURE book_appointment(
    IN p_patient_id INT,
    IN p_doctor_id INT,
    IN p_date DATE
)
BEGIN
    DECLARE maxSlots INT;
    DECLARE booked INT;

    -- Get doctor limits
    SELECT max_patients_per_day, booked_patients
    INTO maxSlots, booked
    FROM Doctors
    WHERE doctor_id = p_doctor_id;

    -- Check availability
    IF booked < maxSlots THEN
        -- Insert appointment
        INSERT INTO Appointments(patient_id, doctor_id, appointment_date)
        VALUES (p_patient_id, p_doctor_id, p_date);

        -- Update booked count
        UPDATE Doctors
        SET booked_patients = booked_patients + 1
        WHERE doctor_id = p_doctor_id;

        SELECT 'Appointment booked successfully!' AS message;
    ELSE
        SELECT 'Doctor not available today' AS message;
    END IF;
END //

DELIMITER ;

CALL book_appointment(3, 1, '2026-03-15');

CALL book_appointment(3,1,'2026-03-15');

CALL book_appointment(3,1,'2026-03-15');
