-- Table: public.items_data

-- DROP TABLE IF EXISTS public.items_data;

CREATE TABLE IF NOT EXISTS public.items_data
(
    item_id bigint NOT NULL DEFAULT nextval('items_data_item_id_seq'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    requires_cold boolean NOT NULL DEFAULT false,
    requires_freezing boolean NOT NULL DEFAULT false,
    requires_room_temp boolean NOT NULL DEFAULT false,
    expire_days integer DEFAULT '-1'::integer,
    sku text COLLATE pg_catalog."default" NOT NULL DEFAULT 0,
    description text COLLATE pg_catalog."default",
    CONSTRAINT items_data_pkey PRIMARY KEY (item_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.items_data
    OWNER to postgres;

COMMENT ON TABLE public.items_data
    IS 'data for all inventory items in the system';