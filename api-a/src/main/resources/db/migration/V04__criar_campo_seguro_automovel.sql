DO
$$
    DECLARE

    BEGIN 
        INSERT INTO public.t_campo(id, obrigatorio, nome) VALUES (DEFAULT, true, 'objeto.placa');
        
        INSERT INTO public.t_campo(id, obrigatorio, nome) VALUES (DEFAULT, true, 'cliente.cnh');
    END 
$$;