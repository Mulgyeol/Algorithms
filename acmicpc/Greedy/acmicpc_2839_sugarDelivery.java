package com.ssafy.homework;

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
			int count = 0; //count를 for문 안에서 초기화 안해줘도 된다.
			for(int i=five; i>=0; i--) {
				do {
					sum = i*5 + count*3;
					count++;
				}while(sum < N);
				if(sum == N){
					if(i == -1)	i++;
					answer = i+ (count-1);
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
