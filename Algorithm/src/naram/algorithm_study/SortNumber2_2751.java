package naram.algorithm_study;

import java.util.Scanner;

class MergeSort {
    
    static int[] buf; // 작업용 배열
    
    static void __mergerSort(int[] a, int left, int right) {
        
        if(left < right) {
            
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;
            
            __mergerSort(a, left, center);
            __mergerSort(a, center+1, right);
            
            for(i = left; i <= center; i++)
                buf[p++] = a[i]; // for문이 끝나면 i는 center와 같음
            
            while(i <= right && j < p)
                a[k++] = (buf[j] <= a[i]) ? buf[j++] : a[i++]; 
            
            while (j < p)
                a[k++] = buf[j++];
                
        }
        
    }
    
    static void mergeSort(int[] a, int n) {
        
        buf = new int[n];
        
        __mergerSort(a, 0, n-1);
        
        buf = null;
        
    }
    
}

public class SortNumber2_2751 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		
		int n;
		
		n = stdIn.nextInt();
		int[] sorting = new int[n];
		
		for(int i = 0; i < n; i++) {
		    
		    sorting[i] = stdIn.nextInt();
		    
		}
		
		MergeSort Sort = new MergeSort();
        Sort.mergeSort(sorting, n);
    
        for (int i = 0; i < n; i++) {
            
            sb.append(sorting[i]).append('\n');
            
		}
        
		System.out.println(sb);
        
    }
}
