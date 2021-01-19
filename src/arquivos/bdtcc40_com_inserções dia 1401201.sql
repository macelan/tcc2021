DROP DATABASE IF EXISTS bdtcc40;
CREATE DATABASE bdtcc40;

USE bdtcc40;

CREATE TABLE coordenadoria(
		coordenadoria_id		INT auto_increment,
		nome	VARCHAR(170),
        sigla    VARCHAR(10),
		PRIMARY KEY (coordenadoria_id)
       );
	   
	   INSERT INTO coordenadoria (coordenadoria_id,nome,sigla) VALUES
		 (1,'Região Metropolitana de São Paulo','COREMETRO'),
		 (2,'Região do Vale do Paraiba e Litoral','CVL'),
         (3,'Região Central','CRC'),
         (4,'Região Noroeste','CRN'),
         (5,'Região Oeste','CRO'),
		 (6,'Saúde','CS');

CREATE TABLE presidio(
		presidio_id 			int auto_increment,
		coordenadoria_id  		    INT,
		cidade          VARCHAR (30) not null,
        nome			VARCHAR(170) NOT NULL,
        sigla           VARCHAR(7) NOT NULL,
        regime      	VARCHAR(15) NOT NULL,
        PRIMARY KEY (presidio_id),
        foreign key (coordenadoria_id) references coordenadoria(coordenadoria_id)
);   

