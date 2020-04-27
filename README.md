# sistema_diagnostico_perecial
Implementação de um sistema de Diagnostico pericial feito em Java + Prolog + MySQL


Executa as seguintes instruções sql para criar as tabelas e a Base de dados

create database hospital;
use hospital;
create table tbpaciente
(
  pk_paciente int auto_increment,
  nome varchar(30) not null,
  idade int not null,
  sexo enum('Masculino','Feminino'),
  altura float not null,
  morada varchar(30) not null,
  telefone varchar(30) not null,
  email varchar(30) not null,
  senha varchar(30) not null,
  constraint pk_tbpaciente primary key(pk_paciente)
)Engine=InnoDB;


create table tbresultado
(
  pk_resultado int auto_increment,
  diagnostico varchar(200) not null,
  fk_paciente int not null,
  data date not null,
  constraint pk_tbresultado primary key(pk_resultado),
  constraint fk_paciente_tbresultado foreign key fk_paciente reference tbpaciente(pk_paciente)
  on delete cascade on update cascade
)Engine=InnoDB;
