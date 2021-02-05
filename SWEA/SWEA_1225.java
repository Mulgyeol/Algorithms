package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			sb.append("#").append(Integer.parseInt(br.readLine()));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Queue<Integer> queue = new LinkedList<Integer>();
			
			int item;
			boolean flag = true;
			
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			while(flag) {
				for(int i=1; i<=5; i++) {
					item = queue.poll()-i;
					if(item > 0) {
						queue.offer(item);
					}else {
						queue.offer(0);
						flag = false;
						break;
					}
				}
			}
			
			for(int i=0; i<8; i++) {
				sb.append(" ").append(queue.poll());
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}
