package com.algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acmicpc_10870_fibonacci {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.print(fibo(n));
		
	}

	private static int fibo(int n) {
		if(n<=1) return n;
		return fibo(n-1)+fibo(n-2);
	}

}
