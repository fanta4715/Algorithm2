#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int n;
	scanf("%d", &n);
	int* p = (int*)malloc(sizeof(int) * n);
	for (int i = 0; i < n; i++) {
		scanf("%d", p + i);
	}
	int v;
	scanf("%d", &v);
	int count = 0;
	for (int i = 0; i < n; i++) {
		if (p[i] == v) count++;
	}
	printf("%d", count);
	return 0;
}