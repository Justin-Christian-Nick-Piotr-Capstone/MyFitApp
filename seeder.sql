DROP DATABASE IF EXISTS myFitApp_db;
CREATE DATABASE IF NOT EXISTS myFitApp_db;
USE myFitApp_db;
CREATE TABLE users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       username VARCHAR(50),
                       email VARCHAR(50),
                       password VARCHAR(100),
                       height INT UNSIGNED NOT NULL,
                       age INT UNSIGNED NOT NULL,
                       gender VARCHAR(6),
                       maintenance_calories INT UNSIGNED NOT NULL,
                       starting_weight INT UNSIGNED NOT NULL,
                       target_weight INT UNSIGNED NOT NULL,
                       profile_visibility VARCHAR(10),
                       progress INT UNSIGNED NOT NULL,
                       PRIMARY KEY (id)
);
CREATE TABLE custom_meals (
                              id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                              user_id INT UNSIGNED NOT NULL,
                              query TEXT,
                              calories INT UNSIGNED,
                              PRIMARY KEY (id),
                              FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE custom_exercises (
                                  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                  user_id INT UNSIGNED NOT NULL,
                                  query TEXT,
                                  calories INT UNSIGNED,
                                  PRIMARY KEY (id),
                                  FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE daily_log (
                           id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                           date DATE,
                           exercise_query TEXT,
                           meals_query TEXT,
                           target_calories INT UNSIGNED,
                           current_calories INT UNSIGNED,
                           user_id INT UNSIGNED NOT NULL,
                           PRIMARY KEY (id),
                           FOREIGN KEY (user_id) REFERENCES users(id)
);

SHOW TABLES;

DESCRIBE users;

INSERT INTO users(username, email, password, height, age, gender, maintenance_calories, starting_weight, target_weight, profile_visibility, progress)
VALUES ('testuser1', 'testuser1@gmailcom', 'password', 72, 22, 'male', 3000, 220, 190, 'public', 0);


INSERT INTO custom_exercises(user_id, query, calories)
VALUES (1, '3 mile run', 500);

INSERT INTO custom_meals(user_id, query, calories)
VALUES (1, '5 potatoes', 750);

INSERT INTO daily_log(date, exercise_query, meals_query, target_calories, current_calories, user_id)
VALUES ('2022-12-01', '5 mile run', '5 eggs, 1 banana, 1lb ground beef', 2500, 2400, 1);


