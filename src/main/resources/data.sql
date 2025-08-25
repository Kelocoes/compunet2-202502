INSERT INTO role (name, description) VALUES 
('Admin', 'Administrator role with full access'),
('User', 'Standard user role with limited access');

-- Insert permissions
INSERT INTO permission (name, description) VALUES 
('view-user', 'Permission to view user details'), -- 1
('delete-user', 'Permission to delete users'), -- 2
('update-user', 'Permission to update user details'), -- 3
('create-user', 'Permission to create new users'), -- 4
('view-role', 'Permission to view roles'), -- 5
('delete-role', 'Permission to delete roles'), -- 6
('update-role', 'Permission to update roles'), -- 7
('create-role', 'Permission to create new roles'), -- 8
('view-game', 'Permission to view games'), -- 9
('delete-game', 'Permission to delete games'), -- 10
('update-game', 'Permission to update games'), -- 11
('create-game', 'Permission to create new games'), -- 12
('view-permission', 'Permission to view permissions'), -- 13
('delete-permission', 'Permission to delete permissions'), -- 14
('update-permission', 'Permission to update permissions'), -- 15
('create-permission', 'Permission to create new permissions'); -- 16

-- Assign permissions to roles
INSERT INTO role_permission (role_id, permission_id) VALUES 
(1, 1), (1, 2), (1, 3), (1, 4),
(1, 5), (1, 6), (1, 7), (1, 8),
(1, 9), (1, 10), (1, 11), (1, 12),
(1, 13), (1, 14), (1, 15), (1, 16),
(2, 1), (2, 9), (2, 12);

-- Insert users
INSERT INTO users (username, email, password_hash, bio, created_at, role_id) VALUES 
('admin', 'admin@example.com', 'hashed_password_1', 'Administrator account', CURRENT_TIMESTAMP, 1),
('user1', 'user1@example.com', 'hashed_password_2', 'Standard user account', CURRENT_TIMESTAMP, 2),
('user2', 'user2@example.com', 'hashed_password_3', 'Standard user account', CURRENT_TIMESTAMP, 2),
('user3', 'user3@example.com', 'hashed_password_4', 'Standard user account', CURRENT_TIMESTAMP, 2);

-- Insert sample games
INSERT INTO game (name, description, min_players, max_players, genre, created_by) VALUES
('Catan', 'A strategy game about resource management and trading.', 3, 4, 'Strategy', 2),
('Ticket to Ride', 'A railway-themed board game.', 2, 5, 'Family', 2),
('Pandemic', 'A cooperative game where players work together to stop global outbreaks.', 2, 4, 'Cooperative', 2),
('Carcassonne', 'A tile-placement game where players build cities and roads.', 2, 5, 'Strategy', 2),
('Codenames', 'A word game where players guess the right words based on clues.', 2, 8, 'Party', 2),
('Azul', 'A tile-drafting game inspired by Portuguese tiles.', 2, 4, 'Abstract', 3),
('7 Wonders', 'A card drafting game about building civilizations.', 3, 7, 'Strategy', 3),
('Splendor', 'A game about collecting gems and building developments.', 2, 4, 'Card Game', 3),
('Dixit', 'A storytelling game with beautifully illustrated cards.', 3, 6, 'Party', 3),
('King of Tokyo', 'A dice game where players compete as monsters for dominance.', 2, 6, 'Dice', 3);
