--Αριθμός ταινιών ανά χρόνο
SELECT extract(year FROM release_date) AS year, count(*) AS number_of_movies
FROM movie
WHERE extract(year FROM release_date) is not NULL
GROUP BY year
ORDER BY year;


--Αριθμός ταινιών ανά είδος(genre)
SELECT genre.name, COUNT(DISTINCT movie_genres.movie_id) AS number_of_movies
FROM genre INNER JOIN movie_genres 
ON movie_genres.genre_id = genre.id 
GROUP BY genre.name
ORDER BY genre.name;


--Αριθμός ταινιών ανά είδος (genre) και ανά έτος
SELECT  extract(year FROM release_date) AS year, genre.name, COUNT(DISTINCT movie_genres.movie_id) AS number_of_movies
FROM movie INNER JOIN movie_genres 
ON movie.id = movie_genres.movie_id
INNER JOIN genre 
ON movie_genres.genre_id = genre.id
WHERE extract(year FROM release_date) is not NULL
GROUP BY genre.id,year
ORDER BY year DESC, COUNT(DISTINCT genre.id);

--Το υψηλότερο budget ταινίας ανά έτος (δεν μας ενδιαφέρει για ποια ταινία)
SELECT extract(year FROM release_date) AS year, MAX(budget) AS max_budget
FROM movie 
WHERE extract(year FROM release_date) is not NULL
GROUP BY year
ORDER BY year DESC;


--Για τον αγαπημένο σας ηθοποιό, το σύνολο των εσόδων (revenue) για τις ταινίες στις οποίες έχει
--συμμετάσχει ανά έτος
SELECT extract(year FROM release_date) AS year, revenue
FROM movie INNER JOIN movie_cast
ON movie.id = movie_cast.movie_id
INNER JOIN person
ON movie_cast.person_id = person.id
WHERE person.name LIKE 'Johnny Depp'
GROUP BY year,revenue
ORDER BY year;


--Μέση βαθμολογία (rating) ανά χρήστη
SELECT DISTINCT user_id, ROUND(AVG(rating)::numeric,2) AS average_rating
FROM ratings
GROUP BY user_id
ORDER BY user_id;

--Αριθμός από βαθμολογίες ανά χρήστη 
SELECT DISTINCT user_id , count(rating) AS number_of_ratings
FROM ratings
GROUP BY user_id
ORDER BY user_id;


--Scatter plot το οποίο θα έχει ένα σημείο για κάθε χρήστη που στον x άξονα φαίνεται ο αριθμός
--των αξιολογήσεων του χρήστη και στον y άξονα η μέση βαθμολογία του
--Αριθμός από αξιολογήσεις χρήστη ανά μέση βαθμολογία του χρήστη
SELECT user_id,ROUND(AVG(rating)::numeric, 2) AS average_rating, COUNT(user_id) AS number_of_ratings
FROM ratings
GROUP BY user_id
ORDER BY user_id;


--Μέση βαθμολογία (rating) ανά είδος ταινίας
SELECT genre.name ,ROUND(AVG(rating)::numeric, 2) AS average_rating
FROM genre INNER JOIN movie_genres
ON genre.id = movie_genres.genre_id
INNER JOIN ratings 
ON movie_genres.movie_id = ratings.movie_id
GROUP BY genre.name
ORDER BY genre.name;






