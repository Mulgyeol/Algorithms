package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_2961_doyoungFood {
	
	private static int N, min = Integer.MAX_VALUE;
	private static int[][] ingredients;


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		ingredients = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ingredients[i][0] = Integer.parseInt(st.nextToken());
			ingredients[i][1] = Integer.parseInt(st.nextToken());
		}
		
		findCook(0, 0, 1, 0);
		System.out.println(min);
	}

	private static void findCook(int idx, int cnt, int sour, int bitter) {
		if(idx >= N) {
			if (cnt == 0) return;
			min = Math.min(Math.abs(sour-bitter),min);
			return;
		}
		
		findCook(idx+1,cnt+1,sour*ingredients[idx][0],bitter+ingredients[idx][1]);
		findCook(idx+1,cnt,sour,bitter);
	}
	

}
