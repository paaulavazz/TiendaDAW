-- Table: public.pedido

-- DROP TABLE IF EXISTS public.pedido;

CREATE TABLE IF NOT EXISTS public.pedido
(
    id integer NOT NULL DEFAULT nextval('pedido_id_seq'::regclass),
    usuariocomprador integer NOT NULL,
    importe numeric(10,2) NOT NULL,
    CONSTRAINT pedido_pkey PRIMARY KEY (id),
    CONSTRAINT pedido_usuariocomprador_fkey FOREIGN KEY (usuariocomprador)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pedido
    OWNER to postgres;

GRANT ALL ON TABLE public.pedido TO daw WITH GRANT OPTION;

GRANT ALL ON TABLE public.pedido TO postgres;