INSERT INTO course (course_id, course_name) VALUES
(1, 'BIT'),
(2, 'HND Computing'),
(3, 'Software Engineering'),
(4, 'HR');



INSERT INTO students (stu_id, name, email, tel, course_id) VALUES
(1, 'kalum rasanga', 'kalum@gmail.com', '0711111989', 3),
(2, 'jayan gunawardana', 'jayan@gmail.com', '0711112222', 3),
(3, 'imesh madushan', 'imesh@gmail.com', '07144444', 3),
(4, 'madushan bandara', 'madushan@gmail.com', '0711111100', 1),
(5, 'sunil jayawickrama', 'sunil@amailcom', '0711111909', 1),
(6, 'rasith udayanga', 'rasith@gmail.com', '0711111188', 3),
(7, 'nisal alahakon', 'nisal2gmail.com', '0711111109', 1),
(8, 'rajith yatagedra', 'rajith@gmail.com', '0711112222', 4),
(9, 'malith sadun', 'malith@gmail.com', '0711111112', 1),
(10, 'malith dasanayaka', 'malithda@gmail.com', '07134343223', 4),
(11, 'tharindu siriwardana', 'tharindu@gmail.com', '0713434111', 1),
(12, 'tharindu akash', 'tharinduakash@gmail.com', '0713432321', 4),
(13, 'chamiika karunarathna', 'chamika@gmail.com', '0713454543', 2),
(14, 'namal bandara', 'namal@gmail.com', '0713439987', 3),
(15, 'sumudu deshan', 'sumudu@gmail.com', '0713433456', 2),
(16, 'rangana rusiru', 'rangana@gmail.com', '0713434222', 3),
(17, 'malisha malshan', 'malisha @gmail.com', '0713434777', 2),
(18, 'dilshan maleesha', 'dilshan@gmail.com', '0713499877', 3),
(19, 'kasun kalhara', 'kasun@gmail.com', '0713676767', 2),
(20, 'dsun sanjaaya', 'dasun@gmail.com', '0713436611', 2);




INSERT INTO subjects (sub_id, sub_name) VALUES
(1, 'Database Systems'),
(2, 'Programming Fundamentals'),
(3, 'Web Development'),
(4, 'Networking Fundamentals'),
(5, 'Information Security'),
(6, 'Object Oriented Programming'),
(7, 'Data Structures'),
(8, 'Operating Systems'),
(9, 'Software Engineering'),
(10, 'Cloud Computing'),
(11, 'CoreHR'),
(12, 'Business & Stratergy'),
(13, 'Legal & complaince'),
(14, 'data & Tech');




INSERT INTO course_subjects (cst_id, course_id, sub_id) VALUES
(49, 1, 1),
(50, 1, 3),
(51, 2, 2),
(52, 2, 4),
(53, 2, 7),
(54, 3, 5),
(55, 3, 6),
(56, 3, 8),
(57, 3, 9),
(58, 3, 10),
(59, 4, 11),
(60, 4, 12),
(61, 4, 13),
(62, 4, 14);




INSERT INTO lecturer (lec_id, name, email, tel) VALUES
(1, 'nimal perera', 'nimal@gmail', '0122222222'),
(2, 'kamal', 'kamal@gmail.com', '0713333333'),
(3, 'perera', 'perera@gamail.com', '071222121212'),
(4, 'wimitha kaleum', 'wimitha@gamaill.com', '07446464646'),
(5, 'darshana withana', 'darshana@gmail.com', '0767676767'),
(6, 'kalhara sadun', 'kalhara@gmail.com', '0746464646'),
(7, 'kulitha nissanka', 'kulitha@gamil.com', '076543232'),
(8, 'madura rangana', 'madura@gmail.com', '077222243'),
(9, 'dushen bandara', 'dushen@gmail.com', '077888888'),
(10, 'nirawan dasanayaka', 'nirwan@gmail.com', '077777667');




