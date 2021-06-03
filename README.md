<h1 align="center">Person Service</h1>

# Docker Commands

## move to directory docker
- cd docker

## create docker image
- docker build -t postgres .

## run the command
- docker run --name postgres  -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e PGDATA=/var/lib/postgresql/data/pgdata  -v /custom/mount:/var/lib/postgresql/data -d postgres

## Enter to docker container
- docker exec -it postgres psql -U postgres

## Create BD
- CREATE DATABASE postgres;

## Create super user
- CREATE ROLE postgres WITH SUPERUSER CREATEDB CREATEROLE LOGIN ENCRYPTED PASSWORD 'postgres';

## Enter to DB postgres
- \c postgres

## Create table

- CREATE TABLE PERSON
(
    id        INTEGER NOT NULL,
    full_name  TEXT,
    birth     TIMESTAMP,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

## Run project

-  mvn spring-boot:run 
