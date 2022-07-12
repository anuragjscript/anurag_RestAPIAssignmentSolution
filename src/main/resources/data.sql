INSERT INTO users (id, username, password) VALUES 
(1, 'superadmin', '$2a$12$1G14mKd97MtUT11UoDuRy.BfyPE98Js5VliYdjUPb9.7/MyADlPmq');

INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);

INSERT INTO EMPLOYEE (id, email, first_name, last_name) VALUES 
(1, 'john.doe@emsproject.com', 'John', 'Doe'),
(2, 'donald.trump@emsproject.com', 'Donald', 'Trump'),
(3, 'emanuel.macron@emsproject.com', 'Emanuel', 'Macron'),
(4, 'anurag.jaisingh@emsproject.com', 'Anurag', 'Jaisingh'),
(5, 'brock.lesnar@emsproject.com', 'Brock', 'Lesnar'),
(6, 'vladimir.putin@emsproject.com', 'Vladimir', 'Putin'),
(7, 'nikki.halley@emsproject.com', 'Nikki', 'Halley'),
(8, 'satya.nadela@emsproject.com', 'Satya', 'Nadela'),
(9, 'emanuel.kant@emsproject.com', 'Emanuel', 'Kant'),
(10, 'donald.duck@emsproject.com', 'Donald', 'Duck');
