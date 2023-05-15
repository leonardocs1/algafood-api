insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into estado (id, nome) values (1, 'Goiás');
insert into estado (id, nome) values (2, 'Maranhão');
insert into estado (id, nome) values (3, 'Pará');

insert into cidade (id, nome, estado_id) values (1, 'Uruaçu', 1);
insert into cidade (id, nome, estado_id) values (2, 'Goiânia', 1);
insert into cidade (id, nome, estado_id) values (3, 'Porangatu', 1);
insert into cidade (id, nome, estado_id) values (4, 'Balsas', 2);
insert into cidade (id, nome, estado_id) values (5, 'Imperatriz', 2);
insert into cidade (id, nome, estado_id) values (6, 'Belém', 2);

insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (1, 'Thai Gourmet', 10, 1, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (2, 'Thai Delivery', 9.50, 1);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (3, 'Tuk Tuk Comida Indiana', 15, 2);

insert into forma_pagamento (id, descricao) values (1, 'Cartão crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');
insert into forma_pagamento (id, descricao) values (4, 'PIX');

insert into permissao (id, descricao, nome) values (1, 'Permite consultar forma de pagamento', 'CONSULTAR_FORMA');
insert into permissao (id, descricao, nome) values (2, 'Permite alterar forma de pagamento', 'ALTERAR_FORMA');



insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);