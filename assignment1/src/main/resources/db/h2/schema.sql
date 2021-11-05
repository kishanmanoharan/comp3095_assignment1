DROP TABLE if exists recipes;

DROP TABLE if exists users;

create table users (
    id int AUTO_INCREMENT PRIMARY KEY,
    email varchar(250) NOT NULL,
    password varchar(250) NOT NULL
);

create table recipes (
    id int AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    date date NOT NULL,
    ingredients LONGTEXT NOT NULL,
    directions LONGTEXT NOT NULL,
    user_id int
);

-- ALTER TABLE recipes ADD CONSTRAINT fk_recipes_user FOREIGN KEY (user_id) REFERENCES users (id);
