package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808_CardGame {
	private static int[] gyu = new int[9];
	private static int[] young = new int[9];
	private static boolean[] cards;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");			
			
			st = new StringTokenizer(br.readLine());
			
			cards = new boolean[19];
			for(int i=0; i<9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				cards[gyu[i]] = true;
			}
			
			int cnt = 0;
			for(int i=1; i<19; i++) {
				if(cards[i] == false) young[cnt++] = i;
			}
			
			Arrays.sort(young);
			
			int win = 0;
			int lose = 0;
			
			do {
				int g_score = 0;
				int y_score = 0;
				for(int i=0; i<9; i++) {
					if(gyu[i] > young[i]) {
						g_score += gyu[i]+young[i];
					}else if(gyu[i] < young[i]) {
						y_score += gyu[i]+young[i];
					}
				}
				if(g_score>y_score) win++;
				else if(g_score<y_score) lose++;
			}while(np());
			
			sb.append(win).append(" ").append(lose).append("\n");
		}// 테스트 케이스
		
		System.out.print(sb);
		
	}

	private static boolean np() { //Next-Permutation
		int i = 8;
		while(i>0 && young[i-1] >= young[i]) --i;
		
		if(i==0) return false;
		
		int j = 8;
		while(young[i-1]>=young[j]) --j;
		swap(i-1,j);
		
		int k = 8;
		while(i<k) {
			swap(i++,k--);
		}
		
		return true;
		
	}
	
	private static void swap(int i, int j) {
		int temp = young[i];
		young[i] = young[j];
		young[j] = temp;
	}

}
