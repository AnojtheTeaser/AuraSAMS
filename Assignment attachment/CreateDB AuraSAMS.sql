
CREATE DATABASE AuraEducation;


USE AuraEducation;



CREATE TABLE course (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL
    
);



CREATE TABLE students (
    stu_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    tel VARCHAR(20),
    course_id INT,
    FOREIGN KEY (course_id) REFERENCES course(course_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);


CREATE TABLE subjects (
    sub_id INT AUTO_INCREMENT PRIMARY KEY,
    sub_name VARCHAR(100) NOT NULL
    
);


CREATE TABLE course_subjects (
    cst_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    sub_id INT NOT NULL,
    CONSTRAINT fk_course_subject_course
    FOREIGN KEY (course_id) REFERENCES course(course_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_course_subject_subject

    FOREIGN KEY (sub_id) REFERENCES subjects(sub_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE

);

CREATE TABLE lecturer (
    lec_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    tel VARCHAR(20)
   
    
);



CREATE TABLE lecturer_subjects (
    lst_id INT AUTO_INCREMENT PRIMARY KEY,
     lec_id INT NOT NULL,
     sub_id INT NOT NULL,

       CONSTRAINT fk_lecturer_subject_lecturer
       FOREIGN KEY (lec_id) REFERENCES lecturer(lec_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
        CONSTRAINT fk_lecturer_subject_subjects
       FOREIGN KEY (sub_id) REFERENCES subjects(sub_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
   
);




CREATE TABLE  class_schedule (

    sched_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    sub_id INT NOT NULL,
    lec_id INT NOT NULL,
    date DATE NOT NULL,
    time TIME NOT NULL,

 CONSTRAINT fk_class_schedule_course
       FOREIGN KEY (course_id) REFERENCES course(course_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
   CONSTRAINT fk_class_schedule_subjects
       FOREIGN KEY (sub_id) REFERENCES subjects(sub_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
     CONSTRAINT fk_class_schedule_lecturer
       FOREIGN KEY (lec_id) REFERENCES lecturer (lec_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE


);


CREATE TABLE attendance(
    att_id INT AUTO_INCREMENT PRIMARY KEY,
    sched_id INT NOT NULL,
    stu_id INT NOT NULL,
    status ENUM('PRESENT', 'LATE', 'ABSENT') NOT NULL,
    

    CONSTRAINT fk_attendance_students
       FOREIGN KEY (stu_id) REFERENCES students(stu_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_attendance_schedule
       FOREIGN KEY (sched_id) REFERENCES class_schedule(sched_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
   
);

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KET,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
























