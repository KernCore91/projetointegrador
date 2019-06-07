-- banco de dados : projetointegrador

drop table if exists baixa;
drop table if exists patrimonio;

create table patrimonio(
	id serial primary key,
	nome_bem varchar(50),
	dataAquisicao date,
	categoria varchar(20),
	vida_util numeric,
	bem_usado varchar(3),
	valorAquisicao numeric,
	taxa_residual numeric,
	turnos numeric,
	tempo_uso numeric
);

create table baixa(
	idBaixa serial primary key,
	idPatrimonio integer,
	dataDaBaixa date,
	valorDaBaixa numeric,
	motivoDaBaixa varchar(10),
	FOREIGN KEY (idPatrimonio) REFERENCES patrimonio (id)
);

insert into patrimonio (nome_bem, dataAquisicao, categoria, vida_util, bem_usado, valorAquisicao, taxa_residual, turnos)
values ('Veiculo', '2015-12-18', 'Veiculos', 4, 'não', 42000, 10, 1);