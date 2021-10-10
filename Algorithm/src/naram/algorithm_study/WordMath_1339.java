package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordMath_1339 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] word = new String[N];
        int [] alpha = new int[26];
        for(int i = 0; i < N; i++) {
            word[i] = br.readLine();
        }


        for(int i = 0; i < N; i++) {
            int temp = (int)Math.pow(10, word[i].length() - 1);
            for(int j = 0; j < word[i].length(); j++) {
                alpha[word[i].charAt(j) - 'A'] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(alpha);
        
        for(int i = 0; i < alpha.length; i++)
        	System.out.println(alpha[i]);
        
        int index = 9;
        int sum = 0;
        for(int i = alpha.length-1; i >= 0; i--){
            if(alpha[i] == 0){
                break;
            }
            sum += alpha[i]*index;
            index--;
        }
        System.out.println(sum);
    }
}