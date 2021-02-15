package com.algo.study;

import java.util.Scanner;

public class acmicpc_1436_movieDirector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int count = 0;
		int num = 665;
		while(count != N) {
			num++;
			if(Integer.toString(num).contains("666")) count++;
		}
		
		System.out.println(num);
		sc.close();
	}

}
