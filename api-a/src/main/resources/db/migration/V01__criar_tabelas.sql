CREATE TABLE t_produto (
    id BIGSERIAL NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    preco NUMERIC NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE t_campo (
    id BIGSERIAL NOT NULL,
    nome VARCHAR(255) NOT NULL,
    obrigatorio BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE t_produto_campo (
    id_produto BIGINT NOT NULL,
    id_campo BIGINT NOT NULL,
    FOREIGN KEY (id_produto) REFERENCES t_produto(id),
    FOREIGN KEY (id_campo) REFERENCES t_campo(id)
);

CREATE TABLE t_adesao (
    id BIGSERIAL NOT NULL,
    data_adesao TIMESTAMP,
    dia_cobranca INT NOT NULL,
    STATUS INTEGER NOT NULL,
    qtd_parcelas INT NOT NULL,
    valor NUMERIC NOT NULL,
    id_produto BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_produto) REFERENCES t_produto(id)
);

CREATE TABLE t_resposta (
    id BIGSERIAL NOT NULL,
    valor VARCHAR(255) NOT NULL,
    id_campo BIGINT,
    id_adesao BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_adesao) REFERENCES t_adesao (id),
    FOREIGN KEY (id_campo) REFERENCES t_campo (id)
);

CREATE TABLE t_pagamento (
    id BIGSERIAL NOT NULL,
    data_pagamento TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE t_cobranca (
    id BIGSERIAL NOT NULL,
    id_pagamento BIGINT NOT NULL,
    id_adesao BIGINT NOT NULL,
    valor_cobranca NUMERIC NOT NULL,
    data_cobranca TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (id_pagamento) REFERENCES t_pagamento(id),
    FOREIGN KEY (id_adesao) REFERENCES t_adesao(id)
);
