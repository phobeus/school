/*	This programm caluclates the next Day.
	Author: Christian Brüesch
	Date: 15.04.2013
	Tested: 16.04.2013 -- Aufgabe 1
	--------Augabe 2--------
	Überprüfung der eingabe:
	Möglichkeiten:
		afoejfiaowf
		39 29 1093 +
		13.02.3102
		12313957413


*/

#include <stdio.h>
#include <stdbool.h>


enum {Jan=1, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec};
enum {longMonth=1, shortMonth, possibleLeapMonth, lastMonth};


typedef struct {
int day;
int month;
int year;
} Date;


Date calculateNextDay(Date date);
int kindOfMonth(Date newDate);
void display(Date newDate);
bool isLeapYear(Date date);
bool compare(Date date, Date newDate);


int main(int argc, char **argv) {

	Date date;
	Date newDate;

	printf("Bitte geben Sie ein Datum ein (dd mm yyyy): ");
	scanf("%d%d%d", &date.day, &date.month, &date.year);

	newDate = calculateNextDay(date);

	if(!compare(date, newDate)) {
		display(newDate);
	}

	else {
		printf("Fehleingabe\n");
	}
	
	

}


Date calculateNextDay(Date date) {
	
	Date newDate = date;

	switch(kindOfMonth(newDate)) {
		case longMonth:

				if(newDate.day == 31) {
					newDate.day = 1;
					newDate.month++;
				}
				else if(newDate.day<31) {
					newDate.day++;
				}

				break;
	
		case shortMonth:

				if(newDate.day==30) {
					newDate.day = 1;
					newDate.month++;
				}
				else if(newDate.day<30) {
					newDate.day++;
				} 
				break;

		case possibleLeapMonth: 

				if(isLeapYear(newDate)) {
					if(newDate.day==29) {
						newDate.day = 1;
						newDate.month++;
					}
					else if(newDate.day<29) {
						newDate.day++;
					}
				}

				if(!isLeapYear(newDate)) {
					if(newDate.day==28) {
						newDate.day = 1;
						newDate.month++;
					}
					else if(newDate.day<28) {
						newDate.day++;
					}
				}
				break;

		case lastMonth: 

				if(newDate.day==31) {
					newDate.day = 1;
					newDate.month = 1;
					newDate.year++;
				}
				else if(newDate.day<31) {
					newDate.day++;
				}
				break;	
	}

	return newDate;
	
}

int kindOfMonth(Date newDate) {


	if(newDate.month == Jan || newDate.month == Mar || newDate.month == May || newDate.month == Jul || newDate.month == Aug || newDate.month == Oct) {
		return longMonth;
	}

	else if(newDate.month == Apr || newDate.month == Jun || newDate.month == Sep || newDate.month == Nov) {
		return shortMonth;
	}
	
	else if(newDate.month == Feb) {
		return possibleLeapMonth;
	}

	else if(newDate.month == Dec) {
		return lastMonth;
	}

	return 0;
}

void display(Date newDate) {

	if(newDate.day <10 && newDate.month <10) {
		printf("Morgen ist der: 0%d.0%d.%d\n", newDate.day, newDate.month, newDate.year);
	}

	else if( newDate.day < 10 && newDate.month >= 10) {
		printf("Morgen ist der: 0%d.%d.%d\n", newDate.day, newDate.month, newDate.year);
	}

	else if(newDate.day >= 10 && newDate.month <10) {
		printf("Morgen ist der: %d.0%d.%d\n", newDate.day, newDate.month, newDate.year);
	}

	else {
		printf("Morgen ist der: %d.%d.%d\n", newDate.day, newDate.month, newDate.year);
	}
}

bool isLeapYear(Date date) {

	if(date.year % 4 == 0 && date.year % 100 != 0) {
		return true;
	}	
	else if(date.year % 400 == 0) {
		return true;
	}
	
	return false;
}

bool compare(Date date, Date newDate) {
	if(date.day == newDate.day && date.month == newDate.month && date.year == newDate.year) {
		return true;
	}
	return false;
}
