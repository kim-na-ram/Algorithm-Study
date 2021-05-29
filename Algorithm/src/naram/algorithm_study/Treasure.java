package naram.algorithm_study;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Treasure {
	
	public static void main(String[] args) throws IOException {
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    int[] a = new int[n];
	    int[] b = new int[n];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0; i < n; i++) {
	    	
	    	a[i] = Integer.parseInt(st.nextToken()); 
	    	
	    }
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0; i < n; i++) {
	    	
	    	b[i] = Integer.parseInt(st.nextToken()); 
	    	
	    }
	    
	    Integer[] temp_b = Arrays.stream(b).boxed().toArray(Integer[]::new);
	    
	    Arrays.sort(a);
	    Arrays.sort(temp_b, Comparator.reverseOrder());
	    
	    int sum = 0;
	    for(int i = 0; i < n; i++) {
	    	
	    	sum += a[i] * temp_b[i];
	    	
	    }
	    
	    System.out.println(sum);
		
	}

}
