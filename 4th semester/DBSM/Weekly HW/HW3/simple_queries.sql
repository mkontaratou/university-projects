--1ο ερώτημα
--Βρίσκει τις λέξεις κλειδιά της ταινίας casino
--5 rows
SELECT DISTINCT "Keyword".name
FROM "Keyword" INNER JOIN "Movie_Keywords"
ON "Movie_Keywords".keyword_id= "Keyword".id
WHERE "Movie_Keywords".movie_id=524; 

--2ο ερώτημα
--Βρίσκει ταινίες είδους crime
--1259 rows
SELECT DISTINCT "Movie".title
FROM "Movie" LEFT OUTER  JOIN "Movie_genre"
ON "Movie".id= "Movie_genre".movie_id
WHERE "Movie_genre".genre_id=80; 

--3ο ερώτημα
--Βρίσκει τις ταινίες της συλλογής James Bond που διαρκούν παραπάνω από 2 ώρες και εμφανίζει και το homepage τους
--17 rows
SELECT DISTINCT "Movie".title,"Movie".homepage
FROM "Movie" LEFT OUTER JOIN "Movie_collection"
ON "Movie".id= "Movie_collection".movie_id
WHERE "Movie_collection".collection_id=645 AND "Movie".runtime>=120 ; 

--4ο ερώτημα
--Βρίσκει τις ταινίες της PIXAR
--6 rows
SELECT DISTINCT "Movie".title
FROM "Movie" INNER JOIN "Movie_production_companies"
ON "Movie".id= "Movie_production_companies".movie_id
WHERE "Movie_production_companies".pc_id=3;

--5ο ερώτημα
--Βρίσκει τις ταινίες του Quentin Tarantino που έχουν βαθμολογηθεί με τουλάχιστον ένα 5
-- 8 Rows
SELECT DISTINCT "Movie".title
FROM "Movie" INNER  JOIN(
SELECT DISTINCT "Movie_crew".movie_id,"Movie_crew".person_id
FROM "Movie_crew"  INNER JOIN "Ratings"
ON "Movie_crew".movie_id= "Ratings".movie_id
WHERE "Ratings".rating=5) AS New_table
ON "Movie".id=New_table.movie_id
WHERE New_table.person_id=138;

--6ο ερώτημα
--Βρίσκει τις ταινίες που περιέχουν ως λέξη κλειδί την λέξη prison
--147 rows
SELECT DISTINCT "Movie".title,"Movie".id
FROM "Movie" INNER JOIN "Movie_Keywords"
ON "Movie".id= "Movie_Keywords".movie_id
WHERE "Movie_Keywords".keyword_id=378;

--7ο ερώτημα
--Ποια είναι τα βασικά departments που χρειάζονται στη δημιουργία μιας ταινίας που είχε μεγάλα έσοδα
--12 rows
SELECT DISTINCT "Movie_crew".department
FROM "Movie" INNER JOIN "Movie_crew"
ON "Movie".id= "Movie_crew".movie_id
WHERE "Movie".revenue>1000000; 

--8ο ερώτημα
--Βρίσκει πόσες family-friendly ταινίες είναι διαθέσιμες
--1 row
SELECT COUNT(movie_id) AS number_of_family_friendly_movies
FROM "Movie_genre" INNER JOIN "Genre"
ON "Movie_genre".genre_id = "Genre".id
WHERE "Genre".name LIKE 'Animation' 
	OR "Genre".name LIKE 'Comedy' 
	OR "Genre".name LIKE 'Family';
	
--9o ερώτημα
--Βρίσκει τους 100 πρώτους users που έχουν κάνει τα περισσότερα ratings σε ταινίες 
-- χωρίς το limit, 671 rows, με το limit ,100 rows
SELECT Count(user_id),user_id
from "Ratings" INNER JOIN "Movie"
on "Movie".id="Ratings".movie_id
GROUP BY user_id
ORDER BY COUNT(user_id) DESC
LIMIT 100;

--10o ερώτημα
--Επιστρέφει τον μεσο όρο, τη μέγιστη και ελάχιστη τιμή του budget των ταινιών που ήταν αρκετά δημοφιλείς
--1 row
SELECT AVG("Movie".budget::numeric) AS average_budget,
	   MAX("Movie".budget::numeric) AS max_budget,
	   AVG("Movie".budget::numeric) AS min_budget
FROM "Movie"
WHERE "Movie".popularity > 50.0 AND NOT ("Movie".budget is NULL);

--11o ερώτημα
--Επιστρέφει τίτλους ταινιών που δεν έχουν κανένα rating
--8221 rows
SELECT title
FROM public."Movie"
EXCEPT
SELECT title 
FROM "Movie" INNER JOIN "Ratings"
ON "Ratings".movie_id="Movie".id;

--12o ερώτημα
--Επιστρέφει τον τίτλο και την γλώσσα των ταινιών των 90s με γυναίκες πρωταγωνίστριες
--2795 rows
SELECT "Movie".title, "Movie".original_language
FROM "Movie"
INNER JOIN (
	SELECT DISTINCT "Movie_cast".movie_id
	FROM "Movie_cast"
	WHERE "Movie_cast".gender=1) AS New_Table
ON "Movie".id= New_Table.movie_id
WHERE "Movie".release_date BETWEEN '1990-01-01' AND '2000-01-01';