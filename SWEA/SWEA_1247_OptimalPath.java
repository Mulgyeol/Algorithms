package com.ssafy.inclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_OptimalPath {
	
	private static int[][] position;
	private static int[] firm;
	private static int[] home; 
	private static int[] order; 
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			order = new int[N];
			for(int i=0; i<N; i++) {
				order[i] = i;
			}
			
			st = new StringTokenizer(br.readLine()," ");
			firm = new int[2];
			home = new int[2];
			position = new int[N][2];
			
			firm[0] = Integer.parseInt(st.nextToken());
			firm[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				position[i][0] = Integer.parseInt(st.nextToken());
				position[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int min = Integer.MAX_VALUE;
			
			do {
				int sum = 0;
				sum += getDistance(firm[0], firm[1], position[order[0]][0], position[order[0]][1]);
				
				for(int i=0; i<N-1; i++) {
					sum += getDistance(position[order[i]][0], position[order[i]][1], position[order[i+1]][0], position[order[i+1]][1]);
				}

				sum += getDistance(position[order[N-1]][0], position[order[N-1]][1], home[0], home[1]);
				
				min = Math.min(min, sum);
			}while(np());
			
			sb.append(min).append("\n");
		}//t
		System.out.print(sb);
		
	}//main
	
	private static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}

	public static boolean np() { //n개 중에 n개 뽑는 순열만 된다. nPr은 안된다.
		//STEP 1
		int i= N-1; // 맨 뒤부터
		while(i>0 && order[i-1] >= order[i]) { // 인접한 두 요소 비교
			--i; // 앞으로
		}
		
		// 더 이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰 순열(마지막 순열)
		if(i==0) return false;
		
		//STEP 2
		int j= N-1; // 맨 뒤부터
		// i는 꼭대기
		// i-1은 뚝 떨어진 곳(꼭대기의 바로 앞, 교환위치)
		while(order[i-1]>= order[j]) --j; //교환위치보다 큰 수 인지 비교
		// 뚝 떨어진 곳보다 바로 다음 큰수를 찾으면 빠져 나온다.
		
		//STEP 3
		swap(i-1,j);
		
		//STEP 4
		int k= N-1; // 맨 뒤부터
		while(i<k) {
			swap(i++,k--);
		}
		
		return true;
	}

	private static void swap(int i, int j) {
		int temp = order[i];
		order[i] = order[j];
		order[j] = temp;
	}

}
