package com.ssafy.inclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class acmicpc_1600_MonkeyHorse_BFS {
	
	static class Monkey{
		int x;
		int y;
		int k;
		int cnt;
		
		public Monkey(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}
	
	static int[] dx = {-1,1,0,0,-1,-2,-2,-1,1,2,2,1};
	static int[] dy = {0,0,-1,1,-2,-1,1,2,2,1,-1,-2};
	static int H,W,K;
	static int[][] map;
	boolean[][][] visited;
	static int min = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		W = Integer.parseInt(st.nextToken()); //가로
		H = Integer.parseInt(st.nextToken()); //세로
		map = new int[H][W];
		boolean[][][] visited = new boolean[H][W][31];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Monkey> queue = new LinkedList<>();
		
		queue.offer(new Monkey(0,0,0,0));
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Monkey monkey = queue.poll();
			int x =monkey.x;
			int y =monkey.y;
			int k =monkey.k;
			int cnt =monkey.cnt;
			
			if(x == H-1 && y == W-1) {
				min = cnt;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][k] && map[nx][ny] != 1) {
					queue.offer(new Monkey(nx,ny,k,cnt+1));
					visited[nx][ny][k] = true;
				}
			}
			
			if(k < K) {
				for(int i=4; i<12; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][k+1] && map[nx][ny] != 1) {
						queue.offer(new Monkey(nx,ny,k+1,cnt+1));
						visited[nx][ny][k+1] = true;
					}
				}
			}
			
		}
		
		System.out.println(min);
	}

}
