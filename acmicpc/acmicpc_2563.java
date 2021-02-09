package com.algo.acmicpc;

import java.util.Scanner;

public class acmicpc_2563 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] back = new boolean[100][100];
		int count = 0;
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int x2 = x+10;
			int y2 = y+10;
			for(int j=x; j<x2; j++) {
				for(int k=y; k<y2; k++) {
					if (back[j][k] == false) count++;
					back[j][k] = true;
				}
			}
		}
		System.out.println(count);
		sc.close();
	}

}
