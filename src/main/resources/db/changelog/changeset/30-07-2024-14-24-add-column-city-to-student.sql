--liquibase formatted sql
--changeset vitaliy:add-column-city-to-student
ALTER TABLE student
ADD COLUMN city jsonb;


