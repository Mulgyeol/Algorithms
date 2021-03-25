package com.ssafy.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class acmicpc_9205_WalkingOverBeer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] point = new int[n+2][2];
			boolean[] visited = new boolean[n+2];
			String answer = "sad";
	
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
			if(disUnder1000(point[0],point[n+1])) {
				System.out.println("happy");
				continue;
			}

			Queue<int[]> queue = new LinkedList<>();
			queue.offer(point[0]);
			visited[0] = true;
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				
				if(temp.equals(point[n+1])) {
					answer = "happy";
				}
				
				for(int i=0; i<n+2; i++) {
					if(!visited[i] && disUnder1000(temp,point[i])) {
						queue.offer(point[i]);
						visited[i] = true;
					}
				}
			}
			
			System.out.println(answer);
			
		}//tc
		
	}

	private static boolean disUnder1000(int[] p1, int[] p2) {
		if(Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]) <= 1000)
			return true;
		return false;
	}

}
