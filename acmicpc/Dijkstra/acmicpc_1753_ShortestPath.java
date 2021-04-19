package com.algo.acmicpc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class acmicpc_1753_ShortestPath {
	
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken()); // 정점의 갯수
		int E = Integer.parseInt(st.nextToken()); // 간선의 갯수
		int K = Integer.parseInt(br.readLine()); // 시작점
		ArrayList<int[]>[] adjList = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken()); //출발
			int v = Integer.parseInt(st.nextToken()); //도착
			int w = Integer.parseInt(st.nextToken()); //가중치
			
			adjList[u].add(new int[] {v,w});
		}
		
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Arrays.fill(distance, INF);
		distance[K] = 0;
		visited[K] = true;
		
		for(int[] temp : adjList[K]) {
			if(distance[temp[0]] > temp[1])
				distance[temp[0]] = temp[1];
		}
		
		
		
		for(int i=1; i<=V; i++) {
			int min = INF;
			int next = 0;
			for(int j=1; j<=V; j++) {
				if(!visited[j] && distance[j] < min) {
					min = distance[j];
					next = j;
				}
			}
			
			visited[next] = true;
			if(next == 0) break;
			
			for(int[] temp : adjList[next]) {
				if(!visited[temp[0]] && distance[temp[0]] > distance[next] + temp[1]) {
					distance[temp[0]] = distance[next] + temp[1];
				}
			}
			
			K = next;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(distance[i] != INF) sb.append(distance[i]).append("\n");
			else sb.append("INF").append("\n");
		}
		
		
		System.out.print(sb);

	}

}
