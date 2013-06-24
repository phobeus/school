/*	Programm grades.c
	Author: Christian Brüesch
	Date: 18.04.2013
*/

#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#include <assert.h>

#define TESTMODE 1			/* Testmode 0 (Normales Programm) Testmode 1 (Test calculateGrades) Testmode 2 (Test calculateAverage) */
#define NUMBER_OF_GRADES 100
#define ROUND_US(x) ((unsigned) ((x)+.5))

void calculateGrades(float *points, int length, float minPoints, int *grades);
void display(int *grades, int length, float minPoints);
void sort(int *grades, int length);
void swap(int *grades, int i, int j);
float calculateAverage(int *grades, int length);
int calculateMarkOverFour(int *grades,int length);


#if TESTMODE == 0
int main(int argc, char **argv) {

	float points[NUMBER_OF_GRADES], minPoints, average;
	int length = 0, grades[NUMBER_OF_GRADES], desicion;
	bool waitForInput = true, calculateResult = true;

	while (waitForInput) {
		printf("Geben Sie die Punktzahl des Studenten ein: ");
		scanf("%f", &points[length]);
		if(points[length] == -1) {
			waitForInput =false;
		}
		length++;
	}
	length--;

	
	while(calculateResult) {
		printf("Geben Sie ein, wieviele Punkte benötigt werden um eine 6 zu erreichen: ");
		scanf("%f", &minPoints);

		calculateGrades(points, length, minPoints, grades);
		sort(grades, length);
	
	
		display(grades, length, minPoints);

		printf("Möchten Sie eine andere Punktezahl eingeben für die Note 6? (1/0) :");
		scanf("%d", &desicion);
		if(desicion == 0) {
			calculateResult=false;
		}	
	}
}



void calculateGrades(float *points, int length, float minPoints, int *grades) {

	int i;

	for(i = 0; i<length; i++) {
		grades[i] = ROUND_US(((5*points[i])/minPoints)+1);
		printf("%d", grades[i]);
		if (grades[i] > 6) {
			grades[i] = 6;
		}	
	}

}

void display(int *grades, int length, float minPoints) {

	printf("----------------------------------------------\n");
	printf("Statistics (%d Students, %.1f Points needed for mark 6)\n\n", length, minPoints);	

	int i, j=0;
	for(i = 1; i<7; i++) {
		int tmp = 0;
		while(grades[j] == i) {
			tmp++;
			j++;
		}
		printf("Mark %d: %d\n", i, tmp);
	}
	printf("\n\n\n\n");
	printf("Best Mark: %d\n", grades[length-1]);
	printf("Worst Mark: %d\n", grades[0]);
	printf("Average: %.2f\n", calculateAverage(grades, length));
	printf("Mark >=4: %d\n", calculateMarkOverFour(grades,length));
	printf("----------------------------------------------\n\n\n\n");
}

void sort(int *grades, int length) {

	int i=0, j;

	while(i<length-1) {
		j=i+1;
		while(j<length) {
			if(grades[i]<grades[j]) {
				j++;
			}
			else if(grades[i]>grades[j]) {
				swap(grades,i,j);
				j++;
			}
			else if(grades[i]==grades[j]) {
				j++;
			}
		}
		i++;
	}
}

void swap(int *grades, int i, int j) {

	int tmp = grades[i];
	grades[i] = grades[j];
	grades[j] = tmp;
}

float calculateAverage(int *grades, int length) {

	int i;
	float average;

	for (i=0; i<length; i++) {

		average+=grades[i];
	}

	return average/length;


}

int calculateMarkOverFour(int *grades,int length) {

	int i, result = 0;

	for(i=0; i<length; i++) {
		if(grades[i] >=4) {
			result++;
		}
	}
	return result;
}

#elif TESTMODE == 1
int main(int argc, char **argv) {

	float points[NUMBER_OF_GRADES], minPoints, average;
	int length = 0, grades[NUMBER_OF_GRADES], desicion;
	bool waitForInput = true, calculateResult = true;

	/*Abfüllen der Punkte*/
	points[0] = 50;
	points[1] = 10005;
	points[2] = 0;
	points[3] = 75;
	points[4] = 33;
	points[5] = 18;
	points[6] = 5;

	minPoints = 50.0;
	length=7;

	calculateGrades(points, length, minPoints, grades);

	
	assert(minPoints==50);
	assert(grades[0] == 6);
	assert(grades[1] == 6);
	/* assert(grades[2] == 6); Richtige Werte noch einfüllen
	assert(grades[3] == 6);
	assert(grades[4] == 6);
	assert(grades[5] == 6);
	assert(grades[6] == 6); */
}


void calculateGrades(float *points, int length, float minPoints, int *grades) {

	int i;

	for(i = 0; i<length; i++) {
		grades[i] = ROUND_US(((5*points[i])/minPoints)+1);
		printf("%d", grades[i]);
		if (grades[i] > 6) {
			grades[i] = 6;
		}	
	}

}



#endif

