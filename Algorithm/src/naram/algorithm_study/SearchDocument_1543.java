package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SearchDocument_1543 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    String document = br.readLine();
	    String find = br.readLine();
	    
	    int sum = 0;
	    
	    for(int i = 0; i < document.length() - find.length() + 1;) {
	    	if(document.substring(i, i + find.length()).equals(find)) {
	    		sum += 1;
	    		i = i + find.length();
	    	} else {
	    		i++;
	    		continue;
	    	}
	    }
	    
	    System.out.println(sum);

	}

}
