package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class MergeSort {
    
    static String[] buf;
    
    static boolean compareString(String a, String b) {
    	
    	if(a.compareTo(b) >= 0) {
    		return true; // a가 b보다 순서가 앞설 때
    	} else {
    		return false; // b가 a보다 순서가 앞설 때
    	}
    	
    }
    
    static void __mergerSort(String[] a, int left, int right) {
        
        if(left < right) {
            
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;
            
            __mergerSort(a, left, center);
            __mergerSort(a, center+1, right);
            
            for(i = left; i <= center; i++)
                buf[p++] = a[i]; 
            
            while(i <= right && j < p)
                a[k++] = (compareString(a[i], buf[j])) ? buf[j++] : a[i++]; 
            
            while (j < p)
                a[k++] = buf[j++];
                
        }
        
    }
    
    static void mergeSort(String[] a, int n) {
        
        buf = new String[n];
        
        __mergerSort(a, 0, n-1);
        
        buf = null;
        
    }
    
}

public class BestSeller_1302 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        HashMap<String,Integer> bestseller = new HashMap<String,Integer>();
        
        String book_name = new String();
        
        for(int i = 0; i < n; i++) {
            
            book_name = br.readLine();
            
            if (bestseller.containsKey(book_name)) {
                
                bestseller.replace(book_name, bestseller.get(book_name) + 1);
                
            }
            else {
                
                bestseller.put(book_name, 1);
                
            }
            
        }
        
        int best = 0;
        
        for(String book : bestseller.keySet()) {
            
            best = Math.max(best, bestseller.get(book));
            
        }
        
        ArrayList<String> list = new ArrayList<String>(bestseller.keySet());
        String[] book_list = new String[list.size()];
        
        for(int i = 0; i < list.size(); i++)
            book_list[i] = list.get(i);
        
        MergeSort Sort = new MergeSort();
        Sort.mergeSort(book_list, book_list.length);
        
        for(String book : book_list) {
            if(bestseller.get(book) == best) {
                
                System.out.println(book);
                break;
    
            }
        }
        
    }
    
}