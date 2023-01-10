create table if not exists todo(id BIGINT auto_increment primary key, title VARCHAR(250) NOT NULL, description VARCHAR(250) NOT NULL, completed bit NOT NULL);

insert into todo(id, title, description, completed) values(1, 'Complete Youtube Video', 'Java Video', 1);