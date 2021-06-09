package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeliverySugar_2839 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int portion = n / 5;
		int rest = n % 5;
		int number = 0;

		if (n > 3) {

			if (n != 4 && n != 7) {

				if (rest == 0) {
					number = portion;
				} else if (rest == 1) {
					number = portion + 1;
				} else if (rest == 2) {
					number = portion + 2;
				} else if (rest == 3) {
					number = portion + 1;
				} else if (rest == 4) {
					number = portion + 2;
				}

			} else if (n == 4 || n == 7) {
				
				number = -1;
				
			}

		} else {
			
			number = 1;
			
		}
		
		System.out.println(number);

	}
}
