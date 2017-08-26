#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <ctype.h>
#include <stdbool.h>

int main(){
	char *a=(char *)malloc(100*sizeof(char));
	scanf("%s",a);
	int x=0;
	for (;*a!='\0';a++)
	{
		if('0'==*a){
			x++;
		}
	}
	printf("%d\n", x);
	return 0;
}
