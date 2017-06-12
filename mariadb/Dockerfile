FROM mariadb

ENV MYSQL_ROOT_PASSWORD=password 
ENV MYSQL_DATABASE=test

ADD initialise.sql /docker-entrypoint-initdb.d
