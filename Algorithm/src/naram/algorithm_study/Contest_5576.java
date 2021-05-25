package naram.algorithm_study;

import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;

public class Contest_5576 {
	public static void main(String[] args) {
	    
		Scanner stdIn = new Scanner(System.in);
		
		int n = 20;
		
		int[] W_score = new int[10];
		int[] K_score = new int[10];
		
		int W_sum = 0;
		int K_sum = 0;
		
		for(int i = 0; i < 10; i++)
		    W_score[i] = stdIn.nextInt();
		for(int j = 0; j < 10; j++)
		    K_score[j] = stdIn.nextInt();
		
		Arrays.sort(W_score);
		Arrays.sort(K_score);
    
        for (int i = 9; i > 6; i--) {
            
            W_sum += W_score[i];
            K_sum += K_score[i];
            
		}
        
		System.out.println(W_sum + " " + K_sum);
        
    }
}