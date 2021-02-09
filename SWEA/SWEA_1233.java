package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233 {
	
	private static char[] tree;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=1;t<=10;t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			
			tree = new char[N+1];
			
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}
			
			if(N%2==0) {
				sb.append(0).append("\n");
				continue;
			}

			
			sb.append(solution()).append("\n");
		}
		
		System.out.print(sb);

	}

	private static int solution() {
		for(int i = N; i>=2; i -=2) {
			if(checkInteger(tree[i]) && checkInteger(tree[i-1]) && !checkInteger(tree[i/2])) tree[i/2] = '1';
			else return 0;
		}
		
		if(checkInteger(tree[1])) return 1;
		return 0;
	}
	
	private static boolean checkInteger(char c) {
		if(c != '+' &&c != '-' &&c != '*' &&c != '/') return true;
		else return false;
	}

}
