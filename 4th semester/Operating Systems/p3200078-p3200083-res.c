#include "p3200078-p3200083-res.h"
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>

void * main_thread(void *customer_id){
	
	int cid;
	cid = *(int *)customer_id;

	unsigned int seedT = seedT^(cid); //seed for every thread
	struct timespec c_start; // start ordering
	struct timespec c_service; // found phoner and start ordering
	struct timespec c_tel_done; // wait to find cashier
	struct timespec c_cash_done; // found available cashier
	struct timespec c_done; // service is done


	//start ordering
	clock_gettime(CLOCK_REALTIME,&c_start);
	rc = pthread_mutex_lock(&m_availableTel);
	if(rc != 0){
		printf("Σφάλμα κλειδώματος στο mutex με response code %d\n", rc);
		pthread_exit(&rc);
	}

	while (n_availableTel<=0){
		rc = pthread_cond_wait(&condition_n_availableTel,&m_availableTel);
		if(rc != 0){
		printf("Σφάλμα κλειδώματος στο mutex με response code %d\n", rc);
		pthread_exit(&rc);
		}
	}


	//Found phoner and start ordering
	n_availableTel--;
	clock_gettime(CLOCK_REALTIME,&c_service);
	rc = pthread_mutex_unlock(&m_availableTel);
	if(rc != 0){
		printf("Σφάλμα κλειδώματος στο mutex με response code %d\n", rc);
		pthread_exit(&rc);
	}

	
	//random number of tickets, random service time, random zone, random cashier time
	int rand_seats = rand_r(&seedT) % n_seatHigh + n_seatLow;
	int rand_telTime = rand_r(&seedT) % t_seatHigh + t_seatLow;
	int rand_zone = rand_r(&seedT) % 101;
	int rand_cashTime = rand_r(&seedT) % t_cashHigh + t_cashLow;

	//choose random seats
	int *seats_id = (int*)malloc(sizeof(int)*rand_seats);
	if (seats_id==NULL){
		printf("Δεν υπάρχει αρκετή διαθέσιμη μνήμη.\n");
		pthread_exit(NULL);
	}

	while(sleep(rand_telTime) > 0){
		rc = pthread_mutex_lock(&m_availableTel);
		n_availableTel++;
		rc = pthread_cond_signal(&condition_n_availableTel);
		rc = pthread_mutex_unlock(&m_availableTel);
		pthread_exit(&rc);
	}

	//select zone
	int zone_id;
	if(rand_zone<p_zoneA){
		zone_id=1;
	}else{
		zone_id=2;
	}


    if(zone_id==1){
        avail = seatsAvailA; // for RSVseats()
        m_avail = m_seatsAvailA; //for RSVseats()
        m_availSeatsForCards = m_seatsAvailA; //for cardCalculations()
        availSeatsForCards = seatsAvailA; //for cardCalculations()
        seats = zoneA; //for plan
        m_seats = m_seatsA; // for plan
    }

    if(zone_id==2){
        avail = seatsAvailB; // for RSVseats()
        m_avail = m_seatsAvailB; // for RSVseats()
        m_availSeatsForCards = m_seatsAvailB; //for cardCalculations()
        availSeatsForCards = seatsAvailB; //for cardCalculations()
        seats = zoneB; //for plan
        m_seats = m_seatsB; // for plan
    }

	//check if seats are available
	RSVseats(zone_id,rand_seats,cid,seats_id);

	//Releasing telephoner
	rc = pthread_mutex_lock(&m_availableTel);
	n_availableTel++;
	rc = pthread_cond_signal(&condition_n_availableTel);
	rc = pthread_mutex_unlock(&m_availableTel);
	if(rc != 0){
		printf("Σφάλμα κλειδώματος στο mutex με response code %d\n", rc);
		pthread_exit(&rc);
	}


	//wait to find cashier
	clock_gettime(CLOCK_REALTIME,&c_tel_done);
	rc = pthread_mutex_lock(&m_availableCash);
	if(rc != 0){
		printf("Σφάλμα κλειδώματος στο mutex με response code %d\n", rc);
		pthread_exit(&rc);
	}

	while (n_availableCash<=0){
		rc = pthread_cond_wait(&condition_n_availableCash,&m_availableCash);
		if(rc != 0){
		printf("Σφάλμα κλειδώματος στο mutex με response code %d\n", rc);
		pthread_exit(&rc);
		}
	}


	//found available cashier
	n_availableCash--;
	clock_gettime(CLOCK_REALTIME,&c_cash_done);
	rc = pthread_mutex_unlock(&m_availableCash);
	if(rc != 0){
		printf("Σφάλμα κλειδώματος στο mutex με response code %d\n", rc);
		pthread_exit(&rc);
	}


	//cashier service time
	while(sleep(rand_cashTime) > 0){
		rc = pthread_mutex_lock(&m_availableCash);
		n_availableCash++;
		rc = pthread_cond_signal(&condition_n_availableCash);
		rc = pthread_mutex_unlock(&m_availableCash);
		pthread_exit(&rc);
	}
	cardCalculations(zone_id,rand_seats,cid,seats_id);
	free(seats_id);


	//The service is done 
	clock_gettime(CLOCK_REALTIME,&c_done);
	rc = pthread_mutex_unlock(&m_availableCash);

	if(rc != 0){
		printf("Σφάλμα κλειδώματος στο mutex με response code %d\n", rc);
		pthread_exit(&rc);
	}



	//Releasing cashier
	rc = pthread_mutex_lock(&m_availableCash);
	n_availableCash++;
	rc = pthread_cond_signal(&condition_n_availableCash);
	rc = pthread_mutex_unlock(&m_availableCash);
	if(rc != 0){
		printf("Σφάλμα κλειδώματος στο mutex με response code %d\n", rc);
		pthread_exit(&rc);
	}



	//Calculate waiting and service time 
	pthread_mutex_lock(&m_waitingTime);
	waitingTime+=(c_service.tv_sec - c_start.tv_sec) + (c_cash_done.tv_sec - c_tel_done.tv_sec);
	pthread_mutex_unlock(&m_waitingTime);

	pthread_mutex_lock(&m_servicingTime);
	servicingTime+=(c_done.tv_sec - c_service.tv_sec) + (c_done.tv_sec - c_cash_done.tv_sec);
	pthread_mutex_unlock(&m_servicingTime);

	pthread_exit(NULL);

}



