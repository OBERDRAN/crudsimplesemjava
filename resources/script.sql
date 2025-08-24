create database agenda;

create table contatos(
id int not null auto_increment primary key,
  nome varchar(20),
  idade int,
dataCadastro date)