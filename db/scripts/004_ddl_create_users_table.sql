CREATE table if not exists j_user (
id serial primary key,
name varchar(2000),
role_id int not null references j_role(id)
);