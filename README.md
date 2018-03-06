# simpleCMS

init database
´´´
CREATE DATABASE simpleCMS;
CREATE USER 'simpleCMS'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON simpleCMS . * TO 'simpleCMS'@'localhost';
FLUSH PRIVILEGES;
´´´