-- Table: public.roles

-- DROP TABLE IF EXISTS public.roles;

CREATE TABLE IF NOT EXISTS public.roles
(
    role text COLLATE pg_catalog."default" NOT NULL,
    access_level integer DEFAULT 0,
    geographic_department text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT roles_pkey PRIMARY KEY (role),
    CONSTRAINT access_and_location UNIQUE (access_level, geographic_department)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.roles
    OWNER to postgres;

COMMENT ON TABLE public.roles
    IS 'roles for users';