package naram.algorithm_study;

import java.util.Scanner;
import java.io.FileInputStream;

public class LonelyLetter_10912 {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String line = sc.next();
			int[] alpha = new int[26];

			for(int i = 0; i < line.length(); i++) {
				int index = line.charAt(i) - 'a';
				alpha[index]++;
			}

			sb.append("#" + test_case + " ");

			boolean flag = false;
			for(int i = 0; i < alpha.length; i++) {
				if(alpha[i] % 2 != 0) {
					flag = true;
					sb.append((char)('a' + i));
				}
			}

			if(!flag) sb.append("Good");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}