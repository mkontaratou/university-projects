import random

#βρίσκει επίπεδο δυσκολίας
def difficulty_level():
    d=input('Δώστε επίπεδο δυσκολίας Εύκολο (1), Μέτριο (2), Δύσκολο (3): ')
    while d!='1' and d!='2' and d!='3':
        print('Λάθος είσοδος.Παρακαλώ δώστε 1 ή 2 ή 3.')
        d=input('Δώστε επίπεδο δυσκολίας Εύκολο (1), Μέτριο (2), Δύσκολο (3): ')
    if d=='1':
        n=4
    elif d=='2':
        n=10
    else:
        n=13
    return n
    

m=4
n=difficulty_level()
    

#λίστα διαστάσεων m*n με στοιχεία 'χ'
deck_x=[]
for i in range(0,m):
    deck_x.append([])
    for j in range(0,n):
        deck_x[i].append('X')
            

ranks=["A","2","3","4","5","6","7","8","9","10","J","Q","K"]
suits =['\u2666', '\u2665', '\u2663', '\u2660']  # ["Clubs", "Diamonds", "Hearts", "Spades"]
values={"A":1,"2":2,"3":3,"4":4,"5":5,"6":6,"7":7,"8":8,"9":9,"10":10,"J":11,"Q":12,"K":13}



#λίστα με τα 52 χαρτιά της τράπουλας 
f_deck=[]
for rank in ranks:
    for suit in suits:
        f_deck.append(rank + suit)


#δημιουργεί λίστα m*n ανάλογα με το επίπεδο δυσκολίας 
p_deck=[]
if n==4:
    p=36
else:
    p=0
for i in range(0,m):
    for j in range(0,n):
        p_deck.append(f_deck[p])
        p+=1

#ανακατεύει τη λίστα
random.shuffle(p_deck)



# δημιουργεί λίστα m*n αλλά είναι ανακατεμένα τα χαρτιά της τράπουλας
final_deck=[]
v=0
for i in range(0,m):
    final_deck.append([])
    for j in range(0,n):
        final_deck[i].append(p_deck[v])
        v+=1
        



#εμφανίζει τον πίνακα
def print_board(board):
    b=['  ']
    c=[' '+ str(i+1) for i in range(0,n)]
    a=b+c
    print(*a, sep='   ') 
    for i in range(0,m):
        l=[' '+str(i+1)]
        for j in range(0,n):
            if board[i][j]=='X':
                space=' '
            else:
                space=''
            if int(a[j+1])>=11:
                l.append(space+' '+ board[i][j])
            else:
                l.append(space+board[i][j])
        print(*l,sep='   ')
    

#ελέγχει αν μπορεί να ανοίξει τρίτη κάρτα 
def third_card(a,b):
    if a=='K' and b=='Q' or a=='Q' and b=='K':
        f=True
    else:
        f=False
    return f


#υπολγίζει τους πόντους που κερδίζει ο παίκτης όταν ανοίγει δύο ίδιες κάρτες, χρησιμοποιείται και στο bonus ερώτημα 1
def points_counter(a,x,y,s1,s2,v1,v2): #a=ps, x=r1, y=r2, s1=symbol1, s2=symbol2, v1,v2 
    if v1>=10:
        p1=10
    else:
        p1=v1
    if v2>=10:
        p2=10
    else:
        p2=v2
    if a=='ΝΑΙ' and x==y and s1==s2:
        p=p1+p2
    else:
        p=p1
    return p


            
        
    
#χρησιμοποιείται για να δώσει τις συντεταγμένες της κάρτας που θέλει να ανοίξει ο χρήστης
def elements(lx,n,m,k): #deck, n, m , k:card
    r=int(input("Δώσε σειρά για "+ str(k)+"η θέση: " ))
    c= int(input("Δώσε στήλη για "+ str(k)+"η θέση: "))
    while (r <= 0 or r > m) or (c <= 0 or c> n) or lx[r-1][c-1] != "X":
        print("Μη έγκυρες συντεταγμένες.Προσπαθήστε ξανά.")
        r = int(input("Δώσε σειρά για "+ str(k)+"η θέση: "))
        c = int(input("Δώσε στήλη για "+ str(k)+"η θέση: ")) 
    return r,c


#αλλάζει το ιστορικό του υπολογιστή-παίκτη(είναι για το bonus ερώτημα 2)
def add_el(l1,l2,l3,r,c,v,s):
    if len(l1)==5:
        l1.pop(0)
        l2.pop(0)
        l3.pop(0)
    l1.append(v)
    l2.append([r,c])
    l3.append(s)
    
#ελέγχει αν υπάρχει ήδη η συγκεκριμένη κάρτα στο ιστορικό του υπολογιστή-παίκτη(είναι για το bonus ερώτημα 2)
def duplicate(r,c,cords):
    f=True
    for i in range(len(cords)-1):
        if r==cords[i-1][0] and c==cords[i-1][1]:
            f=False
    return f
             


    
    


    