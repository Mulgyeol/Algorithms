package com.ssafy.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_HeightOrder {
	
	static class Node{
		int num;
		ArrayList<Node> shorterThanMe;
		ArrayList<Node> tallerThanMe;
		
		public Node(int num) {
			super();
			this.num = num;
			this.shorterThanMe = new ArrayList<>();
			this.tallerThanMe = new ArrayList<>();
		}
	}
	
	static Map<Integer, Node> map;
	static int N,M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			int answer = 0;
			
			map = new HashMap<>();
			
			for(int i=1; i<=N; i++) {
				map.put(i, new Node(i));
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int smaller = Integer.parseInt(st.nextToken());
				int taller = Integer.parseInt(st.nextToken());
				
				map.get(smaller).tallerThanMe.add(map.get(taller));
				map.get(taller).shorterThanMe.add(map.get(smaller));
				
			}
			
			for(int i=1; i<=N; i++) {
				if(tallerBFS(i) + smallerBFS(i) == N-1) {
					answer++;
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
		
		
	}

	private static int smallerBFS(int i) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		int cnt = 0;
		
		for(Node node : map.get(i).shorterThanMe) {
			queue.offer(node.num);
			visited[node.num] = true;
			cnt++;
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(Node next : map.get(current).shorterThanMe) {
				if(!visited[next.num]) {
					queue.offer(next.num);
					visited[next.num] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}

	private static int tallerBFS(int i) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		int cnt = 0;
		
		for(Node node : map.get(i).tallerThanMe) {
			queue.offer(node.num);
			visited[node.num] = true;
			cnt++;
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(Node next : map.get(current).tallerThanMe) {
				if(!visited[next.num]) {
					queue.offer(next.num);
					visited[next.num] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}

}
