BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

--EKS inserted code below:

DROP TABLE IF EXISTS category, modules, lesson, external_link, topic, keyword, topic_to_keyword;
DROP SEQUENCE IF EXISTS seq_category_id, seq_module_id, seq_lesson_id, seq_external_link_id, seq_keyword_id, seq_topic_id, seq_topic_to_keyword_id;

CREATE SEQUENCE seq_category_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_module_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_lesson_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_external_link_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_keyword_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_topic_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_topic_to_keyword_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE category (
	category_id int DEFAULT nextval('seq_category_id'::regclass) NOT NULL,
	category varchar(50) NOT NULL UNIQUE,

	CONSTRAINT PK_category PRIMARY KEY (category_id)
);

CREATE TABLE modules (
	module_id int DEFAULT nextval('seq_module_id'::regclass) NOT NULL,
	module_name varchar(50) NOT NULL UNIQUE,

	CONSTRAINT PK_module PRIMARY KEY (module_id)
);

CREATE TABLE lesson (
	lesson_id int DEFAULT nextval('seq_lesson_id'::regclass) NOT NULL,
	lesson_name varchar(50) NOT NULL UNIQUE,

	CONSTRAINT PK_lesson PRIMARY KEY (lesson_id)
);


CREATE TABLE external_link (
    external_link_id int DEFAULT nextval('seq_external_link_id'::regclass) NOT NULL,
    external_link_url varchar(500) NOT NULL UNIQUE,
	CONSTRAINT PK_link PRIMARY KEY (external_link_id)
);

CREATE TABLE keyword (
	keyword_id int DEFAULT nextval('seq_keyword_id'::regclass) NOT NULL,
	keyword varchar(50) NOT NULL UNIQUE,

	CONSTRAINT PK_keyword PRIMARY KEY (keyword_id)
);

CREATE TABLE topic (
    topic_id int DEFAULT nextval('seq_topic_id'::regclass) NOT NULL,
    topic varchar(500) NOT NULL,
    category_id int NOT NULL,
    module_id int,
    lesson_id int,
    external_link_id int,
	CONSTRAINT PK_topic PRIMARY KEY (topic_id),
	CONSTRAINT FK_topic_category FOREIGN KEY (category_id) REFERENCES category (category_id),
    CONSTRAINT FK_topic_module FOREIGN KEY (module_id) REFERENCES modules (module_id),
    CONSTRAINT FK_topic_lesson FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id),
    CONSTRAINT FK_topic_external_link FOREIGN KEY (external_link_id) REFERENCES external_link (external_link_id)
);

CREATE TABLE topic_to_keyword (
	id int DEFAULT nextval('seq_topic_to_keyword_id'::regclass) NOT NULL,
	topic_id int NOT NULL,
	keyword_id int NOT NULL,

	CONSTRAINT PK_topic_to_keyword PRIMARY KEY (id),
	CONSTRAINT FK_to_topic FOREIGN KEY (topic_id) REFERENCES topic (topic_id),
	CONSTRAINT FK_to_keyword FOREIGN KEY (keyword_id) REFERENCES keyword (keyword_id)
);

COMMIT TRANSACTION;
