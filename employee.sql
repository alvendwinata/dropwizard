
-- A script to create employee table
create table employees(
    -- auto-generated primary key
    id bigint primary key not null auto_increment,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    -- employee position
    e_position  varchar(255) not null,
    phone  varchar(255) not null,
    e_mail varchar(255) not null
);