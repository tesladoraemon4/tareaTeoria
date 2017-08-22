#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <ctype.h>
#include <stdbool.h>

int main(){
	int a,d;
	scanf("%d",&a);
	scanf("%d",&d);
	for (int q = 0; q <= a; ++q)
	{
		for (int r = 0; r < d; ++r){
			if(a==q*d+r){
				printf("%d\n", q);
				printf("%d\n", r);
			}
		}
		
	}

	return 0;
}
