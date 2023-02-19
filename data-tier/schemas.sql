CREATE DATABASE yorkuniversity;

USE yorkuniversity;

CREATE TABLE user (
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR (15) UNIQUE NOT NULL,
    email VARCHAR (64) UNIQUE NOT NULL,
    password VARCHAR (32) NOT NULL,
    account_type VARCHAR (64) NOT NULL,
    first_name  VARCHAR (64), 
    last_name  VARCHAR (64),
    bio  VARCHAR (64), 
    department  VARCHAR (64),
    PRIMARY KEY (user_id)
);

CREATE TABLE artifact (
    artifact_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR (15) NOT NULL,
    title VARCHAR (50) NOT NULL,
    content VARCHAR (255) NOT NULL,
    external_url VARCHAR (255) UNIQUE,
    category VARCHAR (64),
    status VARCHAR (64),
    location VARCHAR (64),
    artifact_date_time DATETIME,
    date_time_created DATETIME NOT NULL DEFAULT NOW(),
    media_url VARCHAR (255) UNIQUE,
    likes_count INT NOT NULL DEFAULT 0,
    PRIMARY KEY(artifact_id, username),
    FOREIGN KEY (username) REFERENCES user (username)
);

INSERT INTO user (username, email, password, account_type, first_name, last_name, bio, department) VALUES ('jsmith', 'jsmith@my.yorku.ca', 'student1_123', 'Student','John', 'Smith', '2nd Year Computer Science Student and Soccer Lover', 'Electrical Engineering and Computer Science');
INSERT INTO user (username, email, password, account_type, first_name, last_name, bio, department) VALUES ('svalera', 'svalera@my.yorku.ca', 'student2_123', 'Student', 'Samantha', 'Valera', '3rd Year Biomedical Science Student and Art Nerd', 'Biology');
INSERT INTO user (username, email, password, account_type, first_name, last_name, bio, department) VALUES ('johnadams', 'johnadams@my.yorku.ca', 'professor1_123', 'Professor', 'John', 'Adams', 'Professor at the Lassonde School of Engineering teaching EECS 3101', 'Electrical Engineering and Computer Science');
INSERT INTO user (username, email, password, account_type, first_name, last_name, bio, department) VALUES ('elizabethparker', 'elizabethparker@my.yorku.ca', 'professor2_123', 'Professor', 'Elizabeth', 'Parker', 'Professor at the Department of Biology teaching BIOL 1000', 'Biology');
INSERT INTO user (username, email, password, account_type) VALUES ('cshub', 'cshub@my.yorku.ca', 'organization1_123', 'Organization');
INSERT INTO user (username, email, password, account_type) VALUES ('yfs', 'yfs@my.yorku.ca', 'organization2_123', 'Organization');


INSERT INTO artifact (username, title, content, likes_count) VALUES ('elizabethparker', 
'Looking for student volunteers regarding a reasearch study', 
'I am looking for 5 student volunteers to participate in a research study regarding willpower. 
I have attached a link to a google form for interested students. 
Link to form: (form)', 1);
INSERT INTO artifact (username, title, content, likes_count) VALUES ('johnadams', 
'Reasearch opportunities available for undergraduate students.', 
'My lab has 3 available research positions available to undergraduate students.
My research is focused on Evidence-based software engineering. 
Interested students should send an email with thier resume attached to professor2@my.yorku.ca.', 1);
INSERT INTO artifact (username, title, content, likes_count) VALUES ('yfs', 
'Upcoming Student Union Government Elections', 
'We will be unveiling our candidates and campaign outline for the upcoming student union government elections.', 1);
INSERT INTO artifact (username, title, content, likes_count) VALUES ('cshub', 
'Mexico vs Poland World Cup Group Game Stream Tomorrow @ Second Student Center Room 210 10:00am - 12:00pm', 
'We are streaming the Mexico vs Poland World Cup Group Game tomorrow @ the Second Student Center Room 210 from 10:00am - 12:00pm. 
It is free for club members, and $2 for non-members.', 1);
