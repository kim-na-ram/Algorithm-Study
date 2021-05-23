package naram.algorithm_study;

import java.util.Scanner;

class QuickSort {
	
	static void swap(int[] array, int x, int y) {
		
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
		
	}
	
	static void quickSort(int[] array, int left, int right) {
		int pl = left;
		int pr = right;
		int x = array[(pl + pr) / 2];
		
		do {
			while (array[pl] < x) pl++;
			while (array[pr] > x) pr--;
			
			if(pl <= pr) swap(array, pl++, pr--);
		} while(pl <= pr);
		
		if (left < pr) quickSort(array, left, pr);
		if (pl < right) quickSort(array, pl, right);
	}
	
}

public class QuickSort_Algorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QuickSort Sort = new QuickSort();
		
		int n;
		
		Scanner stdIn = new Scanner(System.in);
		
		n = stdIn.nextInt(); // n 입력
		int[] sorting = new int[n];
		
		for(int i = 0; i < n; i++) {

			sorting[i] = stdIn.nextInt();
			
		} // n개의 수 입력
		
		Sort.quickSort(sorting, 0, n-1);
		
		for(int i = 0; i < n; i++) { 
			
			System.out.println(sorting[i]);
			
		}

	}

}
