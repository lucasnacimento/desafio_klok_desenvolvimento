DO
$$
    DECLARE
        produto_seguro_celular_id INTEGER := 0;

        campo_objeto_armazenamento_id INTEGER := 0;
        
        campo_cliente_cpf_id INTEGER := 0;

        campo_objeto_marca_id INTEGER := 0;
        campo_adesao_qtdParcelas_id INTEGER := 0;
        campo_adesao_diaCobranca_id INTEGER := 0;

    BEGIN
        INSERT INTO public.t_produto(id, descricao, nome, preco) VALUES (DEFAULT, 'Seguro para Smartphones', 'Seguro_Celular', 100)
        RETURNING id INTO produto_seguro_celular_id;
        
        SELECT id INTO campo_cliente_cpf_id FROM public.t_campo WHERE nome = 'cliente.cpf';
        
        SELECT id INTO campo_objeto_marca_id FROM public.t_campo WHERE nome = 'objeto.marca';
        
        SELECT id INTO campo_objeto_armazenamento_id FROM public.t_campo WHERE nome = 'objeto.armazenamento';
        
        SELECT id INTO campo_adesao_qtdParcelas_id FROM public.t_campo WHERE nome = 'adesao.qtdParcelas';
        
        SELECT id INTO campo_adesao_diaCobranca_id FROM public.t_campo WHERE nome = 'adesao.diaCobranca';

        INSERT INTO public.t_produto_campo (id_produto, id_campo) VALUES (produto_seguro_celular_id, campo_objeto_armazenamento_id);
        
        INSERT INTO public.t_produto_campo (id_produto, id_campo) VALUES (produto_seguro_celular_id, campo_cliente_cpf_id);
        
        INSERT INTO public.t_produto_campo (id_produto, id_campo) VALUES (produto_seguro_celular_id, campo_objeto_marca_id);

        INSERT INTO public.t_produto_campo (id_produto, id_campo) VALUES (produto_seguro_celular_id, campo_adesao_qtdParcelas_id);
        
        INSERT INTO public.t_produto_campo (id_produto, id_campo) VALUES (produto_seguro_celular_id, campo_adesao_diaCobranca_id);

    END 
$$;