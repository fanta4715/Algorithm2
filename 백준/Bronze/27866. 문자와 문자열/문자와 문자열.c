#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	char str[1001];
	int i;
	scanf("%s", str);
	scanf("%d", &i);
	printf("%c", *(str + i - 1));
}