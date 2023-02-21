-- 4o erwthma.Dhmiourgia twn pinakwn Person,Actor kai CrewMember

CREATE TABLE IF NOT EXISTS "Person"(
person_id INT PRIMARY KEY,
name VARCHAR(50),
gender INT
);

CREATE TABLE IF NOT EXISTS "Actor"(
)inherits("Person");

CREATE TABLE IF NOT EXISTS "CrewMember"(
)inherits("Person");

--Backup twn piankwn Movie_cast kai Movie_crew 
CREATE TABLE IF NOT EXISTS "Movie_cast2"
AS TABLE "Movie_cast";

CREATE TABLE IF NOT EXISTS "Movie_crew2"
AS TABLE "Movie_crew";


--5o erwthma. xrhsimopoioumai tous backup pinakes logw diagrafhs kapoiwn gnwrismatwn tous se epomena erwthmata
SELECT person_id
FROM(
SELECT DISTINCT
cas.movie_id movie_cast_id, crew.movie_id movie_crew_id,cas.person_id
FROM "Movie_cast2" cas
INNER JOIN  "Movie_crew2" crew
ON cas.person_id=crew.person_id 
ORDER BY person_id)AS foo
GROUP BY person_id
HAVING COUNT(DISTINCT name )>1 OR COUNT(DISTINCT gender )>1;

--6o erwthma. Insert ta katallhla stoixeia stous pinakes
INSERT INTO "Actor"(person_id,name,gender)
SELECT DISTINCT
person_id,name,gender
FROM "Movie_cast2";

INSERT INTO "CrewMember"(person_id,name,gender)
SELECT DISTINCT
person_id,name,gender
FROM "Movie_crew2";

INSERT INTO "Person"(person_id,name,gender)
SELECT DISTINCT
person_id,name,gender
FROM "Movie_cast2"
UNION
SELECT DISTINCT
person_id,name,gender
FROM "Movie_crew2"
EXCEPT
SELECT person_id,name,gender
FROM "Movie_crew2";

--7o erwthma. diagrafh gnwrismatwn
ALTER TABLE "Movie_cast"
DROP COLUMN name,
DROP COLUMN gender,
ADD FOREIGN KEY(movie_id) REFERENCES "Movie"(id);

ALTER TABLE "Movie_crew"
DROP COLUMN name,
DROP COLUMN gender,
ADD FOREIGN KEY(person_id) REFERENCES "CrewMember"(person_id);




