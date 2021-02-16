package com.ssafy.inclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_2961_doyoungFood {
	
	private static int N, min = Integer.MAX_VALUE;
	private static int[][] gredients;


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		gredients = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			gredients[i][0] = Integer.parseInt(st.nextToken());
			gredients[i][1] = Integer.parseInt(st.nextToken());
		}
		
		findCook(0, 0, 1, 0);
		System.out.println(min);
	}

	private static void findCook(int idx, int cnt, int mul, int sum) {
		if(idx >= N) {
			if (cnt == 0) return;
			if (Math.abs(mul-sum) < min) {
				min = (Math.abs(mul-sum));
			}
			return;
		}
		
		findCook(idx+1,cnt+1,mul*gredients[idx][0],sum+gredients[idx][1]);
		findCook(idx+1,cnt,mul,sum);
	}
	

}
