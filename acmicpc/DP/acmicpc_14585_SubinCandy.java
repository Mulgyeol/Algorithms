package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N개의 사탕 바구니
 * M개의 사탕이 각각의 사탕 바구니에 들어있다.
 * 1만큼 이동할 때마다 시간은 1만큼 지나간다.
 * 시간이 1지날때마다 모든 사탕 바구니에서 사탕은 한 개씩 녹아서 없어진다.
 * 이동은 x축과 y축 모두 +방향으로만 가능하다.
 * 수빈이의 위치는 (0,0)이며, 그곳에는 사탕이 없다.
 * 사탕 바구니의 위치는 중복되지 않는다.
 * 사탕 바구니랑 만나자마자 다먹는다.
 * 먹을 수 있는 사탕의 최대 갯수는?
 * 0<=N<=300
 * 1<=M<=10000000
 * 0<=x,y<=300
 * 
 */

public class acmicpc_14585_SubinCandy {
	
static int N, M, max = Integer.MIN_VALUE;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int x, y;
		int[][] map = new int[301][301];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y] = M-x-y; // 사탕바구니의 위치에 그 곳에 도착했을 때, 남아있는 사탕 갯수 넣어두기.
		}
		
		//map[x][y] = 그 위치에 도착했을 때, 먹은 최대 사탕
		
		for(int i=1; i<301; i++) {
			// 0열 먼저 계산 해주기
			if(map[i][0] != 0) { // 사탕이 있는 곳이 있으면,
				if (map[i][0]<0) map[i][0] = map[i-1][0]; // 그 사탕 바구니의 사탕이 다 녹아있으면
				else map[i][0] = map[i-1][0] + map[i][0]; // 사탕이 남아있으면,
			}else {// 사탕 바구니가 없으면
				map[i][0] = map[i-1][0]; 
			}
            
			// 0행 먼저 테이블 채우기
            if(map[0][i] != 0) {
            	if (map[0][i] < 0) map[0][i] = map[0][i-1];
            	else map[0][i] = map[0][i-1] + map[0][i];
			}else {
				map[0][i] = map[0][i-1];
			}
		}
		
		
		for(int i=1; i<301; i++) {
			for(int j=1; j<301; j++) { //1행 1열 부터
				if (map[i][j] != 0) {
					if (map[i][j] <0) map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
					else map[i][j] += Math.max(map[i-1][j], map[i][j-1]);
				}else {
					map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
				}
			}
		}
			
		System.out.println(map[300][300]);
	}


}