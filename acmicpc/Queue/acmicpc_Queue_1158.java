package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class acmicpc_Queue_1158 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			list.offer(i);
		}
		
		int next = K-1;
		K--;
		while(true) {
			sb.append(list.get(K)).append(", ");
			list.remove(K);
			if(list.isEmpty()) break;
			K = (K+next) % list.size();
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
		
	}

}
