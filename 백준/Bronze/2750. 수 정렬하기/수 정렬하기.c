#include <stdio.h>
//#include <string.h>
//#define _USE_MATH_DEFINES
//#include <math.h>

int main(void) {
	int N, arr[1000] = {0,};
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}

		}
	}
	for (int i = 0; i < N; i++) {
		printf("%d\n",arr[i]);

	}
	

}