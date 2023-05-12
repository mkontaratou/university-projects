--
-- PostgreSQL database dump
--

-- Dumped from database version 11.12
-- Dumped by pg_dump version 14.2

-- Started on 2022-04-04 16:11:36 EEST

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
-- TOC entry 206 (class 1259 OID 16562)
-- Name: Movie_production_companies; Type: TABLE; Schema: public; Owner: student
--

CREATE TABLE public."Movie_production_companies" (
    movie_id integer,
    pc_id integer
);


ALTER TABLE public."Movie_production_companies" OWNER TO student;

--
-- TOC entry 4133 (class 2606 OID 16931)
-- Name: Movie_production_companies Movie_production_companies_movie_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_movie_id_fkey" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4135 (class 2606 OID 17006)
-- Name: Movie_production_companies Movie_production_companies_movie_id_fkey1; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_movie_id_fkey1" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4153 (class 2606 OID 17408)
-- Name: Movie_production_companies Movie_production_companies_movie_id_fkey10; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_movie_id_fkey10" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4137 (class 2606 OID 17046)
-- Name: Movie_production_companies Movie_production_companies_movie_id_fkey2; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_movie_id_fkey2" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4139 (class 2606 OID 17091)
-- Name: Movie_production_companies Movie_production_companies_movie_id_fkey3; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_movie_id_fkey3" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4141 (class 2606 OID 17138)
-- Name: Movie_production_companies Movie_production_companies_movie_id_fkey4; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_movie_id_fkey4" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4143 (class 2606 OID 17183)
-- Name: Movie_production_companies Movie_production_companies_movie_id_fkey5; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_movie_id_fkey5" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4145 (class 2606 OID 17228)
-- Name: Movie_production_companies Movie_production_companies_movie_id_fkey6; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_movie_id_fkey6" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4147 (class 2606 OID 17273)
-- Name: Movie_production_companies Movie_production_companies_movie_id_fkey7; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_movie_id_fkey7" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4149 (class 2606 OID 17318)
-- Name: Movie_production_companies Movie_production_companies_movie_id_fkey8; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_movie_id_fkey8" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4151 (class 2606 OID 17363)
-- Name: Movie_production_companies Movie_production_companies_movie_id_fkey9; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_movie_id_fkey9" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4134 (class 2606 OID 16936)
-- Name: Movie_production_companies Movie_production_companies_pc_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_pc_id_fkey" FOREIGN KEY (pc_id) REFERENCES public."Production_company"(id);


--
-- TOC entry 4136 (class 2606 OID 17011)
-- Name: Movie_production_companies Movie_production_companies_pc_id_fkey1; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_pc_id_fkey1" FOREIGN KEY (pc_id) REFERENCES public."Production_company"(id);


--
-- TOC entry 4154 (class 2606 OID 17413)
-- Name: Movie_production_companies Movie_production_companies_pc_id_fkey10; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_pc_id_fkey10" FOREIGN KEY (pc_id) REFERENCES public."Production_company"(id);


--
-- TOC entry 4138 (class 2606 OID 17051)
-- Name: Movie_production_companies Movie_production_companies_pc_id_fkey2; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_pc_id_fkey2" FOREIGN KEY (pc_id) REFERENCES public."Production_company"(id);


--
-- TOC entry 4140 (class 2606 OID 17096)
-- Name: Movie_production_companies Movie_production_companies_pc_id_fkey3; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_pc_id_fkey3" FOREIGN KEY (pc_id) REFERENCES public."Production_company"(id);


--
-- TOC entry 4142 (class 2606 OID 17143)
-- Name: Movie_production_companies Movie_production_companies_pc_id_fkey4; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_pc_id_fkey4" FOREIGN KEY (pc_id) REFERENCES public."Production_company"(id);


--
-- TOC entry 4144 (class 2606 OID 17188)
-- Name: Movie_production_companies Movie_production_companies_pc_id_fkey5; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_pc_id_fkey5" FOREIGN KEY (pc_id) REFERENCES public."Production_company"(id);


--
-- TOC entry 4146 (class 2606 OID 17233)
-- Name: Movie_production_companies Movie_production_companies_pc_id_fkey6; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_pc_id_fkey6" FOREIGN KEY (pc_id) REFERENCES public."Production_company"(id);


--
-- TOC entry 4148 (class 2606 OID 17278)
-- Name: Movie_production_companies Movie_production_companies_pc_id_fkey7; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_pc_id_fkey7" FOREIGN KEY (pc_id) REFERENCES public."Production_company"(id);


--
-- TOC entry 4150 (class 2606 OID 17323)
-- Name: Movie_production_companies Movie_production_companies_pc_id_fkey8; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_pc_id_fkey8" FOREIGN KEY (pc_id) REFERENCES public."Production_company"(id) ON DELETE CASCADE;


--
-- TOC entry 4152 (class 2606 OID 17368)
-- Name: Movie_production_companies Movie_production_companies_pc_id_fkey9; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_production_companies"
    ADD CONSTRAINT "Movie_production_companies_pc_id_fkey9" FOREIGN KEY (pc_id) REFERENCES public."Production_company"(id) ON DELETE CASCADE;


--
-- TOC entry 4283 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE pg_buffercache; Type: ACL; Schema: public; Owner: azure_superuser
--

GRANT SELECT ON TABLE public.pg_buffercache TO examiner;


--
-- TOC entry 4284 (class 0 OID 0)
-- Dependencies: 198
-- Name: TABLE pg_stat_statements; Type: ACL; Schema: public; Owner: azure_superuser
--

GRANT SELECT ON TABLE public.pg_stat_statements TO examiner;


-- Completed on 2022-04-04 16:11:50 EEST

--
-- PostgreSQL database dump complete
--

