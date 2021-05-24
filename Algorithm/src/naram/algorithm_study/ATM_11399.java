package naram.algorithm_study;

import java.util.Scanner;
import java.util.Arrays;

class ATM {
    
    static void sumMin(int[] array) {
        
        int sum = 0;
        int allSum = 0;
        
        for(int i = 0; i < array.length; i++) {
            
            sum += array[i];
            allSum += sum;
            
        }
        
        System.out.println(allSum);
        
    }
    
}

public class ATM_11399 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int n;
		
		n = stdIn.nextInt();
		int[] sorting = new int[n];
		
		for(int i = 0; i < n; i++) {
		    
		    sorting[i] = stdIn.nextInt();
		    
		}
		
		Arrays.sort(sorting);
		
		ATM atm = new ATM();
		atm.sumMin(sorting);
	}
}

