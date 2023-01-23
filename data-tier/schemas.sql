CREATE DATABASE yorkuniversity;

USE yorkuniversity;

CREATE TABLE user (
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR (15) UNIQUE NOT NULL,
    email VARCHAR (64) UNIQUE NOT NULL,
    password VARCHAR (32) NOT NULL,
    account_type VARCHAR (64) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE post (
    post_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR (15) NOT NULL,
    title VARCHAR (50) NOT NULL,
    content VARCHAR (255) NOT NULL,
    date_time_created DATETIME NOT NULL DEFAULT NOW(),
    media_url VARCHAR (255) UNIQUE,
    likes_count INT NOT NULL DEFAULT 0,
    PRIMARY KEY(post_id, username),
    FOREIGN KEY (username) REFERENCES user (username)
);

CREATE TABLE comment (
	comment_id INT NOT NULL AUTO_INCREMENT,
    post_id INT NOT NULL,
    username VARCHAR (15) NOT NULL,
    content VARCHAR (255) NOT NULL,
    date_time_created DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY(comment_id, post_id),
    FOREIGN KEY (post_id) REFERENCES post (post_id),
    FOREIGN KEY (username) REFERENCES user (username)
);

CREATE TABLE reply (
	reply_id INT NOT NULL AUTO_INCREMENT,
    comment_id INT NOT NULL,
    username VARCHAR (15) NOT NULL,
    content VARCHAR (255) NOT NULL,
    date_time_created DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY(reply_id, comment_id),
    FOREIGN KEY (comment_id) REFERENCES comment (comment_id),
    FOREIGN KEY (username) REFERENCES user (username)
);

CREATE TABLE event (
    event_id INT NOT NULL AUTO_INCREMENT,
    owner VARCHAR (15) NOT NULL,
    category VARCHAR (15) NOT NULL,
    event_type VARCHAR (64) NOT NULL,
    event_title VARCHAR (50) NOT NULL,
    event_description VARCHAR (255) NOT NULL,
    date_time_created DATETIME NOT NULL DEFAULT NOW(),
    event_date DATE,
    event_time TIME,
    event_location VARCHAR (255),
    media_url VARCHAR (255) UNIQUE,
    event_status VARCHAR (64) NOT NULL,
    likes_count INT NOT NULL DEFAULT 0,
    PRIMARY KEY(event_id, owner),
    FOREIGN KEY (owner) REFERENCES user (username)
);

CREATE TABLE booked_event (
    event_id INT NOT NULL,
    attender_username VARCHAR (15) NOT NULL,
    attender_university_email VARCHAR (64) NOT NULL,
    attender_first_name VARCHAR (50) NOT NULL,
    attender_last_name VARCHAR (50) NOT NULL,
    event_owner VARCHAR(15) NOT NULL,
    PRIMARY KEY(event_id, attender_username),
    FOREIGN KEY (event_id) REFERENCES event (event_id),
    FOREIGN KEY (attender_username) REFERENCES user (username),
    FOREIGN KEY (attender_university_email) REFERENCES user (email),
    FOREIGN KEY (event_owner) REFERENCES user (username)
);

INSERT INTO user (username, email, password, account_type) VALUES ('admin', 'admin@my.yorku.ca', 'admin123', 'Adminstrator');
INSERT INTO user (username, email, password, account_type) VALUES ('student1', 'student1@my.yorku.ca', 'student1_123', 'Student');
INSERT INTO user (username, email, password, account_type) VALUES ('student2', 'student2@my.yorku.ca', 'student2_123', 'Student');
INSERT INTO user (username, email, password, account_type) VALUES ('professor1', 'professor1@my.yorku.ca', 'professor1_123', 'Professor');
INSERT INTO user (username, email, password, account_type) VALUES ('professor2', 'professor2@my.yorku.ca', 'professor2_123', 'Professor');
INSERT INTO user (username, email, password, account_type) VALUES ('organization1', 'organization1@my.yorku.ca', 'organization1_123', 'Organization');
INSERT INTO user (username, email, password, account_type) VALUES ('organization2', 'organization2@my.yorku.ca', 'organization2_123', 'Organization');


INSERT INTO post (username, title, content, likes_count) VALUES ('professor1', 
'Looking for student volunteers regarding a reasearch study', 
'I am looking for 5 student volunteers to participate in a research study regarding willpower. 
I have attached a link to a google form for interested students. 
Link to form: (form)', 1);
INSERT INTO post (username, title, content, likes_count) VALUES ('professor2', 
'Reasearch opportunities available for undergraduate students.', 
'My lab has 3 available research positions available to undergraduate students.
My research is focused on Evidence-based software engineering. 
Interested students should send an email with thier resume attached to professor2@my.yorku.ca.', 1);
INSERT INTO post (username, title, content, likes_count) VALUES ('organization1', 
'Spanish Hour Today @ First Student Center Room 302 6:00pm - 7:00pm', 
'We are having spanish hour classes today @ the First Student Center Room 302 from 6:00pm - 7:00pm. 
It is free for club members, and $2 for non-members.', 1);
INSERT INTO post (username, title, content, likes_count) VALUES ('organization2', 
'Mexico vs Poland World Cup Group Game Stream Tomorrow @ Second Student Center Room 210 10:00am - 12:00pm', 
'We are streaming the Mexico vs Poland World Cup Group Game tomorrow @ the Second Student Center Room 210 from 10:00am - 12:00pm. 
It is free for club members, and $2 for non-members.', 1);


INSERT INTO comment (post_id, username, content) VALUES (1, 'student1',
'Thanks for posting this opportunity Professor1. I am interested and have filled out the form
When should I expect to hear back?');
INSERT INTO comment (post_id, username, content) VALUES (2, 'student2',
'Thanks for posting this opportunity Professor2. 
Are there any requirements to meet before sending an email or is this opportunity open to students irrespective of their background?');
INSERT INTO comment (post_id, username, content) VALUES (3, 'student1',
'Wow! This is amazing. I have always wanted to learn spanish. Is this a one time class or recurring one?');
INSERT INTO comment (post_id, username, content) VALUES (4, 'student2',
'VAMONOS MEXICO! Are you going to be streaming other games as well?');


INSERT INTO reply (comment_id, username, content) VALUES (1, 'professor1',
'You should expect to hear back in 2 weeks.');
INSERT INTO reply (comment_id, username, content) VALUES (2, 'professor2',
'This opportunity is open to students irrespective of their background.');
INSERT INTO reply (comment_id, username, content) VALUES (3, 'organization1',
'We are glad to provide an opportunity and safe space for you to learn Spanish!
Our Spanish Hours are going to be a recurring class.');
INSERT INTO reply (comment_id, username, content) VALUES (4, 'organization2',
'We love your excitement! Yes, we are going to be streaming other games!');


INSERT INTO event (category, event_type, owner, event_title, event_description, event_status) 
VALUES ('Halloween', 'Free', 'organization1', 'Halloween Movie Night',
'We are going to hos sting a Movie Night on Halloween where we will showing movies in Spanish and Portuguese.
There will be food, games, and pumpkin painting. More details will be added soon!', 'To Be Updated');
INSERT INTO event (category, event_type, owner, event_title, event_description, event_status)
VALUES ('Sports', 'Free', 'organization2', 'All Day Soccer Tournament',
'We are going to hosting an All Day Soccer Tournament.
Teams will consist of 5 outfield players and 1 goalie. There will be food, and drink. More details will be added soon!', 'To Be Updated');


INSERT INTO booked_event (event_id, attender_username, attender_university_email, attender_first_name, attender_last_name, event_owner) 
VALUES (1, 'student1', 'student1@my.yorku.ca', 'Student', 'One', 'organization1');
INSERT INTO booked_event (event_id, attender_username, attender_university_email, attender_first_name, attender_last_name, event_owner) 
VALUES (2, 'student2', 'student2@my.yorku.ca', 'Student', 'Two', 'organization2');