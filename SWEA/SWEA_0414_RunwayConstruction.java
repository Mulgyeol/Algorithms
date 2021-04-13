package com.ssafy.inclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_0414_RunwayConstruction {
	
	/*
	 * 경사로의 조건
	 * 
	 * 
	 * 
	 */

	static int[][] map;
	static int N,X,answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 지형의 길이
			X = Integer.parseInt(st.nextToken()); // 활주로 밑변
			answer = 0;
			
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				answer += isOK(i, true); //가로
				answer += isOK(i, false); // 세로
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int isOK(int i, boolean flag) {
		//int[] height = new int[7];

		if(flag == true) {// 가로
			int current = map[i][0];
			//height[current]++;
			
			int inclineCntNext = 0;
			int inclineCntCurrent = 1;
			
			for(int k=1; k<N; k++) {
				int next = map[i][k];
				
				if(inclineCntNext == 0) {
					if(next == current) {
						inclineCntCurrent++;
						continue;
					}else if((next - current)== 1) { // 다음이 한 칸 높음
						if(inclineCntCurrent >= X) { // 이전 높이 지형의 갯수가 X보다 넓었다면
							current = next;
							inclineCntCurrent = 1;
						}else {
							return 0;
						}
					}else if((next - current)== -1) { // 다음이 한 칸 낮음
						inclineCntNext++;
						current = next;
						
					}else {
						return 0;
					}
				}else {
					if(inclineCntNext < X) {
						if(current != next) {
							return 0;
						}else {
							inclineCntNext++;
						}
					}else { // inclineCntNext > X  경사로를 세울 수 있게 되면.
						inclineCntCurrent = 0;
						inclineCntNext = 0;
						
						if(next == current) {
							inclineCntCurrent++;
							continue;
						}else if((next - current)== 1) { // 다음이 한 칸 높음
							if(inclineCntCurrent >= X) { // 이전 높이 지형의 갯수가 X보다 넓었다면
								current = next;
								inclineCntCurrent = 1;
							}else {
								return 0;
							}
						}else if((next - current)== -1) { // 다음이 한 칸 낮음
							inclineCntNext++;
							current = next;
							
						}else {
							return 0;
						}
						
					}
				}
			}
			if(inclineCntNext > 0 && inclineCntNext < X) {
				return 0;				
			}else {
				return 1;
			}
				
		}else  {// 세로
			int current = map[0][i];
			//height[current]++;
			
			int inclineCntNext = 0;
			int inclineCntCurrent = 1;
			
			for(int k=1; k<N; k++) {
				int next = map[k][i];
				
				if(inclineCntNext == 0) {
					if(next == current) {
						inclineCntCurrent++;
						continue;
					}else if((next - current)== 1) { // 다음이 한 칸 높음
						if(inclineCntCurrent >= X) { // 이전 높이 지형의 갯수가 X보다 넓었다면
							current = next;
							inclineCntCurrent = 1;
						}else {
							return 0;
						}
					}else if((next - current)== -1) { // 다음이 한 칸 낮음
						inclineCntNext++;
						current = next;
						
					}else {
						return 0;
					}
				}else {
					if(inclineCntNext < X) {
						if(current != next) {
							return 0;
						}else {
							inclineCntNext++;
						}
					}else { // inclineCntNext > X  경사로를 세울 수 있게 되면.
						inclineCntCurrent = 0;
						inclineCntNext = 0;
						
						if(next == current) {
							inclineCntCurrent++;
							continue;
						}else if((next - current)== 1) { // 다음이 한 칸 높음
							if(inclineCntCurrent >= X) { // 이전 높이 지형의 갯수가 X보다 넓었다면
								current = next;
								inclineCntCurrent = 1;
							}else {
								return 0;
							}
						}else if((next - current)== -1) { // 다음이 한 칸 낮음
							inclineCntNext++;
							current = next;
							
						}else {
							return 0;
						}
						
					}
				}
			}
			if(inclineCntNext > 0 && inclineCntNext < X) {
				return 0;				
			}else {
				return 1;
			}
				
		}
		
	}

}
