CREATE TABLE Banda (
	nome varchar(50),
	localOrigem varchar(50),
	
	PRIMARY KEY(nome)
);

CREATE TABLE Integrantes (
	nome varchar(50),
	banda varchar(50),
	
	PRIMARY KEY (nome, banda),
	FOREIGN KEY (banda) REFERENCES Banda(nome)
);

CREATE TABLE Album (
	id serial,
	estilo varchar(50),
	banda varchar(50),
	anoLancamento date,

	PRIMARY KEY(id),
	FOREIGN KEY (banda) REFERENCES Banda(nome)	
);