INSERT INTO presidio (presidio_id,coordenadoria_id,cidade,nome,sigla,regime) VALUES
(1,4,'Álvaro de Carvalho','Penitenciária  de Alvaro de Carvalho','PCAR','Fechado'),
(2,3,'Americana','Centro de Detenção Provisória de Americana','CDAME','Fechado'),
(3,5,'Andradina','Penitenciária de Andradina','ANDRA','Fechado'),
(4,5,'Araçatuba','Centro de Ressocialização Araçatuba','ARATU','Fechado'),
(5,4,'Araraquara','Centro de Ressocialização Masculino de Araraquara','CRARQ','Fechado'),
(6,4,'Araraquara','Penitenciária  de Araraquara + Ala de Progressão','PAR','Semi-Aberto'),
(146,4,'Araraquara','Anexo de Detenção Provisória de Araraquara','ANEPA','Fechado'),
(7,4,'Araraquara','Centro de Ressocialização Feminino de Araraquara','CRFAR','Fechado'),
(8,5,'Assis','Penitenciária de Assis','PAS','Fechado'),
(9,3,'Atibaia','Centro de Ressocialização Masculino de Atibaia','CRATI','Fechado'),
(10,4,'Avanhandava','Penitenciária Compacta de Avanhandava','PEAVA','Fechado'),
(11,4,'Avarè','Centro de Ressocialização de Avaré','CRAVA ','Fechado'),
(12,4,'Avarél','Penitenciária  de Avaré I','AVARE','Fechado'),
(13,4,'Avarè II','Penitenciária de Avaré II','AVRII','Fechado'),
(14,4,'Balbinos','Penitenciária I de Balbinos','PBALI','Fechado'),
(15,4,'Balbinos','Penitenciária II de Balbinos','PEBII','Fechado'),
(16,4,'Bauru','Instituto Penal Agrícola, de Bauru','IPAB','Fechado'),
(17,4,'Bauru','Centro de Detenção Proviasoria de Bauru','CDBAU','Fechado'),
(18,4,'Bauru','Penitenciária de Bauru I + Ala de Progressão','PBI','Semi-Aberto'),
(19,4,'Bauru','Penitenciária  de Bauru II + Ala de Progressão','BRUSA','Semi-Aberto'),
(20,5,'Birigüi','Centro de Ressocialização de Birigüi','CRBIR','Fechado'),
(21,3,'Bragança Paulista','Centro de Ressocialização de Bragança Paulista','BRAGA','Fechado'),
(22,5,'Caiuá','Centro de Detenção Provisória de Caiuá','CDCAI','Fechado'),
(23,3,'Campinas','Centro de Detenção Provisória de Campinas','CDPC','Fechado'),
(24,3,'Campinas','Penitenciária Feminina de Campinas','PFCAM','Fechado'),
(25,3,'Campinas','Centro de Progressão Penitenciária , de Campinas','PCAM','Fechado'),
(26,3,'Casa Branca','Penitenciária  de Casa Branca + Ala de Progressão','PCB','Semi-Aberto'),
(27,1,'Diadema','Centro de Detenção Provisória de Diadema','CDDIA','Fechado'),
(28,5,'Dracena','Penitenciária Compacta de Dracena','PEDRA','Fechado'),
(29,1,'Franco da Rocha','Centro de Detenção Provisória de Franco da Rocha','CDPFR','Fechado'),
(30,1,'Franco da Rocha','Centro de Progressão Penintendária de Franco da Rocha','PFR','Fechado'),
(31,1,'Franco da Rocha','Penitenciária de Franco da Rocha I + Ala de Progressão','FRI','Semi-Aberto'),
(32,1,'Franco da Rocha','Penitenciária  de Franco da Rocha II','RCHII','Fechado'),
(33,1,'Franco da Rocha','Penitenciária de Franco da Rocha III','FRIII','Fechado'),
(34,6,'Franco da Rocha','Hosp. de Custódia e Tratamento Psiquiátricode Franco da Rocha I - Desintemação ''Progressiva de Franco da Rocha','HCTP','Fechado'),
(35,6,'Franco da Rocha','Hosp. de Custódia e Tratamento Psiquiátrico de Franco da Rocha II','HCFR','Fechado'),
(36,5,'Flórida Paulista','Penitenciária Compacta de Flórida Paulista','PFLP','Fechado'),
(37,4,'Getulina','Penitenciária  de Getulina','PGET','Fechado'),
(38,3,'Guarei','Penitenciária I de Guareí','PGUEI','Fechado'),
(39,3,'Guareí','Penitenciária II de Guareí','PEGII','Fechado'),
(40,1,'Guarulhos','Centro de Detenção Provisória de Guarulhos I','CDPGI','Fechado'),
(41,1,'Guarulhos','Centro de Detenção Provisória de Guarulhos II','CPGII','Fechado'),
(42,1,'Guarulhos','Penitenciária  de Guarulhos I + Anexo Penitenciário','PG','Semi-Aberto'),
(43,1,'Guarulhos','Presídio Guarulhos II','GUAII','Fechado'),
(44,3,'Hortolândia','Centro de Detenção Provisória Hortolândia','CDPHO','Fechado'),
(45,3,'Hortolãndia','Penitenciária de Hortolândia I','PHI','Fechado'),
(46,3,'Hortolãndia','Penitenciária  de Hortolândia II + Ala de Progressão','HRTII','Semi-Aberto'),
(47,3,'Hortolãndia','Penitenciária de Hortolândia III','HTIII','Fechado'),
(48,4,'Iaras','Penitenciária  de Iaras +Ala de Progressão','IARAS','Semi-Aberto'),
(49,3,'Iperó','Penitenciária de Iperó + Ala de Progressão','IPERO','Semi-Aberto'),
(50,5,'Irapuru','Penitenciária de Irapuru','PEURU','Fechado'),
(51,4,'Itai','Penitenciária  de Itai + Ala de Progressão','ITAI','Semi-Aberto'),
(52,1,'Itapecerica da Serra','Centro de Detenção Provisória de Itapecerica da Serra','CDISE','Fechado'),
(53,3,'Itapetininga','Centro de Ressocialização de Itapetininga','CRITA','Fechado'),
(54,3,'ItapetiningaI','Penitenciária de Itapetininga I','PITPI','Fechado'),
(55,3,'ItapetiningaI','Penitenciária de Itapetininga II','ITPII','Fechado'),
(56,3,'Itirapina','Penitenciária de Itirapina I + Anexo Penitenciário','R','Semi-Aberto'),
(57,3,'Itirapina','Penitenciária de Itirapina II + Ala de Progressão','ITIR','Fechado'),
(58,4,'Jaú','Centro de Ressocialização de Jaú','CRJAU','Fechado'),
(59,5,'Junqueirópolis','Penitenciária de Junqueirópolis','PJUNQ','Fechado'),
(60,5,'Lavínia','Penitenciária Compacta de Lavínia I','PLAV','Fechado'),
(61,5,'Lavlnia','Penitenciária Compacta de Lavinia II','LAVII','Fechado'),
(62,5,'Lavinia','Penitenciária Compacta de Lavinia III','PLIII','Fechado'),
(63,3,'limeira','Centro de Ressocialização de Limeira','CRLIM','Fechado'),
(64,4,'Lins','Centro de Ressocialização','LINS','Fechado'),
(65,5,'Lucélia','Penitenciária de Lucélia','PLUC','Fechado'),
(66,5,'Marabá Paulista','Penitenciária Compacta de Marabá Paulista','PMAPA','Fechado'),
(67,4,'Marilia','Centro de Ressocialização de Marilia','CREMA','Fechado'),
(68,4,'Marilia','Penitenciária de Marilia','PMAR','Fechado'),
(69,5,'Martinópolis','Penitenciária de Martinópolis','MARTI','Fechado'),
(70,1,'Mauá','Centro de Detenção Provisória de Mauá','CDPMA','Fechado'),
(71,5,'Mirandópolis','Penitenciária  de Mirandópolis I + Anexo Penitenciário','PIMIR','Semi-Aberto'),
(72,5,'Mirandópolis','Penitenciária de Mirandópolis II','MIRII','Fechado'),
(73,3,'Mococa','Centro de Ressocialização de Mococa','CRMOC','Fechado'),
(74,2,'Mogi das Cruzes','Centro de Detenção Provisória Mogi das Cruzes','CDPMC','Fechado'),
(75,3,'Mogi Mirim','Centro de Ressocialização de Mogi Mirim','CRMGM','Fechado'),
(76,2,'Mongaguá','Centro de Progressão Penitenciária de Mongaguá','PM','Fechado'),
(77,1,'Osasco','Centro de Detenção Provisória de Osasco I','CDPI','Fechado'),
(78,1,'Osasco','Centro de Detenção Provisória de Osasco II','CDPO','Fechado'),
(79,4,'Ourinhos','Centro de Ressocialização de Ourinhos','CROUR','Fechado'),
(80,5,'Osvaldo Cruz','Penitenciária de Osvaldo Cruz','PEOCR','Fechado'),
(81,5,'Pacaembu','Centro de Progressão Penitenciária de Pacaembu','CPPCA','Fechado'),
(82,5,'Pacaembu','Penitenciária de Pacaembu','PPAC','Fechado'),
(83,5,'Paraguaçu Paulista','Penitenciária Compacta de Paraguaçu Paulista','PPALA','Fechado'),
(84,3,'Piracicaba','Centro de Detenção Provisória de Piracicaba + Ala de Progressão','CDPIR','Fechado'),
(85,3,'Piracicaba','Centro de Ressocialização  de Piracicaba','CRPBA','Fechado'),
(86,4,'Pirajui I','Penitenciária  de Pirajuí I','PP','Fechado'),
(87,4,'Pirajui II','Penitenciária  de Pirajuí II + Ala de Progressão','PRJII','Fechado'),
(88,2,'Potim I','Penitenciária Compacta de Potim I','POTIM','Fechado'),
(89,2,'Potim II','Penitenciária Compacta de Potim II','PPOII','Fechado'),
(90,5,'Pradnha','Penitenciária Compacta de Pracinha','PPRAC','Fechado'),
(91,2,'Praia Grande','Centro de Detenção Provisória de Praia Grande','CDPPG','Fechado'),
(92,5,'Pres. Bemardes','Centro de Readaptação Penitenciária de Presidente Bemardes','CRPPB','Fechado'),
(93,5,'Pres. Bemardes','Penitenciária de Presidente Bemardes','PPB','Fechado'),
(94,5,'Pres. Prudente','Centro de Ressocialização de Pres. Prudente','CRPPR','Fechado'),
(95,5,'Pres. Prudente','Penitenciária de Presidente Prudente','PRUD','Fechado'),
(96,5,'Pres. Vencesiau','Penitenciária  de Presidente Vencesiau','PPWI','Fechado'),
(97,5,'Pres. Vencesiau','Penitenciária  de Presidente Vencesiau II','WENII','Fechado'),
(98,4,'Reginópolis','Penitenciária I de Reginópolis','PREGI','Fechado'),
(99,4,'Reginópolis','Penitenciária II de Reginópolis','PERU','Fechado'),
(100,4,'Ribeirão Preto','Centro de Detenção Provisória de Ribeirão Preto','COPR','Fechado'),
(101,4,'Ribeirão Preto','Penitenciária de Ribeirão Preto','PRP','Fechado'),
(102,4,'Ribeirão Preto','Penitenciária Feminina de Ribeirão Preto','PFERP','Fechado'),
(103,3,'Rio Claro','Centro de Ressocialização Feminino de Rio Claro','CRRCL','Fechado'),
(104,3,'Rio Claro','Centro de Ressocialização Masculino de Rio Claro','CRMRC','Fechado'),
(105,5,'Riolândia','Penitenciária de Riolândia','PRIO','Fechado'),
(106,1,'Santo André','Centro de Detenção Provisória de Santo André','CDPA','Fechado'),
(107,1,'São Bernado dos Campo','Centro de Detenção Provisória de São Bernado do Campo','CDPSB','Fechado'),
(108,5,'São José do Rio Preto','Instituto Penal Agrícola  de S.J.do Rio Preto','SJRP','Fechado'),
(109,5,'São José do Rio Preto','Centro de Detenção Provisória de São José do Rio Preto','CDRIO','Fechado'),
(110,5,'São José do Rio Preto','Centro de Ressocialização Feminino de São José do Rio Preto','CRFRP','Fechado'),
(111,2,'São José dos Campos','Centro de Ressocialização Feminino de São José dos Campos','CRFSJ','Fechado'),
(112,2,'São José dos Campos','Centro de Detenção Provisória de São José dos Campos','CDPSJ','Fechado'),
(113,1,'São Paulo','Centro de Detenção Provisória  de Parelheiros','CDPPL','Fechado'),
(114,1,'São Paulo','Centro de Detenção Provisória de Pinheiros I','CDPNS','Fechado'),
(115,1,'São Paulo','Centro de Detenção Provisória de Pinheiros II','PINII','Fechado'),
(116,1,'São Paulo','Centro de Detenção Provisória de Vila Independência','CDVI','Fechado'),
(117,6,'São Paulo','Centro Hospitalar do Sistema Penitenciário','CHSP','Fechado'),
(118,1,'São Paulo','Centro de Proqressão Penitenciário de São Miguel Paulista','CPPSM','Fechado'),
(119,1,'São Paulo','Penitenciária Feminina do Butantan +Anexo Penitenciário','FEBUT','Fechado'),
(120,6,'São Paulo','Centro de Atendimento Hospitalar a Mulher Presa','CAHMP','Fechado'),
(121,1,'São Paulo','Penitenciária Feminina da Capital','PFC','Fechado'),
(122,1,'São Paulo','Penitenciária Feminina do Tatuapé','TATU','Fechado'),
(123,1,'São Paulo','Centro de Detenção Provisória da Capital - Chácara Belém 1 + Ala de Progressão','CDPB','Fechado'),
(124,1,'São Paulo','Centro de Detenção Provisória da Capital - Chácara Belém II + Ala de Progressão','BUI','Fechado'),
(125,1,'São Paulo','Penitenciária Feminina de SantAna','PFSAN','Fechado'),
(126,2,'São Vicente','Centro de Detenção Provisória de São Vicente','CDPSV','Fechado'),
(127,2,'São Vicente','Penitenciária  de São Vicente I','PSVIC','Fechado'),
(128,2,'São Vicente','Penitenciária II de São Vicente','PIISV','Fechado'),
(129,4,'Serra Azul','Penitenciária Compacta de Serra Azul I','PSAZ','Fechado'),
(130,4,'Serra Azul','Penitenciária Compacta de Serra Azul II','PSAII','Fechado'),
(131,3,'Sorocaba','Centro de Detenção Provisória de Sorocaba','COPS','Fechado'),
(132,3,'Sorocaba','Penitenciária Sorocaba I','PSORO','Fechado'),
(133,3,'Sorocaba','Penitenciária  de Sorocaba II','SORII','Fechado'),
(134,3,'Sumaré','Centro de Ressocialização de Sumaré','CRSU','Fechado'),
(135,2,'Suzano','Centro de Detenção Provisória de Suzano','CDPSZ','Fechado'),
(136,6,'Taubaté','Hospital de Custódia e Tratamento Psiquiátrico de Taubaté','CCTT','Fechado'),
(145,2,'Taubaté','Centro de Readaptação Penitenciário de Taubaté','CRP','Fechado'),
(137,2,'Taubaté','Centro de Detenção Provisória  de Taubaté','CDPTB','Fechado'),
(138,2,'Tremembé','Centro de Progressão Penitenciária de Tremembé','PEMAN','Fechado'),
(139,2,'Tremembé','Penitenciária Feminina de Tremembé','PFT','Fechado'),
(140,2,'Tremembé','Penitenciária  de Tremembé I','PTR','Fechado'),
(141,2,'Tremembé','Penitenciária de Tremembé II','JACS','Fechado'),
(142,5,'Tupi Paulista','Penitenciária Compacta de Tupi Paulista','PTUPI','Fechado'),
(143,5,'Valparaiso','Centro de Progressão Penitenciária de Valparaiso','CPPVP','Fechado'),
(144,5,'Valparaiso','Penitenciária de Valparaiso','PVALP','Fechado');

