package com.algo.acmicpc;

import java.util.Scanner;

public class acmicpc_2231_decompositionSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = 1000000;
		
		for(int i = N; i>0; i--) {
			char[] c = Integer.toString(i).toCharArray();
			int sum = i;
			for(char ch : c) {
				sum += (int)(ch - '0');
			}
			if(sum == N) {
				min = Math.min(min, i);
			}
		}
		
		if(min == 1000000) System.out.println(0);
		else System.out.println(min);
		
		sc.close();
	}

}
