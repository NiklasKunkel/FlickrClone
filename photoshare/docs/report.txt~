DROP TABLE Pictures CASCADE;
DROP TABLE Albums CASCADE;
DROP TABLE Users CASCADE;
DROP TABLE Friends CASCADE;
DROP TABLE Comments CASCADE;
DROP TABLE Tag CASCADE;
DROP TABLE Likes CASCADE;

DROP SEQUENCE Pictures_picture_id_seq;
DROP SEQUENCE Users_user_id_seq;
DROP SEQUENCE Comments_comment_id_seq;
DROP SEQUENCE Albums_album_id_seq;

-- Create all of our sequences we will need
CREATE SEQUENCE Pictures_picture_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 14
  CACHE 1;

CREATE SEQUENCE Users_user_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 14
  CACHE 1;

CREATE SEQUENCE Comments_comment_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE Albums_album_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

-- Create all of the tables
CREATE TABLE Users
(
  user_id int4 NOT NULL DEFAULT nextval('Users_user_id_seq'),
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  role_name varchar(255) NOT NULL DEFAULT 'RegisteredUser',
  firstName varchar(255) NOT NULL,
  lastName varchar(255) NOT NULL,
  dateOfBirth varchar(255) NOT NULL,
  userGender varchar(1) NOT NULL,
  currentCity varchar(255) NOT NULL,
  currentState varchar(255) NOT NULL,
  currentCountry varchar(255) NOT NULL,
  homeCity varchar(255) NOT NULL,
  homeState varchar(255) NOT NULL,
  homeCountry varchar(255) NOT NULL,
  schoolName varchar(255) NOT NULL,
  schoolMajor varchar(255) NOT NULL,
  schoolYear varchar(255) NOT NULL,
  UNIQUE(email),
  CONSTRAINT users_pk PRIMARY KEY (user_id)
);

CREATE TABLE Albums
(
  aid INT NOT NULL DEFAULT nextval('Albums_album_id_seq'),
  aname varchar(255) NOT NULL,
  ownid INT REFERENCES users(user_id) ON DELETE CASCADE,
  datecreate DATE NOT NULL,
  UNIQUE(aname,ownid),
  CONSTRAINT aid_pk PRIMARY KEY (aid)
);

CREATE TABLE Pictures
(
  pid int4 NOT NULL DEFAULT nextval('Pictures_picture_id_seq'),
  caption varchar(255) NOT NULL,
  imgdata bytea NOT NULL,
  size int4 NOT NULL,
  content_type varchar(255) NOT NULL,
  thumbdata bytea NOT NULL,
  myalbumid INT REFERENCES Albums(aid)ON DELETE CASCADE,
  CONSTRAINT pictures_pk PRIMARY KEY (pid)
); 

CREATE TABLE Friends
(
  frienda INT REFERENCES Users(user_id) ON DELETE CASCADE,
  friendb INT REFERENCES users(user_id) ON DELETE CASCADE,
  PRIMARY KEY(frienda,friendb)
);

CREATE TABLE Likes
(
  pictureid INT REFERENCES Pictures(pid) ON DELETE CASCADE,
  userid INT REFERENCES Users(user_id) ON DELETE CASCADE,
  CONSTRAINT likes_pk PRIMARY KEY(pictureid, userid)
);

CREATE TABLE Comments
(
  owner INT REFERENCES Users(user_id) ON DELETE CASCADE,
  pid INT REFERENCES Pictures(pid) ON Delete CASCADE,
  cid INT NOT NULL DEFAULT nextval('Comments_comment_id_seq'),
  ctext TEXT NOT NULL,
  datamade DATE NOT NULL,
  CONSTRAINT cid_pk PRIMARY KEY(cid)
);

CREATE Table Tag
(
  pid INT REFERENCES Pictures(pid) ON DELETE CASCADE,
  word varchar(255) NOT NULL,
  PRIMARY KEY(pid, word)
);

INSERT INTO Users (email, password, firstName, lastName, dateOfBirth, userGender, currentCity, currentState, currentCountry, homeCity, homeState, homeCountry, schoolName, schoolMajor, schoolYear ) VALUES ('test@bu.edu', 'test', 'Tester', 'test', '06/25/1991', 'M', 'Boston', 'MA', 'USA', 'Aachen', 'Weststphalen', 'Germany', 'Boston University', 'Computer Engineering', '2015');
INSERT INTO Users (email, password, firstName, lastName, dateOfBirth, userGender, currentCity, currentState, currentCountry, homeCity, homeState, homeCountry, schoolName, schoolMajor, schoolYear ) VALUES ('nkunkel@bu.edu', 'test', 'Tester', 'test', '06/25/1990', 'M', 'Boston', 'MA', 'USA', 'Aachen', 'Wests', 'Germany', 'UCLA University', 'Biology', '2012');
