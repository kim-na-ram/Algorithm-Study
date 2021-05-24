package naram.algorithm_study;

import java.util.Scanner;
import java.util.ArrayList;

class Score {
    
    private int index;
    private int score;
    
    public Score(int index, int score) {
        
        this.index = index;
        this.score = score;
        
    }
    
    public int getIndex() {
        
        return this.index;
        
    }
    
    public int getScore() {
        
        return this.score;
        
    }
    
}

class MergeSort {
    
    static int[] buf; // 작업용 배열
    
    static void __mergerSort(int[] a, int left, int right) {
        
        if(left < right) {
            
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;
            
            __mergerSort(a, left, center);
            __mergerSort(a, center+1, right);
            
            for(i = left; i <= center; i++)
                buf[p++] = a[i]; // for문이 끝나면 i는 center와 같음
            
            while(i <= right && j < p)
                a[k++] = (buf[j] >= a[i]) ? buf[j++] : a[i++]; 
            
            while (j < p)
                a[k++] = buf[j++];
                
        }
        
    }
    
    static void mergeSort(int[] a, int n) {
        
        buf = new int[n];
        
        __mergerSort(a, 0, n-1);
        
        buf = null;
        
    }
    
}

public class ScoreCalculation_2822 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		
		int n = 8;
		
		int[] score = new int[n];
		ArrayList<Score> list = new ArrayList<Score>();
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
		    
		    score[i] = stdIn.nextInt();
		    Score scores = new Score(i, score[i]);
		    list.add(scores);
		    
		}
		
		MergeSort Sort = new MergeSort();
        Sort.mergeSort(score, n);
    
        for (int i = 0; i < 5; i++) {
            
            sum += score[i];
            
		}
		
		for(int i = 0; i < n; i++) {
		    for(int j = 0; j < 5; j++) {
		        
		        if(list.get(i).getScore() == score[j]) {
		            
		            sb.append(i + 1).append(" ");
		            
		        }
		    
		    }
		}
        
		System.out.println(sum + "\n" + sb);
        
    }
}