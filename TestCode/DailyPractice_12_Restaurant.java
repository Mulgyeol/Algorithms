package com.algo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DailyPractice_12_Restaurant {
	
	private static int R, C, ans=0;
	private static char[][] arr;
	private static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][];
		
		for(int i=0; i<R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<R; i++) {
			flag = false;
			setPipe(i,0); //row, column
		}
		
		System.out.println(ans);
	}

	private static void setPipe(int row, int col) {
		if(flag == true) return;
		if(!isAvailable(row, col)) return;
		
		arr[row][col]='X';
		if(col >= C-1) {
			ans++;
			flag = true;
			return;
		}
		
		setPipe(row-1,col+1);
		if(flag == true) return;
		setPipe(row,col+1);
		if(flag == true) return;
		setPipe(row+1,col+1);
	}

	private static boolean isAvailable(int row, int col) {
		if (row < 0 || row >=R) return false;
		return arr[row][col] == '.' ? true : false;
	}

}
