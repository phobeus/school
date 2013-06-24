#include <stdio.h>

int main(int argc, char **argv) {

	char current;
	
	int woerter = 0, zeichen = 0, i=0;

	while ((current=getchar()) != '\n') {
		if(i==0) {
			woerter++;
			i++;
		}
		if(current == ' ' || current == '\t') {
			woerter++;
		}
		else {
			zeichen++;
		}
	}
	printf("Ihre Eingabe beinhaltet %d Zeichen und %d Wörter\n", zeichen, woerter);
}
