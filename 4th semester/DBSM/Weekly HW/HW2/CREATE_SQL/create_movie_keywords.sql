--
-- PostgreSQL database dump
--

-- Dumped from database version 11.12
-- Dumped by pg_dump version 14.2

-- Started on 2022-04-04 16:07:53 EEST

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
-- TOC entry 210 (class 1259 OID 16734)
-- Name: Movie_Keywords; Type: TABLE; Schema: public; Owner: student
--

CREATE TABLE public."Movie_Keywords" (
    movie_id integer,
    keyword_id integer
);


ALTER TABLE public."Movie_Keywords" OWNER TO student;

--
-- TOC entry 4133 (class 2606 OID 17016)
-- Name: Movie_Keywords Movie_Keywords_movie_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_Keywords"
    ADD CONSTRAINT "Movie_Keywords_movie_id_fkey" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4134 (class 2606 OID 17056)
-- Name: Movie_Keywords Movie_Keywords_movie_id_fkey1; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_Keywords"
    ADD CONSTRAINT "Movie_Keywords_movie_id_fkey1" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4135 (class 2606 OID 17101)
-- Name: Movie_Keywords Movie_Keywords_movie_id_fkey2; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_Keywords"
    ADD CONSTRAINT "Movie_Keywords_movie_id_fkey2" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4136 (class 2606 OID 17148)
-- Name: Movie_Keywords Movie_Keywords_movie_id_fkey3; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_Keywords"
    ADD CONSTRAINT "Movie_Keywords_movie_id_fkey3" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4137 (class 2606 OID 17193)
-- Name: Movie_Keywords Movie_Keywords_movie_id_fkey4; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_Keywords"
    ADD CONSTRAINT "Movie_Keywords_movie_id_fkey4" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4138 (class 2606 OID 17238)
-- Name: Movie_Keywords Movie_Keywords_movie_id_fkey5; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_Keywords"
    ADD CONSTRAINT "Movie_Keywords_movie_id_fkey5" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4139 (class 2606 OID 17283)
-- Name: Movie_Keywords Movie_Keywords_movie_id_fkey6; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_Keywords"
    ADD CONSTRAINT "Movie_Keywords_movie_id_fkey6" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4140 (class 2606 OID 17328)
-- Name: Movie_Keywords Movie_Keywords_movie_id_fkey7; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_Keywords"
    ADD CONSTRAINT "Movie_Keywords_movie_id_fkey7" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id) ON DELETE CASCADE;


--
-- TOC entry 4141 (class 2606 OID 17373)
-- Name: Movie_Keywords Movie_Keywords_movie_id_fkey8; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_Keywords"
    ADD CONSTRAINT "Movie_Keywords_movie_id_fkey8" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id) ON DELETE CASCADE;


--
-- TOC entry 4142 (class 2606 OID 17418)
-- Name: Movie_Keywords Movie_Keywords_movie_id_fkey9; Type: FK CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public."Movie_Keywords"
    ADD CONSTRAINT "Movie_Keywords_movie_id_fkey9" FOREIGN KEY (movie_id) REFERENCES public."Movie"(id);


--
-- TOC entry 4271 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE pg_buffercache; Type: ACL; Schema: public; Owner: azure_superuser
--

GRANT SELECT ON TABLE public.pg_buffercache TO examiner;


--
-- TOC entry 4272 (class 0 OID 0)
-- Dependencies: 198
-- Name: TABLE pg_stat_statements; Type: ACL; Schema: public; Owner: azure_superuser
--

GRANT SELECT ON TABLE public.pg_stat_statements TO examiner;


-- Completed on 2022-04-04 16:08:07 EEST

--
-- PostgreSQL database dump complete
--

