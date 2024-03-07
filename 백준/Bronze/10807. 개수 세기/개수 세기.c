#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define _CRT_SECURE_NO_WARNINGS

int main(void) {
	int n;
	scanf("%d", &n);

	int arr[100];
	for (int i = 0; i < n; i++) {		
		scanf("%d", &arr[i]);
	}

	
	int sameNum;
	scanf("%d", &sameNum);

	int answer = 0;
	for (int i = 0; i < n; i++) {
		if (arr[i] == sameNum) answer++;
	}
	printf("%d", answer);
	return 0;
}

