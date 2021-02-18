package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_1987_Alphabet {
	
	static int R, C;
	static char[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int answer = 0;
	static boolean[] isSelected = new boolean[26];


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][];
		
		for(int i=0; i<R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
				
		find(0,0,0);
		System.out.println(answer);
	}


	private static void find(int x, int y, int cnt) {
		if(!isAvaliable(x,y)) {
			answer = Math.max(answer, cnt);
			return;
		}
		
		isSelected[arr[x][y]-65] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			find(nx, ny, cnt+1);
		}

		isSelected[arr[x][y]-65] = false;
	}


	private static boolean isAvaliable(int x, int y) {
		if(x<0 || x >=R || y<0 || y>=C || isSelected[arr[x][y]-65] == true) return false;
		return true;
	}

}
