package com.ssafy.inclass;

import java.util.Scanner;

public class acmicpc_1463_MakeOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] DP = new int[N+1];
		DP[1] = 0;
		
		if(N >= 2) DP[2] = 1;
		if(N >= 3) DP[3] = 1;
		
		for(int i=4; i<N+1; i++) {
			int min = DP[i-1] + 1;
			if(i%3 == 0 && DP[i/3] + 1 < min) min = DP[i/3] + 1;
			if(i%2 == 0 && DP[i/2] + 1 < min) min = DP[i/2] + 1;
			
			DP[i] = min;
		}
		System.out.println(DP[N]);
		sc.close();
	}
}
