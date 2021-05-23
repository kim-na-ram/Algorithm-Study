package naram.algorithm_study;

import java.util.Scanner;

class SelectionSort {
	
	static void swap(int a[], int x, int y) {
		
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
		
	}
	
	static void selectionSort(int array[], int n) {
		
		for (int i = 0; i < n - 1; i++) {
			
			int min = i;
			
			for (int j = i + 1; j < n; j++) {
				
				if(array[j] < array[min]) min = j;
				swap(array, i, min);
				
			}
			
		}
		
	}
	
}

public class SelectionSort_Algorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SelectionSort Sort = new SelectionSort();
		
		int n;
		
		Scanner stdIn = new Scanner(System.in);
		
		n = stdIn.nextInt(); // n 입력
		int[] sorting = new int[n];
		
		for(int i = 0; i < n; i++) {

			sorting[i] = stdIn.nextInt();
			
		} // n개의 수 입력
		
		Sort.selectionSort(sorting, n);
		
		for(int i = 0; i < n; i++) { 
			
			System.out.println(sorting[i]);
			
		}

	}

}
