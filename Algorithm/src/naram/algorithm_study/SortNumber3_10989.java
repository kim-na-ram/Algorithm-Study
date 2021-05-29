package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class SortNumber3_10989 {
	public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] sorting = new int[n];
		
		for(int i = 0; i < n; i++) {
		    
		    sorting[i] = Integer.parseInt(br.readLine());
		    
		}
        
		Arrays.sort(sorting);
    
        for (int i = 0; i < n; i++) {
            
            sb.append(sorting[i]).append('\n');
            
		}
        
		System.out.println(sb);
        
    }
}