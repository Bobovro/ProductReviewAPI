INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO users(username, password) VALUES ('user','$2a$12$runcSibW4dZseJqQmRIgsOuyRkJC2aiU8UI1J.G0dKGYgW6vQPWNa'); --password: 12345
INSERT INTO users(username, password) VALUES ('admin','$2a$12$runcSibW4dZseJqQmRIgsOuyRkJC2aiU8UI1J.G0dKGYgW6vQPWNa'); --password: 12345
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
