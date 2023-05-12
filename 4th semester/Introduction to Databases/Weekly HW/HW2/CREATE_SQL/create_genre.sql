--
-- PostgreSQL database dump
--

-- Dumped from database version 11.12
-- Dumped by pg_dump version 14.2

-- Started on 2022-04-04 16:06:00 EEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- TOC entry 201 (class 1259 OID 16512)
-- Name: Genre; Type: TABLE; Schema: public; Owner: student
--

CREATE TABLE public."Genre" (
    id integer NOT NULL,
    name character varying(70) NOT NULL
);


ALTER TABLE public."Genre" OWNER TO student;

--
-- TOC entry 4134 (class 2606 OID 17112)
-- Name: Genre create_genre_pkey; Type: CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Genre"
    ADD CONSTRAINT create_genre_pkey PRIMARY KEY (id);


--
-- TOC entry 4263 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE pg_buffercache; Type: ACL; Schema: public; Owner: azure_superuser
--

GRANT SELECT ON TABLE public.pg_buffercache TO examiner;


--
-- TOC entry 4264 (class 0 OID 0)
-- Dependencies: 198
-- Name: TABLE pg_stat_statements; Type: ACL; Schema: public; Owner: azure_superuser
--

GRANT SELECT ON TABLE public.pg_stat_statements TO examiner;


-- Completed on 2022-04-04 16:06:13 EEST

--
-- PostgreSQL database dump complete
--

