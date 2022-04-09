DO
$$
    DECLARE
        produto_seguro_celular_id INTEGER := 0;

        campo_adesao_valor_id INTEGER := 0;
        campo_adesao_qtdParcelas_id INTEGER := 0;
        campo_adesao_diaCobranca_id INTEGER := 0;

    BEGIN
        INSERT INTO public.t_produto(id, descricao, nome, preco) VALUES (DEFAULT, "Seguro para Smartphones", "Seguro_Celular", 100)
        RETURNING id INTO produto_seguro_celular_id;
        
        SELECT id INTO campo_adesao_valor_id FROM public.t_campo WHERE nome = 'adesao.valor';
        SELECT id INTO campo_adesao_qtdParcelas_id FROM public.t_campo WHERE nome = 'adesao.qtdParcelas';
        SELECT id INTO campo_adesao_diaCobranca_id FROM public.t_campo WHERE nome = 'adesao.diaCobranca';

        INSERT INTO public.t_produto_campo (produto_id, campo_id) VALUES (produto_seguro_celular_id, campo_adesao_valor_id);

        INSERT INTO public.t_produto_campo (produto_id, campo_id) VALUES (produto_seguro_celular_id, campo_adesao_qtdParcelas_id);
        
        INSERT INTO public.t_produto_campo (produto_id, campo_id) VALUES (produto_seguro_celular_id, campo_adesao_diaCobranca_id);

    END 
$$;