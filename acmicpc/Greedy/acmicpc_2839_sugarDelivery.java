package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acmicpc_2839_sugarDelivery {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = -1;
		if(N % 5 == 0) {
			answer = N/5;
		}else {
			int five = N/5;
			int sum = 0;
			for(int i=five; i>=0; i--) {
				int count = 0;
				do {
					count++;
					sum = i*5 + count*3;
				}while(sum < N);
				if(sum == N){
					if(i == -1)	i++;
					answer = i+count;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
