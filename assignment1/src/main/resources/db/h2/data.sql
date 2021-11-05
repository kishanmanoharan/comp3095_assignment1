insert into users (email, password) VALUES ('test@test.com', 'test');
insert into recipes (name, date, ingredients, directions, user_id) VALUES ('bread', sysdate() , 'yeast, gluten', 'bake', 1);
