import csv
import json
import ast
file = open("csv files/keywords.csv","r", encoding="utf8")
csvreader = csv.reader(file)
header = next(csvreader)
print(header[1])
f=open("csv files/Movie_Keywords.csv","w", encoding="utf8", newline='')
writer=csv.writer(f)
writer.writerow(["movie_id","keyword_id"])
set1=set()
for row in csvreader:
    jsonString=row[1]
    data=ast.literal_eval(jsonString)
    if data:
        for el in data:
            set1.add((row[0],el["id"],el["name"]))
            
          
for x in set1:
    writer.writerow((x[0],x[1]))
f.close()
f=open("csv files/Keyword.csv","w", encoding="utf8",newline='')
writer=csv.writer(f)
writer.writerow(["id","name"])
for x in set1:
    writer.writerow((x[1],x[2]))
    
file.close()
f.close()


