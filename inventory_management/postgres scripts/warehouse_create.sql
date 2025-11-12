-- Table: public.warehouses

-- DROP TABLE IF EXISTS public.warehouses;

CREATE TABLE IF NOT EXISTS public.warehouses
(
    warehouse_id bigint NOT NULL DEFAULT nextval('"Warehouses_warehouse_id_seq"'::regclass),
    total_capacity integer NOT NULL DEFAULT 0,
    "used-total_capacity" integer NOT NULL DEFAULT 0,
    cold_capacity integer NOT NULL DEFAULT 0,
    used_cold_capacity integer NOT NULL DEFAULT 0,
    freezing_capacity integer NOT NULL DEFAULT 0,
    used_freezing_capacity integer NOT NULL DEFAULT 0,
    room_temp_capacity integer NOT NULL DEFAULT 0,
    used_room_temp_capacity integer NOT NULL DEFAULT 0,
    latitude real,
    longitude real,
    address text COLLATE pg_catalog."default",
    state text COLLATE pg_catalog."default" NOT NULL,
    zip_code integer NOT NULL DEFAULT 0,
    open_time_minutes integer NOT NULL DEFAULT 0,
    close_time_minutes integer NOT NULL DEFAULT 1440,
    access_level integer NOT NULL DEFAULT 0,
    geographic_department name COLLATE pg_catalog."C",
    short_name text COLLATE pg_catalog."default",
    CONSTRAINT "Warehouses_pkey" PRIMARY KEY (warehouse_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.warehouses
    OWNER to postgres;

COMMENT ON TABLE public.warehouses
    IS 'Contains warehouses and their information';