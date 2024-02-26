drop table if exists PERSON;


CREATE SEQUENCE IF NOT EXISTS demo_schema.person_seq;

create table IF NOT EXISTS demo_schema.person(
  id int not null default nextval('person_seq'),
  name varchar(100) not null,
  age int,
  dept varchar(250),
  design varchar(250),
  PRIMARY KEY ( ID )
);

--insert into demo_schema.person(id,name, age, dept, design) values(1, 'Test', 25, 'HR', 'MANAGER');--
--insert into demo_schema.person(id,name, age, dept, design) values(2, 'Test', 40, 'Sales', 'MANAGER');