CREATE DATABASE yorkuniversity;

USE yorkuniversity;

CREATE TABLE user (
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR (15) UNIQUE NOT NULL,
    email VARCHAR (64) UNIQUE NOT NULL,
    password VARCHAR (32) NOT NULL,
    account_type VARCHAR (64) NOT NULL,
    title varchar(64), 
    first_name varchar(64), 
    last_name varchar(64),
    bio varchar(64), 
    faculty varchar(64)
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
