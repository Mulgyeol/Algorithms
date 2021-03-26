package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten_RE {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[] map = new int[100];
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<100; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(map);
			
			for(int i=0; i<N; i++) {
				Arrays.sort(map);
				map[0]++;
				map[99]--;
//				int max = Integer.MIN_VALUE;
//				int maxIdx = 0;
//				int min = Integer.MAX_VALUE;
//				int minIdx = 0;
//				
//				for(int j=0; j<100; j++) {
//					if(max < map[j]) {
//						max = map[j];
//						maxIdx = j;
//					}
//					if(min > map[j]) {
//						min = map[j];
//						minIdx = j;
//					}
//				}
//				
//				map[maxIdx]--;
//				map[minIdx]++;
			}
			
			Arrays.sort(map);
			int answer = map[99]-map[0];
			
//			int max = Integer.MIN_VALUE;
//			int min = Integer.MAX_VALUE;
//			for(int j=0; j<100; j++) {
//				if(max < map[j]) {
//					max = map[j];
//				}
//				if(min > map[j]) {
//					min = map[j];
//				}
//			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	

}