CREATE TABLE faccao(
		faccao_id		INT auto_increment,
		nome	VARCHAR(70),
        sigla_faccao    VARCHAR(10),
        PRIMARY KEY (faccao_id)
       );
	   
INSERT INTO faccao (faccao_id,nome,sigla_faccao) VALUES
 (1,'Primeiro Comando da Capital','PCC'),
 (2,'Comando Revolucionário da Criminalidade','CRBC'),
 (3,'Comissão Democratica da LIberdade','CDL'),
 (4,'Comando Vermelho','CV'),
 (5,'Familia do Norte','FDL'),
 (6,'Seita Satanica','SS'),
 (7,'Cerol Fino','CF'),
 (8,'Amigos dos Amigos','ADA');

CREATE TABLE pavilhao (
		pavilhao_id	        			 int auto_increment,
        nome            				 VARCHAR(23) NOT NULL,
        sigla_pavilhao		   			 VARCHAR(15)  NOT NULL,
		PRIMARY KEY (pavilhao_id)
 );
 
 INSERT INTO `pavilhao` (`pavilhao_id`, `nome`, `sigla_pavilhao`) VALUES
(1, 'Raio I', 'RI'),
(2, 'Raio II', 'RII'),
(3, 'Raio III', 'RIII'),
(4, 'Raio IV', 'RIV'),
(5, 'Pavilhão Hospitalar', 'PH'),
(6, 'Pavilhão Disciplinar', 'PD'),
(7, 'Inclusão', 'INC'),
(8, 'Ala de Progressão', 'ALA');
  
