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
                a[k++] = (buf[j] >= a[i]) ? buf[j++] : a[i++]; 
            
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

public class BiggerthanN_2693 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		
		int testcase = stdIn.nextInt();
		
		int[][] card_num = new int[testcase][10];
		for(int i = 0; i < testcase; i++) {
		    for(int j = 0; j < 10; j++) {
		    
		        card_num[i][j] = stdIn.nextInt();
		    
		    }
		    
		    MergeSort Sort = new MergeSort();
            Sort.mergeSort(card_num[i], 10);
            
            sb.append(card_num[i][2]).append("\n");
            
		}
		
		System.out.println(sb);
        
    }
}