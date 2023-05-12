--Emfanizei ta pesron_id tou pinaka movie_cast, ta opoia
--exoun estw mia fora diaforetiko name h gender
--H metrhsh twn name kai gender kathe person_id ginetai me 
--to HAVING COUNT(DISTINCT ...)
SELECT person_id
FROM "Movie_cast"
GROUP BY person_id
HAVING COUNT(DISTINCT name )>1 OR COUNT(DISTINCT gender )>1;

--leitourgoume omoiws me to prohgoumeno erwthma
SELECT person_id
FROM "Movie_crew"
GROUP BY person_id
HAVING COUNT(DISTINCT name )>1 OR COUNT(DISTINCT gender )>1;

--Kanei update ta lanthasmena stoixeia
UPDATE "Movie_cast"
SET gender =2
where person_id =47395 OR person_id =1785844;

UPDATE "Movie_crew"
SET name ='Cheung Ka-Fai'
where person_id =63574
