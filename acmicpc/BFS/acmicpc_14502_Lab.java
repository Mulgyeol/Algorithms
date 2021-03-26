package com.ssafy.inclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class acmicpc_14502_Lab {
	
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> virus = new LinkedList<>();
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N, M, originalZero;
	static int maxZero = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		originalZero = N*M;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					visited[i][j] = true;
					originalZero--;
				}
				if(map[i][j] == 2) {
					virus.offer(new int[] {i,j});
				}
			}
		}
		
		int[] wall = new int[3];
		WallInstall(0, 0, wall);
		System.out.println(maxZero);
	}

	private static void WallInstall(int start, int cnt, int[] wall) {
		if(cnt == 3) {
			int tempMap[][] = new int[N][M];
			int zero = originalZero-3;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					tempMap[i][j] = map[i][j];
				}
			}
			
			for(int i=0; i<3; i++) {
				int num = wall[i];
				int row = num/M;
				int col = num%M;
				
				tempMap[row][col] = 1;
			}
			
			for(int[] q : virus) {
				queue.offer(q);
			}
			
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				for(int i=0; i<4; i++) {
					int nx = temp[0] + dx[i];
					int ny = temp[1] + dy[i];
					
					if(nx >=0 && nx < N && ny >=0 && ny < M && tempMap[nx][ny] == 0) {
						queue.offer(new int[] {nx, ny});
						tempMap[nx][ny] = 2;
						zero --;
					}
				}
			}
			
			if(maxZero < zero) {
				maxZero = zero;
			}
			
			return;
		}
		
		for(int i=start; i<N*M; i++) {
			int row = i/M;
			int col = i%M;
			if(!visited[row][col]) {
				wall[cnt] = i;
				WallInstall(start+1, cnt+1, wall);
			}
		}
		
	}

}
