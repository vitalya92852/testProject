--liquibase formatted sql
--changeset vitaliy:create-student-university-edu_card-table

create table student(
        id serial8 not null primary key,
        name varchar not null ,
        lastname varchar not null,
        isDeleted bool,
        type_of_student varchar

);

create table university(
       id serial8 not null  primary key ,
       country varchar not null ,
       city varchar not null ,
       name varchar not null ,
       isDeleted bool
);

create table edu_card(
     id serial8 not null primary key ,
     start_education timestamp not null ,
     end_education timestamp not null,
     student_id int4 not null ,
     university_id int4 not null ,
     foreign key (student_id) references student(id),
     foreign key (university_id) references university(id)
);

