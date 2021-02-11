package com.algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acmicpc_10872_factorial {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.print(factorial(N));
	}

	private static int factorial(int n) {
		if(n<=1) return 1;
		return n * factorial(n-1);
	}
}
