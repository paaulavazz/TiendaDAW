-- Table: public.usuario

-- DROP TABLE IF EXISTS public.usuario;

CREATE TABLE IF NOT EXISTS public.usuario
(
    id integer NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),
    correoelectronico character varying(100) COLLATE pg_catalog."default" NOT NULL,
    contrasena character varying(100) COLLATE pg_catalog."default" NOT NULL,
    tipotarjeta character varying(50) COLLATE pg_catalog."default" NOT NULL,
    numtarjeta character varying(16) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_correoelectronico_key UNIQUE (correoelectronico)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuario
    OWNER to postgres;

GRANT ALL ON TABLE public.usuario TO daw WITH GRANT OPTION;

GRANT ALL ON TABLE public.usuario TO postgres;