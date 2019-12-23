-- funcionários
INSERT INTO usuarios (id, email, senha) VALUES (1, 'osdeni@gmail.com', '$2y$12$G1dhGzoZBRBJ8UQme4V4leng7kaWVtAqkyP2DuRrQ9gL5siZKJy9K');
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('F', 'osdeni@gmail.com', 'Endereço teste', 'Osdeni', '(48) 99124-5987', 1);

INSERT INTO usuarios (id, email, senha) VALUES (2, 'osdeni@hotmail.com', '$2y$12$G1dhGzoZBRBJ8UQme4V4leng7kaWVtAqkyP2DuRrQ9gL5siZKJy9K');
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('F', 'osdeni@hotmail.com', 'Endereço hotmail', 'Osdeni hotmail', '(48) 99124-5987', 2);

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
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('C', 'abc@gmail.com', 'Endereço abc', 'Abc', '(48) 99124-5987', 0);
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('C', 'def@gmail.com', 'Endereço def', 'Def', '(48) 99124-5987', 0);
INSERT INTO pessoas (tipo, email, endereco, nome, telefone, usuario_id) VALUES ('C', 'ghi@gmail.com', 'Endereço ghi', 'Ghi', '(48) 99124-5987', 0);

-- ordens de serviço
insert into ordem_servicos (data_abertura, data_finalizacao, defeito, cliente_id, marca_id, responsavel_id, tipo_id) VALUES ('2019-12-23', null, 'trocando os canais de forma automática', 3, 1, 1, 1);
insert into ordem_servicos (data_abertura, data_finalizacao, defeito, cliente_id, marca_id, responsavel_id, tipo_id) VALUES ('2019-12-22', null, 'as vezes liga, as vezes não liga', 3, 6, 1, 2);
insert into ordem_servicos (data_abertura, data_finalizacao, defeito, cliente_id, marca_id, responsavel_id, tipo_id) VALUES ('2019-12-23', null, 'tela não está funcionando', 4, 4, 2, 2);
