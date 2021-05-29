package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DeduplicationSort {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int[] num = new int[n];
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    for(int i = 0; i < n; i++) {
	        
	        num[i] = Integer.parseInt(st.nextToken());
	        
	    }
	    
	    Arrays.sort(num);
	    
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    
	    for(int i = 0; i < n; i++) {
	        
	        if(!list.contains(num[i]))
	            list.add(num[i]);
	        
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < list.size(); i++) {
	        sb.append(list.get(i)).append(" ");
	    }
	    
	    System.out.println(sb);
	    
	}

}