create  table evento_coletivo(
		evento_coletivo_id 		int auto_increment,
		pavilhao_id			int,
		data_ocorrido 		date,
		data_registro 		datetime,
		relato          varchar(500), /*Seria melhor usar text ?*/
		PRIMARY KEY (evento_coletivo_id),
		foreign key (pavilhao_id) references pavilhao (pavilhao_id)
);

INSERT INTO `evento_coletivo` (`evento_coletivo_id`, `pavilhao_id`, `data_ocorrido`, `data_registro`, `relato`) VALUES
(1, 1, '2020-07-01', '2020-07-09 19:41:14', 'Foi retirado a força, pois o mesmo se recusou a se apresentar na contagem.'),
(2, 8, '2020-07-01', '2020-07-09 19:45:49', 'Um sentenciado simulou uma convulsão para sair da cela e ao ser retirado da cela atacou os Policiais Penais e foi contido.  '),
(6, 3, '2019-06-06', '2020-07-09 19:47:38', 'População pediu atendimento para um sentenciado e ao ser atendido o mesmo lançou plastico quente no rosto do Policial Penal Caetano Veloso.'),
(7, 6, '2019-09-09', '2020-07-09 19:50:31', 'Sentenciado perde seu beneficio e foi conduzido ao sistema fechado. \nA população não colaborou com os Policiais Penais.\nE hou ve principio de Motim.');

