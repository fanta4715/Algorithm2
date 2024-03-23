#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int n, x, count=0;
	scanf("%d %d", &n, &x);
	int* p = (int*)malloc(sizeof(int) * n);
	for (int i = 0; i < n; i++) {
		int temp;
		scanf("%d", &temp);
		if (temp < x) printf("%d ", temp);
	}
	
	return 0;
}