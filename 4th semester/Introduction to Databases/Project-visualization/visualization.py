import numpy as np
import matplotlib.pyplot as plt
import psycopg2
from mpl_toolkits.mplot3d import axes3d



# Update connection string information
dbname='final_project' 
user='student@auebstudentserver' 
host='auebstudentserver.postgres.database.azure.com' 
password='aueb2020!' 
sslmode='require'

#examiner_password=firstproject

# Construct connection string
conn_string = "host={0} user={1} dbname={2} password={3} sslmode={4}".format(host, user, dbname, password, sslmode)
conn = psycopg2.connect(conn_string)
print("Connection established")
cursor = conn.cursor()


#movies per year
x=[]
y=[]
cursor.execute("SELECT extract(year FROM release_date) AS year, count(*) AS number_of_movies FROM movie WHERE extract(year FROM release_date) is not NULL GROUP BY year ORDER BY year;")
rows = cursor.fetchall()
for row in rows:
    #print("Data row = (%s, %s)" %(str(row[0]), str(row[1])))
    x.append(row[0])
    y.append(row[1])
plt.title("Movies per Year")
plt.xlabel('Year')
plt.ylabel('Movies')
plt.plot(x,y)
plt.show()

#movies per genre
x=[]
y=[]
cursor.execute("SELECT genre.name, COUNT(DISTINCT movie_genres.movie_id) AS number_of_movies FROM genre INNER JOIN movie_genres  ON movie_genres.genre_id = genre.id  GROUP BY genre.name ORDER BY genre.name;")
rows = cursor.fetchall()
for row in rows:
    print("Data row = (%s, %s)" %(str(row[0]), str(row[1])))
    x.append(row[0])
    y.append(row[1])
plt.title("Movies per Genre")
plt.xlabel('Genre')
plt.ylabel('Movies')
plt.bar(x,y)
plt.show()


#movies per genre and year
xVal=[]
yVal=[]
zVal=[]
cursor.execute("SELECT  extract(year FROM release_date) AS year, genre.name, COUNT(DISTINCT movie_genres.movie_id) AS number_of_movies FROM movie INNER JOIN movie_genres  ON movie.id = movie_genres.movie_id INNER JOIN genre  ON movie_genres.genre_id = genre.id WHERE extract(year FROM release_date) is not NULL GROUP BY genre.id,year ORDER BY year DESC, COUNT(DISTINCT genre.id);")
rows = cursor.fetchall()
f=0
for row in rows:
    print("Data row = (%s, %s,%s)" %(str(row[0]), str(row[1]),str(row[2])))
    xVal.append(row[1])
    yVal.append(row[0])
    zVal.append(row[2])

# bubblesort in list xVal
for i in range(len(xVal)):
    min_index = i
    for j in range(i + 1, len(xVal)):
        if xVal[min_index] > xVal[j]:
            min_index = j

    # Swap the found minimum element with the first element
    xVal[i], xVal[min_index] = xVal[min_index], xVal[i]
    yVal[i], yVal[min_index] = yVal[min_index], yVal[i]
    zVal[i], zVal[min_index] = zVal[min_index], zVal[i]
# Initializing Figure
fig = plt.figure()
ax1 = fig.add_subplot(111, projection='3d')
ax1.set_facecolor((1.0, 1.0, 1.0))
# Creating a dictionary from categories to x-axis coordinates
xCategories = xVal
i=0
xDict = {}
x=[]
for category in xCategories:
  if category not in xDict:
    xDict[category]=i
    x.append(i)
    i+=1
  else:
    x.append(xDict[category])
# Defining the starting position of each bar (x is already defined)
z = np.zeros(len(x))
# Defining the length/width/height of each bar.
dx = np.ones(len(x))*0.1
dy = np.ones(len(x))
dz = zVal
plt.title("Movies per Year and Genre")
plt.xlabel('Genre')
plt.ylabel('Year')
ax1.bar3d(x, yVal, z, dx, dy, dz)
ax1.set_zlim([0, max(zVal)])
plt.xticks(range(len(xDict.values())), xDict.keys())
plt.show()