CREATE TABLE sindicancia(
		sindicancia_id		INT auto_increment,
		relato	VARCHAR(500),
		data_ocorrido	Date,
		data_registro   datetime,
        PRIMARY KEY (sindicancia_id)
);
INSERT INTO `sindicancia` (`sindicancia_id`,`relato`, `data_ocorrido`, `data_registro`) VALUES
(1, 'Tentou fugir no latão de lixo.', '2020-02-02', '2020-07-07 09:20:48'),
(2, 'Matou a companheira enforcada, por não aceitar fim de relacionamento.', '0101-01-01', '2020-07-08 15:30:13'),
(3, 'Danificou cela ao queimar colchão.', '1516-03-15', '2020-07-08 15:31:42'),
(4, 'Não se apresentou na hora da contagem e ao ser repreendido atacou o Policial Penal verbalmente.', '1516-03-15', '2020-07-08 15:31:58');
 CREATE TABLE funcionario(
		funcionario_id         int auto_increment,
		presidio_id       	int,
		sindicancia_id      int,
        rg 				 varchar (18),
        nome		   VARCHAR(60) NOT NULL,
        data_nascimento    Date not null,
        usuario VARCHAR (70) NOT NUll,
		senha VARCHAR (50) NOT NUll,
        PRIMARY KEY (funcionario_id),
        foreign key (presidio_id) references presidio(presidio_id)

);

