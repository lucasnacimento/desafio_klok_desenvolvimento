DO
$$
    DECLARE

    BEGIN 
        INSERT INTO public.t_campo(id, obrigatorio, nome) VALUES (DEFAULT, true, 'adesao.qtdParcelas');
        
        INSERT INTO public.t_campo(id, obrigatorio, nome) VALUES (DEFAULT, true, 'adesao.diaCobranca');
        
        INSERT INTO public.t_campo(id, obrigatorio, nome) VALUES (DEFAULT, true, 'objeto.marca');
        
        INSERT INTO public.t_campo(id, obrigatorio, nome) VALUES (DEFAULT, true, 'objeto.armazenamento');
        
        INSERT INTO public.t_campo(id, obrigatorio, nome) VALUES (DEFAULT, true, 'cliente.cpf');
    END 
$$;