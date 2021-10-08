package naram.algorithm_study;

class Solution {
    
    public String solution(int[][] scores) {
        
    	String answer = "";
        
        for(int j = 0; j < scores.length; j++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int count = scores.length;
            boolean flag = true;
            
            for(int i = 0; i < scores.length; i++) {
                
                if(i != j && scores[j][j] == scores[i][j])
                    flag = false;
                
                max = Math.max(scores[i][j], max);
                min = Math.min(scores[i][j], min);
                sum += scores[i][j];
            }
            
            double avg = 0.0;
            
            if(flag && (max == scores[j][j] || min == scores[j][j])) {
                count--;
            	sum -= scores[j][j];
            }
            
            answer += calculateRank((double)sum / (double)count);
            
            
        }
        
        return answer;
    }
    
    public static String calculateRank(double score) {
        if(score >= 90) {
        	return "A";
        } else if(80 <= score) {
            return "B";
        } else if(70 <= score) {
            return "C";
        } else if(50 <= score) {
            return "D";
        } else {
            return "F";
        }
    }
    
}