INSERT INTO `funcionario` (`funcionario_id`, `presidio_id`, `rg`, `nome`, `data_nascimento`, `usuario`, `senha`) VALUES
(4, 97,'24.488.908-9', 'João de Santana', '1970-07-01', '123', '123'),
(5, 146,'42.847.174-2', 'José da Silva  Matos', '1980-01-01', 'laura', 'laura'),
(6, 146,'36.204.766-2', 'Lauro Dantas bomfim', '1978-11-03', 'ana', 'ana'),
(7, 17,'17.070.653-9', 'Mauro da silva Reis', '1978-05-26', 'ja', 'ja159951'),
(8, 74,'14.232.439-5', 'Maria da Silva Braga', '1975-06-12', 'mariabraga', 'mb');
 
 create  table cela(
		cela_id		 	int, /* não sera auto_increment*/
		pavilhao_id	 int,
		lotacao 				int,
		PRIMARY KEY (cela_id, pavilhao_id),
		foreign key (pavilhao_id) references pavilhao(pavilhao_id)
);
INSERT INTO `cela` (`cela_id`, `pavilhao_id`, `lotacao`) VALUES
(1, 1, 2),(1, 2, 2),(1, 3, 2),(1, 4, 2),(1, 5, 2),(1, 6, 2),(1, 7, 2),(1, 8, 2),
(2, 1, 2),(2, 2, 2),(2, 3, 2),(2, 4, 2),(2, 5, 2),(2, 6, 2),(2, 7, 2),(2, 8, 2),
(3, 1, 2),(3, 2, 2),(3, 3, 2),(3, 4, 2),(3, 5, 2),(3, 6, 2),(3, 7, 2),(3, 8, 2),
(4, 1, 2),(4, 2, 2),(4, 3, 2),(4, 4, 2),(4, 5, 2),(4, 6, 2),(4, 7, 2),(4, 8, 2),
(5, 1, 2),(5, 2, 2),(5, 3, 2),(5, 4, 2),(5, 5, 2),(5, 6, 2),(5, 7, 2),(5, 8, 2),
(6, 1, 2),(6, 2, 2),(6, 3, 2),(6, 4, 2),(6, 5, 2),(6, 6, 2),(6, 7, 2),(6, 8, 2),
(7, 1, 2),(7, 2, 2),(7, 3, 2),(7, 4, 2),(7, 5, 2),(7, 6, 2),(7, 7, 2),(7, 8, 2),
(8, 1, 2),(8, 2, 2),(8, 3, 2),(8, 4, 2),(8, 5, 2),(8, 6, 2),(8, 7, 2),(8, 8, 2);

