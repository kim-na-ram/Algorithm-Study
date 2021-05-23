package naram.algorithm_study;

import java.util.Scanner;

class InsertionSort {
	
	static void insertionSort(int[] array, int n) {
		
		for (int i = 1; i < n; i++) {
			
			int j;
			int temp = array[i];
			
			for (j = i; j > 0 && array[j - 1] > temp; j--)
				array[j] = array[j - 1];
				
			array[j] = temp;
			
		}
		
	}
	
}

public class InsertionSort_Algorithm {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InsertionSort Sort = new InsertionSort();
		
		int n;
		
		Scanner stdIn = new Scanner(System.in);
		
		n = stdIn.nextInt(); // n 입력
		int[] sorting = new int[n];
		
		for(int i = 0; i < n; i++) {

			sorting[i] = stdIn.nextInt();
			
		} // n개의 수 입력
		
		Sort.insertionSort(sorting, n);
		
		for(int i = 0; i < n; i++) { 
			
			System.out.println(sorting[i]);
			
		}
		
	}

}
