--
-- PostgreSQL database dump
--

-- Dumped from database version 11.12
-- Dumped by pg_dump version 14.2

-- Started on 2022-04-04 16:09:21 EEST

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
-- TOC entry 203 (class 1259 OID 16547)
-- Name: Movie_collection; Type: TABLE; Schema: public; Owner: student
--

CREATE TABLE public."Movie_collection" (
    movie_id integer,
    collection_id integer
);


ALTER TABLE public."Movie_collection" OWNER TO student;

--
-- TOC entry 4135 (class 2606 OID 16751)
-- Name: Movie_collection Movie_collection_collection_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id);


--
-- TOC entry 4137 (class 2606 OID 16761)
-- Name: Movie_collection Movie_collection_collection_id_fkey1; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey1" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id);


--
-- TOC entry 4155 (class 2606 OID 17208)
-- Name: Movie_collection Movie_collection_collection_id_fkey10; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey10" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id);


--
-- TOC entry 4157 (class 2606 OID 17253)
-- Name: Movie_collection Movie_collection_collection_id_fkey11; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey11" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id) ON DELETE CASCADE;


--
-- TOC entry 4159 (class 2606 OID 17298)
-- Name: Movie_collection Movie_collection_collection_id_fkey12; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey12" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id) ON DELETE CASCADE;


--
-- TOC entry 4161 (class 2606 OID 17343)
-- Name: Movie_collection Movie_collection_collection_id_fkey13; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey13" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id) ON DELETE CASCADE;


--
-- TOC entry 4163 (class 2606 OID 17388)
-- Name: Movie_collection Movie_collection_collection_id_fkey14; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey14" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id);


--
-- TOC entry 4139 (class 2606 OID 16831)
-- Name: Movie_collection Movie_collection_collection_id_fkey2; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey2" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id);


--
-- TOC entry 4141 (class 2606 OID 16856)
-- Name: Movie_collection Movie_collection_collection_id_fkey3; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey3" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id);


--
-- TOC entry 4143 (class 2606 OID 16911)
-- Name: Movie_collection Movie_collection_collection_id_fkey4; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey4" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id);


--
-- TOC entry 4145 (class 2606 OID 16986)
-- Name: Movie_collection Movie_collection_collection_id_fkey5; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey5" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id);


--
-- TOC entry 4147 (class 2606 OID 17026)
-- Name: Movie_collection Movie_collection_collection_id_fkey6; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey6" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id);


--
-- TOC entry 4149 (class 2606 OID 17071)
-- Name: Movie_collection Movie_collection_collection_id_fkey7; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey7" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id);


--
-- TOC entry 4151 (class 2606 OID 17118)
-- Name: Movie_collection Movie_collection_collection_id_fkey8; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey8" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id);


--
-- TOC entry 4153 (class 2606 OID 17163)
-- Name: Movie_collection Movie_collection_collection_id_fkey9; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_collection_id_fkey9" FOREIGN KEY (collection_id) REFERENCES public."Collection"(id);


--
-- TOC entry 4133 (class 2606 OID 16741)
-- Name: Movie_collection Movie_collection_movie_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4134 (class 2606 OID 16746)
-- Name: Movie_collection Movie_collection_movie_id_fkey1; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey1" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4152 (class 2606 OID 17158)
-- Name: Movie_collection Movie_collection_movie_id_fkey10; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey10" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4154 (class 2606 OID 17203)
-- Name: Movie_collection Movie_collection_movie_id_fkey11; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey11" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4156 (class 2606 OID 17248)
-- Name: Movie_collection Movie_collection_movie_id_fkey12; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey12" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4158 (class 2606 OID 17293)
-- Name: Movie_collection Movie_collection_movie_id_fkey13; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey13" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4160 (class 2606 OID 17338)
-- Name: Movie_collection Movie_collection_movie_id_fkey14; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey14" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4162 (class 2606 OID 17383)
-- Name: Movie_collection Movie_collection_movie_id_fkey15; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey15" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4136 (class 2606 OID 16756)
-- Name: Movie_collection Movie_collection_movie_id_fkey2; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey2" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4138 (class 2606 OID 16826)
-- Name: Movie_collection Movie_collection_movie_id_fkey3; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey3" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4140 (class 2606 OID 16851)
-- Name: Movie_collection Movie_collection_movie_id_fkey4; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey4" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4142 (class 2606 OID 16906)
-- Name: Movie_collection Movie_collection_movie_id_fkey5; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey5" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4144 (class 2606 OID 16981)
-- Name: Movie_collection Movie_collection_movie_id_fkey6; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey6" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4146 (class 2606 OID 17021)
-- Name: Movie_collection Movie_collection_movie_id_fkey7; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey7" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4148 (class 2606 OID 17066)
-- Name: Movie_collection Movie_collection_movie_id_fkey8; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey8" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4150 (class 2606 OID 17113)
-- Name: Movie_collection Movie_collection_movie_id_fkey9; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_collection"
    ADD CONSTRAINT "Movie_collection_movie_id_fkey9" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4292 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE pg_buffercache; Type: ACL; Schema: public; Owner: azure_superuser
--

GRANT SELECT ON TABLE public.pg_buffercache TO examiner;


--
-- TOC entry 4293 (class 0 OID 0)
-- Dependencies: 198
-- Name: TABLE pg_stat_statements; Type: ACL; Schema: public; Owner: azure_superuser
--

GRANT SELECT ON TABLE public.pg_stat_statements TO examiner;


-- Completed on 2022-04-04 16:09:33 EEST

--
-- PostgreSQL database dump complete
--

