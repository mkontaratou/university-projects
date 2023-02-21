#pragma once
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdbool.h>

const int n_tel = 3;
const int n_cash = 2;
const int n_seat = 10;
const int n_zoneA = 10;
const int n_zoneB = 20;
const int p_zoneA = 30;
const int c_zoneA = 30;
const int c_zoneB = 20;
const int n_seatLow = 1;
const int n_seatHigh = 5;
const int t_resLow = 1;
const int t_resHigh = 5;
const int t_seatLow = 5;
const int t_seatHigh = 13;
const int t_cashLow = 4;
const int t_cashHigh = 8;
const int cardSuccess = 90;

//DECLARATION OF MUTEXES
pthread_mutex_t console = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t m_availableTel = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t m_availableCash = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t m_waitingTime = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t m_servicingTime = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t m_balance = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t m_seatsA = PTHREAD_MUTEX_INITIALIZER; //seats plan
pthread_mutex_t m_seatsB = PTHREAD_MUTEX_INITIALIZER; //seats plan 

//for rsv_seats()
pthread_mutex_t m_avail = PTHREAD_MUTEX_INITIALIZER; 
pthread_mutex_t m_seats = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t m_failTheatre = PTHREAD_MUTEX_INITIALIZER; 

//for seats 
pthread_mutex_t m_seatsAvailA = PTHREAD_MUTEX_INITIALIZER; 
pthread_mutex_t m_seatsAvailB = PTHREAD_MUTEX_INITIALIZER; 

//for card()
pthread_mutex_t m_completed = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t m_failCard = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t m_availSeatsForCards = PTHREAD_MUTEX_INITIALIZER;

//DECLARATION OF CONDITIONS
pthread_cond_t condition_n_availableTel = PTHREAD_COND_INITIALIZER;
pthread_cond_t condition_n_availableCash = PTHREAD_COND_INITIALIZER;

//DECLARATION OF FUNCTIONS
void cardCalculations(int zone_id,int rand_seats,int cid,int *seats_id);
void RSVseats(int zone_id, int rand_seats,int cid,int* seats_id);

//DECLARATION OF GLOBAL VARIABLES
int rc; //response code
int n_availableTel;
int n_availableCash;
double waitingTime=0;
double servicingTime=0;
double balance=0;
//for RSVseats()
int avail;
int* seats;
int seatsAvailA;
int seatsAvailB;
float failTheatre=0;
//for cardCalculations()
float completed=0;
float failCard=0;
unsigned int availSeatsForCards=0;
//for terminal
int Ncust;
int seedT;
//for zones
int *zoneA;
int *zoneB;
