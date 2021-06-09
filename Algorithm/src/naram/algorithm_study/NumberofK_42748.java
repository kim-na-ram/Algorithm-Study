package naram.algorithm_study;

import java.util.Arrays;

public class NumberofK_42748 {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
		int[] i = new int[commands.length];
		int[] j = new int[commands.length];
		int[] k = new int[commands.length];
        
        for(int m = 0; m < commands.length; m++) {
            
            i[m] = commands[m][0] - 1;
            j[m] = commands[m][1] - 1;
            k[m] = commands[m][2] - 1;
            
        }
        
        for(int m = 0; m < commands.length; m++) {
            
            int[] temp = new int[j[m] - i[m] + 1];
            int index = 0;
            
            for(int n = i[m]; n <= j[m]; n++) {
            
                temp[index++] = array[n];
                
            }
            
            Arrays.sort(temp);
            
            answer[m] = temp[k[m]];
            
        }
        
        return answer;
        
    }
}