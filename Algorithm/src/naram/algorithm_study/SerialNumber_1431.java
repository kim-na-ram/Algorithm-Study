package naram.algorithm_study;

import java.util.Collections;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class SerialNumber implements Comparable<SerialNumber> {
    
    private String serialnumber;
    private int length;
    
    public SerialNumber() {}
    
    public SerialNumber(String serialnumber, int length) {
        
        this.serialnumber = serialnumber;
        this.length = length;
        
    }
    
    public String getSerialnumber() {
        return this.serialnumber;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    @Override
    public int compareTo(SerialNumber serialNumber) {
        int lenResult = this.getLength() - serialNumber.getLength();
        if (lenResult == 0) {
	        String A = this.getSerialnumber();
	        String B = serialNumber.getSerialnumber();
	        A = A.replaceAll("[^0-9]", "");
	        B = B.replaceAll("[^0-9]", "");
	        int A_sum = 0, B_sum = 0;
	        for(int i = 0; i < A.length(); i++)
	            A_sum += Integer.parseInt(A.split("")[i]);
	        for(int i = 0; i < B.length(); i++)
	            B_sum += Integer.parseInt(B.split("")[i]);
	        
	        int sumResult = A_sum - B_sum;           
	        if(sumResult == 0) {
	            int alphaResult = this.getSerialnumber().compareTo(serialNumber.getSerialnumber());
	            return alphaResult;
	        }
	        
	        return sumResult;
	                    
	    }
	    
	    return lenResult;
        
    }
    
}


public class SerialNumber_1431 {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    ArrayList<SerialNumber> list = new ArrayList<SerialNumber>(n);
	    
	    for(int i = 0; i < n; i++) {
	        
	        String line = br.readLine();
	        list.add(new SerialNumber(line, line.length()));
	        
	    }
	    
	    Collections.sort(list);
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < n; i++)
	        sb.append(list.get(i).getSerialnumber()).append("\n");

	    System.out.println(sb);
	
	}
}
