package com.algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class acmicpc_Sort_11650 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] point1, int[] point2){
            	if(point1[0]==point2[0])
                return Integer.compare(point1[1],point2[1]);
            	
            	return Integer.compare(point1[0], point2[0]);
            }
        });
		
		for(int[] a : arr) {
			sb.append(a[0]).append(" ").append(a[1]).append("\n");
		}
		
		System.out.println(sb);
			
	}
}
