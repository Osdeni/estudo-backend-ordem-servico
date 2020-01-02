-- roles --
INSERT INTO roles (id, nome) VALUES (1, 'ATENDIMENTO');
INSERT INTO roles (id, nome) VALUES (2, 'TECNICO');

-- funcionários
INSERT INTO usuarios (id, email, senha) VALUES (1, 'func1@gmail.com', '$2y$12$G1dhGzoZBRBJ8UQme4V4leng7kaWVtAqkyP2DuRrQ9gL5siZKJy9K');
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('F', 'func1@gmail.com', 'Endereço func 1', 'Func 1 - Atendimento', '(48) 99124-5987', 1);
INSERT INTO users_roles (usuario_id, role_id) VALUES (1, 1);

INSERT INTO usuarios (id, email, senha) VALUES (2, 'func2@gmail.com', '$2y$12$G1dhGzoZBRBJ8UQme4V4leng7kaWVtAqkyP2DuRrQ9gL5siZKJy9K');
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('F', 'func2@gmail.com', 'Endereço func 2', 'Func 2 - Técnico', '(48) 99124-5987', 2);
INSERT INTO users_roles (usuario_id, role_id) VALUES (2, 2);

INSERT INTO usuarios (id, email, senha) VALUES (3, 'func3@gmail.com', '$2y$12$G1dhGzoZBRBJ8UQme4V4leng7kaWVtAqkyP2DuRrQ9gL5siZKJy9K');
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('F', 'func3@gmail.com', 'Endereço func 3', 'Func 3 - Técnico', '(48) 99124-5987', 3);
INSERT INTO users_roles (usuario_id, role_id) VALUES (3, 2);

-- marcas
INSERT INTO marcas (descricao) VALUES ('LG');
INSERT INTO marcas (descricao) VALUES ('Samsung');
INSERT INTO marcas (descricao) VALUES ('Philips');
INSERT INTO marcas (descricao) VALUES ('Asus');
INSERT INTO marcas (descricao) VALUES ('AOC');
INSERT INTO marcas (descricao) VALUES ('Apple');

-- tipos
INSERT INTO tipos (descricao) VALUES ('TV');
INSERT INTO tipos (descricao) VALUES ('Notebook');

-- Clientes
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('P', 'cli1@gmail.com', 'Endereço cli 1', 'Cli 1', '(48) 99124-5987', null);
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('P', 'cli2@gmail.com', 'Endereço cli 2', 'Cli 2', '(48) 99124-5987', null);
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('P', 'cli3@gmail.com', 'Endereço cli 3', 'Cli 3', '(48) 99124-5987', null);

-- ordens de serviço
insert into ordem_servicos (data_abertura, data_finalizacao, defeito, cliente_id, marca_id, responsavel_id, tipo_id, status) VALUES ('2019-12-23', null, 'trocando os canais de forma automática', 5, 1, 2, 1, 0);
insert into ordem_servicos (data_abertura, data_finalizacao, defeito, cliente_id, marca_id, responsavel_id, tipo_id, status) VALUES ('2019-12-23', null, 'trocando os canais de forma automática outro tecnico', 5, 1, 3, 1, 0);
insert into ordem_servicos (data_abertura, data_finalizacao, defeito, cliente_id, marca_id, responsavel_id, tipo_id, status) VALUES ('2019-12-22', null, 'as vezes liga, as vezes não liga', 4, 6, 2, 2, 1);
insert into ordem_servicos (data_abertura, data_finalizacao, defeito, cliente_id, marca_id, responsavel_id, tipo_id, status) VALUES ('2019-12-23', null, 'tela não está funcionando', 5, 4, 3, 2, 3);
insert into ordem_servicos (data_abertura, data_finalizacao, defeito, cliente_id, marca_id, responsavel_id, tipo_id, status) VALUES ('2019-12-26', null, 'Tela com ponto falho', 5, 4, 3, 2, 2);

-- evoluções --
insert into evolucoes (ordem_servico_id, data, descricao, status) values (3, '2019-12-23 10:05:00', 'Iniciada', 1);

insert into evolucoes (ordem_servico_id, data, descricao, status) values (4, '2019-12-23 10:05:00', 'Iniciada', 1);
insert into evolucoes (ordem_servico_id, data, descricao, status) values (4, '2019-12-23 16:10:00', 'Realizado diversos testes', null);
insert into evolucoes (ordem_servico_id, data, descricao, status) values (4, '2019-12-23 16:13:00', 'Realizada troca de capacitores', 3);

insert into evolucoes (ordem_servico_id, data, descricao, status) values (5, '2019-12-27 08:00:00', 'Iniciada', 1);
insert into evolucoes (ordem_servico_id, data, descricao, status) values (5, '2019-12-27 10:10:00', 'Solicitado nova tela', 2);