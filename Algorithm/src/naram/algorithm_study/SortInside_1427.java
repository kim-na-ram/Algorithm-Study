package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;

class Words {
    
    private String word1;
    private String word2;
    
    public Words() {
        
    }
    
    public Words (String word1, String word2) {
        
        this.word1 = word1;
        this.word2 = word2;
        
    }
    
    public void setWord1 (String word1) {
        
        this.word1 = word1;
        
    }
    
    public void setWord2 (String word2) {
        
        this.word2 = word2;
        
    }
    
    public String getWord1 () {
        
        return this.word1;
        
    }
    
    public String getWord2 () {
        
        return this.word2;
        
    }
    
}

public class SortInside_1427 {
	public static void main(String[] args) throws Exception {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
        String n = br.readLine();

        int num = Integer.parseInt(n);
        int[] sort = new int[n.length()];
        
		for(int i = n.length() - 1; i >= 0; i--) {
		    
		    sort[i] = (int)(num / Math.pow(10, i));
		    num = (int)(num % Math.pow(10, i));
		    
		}
		
		Arrays.sort(sort);
		
		for(int i = sort.length - 1; i >= 0; i--) {
		    
		    sb.append(sort[i]);
		    
		}
		
		
		    System.out.println(sb);
		
	}
}