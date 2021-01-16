DROP DATABASE IF EXISTS ajax;
CREATE DATABASE ajax;

USE ajax;

CREATE TABLE aluno(
		idaluno		INT auto_increment,
		nome		VARCHAR(60),
        telefone    VARCHAR(60),
		endereco    int,
		cidade    	VARCHAR(50),
		uf    		VARCHAR(2),
		cep    		VARCHAR(9),
		email    	VARCHAR(60),
		PRIMARY KEY (idaluno)
       );
	   
CREATE TABLE atividades(
		idAtividades 			int auto_increment,
		idSemana                int not null,
        nome			    	VARCHAR(60) NOT NULL,
        dataInicio           	DATE NOT NULL,
        dataTermino      		DATE NOT NULL,
		cargaHoraria			double not null,
        PRIMARY KEY (idAtividades,idSemana),
		FOREIGN KEY (idSemana) REFERENCES semana (idSemana)
);   


CREATE TABLE sindicancia(
		sindicancia_id		INT auto_increment,
		funcionario_id     int,
        sentenciado_id     int,
		relato	VARCHAR(500),
		data_ocorrido	Date,
		data_registro   datetime,
        PRIMARY KEY (sindicancia_id)
);
INSERT INTO `sindicancia` (`sindicancia_id`, `funcionario_id`, `sentenciado_id`, `relato`, `data_ocorrido`, `data_registro`) VALUES
(1, NULL, NULL, 'Tentou fugir no latão de lixo.', '2020-02-02', '2020-07-07 09:20:48'),
(2, NULL, NULL, 'Matou a companheira enforcada, por não aceitar fim de relacionamento.', '0101-01-01', '2020-07-08 15:30:13'),
(3, NULL, NULL, 'Danificou cela ao queimar colchão.', '1516-03-15', '2020-07-08 15:31:42'),
(4, NULL, NULL, 'Não se apresentou na hora da contagem e ao ser repreendido atacou o Policial Penal verbalmente.', '1516-03-15', '2020-07-08 15:31:58');

