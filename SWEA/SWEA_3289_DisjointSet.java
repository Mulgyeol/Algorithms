package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_DisjointSet {
	
	static int N;
	static int[] parents;
	
	static void make() {
		for(int i=1; i<N+1; i++) {
			parents[i] = i; //자기 자신이 대표자
		}
	}
	
	//2. 대표자를 찾는 메소드
	static int find(int a) {
		if (parents[a] == a)
			return a;
		
		return parents[a] = find(parents[a]);
//		return find(parents[a])
	}
	
	
	//3.
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)
			return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			make();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cal = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(cal == 0) {
					union(a,b);
				}else {
					if(find(a) == find(b)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb);
	}

}
