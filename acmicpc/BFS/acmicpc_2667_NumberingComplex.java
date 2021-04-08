package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 아이디어
 * 1. (0,0)부터 탐색을 시작한다.
 * 2. 방문한 적이없고, 0이 아니면 카운트를 시작한다.
 * 3. bfs로 갯수를 센다.
 */

public class acmicpc_2667_NumberingComplex {
	
	static int N, cnt = 0;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Integer> pQueue = new PriorityQueue<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = (int)st.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		while(!pQueue.isEmpty()) {
			System.out.println(pQueue.poll());
		}
		
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		visited[i][j] = true;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx >=0 && nx < N && ny >= 0 && ny <N && map[nx][ny] != 0 && !visited[nx][ny]) {
					queue.offer(new int[] {nx,ny});
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		
		pQueue.offer(cnt);
	}

}
