package com.algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class acmicpc_Sort_10814 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[][] people = new String[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			people[i][0] = st.nextToken();
			people[i][1] = st.nextToken();
		}
		
		Arrays.sort(people,new Comparator<String[]>(){
            @Override
            public int compare(String[] p1, String[] p2){
            	return Integer.compare(Integer.parseInt(p1[0]), Integer.parseInt(p2[0]));
            }
        });
		
		for(String[] p : people) {
			sb.append(p[0]).append(" ").append(p[1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
