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

public class Anagram_6996 {
	public static void main(String[] args) throws Exception {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
		ArrayList<Words> list = new ArrayList<Words>();
		
		for(int i = 0; i < n; i++) {
		    
		    Words words = new Words();
		    String word = br.readLine();
		    
		    words.setWord1(word.split(" ")[0]);
		    words.setWord2(word.split(" ")[1]);
		    list.add(words);
		    
		}
		
		for (int i = 0; i < n; i++) {
		    
		    String origin_w1 = list.get(i).getWord1();
		    String[] word_split1 = origin_w1.split("");
		    
		    String origin_w2 = list.get(i).getWord2();
		    String[] word_split2 = origin_w2.split("");
		    
            Arrays.sort(word_split1);
		    Arrays.sort(word_split2);
		    
		    String w1 = Arrays.toString(word_split1);
		    String w2 = Arrays.toString(word_split2);
		    
		    if(w1.equals(w2)) {
		        
		        System.out.println(origin_w1 + " & " + origin_w2 + " are anagrams.");
		        
		    } else {
		        
		        System.out.println(origin_w1 + " & " + origin_w2 + " are NOT anagrams.");
		        
		    }
		    
		}
		
	}
}