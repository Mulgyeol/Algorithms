package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class acmicpc_16926_rotateArray {
	
	private static int[][] array;
	private static int N, M, R;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<R; i++) {
			rotateArray(0,M-1,0,N-1);
		}
		
		for(int i =0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(array[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	private static void rotateArray(int left, int right, int top, int bottom) {
		if(left >= right || top >= bottom) {
			return;
		}
		int x = top;
		int y = left;
		int last = array[x][y];
		for(int i=left; i<right; i++) {
			array[x][y] = array[x][y+1];
			y = y + 1;
		}
		for(int i=top; i<bottom; i++) {
			array[x][y] = array[x+1][y];
			x = x + 1;
		}
		for(int i=left; i<right; i++) {
			array[x][y] = array[x][y-1];
			y = y - 1;
		}
		for(int i=top; i<bottom-1; i++) {
			array[x][y] = array[x-1][y];
			x = x - 1;
		}
		array[x][y] = last; 
		
		rotateArray(left+1, right-1, top+1, bottom-1);
	}
	
}


