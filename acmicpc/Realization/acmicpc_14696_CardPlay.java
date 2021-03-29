package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_14696_CardPlay {
	
	static int[] A, B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for(int n=0; n<N; n++) {
			A = new int[5];
			B = new int[5];
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int i=0; i<a; i++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for(int i=0; i<b; i++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			
			for(int i=4; i>0; i--) {
				if(A[i]==B[i]) {
					if(i==1) sb.append("D\n");
					continue;
				}else {
					if(A[i]>B[i]) {
						sb.append("A\n");
						break;
					}else {
						sb.append("B\n");
						break;
					}
				}
				
			}

		}
		
		System.out.println(sb);
	}

}
