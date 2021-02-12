package com.algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acmicpc_11729_hanoi {
	
	private static StringBuilder sb = new StringBuilder();
	private static int count = 0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int from = 1, temp = 2, to = 3;
		hanoi(N, from, temp, to);
		sb.insert(0, "\n").insert(0, count);
		System.out.print(sb);
	}

	private static void hanoi(int n, int from, int temp, int to) {
		if(n==1) {
			count++;
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		
		hanoi(n-1, from, to, temp);
		sb.append(from).append(" ").append(to).append("\n");
		count++;
		hanoi(n-1, temp, from, to);
	}

}
