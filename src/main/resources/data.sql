-- roles --
INSERT INTO roles (id, nome) VALUES (1, 'ATENDIMENTO');
INSERT INTO roles (id, nome) VALUES (2, 'TECNICO');

-- funcionários
INSERT INTO usuarios (id, email, senha) VALUES (1, 'func1@gmail.com', '$2y$12$G1dhGzoZBRBJ8UQme4V4leng7kaWVtAqkyP2DuRrQ9gL5siZKJy9K');
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('F', 'func1@gmail.com', 'Endereço func 1', 'Func 1', '(48) 99124-5987', 1);
INSERT INTO users_roles (usuario_id, role_id) VALUES (1, 1);

INSERT INTO usuarios (id, email, senha) VALUES (2, 'func2@gmail.com', '$2y$12$G1dhGzoZBRBJ8UQme4V4leng7kaWVtAqkyP2DuRrQ9gL5siZKJy9K');
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('F', 'func2@hotmail.com', 'Endereço func 2', 'Func 2', '(48) 99124-5987', 2);
INSERT INTO users_roles (usuario_id, role_id) VALUES (2, 2);

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
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('P', 'cli1@gmail.com', 'Endereço cli 1', 'Cli 1', '(48) 99124-5987', 0);
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('P', 'cli2@gmail.com', 'Endereço cli 2', 'Cli 2', '(48) 99124-5987', 0);
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('P', 'cli3@gmail.com', 'Endereço cli 3', 'Cli 3', '(48) 99124-5987', 0);

-- ordens de serviço
insert into ordem_servicos (data_abertura, data_finalizacao, defeito, cliente_id, marca_id, responsavel_id, tipo_id, status) VALUES ('2019-12-23', null, 'trocando os canais de forma automática', 3, 1, 1, 1, 0);
insert into ordem_servicos (data_abertura, data_finalizacao, defeito, cliente_id, marca_id, responsavel_id, tipo_id, status) VALUES ('2019-12-22', null, 'as vezes liga, as vezes não liga', 3, 6, 1, 2, 1);
insert into ordem_servicos (data_abertura, data_finalizacao, defeito, cliente_id, marca_id, responsavel_id, tipo_id, status) VALUES ('2019-12-23', null, 'tela não está funcionando', 4, 4, 2, 2, 3);
