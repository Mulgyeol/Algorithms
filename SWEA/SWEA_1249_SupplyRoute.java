package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1249_SupplyRoute {

	static int N, cnt;
	static int[] dx = {1,0,0,-1};
	static int[] dy = {0,1,-1,0};
	
	static int[][] map;
	static int[][] dp;
	static boolean[][] visited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
				
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			dp = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}
			
			dp[0][0] = 0;
			bfs();
			
			sb.append(dp[N-1][N-1]).append("\n");
		}
		
		
		System.out.println(sb);
	}


	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0,0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] tempPos = queue.poll();
			int x = tempPos[0];
			int y = tempPos[1];
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					if(!visited[nx][ny] || dp[nx][ny] > dp[x][y] + map[nx][ny]) {
						dp[nx][ny] = dp[x][y] + map[nx][ny];
						queue.offer(new int[] {nx,ny});
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
}