void cardCalculations(int zone_id,int rand_seats,int cid,int *seats_id){
    int cost;
	if(zone_id==1){
		cost = c_zoneA;
	}
	if(zone_id==2){
		cost = c_zoneB;
	}
	int rand_prob = rand_r(&seedT) % 101;


	//Successful transaction
	if(rand_prob<cardSuccess){
		pthread_mutex_lock(&m_balance);
		balance += rand_seats * cost;
		pthread_mutex_unlock(&m_balance);

		pthread_mutex_lock(&console);
		printf("\n Η κράτηση ολοκληρώθηκε επιτυχώς. \n Αριθμός πελάτη: %d.  Οι θέσεις σας είναι στη ζώνη %d, σειρά %d, αριθμός ", cid, zone_id, (seats_id[0]/n_seat)+1);
		for (int i=0;i<rand_seats;i++){
			printf("%d ",seats_id[i]);
		}
		printf("\nκαι το κόστος της συναλλαγής είναι %d ευρώ!\n", rand_seats*cost);
		pthread_mutex_unlock(&console);
		pthread_mutex_lock(&m_completed);
		completed++;
		pthread_mutex_unlock(&m_completed);
	}
	//Failed transaction due to card
	else{
		pthread_mutex_lock(&m_seats);
		for (int i=0;i<rand_seats;i++){
			seats[seats_id[i]]=0;
		}
		pthread_mutex_unlock(&m_seats);

		pthread_mutex_lock(&m_availSeatsForCards);
        availSeatsForCards += rand_seats;
		pthread_mutex_unlock(&m_availSeatsForCards);

		pthread_mutex_lock(&console);
		printf("\n Αριθμός πελάτη %d: Η κράτηση απέτυχε γιατί η συναλλαγή με την πιστωτική κάρτα δεν έγινε αποδεκτή.\n", cid);
		pthread_mutex_unlock(&console);

		pthread_mutex_lock(&m_failCard);
		failCard++;
		pthread_mutex_unlock(&m_failCard);

	}
}



