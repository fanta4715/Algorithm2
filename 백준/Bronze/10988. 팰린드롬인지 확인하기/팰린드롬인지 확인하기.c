#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main() {
	char str[101];
	scanf("%s", str);
	int len = strlen(str);
	char isSym = 1; // 0이면 비대칭, 1이면 팰린드롬
	for (int i = 0; i < len /2; i++) {
		if (str[i]!=str[len-1-i]) {
			isSym = 0;
			break;
		}
	}
	printf("%d", isSym);
}