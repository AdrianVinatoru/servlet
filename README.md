Demo application for experimenting with Java technologies.

**********************************************************************************************
This instructions assume PostgreSQL server is already installed on MacOS.

PostgreSQL version:PostgreSQL 11.2

PostgreSQL installation location:https://www.postgresql.org/download/macosx/

pgadmin4 installation location:https://www.postgresql.org/ftp/pgadmin/pgadmin4/v4.8/macos/

PostgreSQL home directory:/usr/local/var/postgres

Start PostgreSQL server on local environment:pg_ctl -D /usr/local/var/postgres start

Stop PostgreSQL  server on local environment: pg_ctl -D /usr/local/var/postgres stop

Url to access pgadmin4 on local environment: http://127.0.0.1:65523

After postgres installation please make sure to run the following commands for creating a postgres database

and a user called postgres with password postgres.

Step 1: Login to Postgres with sudo psql -U my.username postgres(.e.g: sudp psql -U stefan.seulean postgres)

Step 2:Create role postgres :CREATE USER postgres WITH SUPERUSER PASSWORD 'password';

Step 3:Connect to PostgreSQL server from pgadmin4
**********************************************************************************************
CREATE TABLE public.users
(
    id integer NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    phone_number text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;