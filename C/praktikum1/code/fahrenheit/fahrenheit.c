/*
 * fahrenheit.c
 *
 *  Created on: Apr 9, 2013
 *      Author: christian
 */

#include <stdio.h>
#include <stdbool.h>

#define SCREEN_HEIGHT 100

void printList();
void fhrInC();
float convertFhrtoC(float fahrenheit);
void cInFhr();
float convertCtoFhr(float celsius);
void clearScreen();
void waitForInput();

int main(int argc, char **argv) {
	bool run = true;
	

	while(run) {

		int selection, testNumber;
		clearScreen();

		printf("Fahrenheit <-------> Celsius berechnung\n");
		printf("\n\n 1. Liste Fahrenheit - Celsius\n");
		printf(" 2. Fahrenheit in Celsius umrechnen \n");
		printf(" 3. Celsius in Fahrenheit umrechnen \n");
		printf(" 0. Programm beenden\n\n\n");
		
		printf(" Bitte geben Sie ein (Nummer) was sie machen möchten: ");
			
		testNumber = scanf("%d", &selection);

		if (testNumber) { /*Test if the input was a number*/

		clearScreen();

		switch(selection) {
			case 1: printList();
				waitForInput();
				break;
			case 2: fhrInC();
				waitForInput();
				break;
			case 3: cInFhr();
				waitForInput();
				break;
			case 0: run = false; break;
		}

		} 
		else {
		  /**** Erroneous input, get rid of it and retry! */
		  scanf ("%*[^\n]");
		}

	}

	return 0;
}





void printList() {
	int i;

	printf("F'heit    Celsius\n");
	printf("-----------------\n");
	
	for (i = -100; i<=200; i=i+20 ){
		printf("%d\t%.2f\n",i, convertFhrtoC(i));
	}

	float convertFhrtoC(float fahrenheit) {
		return (5.0f/9.0f)*(fahrenheit-32);
	}
}

void fhrInC() {
	float fahrenheit;
	int testNumber;
	
	printf(" Geben sie an wieviel Fahrenheit Sie umrechnen wollen: ");
	testNumber = scanf("%f", &fahrenheit);

	if (testNumber) {
		printf(" %.2f Fahrenheit sind %.2f Celsius \n",fahrenheit, convertFhrtoC(fahrenheit));
	}

	else {
		  /**** Erroneous input, get rid of it and retry! */
		  scanf ("%*[^\n]");
	}
}

float convertFhrtoC(float fahrenheit) {
	return (5.0f/9.0f)*(fahrenheit-32);
}

void cInFhr() {
	float celsius;
	int testNumber;
	
	printf(" Geben sie an wieviel Celsius Sie umrechnen wollen: ");
	testNumber = scanf("%f", &celsius);

	if (testNumber) { /*Test if the input was a number*/
		printf(" %.2f Celsius sind %.2f Fahrenheit \n",celsius, convertCtoFhr(celsius));
	}

	else {
		  /**** Erroneous input, get rid of it and retry! */
		  scanf ("%*[^\n]");
	}
	

}

float convertCtoFhr(float celsius) {
	return ((9.0f*celsius)/5.0f)+32;
}

void clearScreen() {
	int i;

	for (i = 0; i<SCREEN_HEIGHT; i++) {
		printf("\n");
	}
}

void waitForInput() {

	bool wait = true;
	int testNumber;

	while (wait) {
		int keystroke;
		printf(" Drücken sie \"1\" um weiterzufahren: ");
		testNumber = scanf("%d", &keystroke);
		if (testNumber) {
			if(keystroke == 1) {
				wait = false;
			}
		}
		
		else {
		  /**** Erroneous input, get rid of it and retry! */
		  scanf ("%*[^\n]");
	}

	}
}