INSERT INTO lecturer_subjects (lst_id, lec_id, sub_id) VALUES
(27, 1, 1),
(28, 2, 2),
(29, 3, 3),
(30, 4, 4),
(31, 5, 14),
(32, 6, 13),
(33, 6, 12),
(34, 7, 11),
(35, 8, 5),
(36, 8, 6),
(37, 8, 10),
(38, 9, 7),
(39, 9, 8),
(40, 10, 9);





INSERT INTO class_schedule (sched_id, course_id, sub_id, lec_id, date, time) VALUES
(14, 3, 10, 8, '2026-07-05', '09:00:00'),
(15, 3, 5, 8, '2026-07-05', '10:00:00'),
(16, 3, 8, 9, '2026-07-05', '11:00:00'),
(17, 3, 6, 8, '2026-07-05', '13:00:00'),
(18, 3, 9, 10, '2026-07-05', '15:00:00'),
(19, 1, 1, 1, '2026-07-12', '09:00:00'),
(20, 1, 3, 3, '2026-07-12', '11:00:00'),
(21, 2, 2, 2, '2026-07-12', '10:00:00'),
(22, 2, 4, 4, '2026-07-12', '11:00:00'),
(23, 2, 7, 9, '2026-07-12', '13:00:00'),
(25, 4, 11, 7, '2026-07-15', '16:00:00'),
(26, 4, 12, 6, '2026-07-16', '16:00:00'),
(27, 4, 13, 6, '2026-07-16', '13:00:00'),
(28, 4, 14, 5, '2026-07-17', '16:00:00');






INSERT INTO attendance (att_id, sched_id, stu_id, status) VALUES
(37, 14, 1, 'PRESENT'),
(38, 14, 2, 'LATE'),
(39, 14, 3, 'PRESENT'),
(40, 14, 6, 'PRESENT'),
(41, 14, 14, 'PRESENT'),
(42, 14, 16, 'PRESENT'),
(43, 14, 18, 'PRESENT'),
(44, 15, 1, 'PRESENT'),
(45, 15, 2, 'PRESENT'),
(46, 15, 3, 'PRESENT'),
(47, 15, 6, 'PRESENT'),
(48, 15, 14, 'PRESENT'),
(49, 15, 16, 'PRESENT'),
(50, 15, 18, 'PRESENT'),
(51, 16, 1, 'PRESENT'),
(52, 16, 2, 'PRESENT'),
(53, 16, 3, 'PRESENT'),
(54, 16, 6, 'PRESENT'),
(55, 16, 14, 'PRESENT'),
(56, 16, 16, 'PRESENT'),
(57, 16, 18, 'PRESENT'),
(58, 17, 1, 'PRESENT'),
(59, 17, 2, 'PRESENT'),
(60, 17, 3, 'PRESENT'),
(61, 17, 6, 'PRESENT'),
(62, 17, 14, 'PRESENT'),
(63, 17, 16, 'PRESENT'),
(64, 17, 18, 'ABSENT'),
(65, 18, 1, 'PRESENT'),
(66, 18, 2, 'PRESENT'),
(67, 18, 3, 'PRESENT'),
(68, 18, 6, 'PRESENT'),
(69, 18, 14, 'PRESENT'),
(70, 18, 16, 'ABSENT'),
(71, 18, 18, 'ABSENT'),
(72, 19, 4, 'PRESENT'),
(73, 19, 5, 'PRESENT'),
(74, 19, 7, 'PRESENT'),
(75, 19, 9, 'PRESENT'),
(76, 19, 11, 'PRESENT'),
(77, 20, 4, 'PRESENT'),
(78, 20, 5, 'PRESENT'),
(79, 20, 7, 'PRESENT'),
(80, 20, 9, 'PRESENT'),
(81, 20, 11, 'PRESENT');




INSERT INTO users (user_id, username, password) VALUES
(1, 'LECkamal', '12345678'),
(2, 'ADMpasan', '11223344');
