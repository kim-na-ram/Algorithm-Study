package naram.algorithm_study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Coordinate implements Comparable<Coordinate> {
	
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	@Override
	public int compareTo(Coordinate c) {
		if(this.y == c.getY()) {
			return this.x - c.getX();
		}
		return this.y - c.getY();
	}
	
}

public class SortCoordinates2_11651 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Coordinate> coordinate_list= new ArrayList<Coordinate>(n);
		int[][] coordinate_arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			coordinate_list.add(new Coordinate(x, y));
			
		}
		
		Collections.sort(coordinate_list);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			
			sb.append(coordinate_list.get(i).getX()).append(" ")
				.append(coordinate_list.get(i).getY()).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
}
