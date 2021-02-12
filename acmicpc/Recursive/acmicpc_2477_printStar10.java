package com.algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acmicpc_2477_printStar10 {
	static char[][] arr;
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
 
		arr = new char[N][N];
        
		printStar(N, 0, 0, '*');
 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

	private static void printStar(int N, int x, int y, char star) {
		int count = 0;
		if(N == 3) {
			for(int i=x; i<N+x; i++) {
				for(int j=y; j<N+y; j++) {
					count++;
					if(count == 5) {
						continue;
					}else {
						arr[i][j] = star;
					}
					
				}
			}
			return;
		}
		
		
		for(int i = x; i<N+x; i=i+N/3) {
			for(int j = y; j<N+y; j=j+N/3) {
				count++;
				if(count == 5) {
					continue;
				}else {
					printStar(N/3, i, j, star);
				}
			}
		}
		
	}
 

}