DO
$$
    DECLARE

    BEGIN
        INSERT INTO public.t_campo(id, obrigatorio, nome) VALUES (DEFAULT, true, "adesao.valor");
        INSERT INTO public.t_campo(id, obrigatorio, nome) VALUES (DEFAULT, true, "adesao.qtdParcelas");
        INSERT INTO public.t_campo(id, obrigatorio, nome) VALUES (DEFAULT, true, "adesao.diaCobranca");
    END 
$$;