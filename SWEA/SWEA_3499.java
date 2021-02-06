package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t);
			int N = Integer.parseInt(br.readLine());
			String[] cards = new String[N];
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<N; i++) {
				cards[i] = st.nextToken();
			}
			
			int mid = N/2;
			
			
			if(N % 2 == 1) {
				for(int i=0; i<mid; i++) {
					sb.append(" ").append(cards[i]).append(" ").append(cards[i+mid+1]);
				}
				sb.append(" ").append(cards[mid]);
			}else {
				for(int i=0; i<mid; i++) {
					sb.append(" ").append(cards[i]).append(" ").append(cards[i+mid]);
				}
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}
