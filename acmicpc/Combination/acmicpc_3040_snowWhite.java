package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acmicpc_3040_snowWhite {
	
	private static int[] boys;
	private static boolean[] findFakeBoys;
	private static int diff;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boys = new int[9];
		findFakeBoys = new boolean[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			boys[i] = Integer.parseInt(br.readLine());
			sum += boys[i];
		}
		
		diff = sum - 100;
		combination(0, 0, 0);
		
	}

	private static void combination(int cnt, int idx, int sum) {
		if(cnt == 2) {
			if(sum == diff) {
				for(int i=0;i<9;i++) {
					if(findFakeBoys[i] == false) {
						System.out.println(boys[i]);
					}
				}
			}
			return;
		}
		if(idx >= 9) {
			return;
		}
		
		findFakeBoys[idx] = true;
		combination(cnt+1,idx+1,sum+boys[idx]);
		findFakeBoys[idx] = false;
		combination(cnt,idx+1,sum);
	}


	

}
