package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5644_WirelessCharge {
	
	static class BatteryCharger{
		int x;
		int y;
		int coverage;
		int p;
		
		public BatteryCharger(int x, int y, int coverage, int p) {
			super();
			this.x = x;
			this.y = y;
			this.coverage = coverage;
			this.p = p;
		}
	}
	
	static ArrayList<BatteryCharger>[][] map;
	static ArrayList<BatteryCharger> list;
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	static int[] personA;
	static int[] personB;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int BC = Integer.parseInt(st.nextToken());
			personA = new int[] {1,1};
			personB = new int[] {10,10};
			map = new ArrayList[11][11];
			list = new ArrayList<>();
			answer = 0;
			
			int[] A = new int[M];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<BC; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				list.add(new BatteryCharger(x,y,c,p));
			}
			
			for(BatteryCharger bc : list) {
				bfs(bc);
			}
			
			choiceBC(personA, personB);
			
			for(int i=0; i<M; i++) {
				move(A,B,i);
				choiceBC(personA, personB);
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb);
	}

	private static void choiceBC(int[] personA, int[] personB) {
		int tempMax = Integer.MIN_VALUE;		
		
		if(map[personA[0]][personA[1]] != null) {
			if(map[personB[0]][personB[1]] != null) {
				// 둘 다 있을 때,
				for(BatteryCharger bcA : map[personA[0]][personA[1]]) {
					for(BatteryCharger bcB : map[personB[0]][personB[1]]) {
						if(bcA.equals(bcB)) {
							tempMax = Math.max(tempMax, bcA.p);
						}else {
							tempMax = Math.max(tempMax, bcA.p + bcB.p);
						}
					}
				}
			}else {
				for(BatteryCharger bcA : map[personA[0]][personA[1]]) {
					tempMax = Math.max(tempMax, bcA.p);
				}
			}
		}else {
			if(map[personB[0]][personB[1]] != null) {
				//B만 있을 때,
				for(BatteryCharger bcB : map[personB[0]][personB[1]]) {
					tempMax = Math.max(tempMax, bcB.p);
				}
			}else {
				tempMax = 0;
			}
		}
		answer += tempMax;
	}

	private static void move(int[] A, int[] B, int idx) {
		personA[0] += dx[A[idx]];
		personA[1] += dy[A[idx]];
		personB[0] += dx[B[idx]];
		personB[1] += dy[B[idx]];
	}

	private static void bfs(BatteryCharger bc) {
		boolean[][] visited = new boolean[11][11];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {bc.x, bc.y});
		visited[bc.x][bc.y] = true;
		if(map[bc.x][bc.y] == null) {
			map[bc.x][bc.y] = new ArrayList<>();
		}
		map[bc.x][bc.y].add(bc);
		int time = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				int[] temp = queue.poll();
				int x = temp[0];
				int y = temp[1];
				
				for(int j=1; j<5; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx >= 1 && nx <= 10 && ny>=1 && ny <= 10 && !visited[nx][ny]) {
						if(map[nx][ny] == null) {
							map[nx][ny] = new ArrayList<>();
						}
						map[nx][ny].add(bc);
						visited[nx][ny] = true;
						queue.offer(new int[] {nx,ny});
					}
				}
			}
			time++;
			if(time == bc.coverage) {
				break;
			}
		}
	}

}
