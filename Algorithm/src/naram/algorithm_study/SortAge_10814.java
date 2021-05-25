package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class User {
	
	private int age;
	private String name;
	
	public User() {
		
	}
	
	public User(int age, String name) {
		
		this.age = age;
		this.name = name;
		
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class SortAge_10814 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		User[] user = new User[n];
		
		for(int i = 0; i < n; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			user[i] = new User(age, name);
			
			
		}
		
		Arrays.sort(user, new Comparator<User>() {
			// 나이순으로 정렬
			@Override
			public int compare(User u1, User u2) {
				// TODO Auto-generated method stub
				return u1.getAge() - u2.getAge();
			}
				
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			sb.append(user[i].getAge() + " " + user[i].getName()).append("\n");
		}
        
		System.out.println(sb);
		
	}

}
