from time import sleep


print("Καλωσήλθατε στο Matching Game.")
#input ονόματα
names=[]
num_players=int(input("Δώστε πλήθος παικτών: "))
while num_players<1:
    print('Μη έγκυρος αριθμός παικτών.Ξαναπροσπαθήστε.')
    num_players=int(input("Δώστε πλήθος παικτών: "))
 

x=num_players
for i in range (x):
    onoma_player=str(input("Δώστε το όνομά σας: "))
    names.append(onoma_player)
names.sort()


#αρχικοποίηση πόντων 
points = []
#κάθε παίκτης ξεκινά με 0 πόντους
for i in range(num_players):
    points.append(0)
    

from cardgame_funcs import *  
ps=input('Θέλεις να μετράει στους πόντους το άθροισμα των αξιών των καρτών που ανοίγονται, έχουν το ίδιο σύμβολο και βρίσκονται στην ίδια σειρά: ')
while ps!='ΝΑΙ' and ps!='ΟΧΙ':
    print('Λάθος απάντηση. Απάντησε ΝΑΙ ή ΟΧΙ.') 
    ps=input('Θέλεις να μετράει στους πόντους το άθροισμα των αξιών των καρτών που ανοίγονται, έχουν το ίδιο σύμβολο και βρίσκονται στην ίδια σειρά: ')
print_board(deck_x) 


if num_players==1:
    ran_choices=[]
    val_choices=[]
    sym_choices=[]
    points.append(0)

        
        
