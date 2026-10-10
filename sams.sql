
-- ============================================
-- Student Attendance Management System (SAMS)
-- MySQL 9.5.0
-- DDL: Database and table definitions
-- ============================================

CREATE DATABASE IF NOT EXISTS sams
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci;

USE sams;

CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL,
    PRIMARY KEY (username)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS course (
    course_id VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    subjects VARCHAR(255) NOT NULL,
    duration VARCHAR(50) NOT NULL,
    PRIMARY KEY (course_id)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS student (
    student_id VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    course_id VARCHAR(10) DEFAULT NULL,
    contact VARCHAR(15) DEFAULT NULL,
    PRIMARY KEY (student_id),
    KEY course_id (course_id),
    CONSTRAINT student_ibfk_1
        FOREIGN KEY (course_id)
        REFERENCES course (course_id)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS lecturer (
    lecturer_id VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    subject VARCHAR(255) NOT NULL,
    PRIMARY KEY (lecturer_id)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS class_schedule (
    session_name VARCHAR(100) DEFAULT NULL,
    course_id VARCHAR(20) DEFAULT NULL,
    subject VARCHAR(100) DEFAULT NULL,
    lecturer_id VARCHAR(20) DEFAULT NULL,
    `date` DATE DEFAULT NULL,
    start_time TIME DEFAULT NULL,
    end_time TIME DEFAULT NULL
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS attendance (
    student_id VARCHAR(20) DEFAULT NULL,
    session_name VARCHAR(100) DEFAULT NULL,
    `date` DATE DEFAULT NULL,
    status VARCHAR(20) DEFAULT NULL
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;


-- ============================================
-- PART 2: DML - SAMPLE DATA
-- ============================================

USE sams;

-- 1. COURSES
INSERT INTO course (course_id, name, subjects, duration)
VALUES
('C001', 'Diploma in Information Technology',
 'Programming, Database Systems, Networking', '2 Years'),
('C002', 'Diploma in Software Engineering',
 'Java, Software Design, Web Development', '2 Years'),
('C003', 'Certificate in Business IT',
 'Business Computing, Office Applications', '1 Year'),
('C004', 'Diploma in Computer Science',
 'Algorithms, Data Structures, Operating Systems', '2 Years');

-- 2. LECTURERS
INSERT INTO lecturer (lecturer_id, name, email, subject)
VALUES
('L001', 'Nimal Perera', 'nimal@example.com', 'Java Programming'),
('L002', 'Kumari Silva', 'kumari@example.com', 'Database Systems'),
('L003', 'Amal Fernando', 'amal@example.com', 'Web Development');

-- 3. STUDENTS
INSERT INTO student
(student_id, name, email, course_id, contact)
VALUES
('S001', 'Kasun Perera', 'kasun@example.com', 'C001', '0711111111'),
('S002', 'Amali Silva', 'amali@example.com', 'C001', '0722222222'),
('S003', 'Nuwan Fernando', 'nuwan@example.com', 'C002', '0733333333'),
('S004', 'Tharushi Jayasinghe', 'tharushi@example.com', 'C002', '0744444444'),
('S005', 'Dinuka Bandara', 'dinuka@example.com', 'C003', '0755555555');

-- 4. CLASS SCHEDULES
INSERT INTO class_schedule
(session_name, course_id, subject, lecturer_id, `date`, start_time, end_time)
VALUES
('Java Session 1', 'C002', 'Java Programming', 'L001',
 '2026-10-12', '09:00:00', '11:00:00'),
('Database Session 1', 'C001', 'Database Systems', 'L002',
 '2026-10-12', '13:00:00', '15:00:00'),
('Web Development Session 1', 'C002', 'Web Development', 'L003',
 '2026-10-13', '09:00:00', '11:00:00'),
('Java Session 2', 'C002', 'Java Programming', 'L001',
 '2026-10-14', '09:00:00', '11:00:00');

-- 5. ATTENDANCE
INSERT INTO attendance (student_id, session_name, `date`, status)
VALUES
('S003', 'Java Session 1', '2026-10-12', 'Present'),
('S004', 'Java Session 1', '2026-10-12', 'Present'),
('S001', 'Database Session 1', '2026-10-12', 'Present'),
('S002', 'Database Session 1', '2026-10-12', 'Absent'),
('S003', 'Web Development Session 1', '2026-10-13', 'Present'),
('S004', 'Web Development Session 1', '2026-10-13', 'Absent'),
('S003', 'Java Session 2', '2026-10-14', 'Present'),
('S004', 'Java Session 2', '2026-10-14', 'Present'),
('S001', 'Java Session 1', '2026-10-12', 'Present'),
('S002', 'Java Session 1', '2026-10-12', 'Absent');

-- Demo accounts are not inserted here,
-- so your existing users table is left unchanged.