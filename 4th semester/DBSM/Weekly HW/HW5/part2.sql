--Βρίσκει τους ηθοποιούς που έχουν παίξει σε πάνω από 10 ταινίες
SELECT per.name,COUNT(mc.person_id)
FROM "Person" per
INNER JOIN "Movie_cast" mc
ON mc.person_id=per.person_id
GROUP BY per.person_id
HAVING COUNT(mc.person_id)>10;

--Βρίσκει Crew members τα οποία συνεργάστηκαν με την Pixar και 
--η ταινία που συμμετείχαν είχε μέσο όρο βαθμολογίας μεγαλύτερο από 3
SELECT DISTINCT per.name,AVG(r.rating) AS avgRating 
FROM "Person" per
INNER JOIN "Movie_crew" mcr
ON mcr.person_id=per.person_id
INNER JOIN "Movie_production_companies" mpc
ON mcr.movie_id=mpc.movie_id
INNER JOIN "Ratings" r
ON r.movie_id=mpc.movie_id
WHERE mpc.pc_id=3
GROUP BY per.name
HAVING AVG(r.rating)>3;


--Βρίσκει ηθοποιούς που έχουν συμμετάσχει σε ταινία και με άλλο ρόλο πέρα από του ηθοποιού
SELECT DISTINCT per.name
FROM "Person" per
INNER JOIN "Movie_cast" ca
ON ca.person_id=per.person_id
INNER JOIN "Movie_crew" cr
ON cr.person_id=per.person_id
INNER JOIN "Movie" mo
ON mo.id=ca.movie_id  
WHERE mo.id=cr.movie_id