#biggest movie budget per year 
x=[]
y=[]
cursor.execute("SELECT extract(year FROM release_date) AS year, MAX(budget) AS max_budget FROM movie  WHERE extract(year FROM release_date) is not NULL GROUP BY year ORDER BY year DESC;")
rows = cursor.fetchall()
for row in rows:
    #print("Data row = (%s, %s)" %(str(row[0]), str(row[1])))
    x.append(row[0])
    y.append(row[1])
plt.title("Biggest budget per year")
plt.xlabel('Year')
plt.ylabel('Budget')
plt.bar(x,y)
plt.show()


#favorite actor's revenue from movies
x=[]
y=[]
cursor.execute("SELECT extract(year FROM release_date) AS year, revenue FROM movie INNER JOIN movie_cast ON movie.id = movie_cast.movie_id INNER JOIN person ON movie_cast.person_id = person.id WHERE person.name LIKE 'Johnny Depp' GROUP BY year,revenue ORDER BY year;")
rows = cursor.fetchall()
for row in rows:
    print("Data row = (%s, %s)" %(str(row[0]), str(row[1])))
    x.append(row[0])
    y.append(row[1])
plt.title("Johny's Depp revenues")
plt.xlabel('Year')
plt.ylabel('Revenue')
plt.bar(x,y)
plt.show()


#average rating per user
x=[]
y=[]
cursor.execute("SELECT DISTINCT user_id, ROUND(AVG(rating)::numeric,2) AS average_rating FROM ratings GROUP BY user_id ORDER BY user_id;")
rows = cursor.fetchall()
for row in rows:
    #print("Data row = (%s, %s)" %(str(row[0]), str(row[1])))
    x.append(row[0])
    y.append(row[1])
plt.title("Average rating per user")
plt.xlabel('User')
plt.ylabel('Average Rating')
plt.scatter(x,y,alpha=0.5)
plt.show()

#number of ratings per user
x=[]
y=[]
cursor.execute("SELECT DISTINCT user_id , count(rating) AS number_of_ratings FROM ratings GROUP BY user_id ORDER BY user_id;")
rows = cursor.fetchall()
for row in rows:
    #print("Data row = (%s, %s)" %(str(row[0]), str(row[1])))
    x.append(row[0])
    y.append(row[1])
plt.title("Number of ratings per user")
plt.xlabel('User')
plt.ylabel('number of ratings')
plt.scatter(x,y,alpha=0.5)
plt.show()


#number of ratings and average rating per user
x=[]
y=[]
cursor.execute("SELECT user_id,ROUND(AVG(rating)::numeric, 2) AS average_rating, COUNT(user_id) AS number_of_ratings FROM ratings GROUP BY user_id ORDER BY user_id;")
rows = cursor.fetchall()
for row in rows:
    #print("Data row = (%s, %s,%s)" %(str(row[0]), str(row[1]),str(row[2])))
    x.append(row[2])
    y.append(row[1])
plt.title("Number of ratings and average rating per user")
plt.xlabel('number of ratings')
plt.ylabel('average rating')
plt.scatter(x,y,alpha=0.5)
plt.show()


#average rating per genre
x=[]
y=[]
cursor.execute("SELECT genre.name ,ROUND(AVG(rating)::numeric, 2) AS average_rating FROM genre INNER JOIN movie_genres ON genre.id = movie_genres.genre_id INNER JOIN ratings  ON movie_genres.movie_id = ratings.movie_id GROUP BY genre.name ORDER BY genre.name;")
rows = cursor.fetchall()
for row in rows:
    #print("Data row = (%s, %s)" %(str(row[0]), str(row[1])))
    x.append(row[0])
    y.append(row[1])
plt.title("Average rating per user")
plt.xlabel('genre')
plt.ylabel('average rating')
plt.bar(x,y)
plt.show()

