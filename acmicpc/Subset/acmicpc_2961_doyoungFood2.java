package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_2961_doyoungFood2 {
	
	private static int N, min = Integer.MAX_VALUE;
	private static int[][] ingredients;
	private static boolean[] choice;


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		ingredients = new int[N][2];
		choice = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ingredients[i][0] = Integer.parseInt(st.nextToken());
			ingredients[i][1] = Integer.parseInt(st.nextToken());
		}
		
		findCook(0,0);
		System.out.println(min);
	}

	private static void findCook(int idx, int cnt) {
		if(idx >= N) {
			if(cnt==0) return;
			
			int mul = 1;
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(choice[i] == true) {
					mul *= ingredients[i][0];
					sum += ingredients[i][1];
				}
			}
			if(min > Math.abs(mul - sum)) {
				min = Math.abs(mul - sum);
			}
			
			return;
		}
		
		choice[idx] = true;
		findCook(idx+1, cnt+1);
		choice[idx] = false;
		findCook(idx+1, cnt);
	}
	

}