CREATE TABLE sentenciado(
		sentenciado_id            		int auto_increment,
		faccao_id                       int,
		matricula	    VARCHAR(13) NOT NULL,
		nome		    VARCHAR(60) NOT NULL,
        rg			    VARCHAR(13),
        data_nascimento          date,
        aliases         VARCHAR(30) NOT NULL,
        registro_ativo			BOOLEAN,
        PRIMARY KEY (sentenciado_id),
		foreign key (faccao_id ) references faccao(faccao_id)

);
INSERT INTO `sentenciado` (`sentenciado_id`, `faccao_id`, `matricula`, `nome`, `rg`, `data_nascimento`, `aliases`, `registro_ativo`) VALUES
(1, 3, '155.155-5', 'carlos', '15.151.515-1', '1975-03-03', 'cd', 0),
(2, 8, '123.123-2', '', '  .   .   - ', '1980-01-01', '', 0),
(3, 8, '888.888-8', '88888', '88.888.888-8', '1990-01-01', '08', 0),
(4, 5, '150.150-6', 'Daniel das Neves ', '22.119.649-3', '1982-07-09', 'DN', 0),
(5, 1, '380.156-9', 'Aristilde Barbosa', '23.080.375-1', '1970-07-09', 'Louco de Pedra', 0),
(6, 4, '900.159-1', 'Amarildo Jose Sarney', '44.647.211-6', '2000-08-15', 'Carioca', 0),
(7, 2, '100.100-9', 'Rafael Goos', '26.275.853-2', '1999-10-15', 'Pato Roco', 0),
(8, 8, '025.169-7', 'Raimundo Nonato', '26.275.853-2', '1997-10-10', 'Alegre', 0),
(9, 8, '369.269-1', 'Romoaldo luiz Machado da silva', '30.904.895-3', '1973-12-12', 'Homem Bomba', 0),
(10, 8, '456.456-7', 'João da silva', '13.677.618-8', '1950-03-30', 'Joana Darck', 0);

create  table observacao(
		observacao_id 		int auto_increment,
		sentenciado_id			int,
		relato          varchar(500), /*Seria melhor usar text ?*/
		data_ocorrido	Date,
		data_registro   datetime,
		PRIMARY KEY (observacao_id, sentenciado_id),
		foreign key (sentenciado_id) references sentenciado(sentenciado_id)
);

INSERT INTO `observacao` (`observacao_id`, `sentenciado_id`, `relato`, `data_ocorrido`, `data_registro`) VALUES
(1, 2, 'Testou se matar por falta de remédio.', '2020-03-03', '2020-07-07 10:25:04'),
(2, 1, 'Matou companheiro de cela.', '0101-01-01', '2020-07-08 15:22:28');

CREATE TABLE movimentacao_interna (
		movimentacao_interna_id           int auto_increment, 
		sentenciado_id				int,
            	cela_id					int,
                data_movimentacao           date,
            	data_registro   datetime, 
                tipo             VARCHAR(2),/*EX-> Exclusão *** IN -> inclusão ***** l -> liberdade*/
		pavilhao_id INT NOT NULL,
            PRIMARY KEY (movimentacao_interna_id, sentenciado_id),
            foreign key (cela_id) references cela(cela_id),
            foreign key (sentenciado_id) references sentenciado(sentenciado_id)
 );

CREATE TABLE movimentacao_externa (
		movimentacao_externa_id     int auto_increment, /*Pode se usar data de inclusão como chave primaria*/
		sentenciado_id				int,
 		data_movimentacao           date,
		data_registro   datetime,  /*Vai pegar automatico*/
                tipo             VARCHAR(12),/*EE-> Exclusão *** IE -> inclusão ***** l -> Liberdade*/
		presidio_id INT not null,
            PRIMARY KEY (movimentacao_externa_id, sentenciado_id), /*O auto increment vem primeiro aqui e nos atributos*/
            foreign key (sentenciado_id) references sentenciado(sentenciado_id),
            foreign key (presidio_id) references presidio(presidio_id)
 );

create table SINDICANCIA_SENTENCIADO(
		sentenciado_id 		int,
		sindicancia_id 		int,
            PRIMARY KEY (sentenciado_id, sindicancia_id),
            foreign key (sentenciado_id) references sentenciado(sentenciado_id),
            foreign key (sindicancia_id) references sindicancia(sindicancia_id)
);

create table SINDICANCIA_FUNCIONARIO(
		funcionario_id		int,
		sindicancia_id 		int,
            PRIMARY KEY (funcionario_id,sindicancia_id),
            foreign key (funcionario_id) references funcionario(funcionario_id),
            foreign key (sindicancia_id) references sindicancia(sindicancia_id)
);



