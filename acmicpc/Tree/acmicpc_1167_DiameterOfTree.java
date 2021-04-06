package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class acmicpc_1167_DiameterOfTree {
	
	static int N, max = Integer.MIN_VALUE, maxidx = 0;
	static boolean[] visited;
	static ArrayList<int[]>[] adjList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		adjList = new ArrayList[N+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			adjList[idx] = new ArrayList<int[]>();
			
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1) break;
				
				int weight = Integer.parseInt(st.nextToken());
				adjList[idx].add(new int[] {to, weight});
			}
		}
		
		//1(아무 값)을 선택해서 가장 먼 곳을 찾는다.
		dfs(1, 0);
		Arrays.fill(visited, false);
		max = Integer.MIN_VALUE;
		
		//찾은 곳으로 부터 가장 먼 곳까지의 거리를 구한다.
		dfs(maxidx, 0);
		
		System.out.println(max);
	}

	private static void dfs(int i, int sum) {
		visited[i] = true;
		boolean flag = false;
		
		for(int[] node : adjList[i]) {
			if(!visited[node[0]]) {
				dfs(node[0], sum+node[1]);
				flag = true;
			}
		}
		
		if(flag == false && sum > max) {
			maxidx = i;
			max = sum;
		}
	}

}
