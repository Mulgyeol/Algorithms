package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class acmicpc_1260_DFSBFS {
	
	static int N, M, V;
	static boolean[][] arr;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());//노드 수
		M = Integer.parseInt(st.nextToken());//간선 수
		V = Integer.parseInt(st.nextToken());//시작 노드
		visited = new boolean[N+1];
		arr = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = true;
			arr[y][x] = true;
		}
		
		DFS(V);
		sb.append("\n");
		
		visited = new boolean[N+1];
		BFS(V);
		
		System.out.print(sb);
		
	}
	
	private static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			for(int i=1; i<N+1; i++) {
				if(arr[current][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}

	private static void DFS(int current) {
		visited[current] = true;
		
		sb.append(current).append(" ");
		
		for(int i=1; i<N+1; i++) {
			if(arr[current][i] && !visited[i]) {
				DFS(i);
			}
		}
		
	}

}
