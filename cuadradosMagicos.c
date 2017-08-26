#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int sig(float x){
	return (x>=0)?floor(x):ceil(x);
}

void genArray(int a[][],int n){



	for (int k = 0; k < n*n; ++k)
	{
		int i=(a+c*k+e*sig(k/n))%n;
		int j=(a+c*k+e*sig(k/n))%n;
		a[i][j]=k;
	}
}


int main(int argc, char const *argv[])
{
	int n;
	printf("Introduzca n del cuadrado magico\n");
	scanf("%d",&n);
	int a[n][n];
	genArray(a,n);
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < n; ++j)
			printf("%d\n", a[i][j]);
	}

	return 0;
}