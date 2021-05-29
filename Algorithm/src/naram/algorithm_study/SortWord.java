package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

class Words implements Comparable<Words> {
    
    private String word;
    private int length;
    
    public Words (String word, int length) {
        
        this.word = word;
        this.length = length;
        
    }
    
    public String getWord() {
        
        return this.word;
        
    }
    
    public int getLength() {
        
        return this.length;
        
    }
    
    @Override
    public int compareTo(Words w) {
        if(this.getLength() == w.getLength()) {
            return this.getWord().compareTo(w.getWord());
        }
        return this.getLength() - w.getLength();
    }
    
}

public class SortWord {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    Words[] words = new Words[n];
	    
	    for(int i = 0; i < n; i++) {
	        
	        String w = br.readLine();
	        int l = w.length();
	        
	        words[i] = new Words(w, l);
	        
	    }
	    
	    Arrays.sort(words);
	    
	    ArrayList<String> list = new ArrayList<String>();
	    
	    for(int i = 0; i < n; i++) {
	        
	        if(!list.contains(words[i].getWord()))
	            list.add(words[i].getWord());
	        
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < list.size(); i++) {
	        sb.append(list.get(i)).append("\n");
	    }
	    
	    System.out.println(sb);
	    
	}

}
