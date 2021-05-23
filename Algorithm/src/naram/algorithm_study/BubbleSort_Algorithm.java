package naram.algorithm_study;

import java.util.Scanner;

class BubbleSort {
	
	static void swap(int[] a, int x, int y) {
		
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
		
	}
	
	static void bubbleSort(int[] array, int n) {
		
		for (int i = 0; i < n-1; i++) {
			int exchange = 0;
			for(int j = n-1; j > i; j--) {
				if(array[j] < array[j-1]) {
					swap(array, j, j-1);
					exchange++;
				}
			}
			if(exchange == 0 ) break;
		}
		
	}
	
}

public class BubbleSort_Algorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BubbleSort Sort = new BubbleSort();
		
		int n;
		
		Scanner stdIn = new Scanner(System.in);
		
		n = stdIn.nextInt(); // n 입력
		int[] sorting = new int[n];
		
		for(int i = 0; i < n; i++) {

			sorting[i] = stdIn.nextInt();
			
		} // n개의 수 입력
		
		Sort.bubbleSort(sorting, n);
		
		for(int i = 0; i < n; i++) { 
			
			System.out.println(sorting[i]);
			
		}

	}

}
