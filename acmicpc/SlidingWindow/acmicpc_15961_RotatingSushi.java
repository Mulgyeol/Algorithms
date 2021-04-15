package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class acmicpc_15961_RotatingSushi {
	
	static int N, d, k, c, maxCnt=0;
	static int answer = 0;
	static int[] dish;
	
	static class Sushi{
		int num;
		int cnt;
		
		public Sushi(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}
	static Sushi[] sushiAll;
	
	static ArrayList<Sushi> sushies = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥 가지수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 c
		
		dish = new int[N];
		sushiAll = new Sushi[d+1];
		
		for(int i=0; i<N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}

		maxCntSushi();
		
		
		System.out.println(maxCnt);
	}

	private static void maxCntSushi() {
		int window_start = 0;
		boolean flag = false;
		
		for(int i=0; i<N+k; i++) {
			//System.out.println(i+"까지 돌았음");
			
			int idx = i;
			if(idx >= N) {
				idx = idx%N;
			}
			
			if(sushiAll[dish[idx]] == null) {
				sushiAll[dish[idx]] = new Sushi(dish[idx], 1);
				sushies.add(sushiAll[dish[idx]]);
			}else {
				sushiAll[dish[idx]].cnt++;
			}
			
			if(idx >= k-1) flag = true;
			if(window_start >= N) break;
			
			if(flag == true){
				int nowCnt = sushies.size();
				if(!sushies.contains(sushiAll[c])) nowCnt++;
				maxCnt = Math.max(maxCnt, nowCnt);
				
				//System.out.println("제거할 위치는 "+window_start);
				//System.out.println("제거할 스시 번호는 "+dish[window_start]);
				sushiAll[dish[window_start]].cnt--;
				if(sushiAll[dish[window_start]].cnt == 0) {
					sushies.remove(sushiAll[dish[window_start]]);
					sushiAll[dish[window_start]] = null;
				}
				window_start++;
			}
			
		}
		
	}

}
