<h1 align="center">Person Service</h1>

## Docker Commands

# move to directory docker
-cd docker

#create docker image
-docker build -t demo .

# run the command
- docker run --name demo  -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e PGDATA=/var/lib/postgresql/data/pgdata  -v /custom/mount:/var/lib/postgresql/data -d demo

# Enter to docker container
- docker exec -it demo psql -U postgres

# Create BD
- CREATE DATABASE demo;

# Create super user
- CREATE ROLE demo WITH SUPERUSER CREATEDB CREATEROLE LOGIN ENCRYPTED PASSWORD 'demo';

# Enter to DB demo
- \c demo

# Create table
-
CREATE TABLE PERSON
(
    id        INTEGER NOT NULL,
    full_name  TEXT,
    birth     TIMESTAMP,
    CONSTRAINT user_pk PRIMARY KEY (id)
);
