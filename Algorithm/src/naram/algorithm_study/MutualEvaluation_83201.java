package naram.algorithm_study;

import java.util.Arrays;
import java.util.Comparator;

public class MutualEvaluation_83201 {
	
	public static void main(String[] args) {
		
		int[][] scores = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}};
		
		int n = scores.length;
		
		StringBuilder sb = new StringBuilder();

		
        for(int i = 0; i < n; i++) {
        	int max = 0, min = 0, sum = 0;
        	double avg = 0;
        	int I = scores[i][i];
        	for(int j = 0; j < n; j++) {
        		
        	}
        	
        	if(max == scores[i][i] || min == scores[i][i]) {
        		sum -= scores[i][i];
        		avg = (double)sum / (double)(n - 1);
        	} else {
        		avg = (double)sum / (double)n;
        	}
        	
        	System.out.print(avg + "\n");
        	
            if(avg >= 90.0)
            	sb.append("A");
            else if(avg >= 80.0 && avg < 90.0)
            	sb.append("B");
            else if(avg >= 70.0 && avg < 80.0)
            	sb.append("C");
            else if(avg >= 50.0 && avg < 70.0)
            	sb.append("D");
            else if(avg < 50.0)
            	sb.append("F");
        		
        }
                
        System.out.println(sb);
	
	}

}