void RSVseats(int zone_id, int rand_seats,int cid,int* seats_id){
    int rows;
    if(zone_id==1){
        rows = n_zoneA;
    }
    if(zone_id==2){
        rows = n_zoneB;
    }

    //check whether seats are available
    pthread_mutex_lock(&m_avail);
    bool noSeats = avail<rand_seats;
    pthread_mutex_unlock(&m_avail);

    //while we have available seats
    if(!noSeats){

        pthread_mutex_lock(&m_seats);
        int first = -1;
        int sum_of_seats=0;
        noSeats = true;

        for (int r=0;r<rows;r++){
            //i= seat index
            for(int i=0;i<n_seat;i++){
                if(seats[r*n_seat+i] == 0){
                    sum_of_seats++;
                    if(sum_of_seats == rand_seats){
                        first = r*n_seat+i;
                    }
                } else{
                    sum_of_seats=0;
                    noSeats=true;
                }

                if(sum_of_seats==rand_seats){
                    noSeats=false;
                    for(int s=first;s<first+rand_seats;s++){
                        seats_id[s-first]=s;
                        seats[s]=cid;
                    }

                    //update available seats
                    pthread_mutex_lock(&m_avail);
                    avail -= rand_seats;
                    pthread_mutex_unlock(&m_avail);
                    break;
                }
            }

            if(sum_of_seats==rand_seats) {
                break;
            }
            else{
                sum_of_seats=0;
                noSeats=true;
            }

        }
        pthread_mutex_unlock(&m_seats);
    }



    //we don't have available seats
    if(noSeats){
        //release tel
        pthread_mutex_lock(&m_availableTel);
        n_availableTel++;
        pthread_cond_signal(&condition_n_availableTel);
        pthread_mutex_unlock(&m_availableTel);

        //errors
        pthread_mutex_lock(&console);
        printf("Αριθμός πελάτη %d: Η κράτηση απέτυχε γιατί δεν υπάρχουν κατάλληλες θέσεις.\n ",cid);
        pthread_mutex_lock(&m_failTheatre);
        failTheatre++;
        pthread_mutex_unlock(&m_failTheatre);
        pthread_mutex_unlock(&console);

        free(seats_id);
        pthread_exit(NULL);
    }

}



int main(int argc, char *argv[]){

	Ncust = atoi (argv[1]);
	seedT = atoi(argv[2]);

	seatsAvailA = n_zoneA;
	seatsAvailB = n_zoneB;
	n_availableTel = n_tel;
	n_availableCash = n_cash;

	//Initialize seats
	int seats_A = n_seat * n_zoneA;
	zoneA = (int*)malloc(sizeof(int)*n_seat*n_zoneA);
	for(int i=0;i<seats_A;i++){
		zoneA[i]=0;
	}

	int seats_B = n_seat * n_zoneB;
	zoneB = (int*)malloc(sizeof(int)*n_seat*n_zoneB);
	for(int i=0;i<seats_B;i++){
		zoneB[i]=0;
	}


	//Initialize customer id and threads 
	int cid[Ncust];
	for(int i=0;i<Ncust;i++){
		cid[i]=i+1;
	}

	//Create threads
	pthread_t tid[Ncust];
	for (int i=0;i<Ncust;i++){
		pthread_create(&tid[i],NULL, &main_thread,(void*)&cid[i]);

	}

	//Wait for threads to finish
	for (int i=0;i<Ncust;++i){
		pthread_join(tid[i],NULL);
	}

	//Printing results
	pthread_mutex_lock(&console);
	printf("\nΠλάνο θέσεων ζώνης Α: \n");
	for(int i=0;i<seats_A;i++){
        if (zoneA[i] != 0)
            printf("Ζώνη Α / Σειρά %d / Θέση %d / Πελάτης %d\n",(i/n_seat)+1, i,zoneA[i]);
	}

    printf("\nΠλάνο θέσεων ζώνης Β: \n");
    for(int i=0;i<seats_B;i++){
        if (zoneB[i] != 0)
            printf("Ζώνη B / Σειρά %d / Θέση %d / Πελάτης %d\n",(i/n_seat)+1, i,zoneB[i]);
    }

	printf("\n\n Συνολικά έσοδα από τις πωλήσεις: %f\n", balance);
	printf("\n Ποσοστό επιτυχημένων συναλλαγών: %f\n", completed*100/Ncust);
	printf("\n Ποσοστό αποτυχημένων συναλλαγών λόγω χρήσης κάρτας: %f\n", failCard*100/Ncust);
	printf("\n Ποσοστό αποτυχημένων συναλλαγών λόγω έλλειψης θέσεων: %f\n", failTheatre*100/Ncust);
	printf("\n Μέσος χρόνος αναμονής πελατών: %f\n", waitingTime/Ncust);
	printf("\n Μέσος χρόνος εξυπηρέτησης πελατών: %f\n", servicingTime/Ncust);

	pthread_mutex_unlock(&console);
	return 0;
	

}

