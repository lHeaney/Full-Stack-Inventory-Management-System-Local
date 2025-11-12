-- Table: public.inventory

-- DROP TABLE IF EXISTS public.inventory;

CREATE TABLE IF NOT EXISTS public.inventory
(
    order_number bigint NOT NULL,
    item_id bigint,
    amount bigint,
    warehouse_id integer,
    expiration_date date,
    CONSTRAINT inventory_pkey PRIMARY KEY (order_number),
    CONSTRAINT item_id FOREIGN KEY (item_id)
        REFERENCES public.items_data (item_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT warehouse_id FOREIGN KEY (warehouse_id)
        REFERENCES public.warehouses (warehouse_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.inventory
    OWNER to postgres;

COMMENT ON TABLE public.inventory
    IS 'master table of all inventory';