activegame=False
while not activegame:
    
    if i!=1 or num_players!=1: 
        i=0
    while i<num_players and  not activegame:
        print(names[i]+' είναι η σειρά σου.')
        k=1
        r1,c1=elements(deck_x,n,m,k)
        deck_x[r1-1][c1-1]=final_deck[r1-1][c1-1]
        print_board(deck_x)
        k=2
        r2,c2=elements(deck_x,n,m,k)
        deck_x[r2-1][c2-1] = final_deck[r2-1][c2-1]
        print_board(deck_x)
        v1=values[deck_x[r1-1][c1-1][:-1]] #deck_x[r1-1][c1-1][:-1] δίνει ουσιαστικά το Q,10,J,K της θεσης// κάνει πριντ πχ σε λιστα 1,2,3 το 1,2
        v2=values[deck_x[r2-1][c2-1][:-1]]
        symbol1=deck_x[r1-1][c1-1][-1] #καρδουλα, ρανκ γενικα της θεσης το -1 γτ είναι τελευταίο στοιχείο
        symbol2=deck_x[r2-1][c2-1][-1]


        if v1!=v2 and ((ps=='ΝΑΙ' and (symbol1!=symbol2 or r1!=r2)) or ps=='ΟΧΙ'):
            #ειδικες καρτες - 3η καρτα αν Q,K
            if third_card(deck_x[r1-1][c1-1][0],deck_x[r2-1][c2-1][0]): #ελέγχει αν μπορεί να ανοίξει τρίτη κάρτα 
                print('Σου δίνεται η δυνατότητα να ανοίξεις και τρίτη κάρτα.')
                k=3
                r3,c3=elements(deck_x,n,m,k)
                deck_x[r3-1][c3-1]=final_deck[r3-1][c3-1]
                print_board(deck_x)
                v3= values[deck_x[r3-1][c3-1][:-1]]
                symbol3=deck_x[r3-1][c3-1][-1]

                if v1==v3:
                    p=points_counter(ps,r1,r3,symbol1,symbol3,v1,v3)
                    print('Μπράβο κέρδισες '+ str(p) + ' πόντους.')
                    points[i]=points[i]+p
                    deck_x[r2-1][c2-1]='X' #η 2η καρτα κλείνει
                    third=True
                    sym=False
                elif v2==v3:
                    p=points_counter(ps,r2,r3,symbol2,symbol3,v2,v3)
                    print('Μπράβο κέρδισες '+ str(p) + ' πόντους.')    
                    points[i]=points[i]+p
                    deck_x[r1-1][c1-1]='X' #η 3η κάρτα κλείνει
                    third=True
                    sym=False
                elif symbol1==symbol3 and r1==r3 and ps=='ΝΑΙ' : #bonus1 εάν είναι 1,3 ίδια σειρά
                    p=points_counter(ps,r1,r3,symbol1,symbol3,v1,v3)
                    print('Μπράβο κέρδισες '+ str(p) + ' πόντους.')
                    points[i]=points[i]+p
                    deck_x[r2-1][c2-1]='X'
                    third=True
                    sym=True
                elif symbol2==symbol3 and r2==r3 and ps=='ΝΑΙ': #bonus1 εάν είναι 2,3 ίδια σειρά
                    p=points_counter(ps,r2,r3,symbol2,symbol3,v2,v3)
                    print('Μπράβο κέρδισες '+ str(p) + ' πόντους.')    
                    points[i]=points[i]+p
                    deck_x[r1-1][c1-1]='X'
                    third=True
                    sym=True
                else: #αν δεν έχει κοινό ζευγάρι
                    deck_x[r3-1][c3-1]='X'
                    third=False

                if third==True: #3η κάρτα: ειδική κάρτα Κ - ΧΑΝΕΙ ΤΗ ΣΕΙΡΑ ΤΟΥ
                    print(names[i]+ ' έχεις '+ str(points[i])+ ' πόντους.')
                    if sym==False: #όχι τα μπόνους1,2
                        if deck_x[r3-1][c3-1][0]=='K': #i=player
                            if num_players-1==i:
                                print(names[0]+ ' χάνεις την σειρά σου.')
                                i=1
                            elif num_players-2==i: 
                                print(names[i+1]+ ' χάνεις την σειρά σου.')
                                i=0
                            else:
                                print(names[i+1]+ ' χάνεις την σειρά σου.')
                                i+=2
                        else:
                            i+=1
                
                else: #για 3η καρτα-οχι ζευγος
                    i+=1
                    deck_x[r2-1][c2-1]='X'
                    deck_x[r1-1][c1-1]='X'

            else: #οχι ζευγος
                i+=1
                deck_x[r2-1][c2-1]='X'
                deck_x[r1-1][c1-1]='X'
            print('\n')
            print_board(deck_x)


        else: #αν v1=v2 δλδ έχουμε ζευγάρι
            p=points_counter(ps,r1,r2,symbol1,symbol2,v1,v2)
            print('Μπράβο κέρδισες '+ str(p) + ' πόντους.')
            points[i]=points[i]+p
            print(names[i]+ ' έχεις '+ str(points[i])+ ' πόντους.')

            if deck_x[r1-1][c1-1][0]=='J' and deck_x[r2-1][c2-1][0]=='J':
                print('Πετύχες δύο βαλέδες, ξαναπαίζεις.')
            elif deck_x[r1-1][c1-1][0]=='K' and deck_x[r2-1][c2-1][0]=='K':
                if num_players-1==i: #αν παιζει ο τελευταιος παικτης, χανει θεση ο 1ος
                    print(names[0]+ ' χάνεις την σειρά σου.')
                    i=1
                elif num_players-2==i: #αν παιζει ο προτελευταιος παικτης, χανει θεση ο τελευταιος
                    print(names[i+1]+ ' χάνεις την σειρά σου.')
                    i=0
                elif num_players==1:
                    print('Ο αντίπαλος χάνει την σειρά του.')
                    i=0
                else: #σε όποια άλλη περίπτωση
                    print(names[i+1]+ ' χάνεις την σειρά σου.')
                    i+=2
            else:
                i+=1
        if deck_x==final_deck:
            activegame=True


    #εδώ ξεκινάει ο κώδικας για το bonus2
    if i!=0 and num_players==1:
        z=0
        flag=False
        lr=len(val_choices)-1
        while z<=lr:
            #ελέγχει αν έχει στο ιστορικό  2 ίδια φύλλα για να τα ανοίξει ( το ιστορικό περιέχει το πολύ 5 φύλλα )
            if val_choices.count(val_choices[z])==2:
                flag=True
                for l in range(lr):
                    if val_choices[l]==val_choices[z] and l!=z:
                        h1=ran_choices.pop(z)
                        r1=h1[0]
                        c1=h1[1]
                        h2=ran_choices.pop(l)
                        r2=h2[0]
                        c2=h2[1]
                        v1=val_choices.pop(z)
                        v2=val_choices.pop(l)
                        s1=sym_choices.pop(z)
                        s2=sym_choices.pop(l)
                        

                deck_x[r1-1][c1-1]= final_deck[r1-1][c1-1]
                print('\n')
                print_board(deck_x)
                sleep(3)
                deck_x[r2-1][c2-1]= final_deck[r2-1][c2-1]
                print('\n')
                print_board(deck_x)
            elif ps=='ΝΑΙ' and sym_choices.count(sym_choices[z])==2:
                flag=True
                for l in range(lr):
                    if sym_choices[l]==sym_choices[z] and ran_choices[l][0]==ran_choices[z] and l!=z:
                        h1=ran_choices.pop(z)
                        r1=h1[0]
                        c1=h1[1]
                        h2=ran_choices.pop(l)
                        r2=h2[0]
                        c2=h2[1]
                        v1=val_choices.pop(z)
                        v2=val_choices.pop(l)
                        s1=sym_choices.pop(z)
                        s2=sym_choices.pop(l)
                        
                        
                        
                deck_x[r1-1][c1-1]= final_deck[r1-1][c1-1]
                print('\n')
                print_board(deck_x)
                sleep(3)
                deck_x[r2-1][c2-1]= final_deck[r2-1][c2-1]
                print('\n')
                print_board(deck_x)
            z+=1
        #ανοίγει random φύλλο
        if flag==False:
            r1=random.randint(1,m)
            c1=random.randint(1,n)
            while deck_x[r1-1][c1-1] != "X":
                r1=random.randint(1,m)
                c1=random.randint(1,n)
            deck_x[r1-1][c1-1]= final_deck[r1-1][c1-1]
            print('\n')
            print_board(deck_x)
            sleep(3)
            v1=values[deck_x[r1-1][c1-1][:-1]]
            symbol1=deck_x[r1-1][c1-1][-1]
            j=0
            f=False
            #ελέγχει αν υπάρχει στο ιστορικό κάποιο ίδιο φύλλο με αυτό που έχει ανοίξει
            if ran_choices!=[] :
                while j<len(ran_choices) and f==False:
                    if val_choices[j]==v1  and duplicate(r1,c1,ran_choices)==True:
                        r2=ran_choices[j][0]
                        c2=ran_choices[j][1]
                        deck_x[r2-1][c2-1]=final_deck[r2-1][c2-1]
                        print('\n')
                        print_board(deck_x)
                        sleep(3)
                        v2=values[deck_x[r2-1][c2-1][:-1]]
                        symbol2=deck_x[r2-1][c2-1][-1]
                        val_choices.pop(j)
                        ran_choices.pop(j)
                        sym_choices.pop(j)
                        f=True
                    elif sym_choices[j]==symbol1 and ran_choices[j][0]==r1 and duplicate(r1,c1,ran_choices)==True:
                        r2=ran_choices[j][0]
                        c2=ran_choices[j][1]
                        deck_x[r2-1][c2-1]=final_deck[r2-1][c2-1]
                        print('\n')
                        print_board(deck_x)
                        sleep(3)
                        v2=values[deck_x[r2-1][c2-1][:-1]]
                        symbol2=deck_x[r2-1][c2-1][-1]
                        val_choices.pop(j)
                        ran_choices.pop(j)
                        sym_choices.pop(j)
                        f=True

                    j+=1
            #ανοίγει και δεύτερο random φύλλο
            if f==False:
                r2=random.randint(1,m)
                c2=random.randint(1,n)
                while deck_x[r2-1][c2-1] != "X":
                    r2=random.randint(1,m)
                    c2=random.randint(1,n)
                deck_x[r2-1][c2-1]= final_deck[r2-1][c2-1]
                print('\n')
                print_board(deck_x)
                sleep(3)
                v2=values[deck_x[r2-1][c2-1][:-1]]
                symbol2=deck_x[r2-1][c2-1][-1]
            if v1!=v2 and ((ps=='ΝΑΙ' and (symbol1!=symbol2 or r1!=r2)) or ps=='ΟΧΙ'):
                if third_card(deck_x[r1-1][c1-1][0],deck_x[r2-1][c2-1][0]):
                    print('Σου δίνεται η δυνατότητα να ανοίξεις και τρίτη κάρτα.')
                    j=0
                    g=False
                    #στην περίπτωση που μπορεί να ανοίξει 3ο φύλλο, ελέγχει αν υπάρχει στο ιστορικό κάποιο ίδιο με το δεύτερο φύλλο που άνοιξε
                    if ran_choices!=[] :
                        while j<len(ran_choices) and g==False:
                            if val_choices[j]==v1 and duplicate(r2,c2,ran_choices)==True and duplicate(r1,c1,ran_choices)==True :
                                r3=ran_choices[j][0]
                                c3=ran_choices[j][1]
                                deck_x[r3-1][c3-1]=final_deck[r3-1][c3-1]
                                print('\n')
                                print_board(deck_x)
                                sleep(3)
                                v3=values[deck_x[r3-1][c3-1][:-1]]
                                symbol3=deck_x[r3-1][c3-1][-1]
                                val_choices.pop(j)
                                ran_choices.pop(j)
                                sym_choices.pop(j)
                                g=True
                            elif sym_choices[j]==symbol2 and ran_choices[j][0]==r2 and duplicate(r2,c2,ran_choices)==True and duplicate(r1,c1,ran_choices)==True:
                                r3=ran_choices[j][0]
                                c3=ran_choices[j][1]
                                deck_x[r3-1][c3-1]=final_deck[r3-1][c3-1]
                                print('\n')
                                print_board(deck_x)
                                sleep(3)
                                v3=values[deck_x[r3-1][c3-1][:-1]]
                                symbol3=deck_x[r3-1][c3-1][-1]
                                val_choices.pop(j)
                                ran_choices.pop(j)
                                sym_choices.pop(j)
                                g=True
                            j+=1
                    #ανοίγει τρίτο random φύλλο
                    if g==False:
                        r3=random.randint(1,m)
                        c3=random.randint(1,n)
                        while deck_x[r3-1][c3-1] != "X":
                            r3=random.randint(1,m)
                            c3=random.randint(1,n)
                        deck_x[r3-1][c3-1]= final_deck[r3-1][c3-1]
                        print('\n')
                        print_board(deck_x)
                        sleep(3)
                        v3=values[deck_x[r3-1][c3-1][:-1]]
                        symbol3=deck_x[r3-1][c3-1][-1]
                    if v1==v3:
                        p=points_counter(ps,r1,r3,symbol1,symbol3,v1,v3)
                        print('Μπράβο κέρδισες '+ str(p) + ' πόντους.')
                        points[i]=points[i]+p
                        deck_x[r2-1][c2-1]='X'
                        third=True
                        sym=False
                    elif v2==v3:
                        p=points_counter(ps,r2,r3,symbol2,symbol3,v2,v3)
                        print('Μπράβο κέρδισες '+ str(p) + ' πόντους.')    
                        points[i]=points[i]+p
                        deck_x[r1-1][c1-1]='X'
                        third=True
                        sym=False
                    elif symbol1==symbol3 and r1==r3 :
                        p=points_counter(ps,r1,r3,symbol1,symbol3,v1,v3)
                        print('Μπράβο κέρδισες '+ str(p) + ' πόντους.')
                        points[i]=points[i]+p
                        deck_x[r2-1][c2-1]='X'
                        third=True
                        sym=True
                    elif symbol2==symbol3 and r2==r3:
                        p=points_counter(ps,r2,r3,symbol2,symbol3,v2,v3)
                        print('Μπράβο κέρδισες '+ str(p) + ' πόντους.')    
                        points[i]=points[i]+p
                        deck_x[r1-1][c1-1]='X'
                        third=True
                        sym=True
                    else:
                        deck_x[r3-1][c3-1]='X'
                        third=False
                    if third==True:
                        print('Ο αντίπαλος έχει '+ str(points[i])+ ' πόντους.')
                        if sym==False:
                            if deck_x[r3-1][c3-1][0]=='K':
                                print(names[0]+ ' χάνεις την σειρά σου.')
                                i=1
                            else:
                                i=0

                    else:
                        i=0
                        #αν τα φύλλα που άνοιξε δεν ταιριάζουν τα αποθηκεύει στο ιστορικό του σε αυτή την συνθήκη ελέγχει να μην μπει δύο φορές το ίδιο φύλλο στο ιστορικό
                        if duplicate(r1,c1,ran_choices)==True:
                            add_el(val_choices,ran_choices,sym_choices,r1,c1,v1,symbol1)
                        deck_x[r1-1][c1-1]='X'
                        if duplicate(r2,c2,ran_choices)==True:
                            add_el(val_choices,ran_choices,sym_choices,r2,c2,v2,symbol2)
                        deck_x[r2-1][c2-1]='X'
                        if duplicate(r3,c3,ran_choices)==True:
                            add_el(val_choices,ran_choices,sym_choices,r3,c3,v3,symbol3)
                        deck_x[r3-1][c3-1]='X'  
                else:
                    i=0
                    if duplicate(r1,c1,ran_choices)==True:
                        add_el(val_choices,ran_choices,sym_choices,r1,c1,v1,symbol1)
                    deck_x[r1-1][c1-1]='X'
                    if duplicate(r2,c2,ran_choices)==True:
                        add_el(val_choices,ran_choices,sym_choices,r2,c2,v2,symbol2)
                    deck_x[r2-1][c2-1]='X'
                print('\n')
                print_board(deck_x)
            else:
                p=points_counter(ps,r1,r2,symbol1,symbol2,v1,v2)
                print('Μπράβο κέρδισες '+ str(p) + ' πόντους.')
                points[i]=points[i]+p
                print('Ο αντίπαλος έχει '+ str(points[i])+ ' πόντους.')
                if deck_x[r1-1][c1-1][0]=='J' and deck_x[r2-1][c2-1][0]=='J':
                    print('Πετύχες δύο βαλέδες, ξαναπαίζεις.')
                    i=1
                elif deck_x[r1-1][c1-1][0]=='K' and deck_x[r2-1][c2-1][0]=='K':
                    print(names[0]+ ' χάνεις την σειρά σου.')
                    i=1
                else:
                    i=0
            if deck_x==final_deck:
                activegame=True





if num_players>1:
    #Tαξινόμηση Eυθείας Ανταλλαγης(Βubble Sort)
    p=len(points)
    for i in range(p-1):
        for j in range(p-1,i,-1):
            if points[j]>points[j-1]:
                points[j],points[j-1]=points[j-1],points[j]
                names[j],names[j-1]=names[j-1],names[j]
            elif points[j]==points[j-1] and names[j]<names[j-1]:
                names[j],names[j-1]=names[j-1],names[j]
    print(names[0]+" είσαι ο νικητής με "+str(points[0])+ " πόντους!")
    draw=1
    while points[draw]==points[0] and draw<=num_players:
        print(names[draw]+ ' ισοβαθμείς σε πόντους με τον νικητή!')
        draw+=1

else:
    if points[0]>points[1]:
        print(names[0]+" είσαι ο νικητής με "+str(points[0])+ " πόντους!")
    elif points[0]<points[1]:
        print('Έχασες. Ο αντίπαλος είχε ' +str(points[1])+ ' πόντους!')
    else:
        print('Ισοπαλία!')       

            



    