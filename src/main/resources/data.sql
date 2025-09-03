INSERT INTO role (name, description) VALUES
('Admin', 'Administrator role with full access');

INSERT INTO users (username, email, password_hash, bio, created_at, role_id) VALUES
('Kelo', 'kevin@gmail.com', 'secreta', 'Bio', CURRENT_TIMESTAMP, 1);

INSERT INTO permission (name, description) VALUES
('READ_PRIVILEGES', 'Grants read access to resources'),
('WRITE_PRIVILEGES', 'Grants write access to resources'),
('DELETE_PRIVILEGES', 'Grants delete access to resources');

INSERT INTO role_permission (role_id, permission_id) VALUES
(1, 1),
(1, 2),
(1, 3);